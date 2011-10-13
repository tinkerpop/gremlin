package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.groovy.GroovyPipeFunction
import com.tinkerpop.gremlin.pipes.GremlinFluentPipeline
import com.tinkerpop.pipes.util.Table
import com.tinkerpop.gremlin.Tokens

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class SideEffectPipeLoader {

    public static void load() {

        Gremlin.addStep(Tokens.SIDEEFFECT);
        GremlinFluentPipeline.metaClass.sideEffect = {final Closure closure ->
            return ((GremlinFluentPipeline) delegate).sideEffect(new GroovyPipeFunction(closure));
        }

        Gremlin.addStep(Tokens.AGGREGATE);
        GremlinFluentPipeline.metaClass.aggregate = {final Object... params ->
            if (params) {
                if (params.length == 2) {
                    return ((GremlinFluentPipeline) delegate).aggregate((Collection) params[0], new GroovyPipeFunction((Closure) params[1]));
                } else {
                    if (params[0] instanceof Collection)
                        return ((GremlinFluentPipeline) delegate).aggregate((Collection) params[0]);
                    else
                        return ((GremlinFluentPipeline) delegate).aggregate(new LinkedList(), new GroovyPipeFunction((Closure) params[0]));
                }
            } else {
                return ((GremlinFluentPipeline) delegate).aggregate();
            }

        }

        Gremlin.addStep(Tokens.GROUPCOUNT);
        GremlinFluentPipeline.metaClass.groupCount = {final Object... params ->
            if (params.length == 3) {
                ((GremlinFluentPipeline) delegate).groupCount((Map) params[0], new GroovyPipeFunction((Closure) params[1]), new GroovyPipeFunction((Closure) params[2]));
            } else if (params.length == 2) {
                if (params[0] instanceof Map) {
                    ((GremlinFluentPipeline) delegate).groupCount((Map) params[0], new GroovyPipeFunction((Closure) params[1]), null);

                } else {
                    ((GremlinFluentPipeline) delegate).groupCount(new HashMap(), new GroovyPipeFunction((Closure) params[0]), new GroovyPipeFunction((Closure) params[1]));
                }
            } else if (params.length == 1) {
                if (params[0] instanceof Map) {
                    ((GremlinFluentPipeline) delegate).groupCount((Map) params[0]);
                } else {
                    ((GremlinFluentPipeline) delegate).groupCount(new HashMap(), new GroovyPipeFunction((Closure) params[0]), null);
                }
            } else {
                return ((GremlinFluentPipeline) delegate).groupCount(new HashMap());
            }
        }

        Gremlin.addStep(Tokens.OPTIONAL)

        Gremlin.addStep(Tokens.TABLE);
        GremlinFluentPipeline.metaClass.table = {final Table table, final Closure... closures ->
            return ((GremlinFluentPipeline) delegate).table(table, null, GroovyPipeFunction.generate(closures));
        }
        GremlinFluentPipeline.metaClass.table = {final Table table, final List<String> columnNames, final Closure... closures ->
            return ((GremlinFluentPipeline) delegate).table(table, columnNames, GroovyPipeFunction.generate(closures));
        }

        Gremlin.addStep(Tokens.AS)
        // todo: why is identity needed?
        [Graph, Vertex, Edge].each {
            it.metaClass.as = {final String name ->
                return new GremlinFluentPipeline(delegate).identity().as(name);
            }
        }
    }
}
