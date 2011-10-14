package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.Tokens
import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline
import com.tinkerpop.gremlin.pipes.GremlinPipeline

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class TransformPipeLoader {

    public static void load() {

        Gremlin.addStep(Tokens.TRANSFORM);
        Gremlin.addStep(Tokens.COPYSPLIT);
        Gremlin.addStep(Tokens.FAIRMERGE);
        Gremlin.addStep(Tokens.EXHAUSTMERGE);
        Gremlin.addStep(Tokens.IFTHENELSE);
        Gremlin.addStep(Tokens.CAP);
        Gremlin.addStep(Tokens.LOOP);
        Gremlin.addStep(Tokens.MAP);
        Gremlin.addStep(Tokens.MEMOIZE);

        Gremlin.addStep(Tokens.GATHER);
        Gremlin.addStep(Tokens.SCATTER);
        Gremlin.addStep(Tokens.PATHS);
        Gremlin.addStep(Tokens.OUT);

        Vertex.metaClass.out = {final String... labels ->
            return new GremlinGroovyPipeline(delegate).out(labels);
        }

        Gremlin.addStep(Tokens.OUTE);
        Vertex.metaClass.outE = {final String... labels ->
            return new GremlinGroovyPipeline(delegate).outE(labels);
        }

        Gremlin.addStep(Tokens.IN);
        Vertex.metaClass.in = {final String... labels ->
            return new GremlinGroovyPipeline(delegate).in(labels);
        }

        Gremlin.addStep(Tokens.INE);
        Vertex.metaClass.inE = {final String... labels ->
            return new GremlinGroovyPipeline(delegate).inE(labels);
        }

        Gremlin.addStep(Tokens.BOTH);
        Vertex.metaClass.both = {final String... labels ->
            return new GremlinPipeline(delegate).both(labels);
        }

        Gremlin.addStep(Tokens.BOTHE);
        Vertex.metaClass.bothE = {final String... labels ->
            return new GremlinGroovyPipeline(delegate).bothE(labels);
        }

        Gremlin.addStep(Tokens.INV);
        Edge.metaClass.inV = {->
            return new GremlinGroovyPipeline(delegate).inV();
        }

        Gremlin.addStep(Tokens.OUTV);
        Edge.metaClass.outV = {->
            return new GremlinGroovyPipeline(delegate).outV();
        }

        Gremlin.addStep(Tokens.BOTHV);
        Edge.metaClass.bothV = {->
            return new GremlinGroovyPipeline(delegate).bothV();
        }
    }
}
