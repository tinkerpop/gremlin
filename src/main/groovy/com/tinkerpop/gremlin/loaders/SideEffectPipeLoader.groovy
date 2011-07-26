package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens
import com.tinkerpop.gremlin.pipes.GremlinPipeline
import com.tinkerpop.gremlin.pipes.TablePipe
import com.tinkerpop.gremlin.pipes.util.GroovyPipeClosure
import com.tinkerpop.gremlin.pipes.util.Table
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.sideeffect.AggregatorPipe
import com.tinkerpop.pipes.sideeffect.GroupCountClosurePipe
import com.tinkerpop.pipes.sideeffect.SideEffectClosurePipe
import com.tinkerpop.pipes.transform.IdentityPipe

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class SideEffectPipeLoader {

    public static void load() {

        Gremlin.addStep(GremlinTokens.SIDEEFFECT);
        [Pipe, Vertex, Edge, Graph].each {
            it.metaClass.sideEffect = {final Closure closure ->
                return Gremlin.compose(delegate, new SideEffectClosurePipe(new GroovyPipeClosure(closure)));
            }
        }

        Gremlin.addStep(GremlinTokens.AGGREGATE);
        Pipe.metaClass.aggregate = {final Object... params ->
            if (params) {
                if (params.length == 2) {
                    return Gremlin.compose(delegate, new AggregatorPipe((Collection) params[0], new GroovyPipeClosure((Closure) params[1])));
                } else {
                    if (params[0] instanceof Collection) {
                        return Gremlin.compose(delegate, new AggregatorPipe((Collection) params[0]))
                    } else {
                        return Gremlin.compose(delegate, new AggregatorPipe(new LinkedList(), new GroovyPipeClosure((Closure) params[0])));

                    }
                }
            } else {
                return Gremlin.compose(delegate, new AggregatorPipe(new LinkedList()));
            }

        }

        Gremlin.addStep(GremlinTokens.GROUPCOUNT);
        Pipe.metaClass.groupCount = {final Object... params ->

            if (params.length == 3) {
                Gremlin.compose(delegate, new GroupCountClosurePipe((Map) params[0], new GroovyPipeClosure((Closure) params[1]), new GroovyPipeClosure((Closure) params[2])));
            } else if (params.length == 2) {
                if (params[0] instanceof Map) {
                    Gremlin.compose(delegate, new GroupCountClosurePipe((Map) params[0], new GroovyPipeClosure((Closure) params[1]), null));

                } else {
                    Gremlin.compose(delegate, new GroupCountClosurePipe(new HashMap(), new GroovyPipeClosure((Closure) params[0]), new GroovyPipeClosure((Closure) params[1])));
                }
            } else if (params.length == 1) {
                if (params[0] instanceof Map) {
                    Gremlin.compose(delegate, new GroupCountClosurePipe((Map) params[0], null, null));
                } else {
                    Gremlin.compose(delegate, new GroupCountClosurePipe(new HashMap(), new GroovyPipeClosure((Closure) params[0]), null));
                }
            } else {
                return Gremlin.compose(delegate, new GroupCountClosurePipe(new HashMap(), null, null));
            }
        }

        Gremlin.addStep(GremlinTokens.OPTIONAL)
        GremlinPipeline.metaClass.optional = {final Integer steps ->
            ((GremlinPipeline) delegate).optionalPipe(steps);
            return delegate;
        }
        GremlinPipeline.metaClass.optional = {final String name ->
            ((GremlinPipeline) delegate).optionalPipe(name);
            return delegate;
        }

        Gremlin.addStep(GremlinTokens.TABLE);
        Pipe.metaClass.table = {final Table table, final Closure... closures ->
            Gremlin.compose(delegate, new TablePipe(table, null, (GremlinPipeline) delegate, closures));
        }
        Pipe.metaClass.table = {final Table table, final List<String> columnNames, final Closure... closures ->
            Gremlin.compose(delegate, new TablePipe(table, columnNames, (GremlinPipeline) delegate, closures));
        }

        Gremlin.addStep(GremlinTokens.AS)
        GremlinPipeline.metaClass.as = {final String name ->
            ((GremlinPipeline) delegate).asPipe(name);
            return delegate;
        }
        [Graph, Vertex, Edge].each {
            it.metaClass.as = {final String name ->
                final GremlinPipeline pipeline = Gremlin.compose(delegate, new IdentityPipe());
                pipeline.asPipe(name);
                return pipeline;
            }
        }
    }
}
