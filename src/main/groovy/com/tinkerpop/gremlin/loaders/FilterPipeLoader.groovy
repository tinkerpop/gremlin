package com.tinkerpop.gremlin.loaders

import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens
import com.tinkerpop.gremlin.GremlinTokens.T
import com.tinkerpop.gremlin.GroovyPipeClosure
import com.tinkerpop.pipes.PipeClosure
import com.tinkerpop.pipes.util.FluentPipeline

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class FilterPipeLoader {

    public static void load() {

        Gremlin.addStep(GremlinTokens.FILTER);
        FluentPipeline.metaClass.filter = {final Closure closure ->
            final PipeClosure pc = new GroovyPipeClosure(closure);
            ((FluentPipeline) delegate).filter(pc);
            pc.setPipe((FluentPipeline) delegate);
            return delegate;
        }

        Gremlin.addStep(GremlinTokens.UNIQUEPATH);
        Gremlin.addStep(GremlinTokens.UNIQUEOBJECT);
        Gremlin.addStep(GremlinTokens.ANDFILTER);
        Gremlin.addStep(GremlinTokens.ORFILTER);
        Gremlin.addStep(GremlinTokens.BACK);
        Gremlin.addStep(GremlinTokens.EXCEPT);
        Gremlin.addStep(GremlinTokens.RETAIN);
        Gremlin.addStep(GremlinTokens.RANDOM);

        Gremlin.addStep(GremlinTokens.PROPERTYFILTER);
        FluentPipeline.metaClass.propertyFilter = {final String key, final T t, final Object value ->
            if (key.equals(com.tinkerpop.gremlin.GremlinTokens.ID)) {
                return ((FluentPipeline) delegate).idFilter(value, Gremlin.mapFilter(t));
            } else if (key.equals(com.tinkerpop.gremlin.GremlinTokens.LABEL)) {
                return ((FluentPipeline) delegate).labelFilter((String) value, Gremlin.mapFilter(t));
            } else {
                return ((FluentPipeline) delegate).propertyFilter(key, Gremlin.mapFilter(t), value);
            }
        }


    }
}
