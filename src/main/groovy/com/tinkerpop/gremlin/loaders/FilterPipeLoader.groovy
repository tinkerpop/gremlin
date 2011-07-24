package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens
import com.tinkerpop.gremlin.GremlinTokens.T
import com.tinkerpop.gremlin.pipes.GremlinPipeline
import com.tinkerpop.gremlin.pipes.util.GroovyPipeClosure
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.transform.HasNextPipe
import com.tinkerpop.pipes.filter.*

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class FilterPipeLoader {

    public static void load() {

        Gremlin.addStep(GremlinTokens.FILTER);
        [Pipe, Vertex, Edge, Graph].each {
            it.metaClass.filter = {final Closure closure ->
                return Gremlin.compose(delegate, new FilterClosurePipe(new GroovyPipeClosure(closure)));
            }
        }

        Gremlin.addStep(GremlinTokens.UNIQUEPATH);
        Pipe.metaClass.uniquePath = {final Closure closure ->
            return Gremlin.compose(delegate, new UniquePathFilterPipe(), closure);
        }

        Gremlin.addStep(GremlinTokens.UNIQUEOBJECT);
        Pipe.metaClass.uniqueObject = {final Closure closure ->
            return Gremlin.compose(delegate, new DuplicateFilterPipe(), closure)
        }

        Gremlin.addStep(GremlinTokens.ANDFILTER);
        Pipe.metaClass.andFilter = {final Pipe... pipes ->
            return Gremlin.compose(delegate, new AndFilterPipe(pipes.collect {new HasNextPipe((Pipe) it)} as List))
        }

        Gremlin.addStep(GremlinTokens.ORFILTER);
        Pipe.metaClass.orFilter = {final Pipe... pipes ->
            return Gremlin.compose(delegate, new OrFilterPipe(pipes.collect {new HasNextPipe((Pipe) it)} as List))
        }

        Gremlin.addStep(GremlinTokens.BACK);
        GremlinPipeline.metaClass.back = {final Integer steps ->
            ((GremlinPipeline) delegate).backPipe(steps);
            return delegate;
        }
        GremlinPipeline.metaClass.back = {final String name ->
            ((GremlinPipeline) delegate).backPipe(name);
            return delegate;
        }

        Gremlin.addStep(GremlinTokens.PROPFILTER);
        [Pipe, Vertex, Edge].each {
            it.metaClass.propFilter = {final String key, final T t, final Object value ->
                if (key.equals(com.tinkerpop.gremlin.GremlinTokens.ID)) {
                    return Gremlin.compose(delegate, new IdFilterPipe(value, Gremlin.mapFilter(t)));
                } else if (key.equals(com.tinkerpop.gremlin.GremlinTokens.LABEL)) {
                    return Gremlin.compose(delegate, new LabelFilterPipe((String) value, Gremlin.mapFilter(t)))
                } else {
                    return Gremlin.compose(delegate, new PropertyFilterPipe(key, value, Gremlin.mapFilter(t)));
                }
            }
        }
    }
}
