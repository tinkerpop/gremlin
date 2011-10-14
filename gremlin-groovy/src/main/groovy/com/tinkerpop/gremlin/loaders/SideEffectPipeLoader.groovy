package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.Tokens
import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class SideEffectPipeLoader {

    public static void load() {

        Gremlin.addStep(Tokens.SIDEEFFECT);
        Gremlin.addStep(Tokens.AGGREGATE);
        Gremlin.addStep(Tokens.GROUPCOUNT);
        Gremlin.addStep(Tokens.OPTIONAL)
        Gremlin.addStep(Tokens.TABLE);
        Gremlin.addStep(Tokens.AS)
        // todo: why is identity needed?
        [Graph, Vertex, Edge].each {
            it.metaClass.as = {final String name ->
                return new GremlinGroovyPipeline(delegate).identity().as(name);
            }
        }
    }
}
