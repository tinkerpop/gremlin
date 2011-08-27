package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens
import com.tinkerpop.gremlin.GroovyPipeClosure
import com.tinkerpop.pipes.PipeClosure
import com.tinkerpop.pipes.util.FluentPipeline

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class TransformPipeLoader {

    public static void load() {

        Gremlin.addStep(GremlinTokens.TRANSFORM);
        FluentPipeline.metaClass.transform = {final Closure closure ->
            final PipeClosure pc = new GroovyPipeClosure(closure);
            ((FluentPipeline) delegate).transform(pc);
            pc.setPipe((FluentPipeline) delegate);
            return delegate;
        }

        Gremlin.addStep(GremlinTokens.COPYSPLIT);
        Gremlin.addStep(GremlinTokens.FAIRMERGE);
        Gremlin.addStep(GremlinTokens.EXHAUSTMERGE);

        Gremlin.addStep(GremlinTokens.IFTHENELSE);
        FluentPipeline.metaClass.ifThenElse = {final Closure ifClosure, final Closure thenClosure, final Closure elseClosure ->
            return ((FluentPipeline) delegate).ifThenElse(new GroovyPipeClosure(ifClosure), new GroovyPipeClosure(thenClosure), new GroovyPipeClosure(elseClosure));
        }
        FluentPipeline.metaClass.ifThenElse = {final Closure ifClosure, final Closure thenClosure ->
            return ((FluentPipeline) delegate).ifThenElse(new GroovyPipeClosure(ifClosure), new GroovyPipeClosure(thenClosure), null);
        }

        Gremlin.addStep(GremlinTokens.CAP);

        Gremlin.addStep(GremlinTokens.LOOP);
        FluentPipeline.metaClass.loop = {final Integer stepsAgo, final Closure closure ->
            return ((FluentPipeline) delegate).loop(stepsAgo, new GroovyPipeClosure(closure));
        }
        FluentPipeline.metaClass.loop = {final String name, final Closure closure ->
            return ((FluentPipeline) delegate).loop(name, new GroovyPipeClosure(closure));
        }

        Gremlin.addStep(GremlinTokens.MAP);
        Gremlin.addStep(GremlinTokens.MEMOIZE);

        Gremlin.addStep(GremlinTokens.GATHER);
        FluentPipeline.metaClass.gather = {final Closure closure ->
            ((FluentPipeline) delegate).gather();
            if (closure)
                ((FluentPipeline) delegate).transform(new GroovyPipeClosure(closure));
            return delegate;
        }

        Gremlin.addStep(GremlinTokens.SCATTER);

        Gremlin.addStep(GremlinTokens.PATHS);
        FluentPipeline.metaClass.paths = { final Closure... closures ->
            return ((FluentPipeline) delegate).path(GroovyPipeClosure.generate(closures));
        }

        Gremlin.addStep(GremlinTokens.OUT);
        Vertex.metaClass.out = {final String... labels ->
            return new FluentPipeline().start(delegate).out(labels);
        }

        Gremlin.addStep(GremlinTokens.OUTE);
        Vertex.metaClass.outE = {final String... labels ->
            return new FluentPipeline().start(delegate).outE(labels);
        }

        Gremlin.addStep(GremlinTokens.IN);
        Vertex.metaClass.in = {final String... labels ->
            return new FluentPipeline().start(delegate).in(labels);
        }

        Gremlin.addStep(GremlinTokens.INE);
        Vertex.metaClass.inE = {final String... labels ->
            return new FluentPipeline().start(delegate).inE(labels);
        }

        Gremlin.addStep(GremlinTokens.BOTH);
        Vertex.metaClass.both = {final String... labels ->
            return new FluentPipeline().start(delegate).both(labels);
        }

        Gremlin.addStep(GremlinTokens.BOTHE);
        Vertex.metaClass.bothE = {final String... labels ->
            return new FluentPipeline().start(delegate).bothE(labels);
        }

        Gremlin.addStep(GremlinTokens.INV);
        Edge.metaClass.inV = {->
            return new FluentPipeline().start(delegate).inV();
        }

        Gremlin.addStep(GremlinTokens.OUTV);
        Edge.metaClass.outV = {->
            return new FluentPipeline().start(delegate).outV();
        }

        Gremlin.addStep(GremlinTokens.BOTHV);
        Edge.metaClass.bothV = {->
            return new FluentPipeline().start(delegate).bothV();
        }
    }
}
