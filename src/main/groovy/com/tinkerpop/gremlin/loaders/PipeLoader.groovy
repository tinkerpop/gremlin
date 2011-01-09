package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens.T
import com.tinkerpop.gremlin.pipes.ClosurePipe
import com.tinkerpop.gremlin.pipes.GremlinPipeline
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.PipeHelper
import com.tinkerpop.pipes.filter.ComparisonFilterPipe.Filter
import com.tinkerpop.pipes.sideeffect.AggregatorPipe
import com.tinkerpop.pipes.sideeffect.GroupCountPipe
import com.tinkerpop.pipes.util.GatherPipe
import com.tinkerpop.pipes.util.HasNextPipe
import com.tinkerpop.pipes.util.PathPipe
import com.tinkerpop.pipes.util.ScatterPipe
import com.tinkerpop.pipes.filter.*
import com.tinkerpop.pipes.pgm.*

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class PipeLoader {

  public static void load() {

    Pipe.metaClass.propertyMissing = {final String name ->
      if (Gremlin.getMissingMethods(delegate.getClass()).contains(name)) {
        return delegate."$name"();
      } else {
        if (name.equals(com.tinkerpop.gremlin.GremlinTokens.ID)) {
          return Gremlin.compose(delegate, new IdPipe());
        } else if (name.equals(com.tinkerpop.gremlin.GremlinTokens.LABEL)) {
          return Gremlin.compose(delegate, new LabelPipe());
        } else {
          return Gremlin.compose(delegate, new PropertyPipe(name));
        }
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.rightShift = {final Collection collection ->
        final Iterator itty;
        if (delegate instanceof Iterable) {
          itty = delegate.iterator();
        } else {
          itty = (Iterator) delegate;
        }
        PipeHelper.fillCollection(itty, collection);
        return collection;
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.rightShift = {final Integer count ->
        final Iterator itty;
        if (delegate instanceof Iterable) {
          itty = delegate.iterator();
        } else {
          itty = (Iterator) delegate;
        }

        if (count == -1) {
          while (itty.hasNext()) {
            itty.next();
          }
          return delegate;
        } else if (count == 1) {
          return itty.next();
        } else {
          List objects = new LinkedList();
          for (int i = 0; i < count; i++) {
            objects.add(itty.next());
          }
          return objects;
        }
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.getAt = {final Integer index ->
        return Gremlin.compose(delegate, new RangeFilterPipe(index as Integer, index + 1 as Integer));
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.getAt = {final Range range ->
        return Gremlin.compose(delegate, new RangeFilterPipe(range.getFrom() as Integer, range.getTo() as Integer));
      }
    }

    GremlinPipeline.metaClass.cap = {->
      final GremlinPipeline pipeline = ((GremlinPipeline) delegate);
      pipeline.capPipe(pipeline.size() - 1);
      return pipeline;
    }

    [Iterator, Iterable].each {
      it.metaClass.getAt = {final Map map ->
        GremlinPipeline pipeline = Gremlin.compose(delegate);
        map.each {key, value ->
          if (key.equals(com.tinkerpop.gremlin.GremlinTokens.LABEL)) {
            if (value instanceof List) {
              pipeline.addPipe(new LabelFilterPipe((String) value[1], Gremlin.mapFilter(value[0])))
            } else {
              pipeline.addPipe(new LabelFilterPipe((String) value, Filter.NOT_EQUAL));
            }
          } else if (key.equals(com.tinkerpop.gremlin.GremlinTokens.ID)) {
            if (value instanceof List) {
              pipeline.addPipe(new IdFilterPipe(value[1], Gremlin.mapFilter(value[0])))
            } else {
              pipeline.addPipe(new IdFilterPipe(value, Filter.NOT_EQUAL));
            }
          } else {
            if (value instanceof List) {
              pipeline.addPipe(new PropertyFilterPipe((String) key, value[1], Gremlin.mapFilter(value[0])))
            } else {
              pipeline.addPipe(new PropertyFilterPipe((String) key, value, Filter.NOT_EQUAL))
            }
          }

        }
        return pipeline;
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.getAt = {final String name ->
        return getAtStringClosure(delegate, name);
      }
    }

    ///////////////////////////
    ////////// PIPES //////////
    ///////////////////////////

    [Iterator, Iterable].each {
      it.metaClass.aggregate = {final Object ... params ->
        if (params) {
          return Gremlin.compose(delegate, new AggregatorPipe((Collection) params[0]))
        } else {
          return Gremlin.compose(delegate, new AggregatorPipe(new LinkedList()));
        }
      }
    }


    [Iterator, Iterable].each {
      it.metaClass.groupCount = {final Object ... params ->
        if (params) {
          return Gremlin.compose(delegate, new GroupCountPipe((Map) params[0]))
        } else {
          return Gremlin.compose(delegate, new GroupCountPipe(new HashMap()));
        }
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.unique = {final Closure closure ->
        return Gremlin.compose(delegate, new DuplicateFilterPipe())
      }
    }

    // todo: add split/merge behavior when good design comes
    /*Pipe.metaClass.split = {final Pipe ... pipes ->
      CopySplitPipe split = new CopySplitPipe(pipes.length);
      for (int i = 0; i < pipes.length; i++) {
        pipes[i].setStarts((Iterator) split.getSplit(i));
      }
      RobinMergePipe merge = new RobinMergePipe();
      merge.setStarts(pipes.iterator());
      Gremlin.compose(delegate, split, null);
      return merge;
    }*/


    [Iterator, Iterable].each {
      it.metaClass.andf = {final Pipe ... pipes ->
        return Gremlin.compose(delegate, new AndFilterPipe(pipes.collect {new HasNextPipe((Pipe) it)} as List))
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.orf = {final Pipe ... pipes ->
        return Gremlin.compose(delegate, new OrFilterPipe(pipes.collect {new HasNextPipe((Pipe) it)} as List))
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.futuref = {final Pipe pipe ->
        return Gremlin.compose(delegate, new FutureFilterPipe(pipe))
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.gather = {final Closure closure ->
        final GremlinPipeline pipeline = new GremlinPipeline();
        pipeline.addPipe(new GatherPipe())
        if (closure)
          pipeline.addPipe(new ClosurePipe(closure));
        return Gremlin.compose(delegate, pipeline)

      }
    }

    [Iterator, Iterable].each {
      it.metaClass.scatter = {final Closure closure ->
        return Gremlin.compose(delegate, new ScatterPipe(), closure)
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.paths = {final Closure closure ->
        return Gremlin.compose(delegate, new PathPipe(), closure)
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.step = {final Closure closure ->
        return Gremlin.compose(delegate, new ClosurePipe(closure))
      }
    }


    [Iterator, Iterable, Vertex, Edge].each {
      it.metaClass.propf = {final String key, final T t, final Object value ->
        if (key.equals(com.tinkerpop.gremlin.GremlinTokens.ID)) {
          return Gremlin.compose(delegate, new IdFilterPipe(value, Gremlin.mapFilter(t)));
        } else if (key.equals(com.tinkerpop.gremlin.GremlinTokens.LABEL)) {
          return Gremlin.compose(delegate, new LabelFilterPipe((String) value, Gremlin.mapFilter(t)))
        } else {
          return Gremlin.compose(delegate, new PropertyFilterPipe(key, value, Gremlin.mapFilter(t)));
        }
      }
    }

    [Iterator, Iterable, Vertex].each {
      it.metaClass.outE = {final Closure closure ->
        return Gremlin.compose(delegate, new VertexEdgePipe(VertexEdgePipe.Step.OUT_EDGES), closure)
      }
    }

    [Iterator, Iterable, Vertex].each {
      it.metaClass.inE = {final Closure closure ->
        return Gremlin.compose(delegate, new VertexEdgePipe(VertexEdgePipe.Step.IN_EDGES), closure)
      }
    }

    [Iterator, Iterable, Vertex].each {
      it.metaClass.bothE = {final Closure closure ->
        return Gremlin.compose(delegate, new VertexEdgePipe(VertexEdgePipe.Step.BOTH_EDGES), closure)
      }
    }

    [Iterator, Iterable, Edge].each {
      it.metaClass.inV = {final Closure closure ->
        return Gremlin.compose(delegate, new EdgeVertexPipe(EdgeVertexPipe.Step.IN_VERTEX), closure)
      }
    }

    [Iterator, Iterable, Edge].each {
      it.metaClass.outV = {final Closure closure ->
        return Gremlin.compose(delegate, new EdgeVertexPipe(EdgeVertexPipe.Step.OUT_VERTEX), closure)
      }
    }


    [Iterator, Iterable, Edge].each {
      it.metaClass.bothV = {final Closure closure ->
        return Gremlin.compose(delegate, new EdgeVertexPipe(EdgeVertexPipe.Step.BOTH_VERTICES), closure)
      }
    }
  }
}
