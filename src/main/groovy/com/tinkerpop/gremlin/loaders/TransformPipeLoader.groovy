package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens
import com.tinkerpop.pipes.MetaPipe
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.branch.CopySplitPipe
import com.tinkerpop.pipes.branch.ExhaustiveMergePipe
import com.tinkerpop.pipes.branch.FairMergePipe
import com.tinkerpop.pipes.filter.CollectionFilterPipe
import com.tinkerpop.pipes.filter.ComparisonFilterPipe.Filter
import com.tinkerpop.pipes.util.GatherPipe
import com.tinkerpop.pipes.util.PathPipe
import com.tinkerpop.pipes.util.ScatterPipe
import com.tinkerpop.gremlin.pipes.*
import com.tinkerpop.pipes.pgm.*

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class TransformPipeLoader {

    public static void load() {

        Gremlin.addStep(GremlinTokens.TRANSFORM);
        [Pipe, Vertex, Edge, Graph].each {
            it.metaClass.transform = {final Closure closure ->
                return Gremlin.compose(delegate, new ClosureTransformPipe(closure));
            }
        }

        Gremlin.addStep(GremlinTokens.COPYSPLIT);
        Pipe.metaClass.copySplit = {final Pipe... pipes ->
            return Gremlin.compose(delegate, new CopySplitPipe(Arrays.asList(pipes)));
        }

        Gremlin.addStep(GremlinTokens.FAIRMERGE);
        Pipe.metaClass.fairMerge = { final Closure closure ->
            if (delegate instanceof GremlinPipeline) {
                List<Pipe> pipes = ((GremlinPipeline) delegate).getPipes();
                return Gremlin.compose(delegate, new FairMergePipe(((MetaPipe) pipes.get(pipes.size() - 1)).getPipes()), closure);
            } else {
                return Gremlin.compose(delegate, new FairMergePipe(((MetaPipe) delegate).getPipes()), closure);
            }
        }

        Gremlin.addStep(GremlinTokens.EXHAUSTMERGE);
        Pipe.metaClass.exhaustMerge = { final Closure closure ->
            if (delegate instanceof GremlinPipeline) {
                List<Pipe> pipes = ((GremlinPipeline) delegate).getPipes();
                return Gremlin.compose(delegate, new ExhaustiveMergePipe(((MetaPipe) pipes.get(pipes.size() - 1)).getPipes()), closure);
            } else {
                return Gremlin.compose(delegate, new ExhaustiveMergePipe(((MetaPipe) delegate).getPipes()), closure);
            }
        }



        Gremlin.addStep(GremlinTokens.IFELSE);
        Pipe.metaClass.ifelse = {final Closure ifClosure, final Closure thenClosure, final Closure elseClosure ->
            return Gremlin.compose(delegate, new IfPipe(ifClosure, thenClosure, elseClosure));
        }
        Pipe.metaClass.ifelse = {final Closure ifClosure, final Closure thenClosure ->
            return Gremlin.compose(delegate, new IfPipe(ifClosure, thenClosure));
        }

        Gremlin.addStep(GremlinTokens.CAP);
        GremlinPipeline.metaClass.cap = {final Closure closure ->
            final GremlinPipeline pipeline = ((GremlinPipeline) delegate);
            pipeline.capPipe(pipeline.size() - 1);
            if (closure) {
                pipeline.addPipe(new ClosureFilterPipe(closure));
            }
            return pipeline;
        }

        Gremlin.addStep(GremlinTokens.LOOP);
        GremlinPipeline.metaClass.loop = {final Integer stepsAgo, final Closure closure ->
            final GremlinPipeline pipeline = ((GremlinPipeline) delegate);
            pipeline.loopPipe(stepsAgo, closure)
            return pipeline;
        }
        GremlinPipeline.metaClass.loop = {final String name, final Closure closure ->
            final GremlinPipeline pipeline = ((GremlinPipeline) delegate);
            pipeline.loopPipe(name, closure)
            return pipeline;
        }

        Gremlin.addStep(GremlinTokens.EXCEPT);
        Pipe.metaClass.except = {final Collection collection ->
            return Gremlin.compose(delegate, new CollectionFilterPipe(collection, Filter.EQUAL));
        }
        Pipe.metaClass.except = {final Collection collection, final Closure closure ->
            return Gremlin.compose(delegate, new CollectionFilterPipe(collection, Filter.EQUAL), closure);
        }

        Gremlin.addStep(GremlinTokens.RETAIN);
        Pipe.metaClass.retain = {final Collection collection ->
            return Gremlin.compose(delegate, new CollectionFilterPipe(collection, Filter.NOT_EQUAL));
        }


        Pipe.metaClass.retain = {final Collection collection, final Closure closure ->
            return Gremlin.compose(delegate, new CollectionFilterPipe(collection, Filter.NOT_EQUAL), closure);
        }

        Gremlin.addStep(GremlinTokens.GATHER);
        Pipe.metaClass.gather = {final Closure closure ->
            GremlinPipeline pipeline;
            pipeline = Gremlin.compose(delegate, new GatherPipe())
            if (closure)
                pipeline = Gremlin.compose(pipeline, new ClosureTransformPipe(closure))
            return pipeline;
        }

        Gremlin.addStep(GremlinTokens.SCATTER);
        Pipe.metaClass.scatter = {final Closure closure ->
            return Gremlin.compose(delegate, new ScatterPipe(), closure)
        }

        Gremlin.addStep(GremlinTokens.PATHS);
        Pipe.metaClass.paths = {->
            return Gremlin.compose(delegate, new PathPipe())
        }
        Pipe.metaClass.paths = { final Closure... closures ->
            return Gremlin.compose(delegate, new PathClosurePipe(closures));
        }

        Gremlin.addStep(GremlinTokens.OUT);
        [Pipe, Vertex].each {
            it.metaClass.out = {final Closure closure ->
                return Gremlin.compose(delegate, new OutPipe(), closure)
            }
            it.metaClass.out = {final String label, final Closure closure ->
                return Gremlin.compose(delegate, new OutPipe(label), closure)
            }
            it.metaClass.out = {final String... labels ->
                return Gremlin.compose(delegate, new OutPipe(labels))
            }
        }

        Gremlin.addStep(GremlinTokens.OUTE);
        [Pipe, Vertex].each {
            it.metaClass.outE = {final Closure closure ->
                return Gremlin.compose(delegate, new OutEdgesPipe(), closure)
            }
            it.metaClass.outE = {final String label, final Closure closure ->
                return Gremlin.compose(delegate, new OutEdgesPipe(label), closure)
            }
            it.metaClass.outE = {final String... labels ->
                return Gremlin.compose(delegate, new OutEdgesPipe(labels))
            }
        }



        Gremlin.addStep(GremlinTokens.IN);
        [Pipe, Vertex].each {
            it.metaClass.in = {final Closure closure ->
                return Gremlin.compose(delegate, new InPipe(), closure)
            }
            it.metaClass.in = {final String label, final Closure closure ->
                return Gremlin.compose(delegate, new InPipe(label), closure)
            }
            it.metaClass.in = {final String... labels ->
                return Gremlin.compose(delegate, new InPipe(labels))
            }
        }



        Gremlin.addStep(GremlinTokens.INE);
        [Pipe, Vertex].each {
            it.metaClass.inE = {final Closure closure ->
                return Gremlin.compose(delegate, new InEdgesPipe(), closure)
            }
            it.metaClass.inE = {final String label, final Closure closure ->
                return Gremlin.compose(delegate, new InEdgesPipe(label), closure)
            }
            it.metaClass.inE = {final String... labels ->
                return Gremlin.compose(delegate, new InEdgesPipe(labels))
            }
        }

        Gremlin.addStep(GremlinTokens.BOTH);
        [Pipe, Vertex].each {
            it.metaClass.both = {final Closure closure ->
                return Gremlin.compose(delegate, new BothPipe(), closure)
            }
            it.metaClass.both = {final String label, final Closure closure ->
                return Gremlin.compose(delegate, new BothPipe(label), closure)
            }
            it.metaClass.both = {final String... labels ->
                return Gremlin.compose(delegate, new BothPipe(labels))
            }
        }


        Gremlin.addStep(GremlinTokens.BOTHE);
        [Pipe, Vertex].each {
            it.metaClass.bothE = {final Closure closure ->
                return Gremlin.compose(delegate, new BothEdgesPipe(), closure)
            }
            it.metaClass.bothE = {final String label, final Closure closure ->
                return Gremlin.compose(delegate, new BothEdgesPipe(label), closure)
            }
            it.metaClass.bothE = {final String... labels ->
                return Gremlin.compose(delegate, new BothEdgesPipe(labels))
            }
        }

        Gremlin.addStep(GremlinTokens.INV);
        [Pipe, Edge].each {
            it.metaClass.inV = {final Closure closure ->
                return Gremlin.compose(delegate, new InVertexPipe(), closure)
            }
        }

        Gremlin.addStep(GremlinTokens.OUTV);
        [Pipe, Edge].each {
            it.metaClass.outV = {final Closure closure ->
                return Gremlin.compose(delegate, new OutVertexPipe(), closure)
            }
        }

        Gremlin.addStep(GremlinTokens.BOTHV);
        [Pipe, Edge].each {
            it.metaClass.bothV = {final Closure closure ->
                return Gremlin.compose(delegate, new BothVerticesPipe(), closure)
            }
        }
    }
}
