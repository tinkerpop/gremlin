package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens
import com.tinkerpop.gremlin.GroovyPipeFunction
import com.tinkerpop.pipes.util.FluentPipeline
import com.tinkerpop.pipes.util.Table

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class SideEffectPipeLoader {

    public static void load() {

        Gremlin.addStep(GremlinTokens.SIDEEFFECT);
        FluentPipeline.metaClass.sideEffect = {final Closure closure ->
            return ((FluentPipeline) delegate).sideEffect(new GroovyPipeFunction(closure));
        }

        Gremlin.addStep(GremlinTokens.AGGREGATE);
        FluentPipeline.metaClass.aggregate = {final Object... params ->
            if (params) {
                if (params.length == 2) {
                    return ((FluentPipeline) delegate).aggregate((Collection) params[0], new GroovyPipeFunction((Closure) params[1]));
                } else {
                    if (params[0] instanceof Collection)
                        return ((FluentPipeline) delegate).aggregate((Collection) params[0]);
                    else
                        return ((FluentPipeline) delegate).aggregate(new LinkedList(), new GroovyPipeFunction((Closure) params[0]));
                }
            } else {
                return ((FluentPipeline) delegate).aggregate();
            }

        }

        Gremlin.addStep(GremlinTokens.GROUPCOUNT);
        FluentPipeline.metaClass.groupCount = {final Object... params ->
            if (params.length == 3) {
                ((FluentPipeline) delegate).groupCount((Map) params[0], new GroovyPipeFunction((Closure) params[1]), new GroovyPipeFunction((Closure) params[2]));
            } else if (params.length == 2) {
                if (params[0] instanceof Map) {
                    ((FluentPipeline) delegate).groupCount((Map) params[0], new GroovyPipeFunction((Closure) params[1]), null);

                } else {
                    ((FluentPipeline) delegate).groupCount(new HashMap(), new GroovyPipeFunction((Closure) params[0]), new GroovyPipeFunction((Closure) params[1]));
                }
            } else if (params.length == 1) {
                if (params[0] instanceof Map) {
                    ((FluentPipeline) delegate).groupCount((Map) params[0]);
                } else {
                    ((FluentPipeline) delegate).groupCount(new HashMap(), new GroovyPipeFunction((Closure) params[0]), null);
                }
            } else {
                return ((FluentPipeline) delegate).groupCount(new HashMap());
            }
        }

        Gremlin.addStep(GremlinTokens.REDUCE)
        FluentPipeline.metaClass.reduce = {final def first, final Closure reduceClosure ->
            return ((FluentPipeline) delegate).reduce(first, new GroovyPipeFunction(reduceClosure));
        }

        Gremlin.addStep(GremlinTokens.TABLE);
        FluentPipeline.metaClass.table = {final Table table, final Closure... closures ->
            return ((FluentPipeline) delegate).table(table, null, GroovyPipeFunction.generate(closures));
        }
        FluentPipeline.metaClass.table = {final Table table, final List<String> columnNames, final Closure... closures ->
            return ((FluentPipeline) delegate).table(table, columnNames, GroovyPipeFunction.generate(closures));
        }

        Gremlin.addStep(GremlinTokens.AS)
        // todo: why is identity needed?
        [Graph, Vertex, Edge].each {
            it.metaClass.as = {final String name ->
                return new FluentPipeline(delegate).identity().as(name);
            }
        }
    }
}
