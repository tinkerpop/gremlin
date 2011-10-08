package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.groovy.GremlinTokens
import com.tinkerpop.gremlin.groovy.GroovyPipeFunction
import com.tinkerpop.gremlin.pipes.GremlinFluentPipeline

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class TransformPipeLoader {

    public static void load() {

        Gremlin.addStep(GremlinTokens.TRANSFORM);
        GremlinFluentPipeline.metaClass.transform = {final Closure closure ->
            return ((GremlinFluentPipeline) delegate).transform(new GroovyPipeFunction(closure));
        }

        Gremlin.addStep(GremlinTokens.COPYSPLIT);
        Gremlin.addStep(GremlinTokens.FAIRMERGE);
        Gremlin.addStep(GremlinTokens.EXHAUSTMERGE);

        Gremlin.addStep(GremlinTokens.IFTHENELSE);
        GremlinFluentPipeline.metaClass.ifThenElse = {final Closure ifClosure, final Closure thenClosure, final Closure elseClosure ->
            return ((GremlinFluentPipeline) delegate).ifThenElse(new GroovyPipeFunction(ifClosure), new GroovyPipeFunction(thenClosure), new GroovyPipeFunction(elseClosure));
        }
        GremlinFluentPipeline.metaClass.ifThenElse = {final Closure ifClosure, final Closure thenClosure ->
            return ((GremlinFluentPipeline) delegate).ifThenElse(new GroovyPipeFunction(ifClosure), new GroovyPipeFunction(thenClosure), null);
        }

        Gremlin.addStep(GremlinTokens.CAP);

        Gremlin.addStep(GremlinTokens.LOOP);
        GremlinFluentPipeline.metaClass.loop = {final Integer stepsAgo, final Closure closure ->
            return ((GremlinFluentPipeline) delegate).loop(stepsAgo, new GroovyPipeFunction(closure));
        }
        GremlinFluentPipeline.metaClass.loop = {final String name, final Closure closure ->
            return ((GremlinFluentPipeline) delegate).loop(name, new GroovyPipeFunction(closure));
        }

        Gremlin.addStep(GremlinTokens.MAP);
        Gremlin.addStep(GremlinTokens.MEMOIZE);

        Gremlin.addStep(GremlinTokens.GATHER);
        GremlinFluentPipeline.metaClass.gather = {final Closure closure ->
            ((GremlinFluentPipeline) delegate).gather();
            if (closure)
                ((GremlinFluentPipeline) delegate).transform(new GroovyPipeFunction(closure));
            return delegate;
        }

        Gremlin.addStep(GremlinTokens.SCATTER);

        Gremlin.addStep(GremlinTokens.PATHS);
        GremlinFluentPipeline.metaClass.paths = { final Closure... closures ->
            return ((GremlinFluentPipeline) delegate).path(GroovyPipeFunction.generate(closures));
        }

        Gremlin.addStep(GremlinTokens.OUT);
        Vertex.metaClass.out = {final String... labels ->
            return new GremlinFluentPipeline(delegate).out(labels);
        }

        Gremlin.addStep(GremlinTokens.OUTE);
        Vertex.metaClass.outE = {final String... labels ->
            return new GremlinFluentPipeline(delegate).outE(labels);
        }

        Gremlin.addStep(GremlinTokens.IN);
        Vertex.metaClass.in = {final String... labels ->
            return new GremlinFluentPipeline(delegate).in(labels);
        }

        Gremlin.addStep(GremlinTokens.INE);
        Vertex.metaClass.inE = {final String... labels ->
            return new GremlinFluentPipeline(delegate).inE(labels);
        }

        Gremlin.addStep(GremlinTokens.BOTH);
        Vertex.metaClass.both = {final String... labels ->
            return new GremlinFluentPipeline(delegate).both(labels);
        }

        Gremlin.addStep(GremlinTokens.BOTHE);
        Vertex.metaClass.bothE = {final String... labels ->
            return new GremlinFluentPipeline(delegate).bothE(labels);
        }

        Gremlin.addStep(GremlinTokens.INV);
        Edge.metaClass.inV = {->
            return new GremlinFluentPipeline(delegate).inV();
        }

        Gremlin.addStep(GremlinTokens.OUTV);
        Edge.metaClass.outV = {->
            return new GremlinFluentPipeline(delegate).outV();
        }

        Gremlin.addStep(GremlinTokens.BOTHV);
        Edge.metaClass.bothV = {->
            return new GremlinFluentPipeline(delegate).bothV();
        }
    }
}
