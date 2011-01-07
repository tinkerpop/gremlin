package com.tinkerpop.gremlin;


import com.tinkerpop.gremlin.GremlinTokens.T
import com.tinkerpop.gremlin.console.Imports
import com.tinkerpop.gremlin.pipes.ClosureFilterPipe
import com.tinkerpop.gremlin.pipes.ClosurePipe
import com.tinkerpop.gremlin.pipes.GremlinPipeline
import com.tinkerpop.pipes.IdentityPipe
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.PipeHelper
import com.tinkerpop.pipes.filter.ComparisonFilterPipe.Filter
import com.tinkerpop.pipes.sideeffect.CountCombinePipe
import com.tinkerpop.pipes.sideeffect.SideEffectCapPipe
import com.tinkerpop.pipes.util.GatherPipe
import com.tinkerpop.pipes.util.HasNextPipe
import com.tinkerpop.pipes.util.PathPipe
import com.tinkerpop.pipes.util.ScatterPipe
import com.tinkerpop.blueprints.pgm.*
import com.tinkerpop.pipes.filter.*
import com.tinkerpop.pipes.pgm.*

class Gremlin {

  private static final String ID = "id";
  private static final String LABEL = "label";
  private static final String VERTICES = "vertices";
  private static final String EDGES = "edges"


  public static void load() {

    Object.metaClass.propertyMissing = {final String name ->
      if (GremlinHelper.getMissingMethods(delegate.getClass()).contains(name)) {
        return delegate."$name"();
      } else {
        throw new MissingPropertyException(name, delegate.getClass());
      }
    }

    Pipe.metaClass.propertyMissing = {final String name ->
      if (GremlinHelper.getMissingMethods(delegate.getClass()).contains(name)) {
        return delegate."$name"();
      } else {
        return delegate.getAt(name);
      }
    }

    Graph.metaClass.propertyMissing = {final String name ->
      if (GremlinHelper.getMissingMethods(delegate.getClass()).contains(name)) {
        return delegate."$name"();
      } else {
        throw new MissingPropertyException(name, delegate.getClass());
      }
    }

    Vertex.metaClass.propertyMissing = {final String name ->
      if (GremlinHelper.getMissingMethods(delegate.getClass()).contains(name)) {
        return delegate."$name"();
      } else {
        if (name.equals(ID)) {
          return delegate.getId();
        } else {
          return delegate.getProperty(name)
        }
      }
    }

    Edge.metaClass.propertyMissing = {final String name ->
      if (GremlinHelper.getMissingMethods(delegate.getClass()).contains(name)) {
        return delegate."$name"();
      } else {
        if (name.equals(ID)) {
          return delegate.getId();
        } else if (name.equals(LABEL)) {
          return delegate.getLabel();
        } else {
          return delegate.getProperty(name)
        }
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.rightShift = {final Collection collection ->
        PipeHelper.fillCollection((Iterator) delegate, collection);
        return collection;
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.rightShift = {final Integer count ->
        if (count == -1) {
          while (delegate.hasNext()) {
            delegate.next();
          }
        } else if (count == 1) {
          return delegate.next();
        } else {
          List objects = new ArrayList();
          for (int i = 0; i < count; i++) {
            objects.add(delegate.next());
          }
          return objects;
        }
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.getAt = {final Integer index ->
        return compose(delegate, new RangeFilterPipe(index as Integer, index + 1 as Integer));
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.getAt = {final Range range ->
        return compose(delegate, new RangeFilterPipe(range.getFrom() as Integer, range.getTo() as Integer));
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.getAt = {final Map map ->
        GremlinPipeline pipeline = compose(delegate);
        map.each {key, value ->
          if (key.equals(LABEL)) {
            if (value instanceof List) {
              pipeline.addPipe(new LabelFilterPipe((String) value[1], mapFilter(value[0])))
            } else {
              pipeline.addPipe(new LabelFilterPipe((String) value, Filter.NOT_EQUAL));
            }
          } else if (key.equals(ID)) {
            pipeline.addPipe(new IdFilterPipe(value, Filter.NOT_EQUAL));
          } else {
            if (value instanceof List) {
              pipeline.addPipe(new PropertyFilterPipe((String) key, value[1], mapFilter(value[0])))
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
        if (name.equals(ID)) {
          return compose(delegate, new IdPipe());
        } else if (name.equals(LABEL)) {
          return compose(delegate, new LabelPipe());
        } else {
          return compose(delegate, new PropertyPipe(name));
        }
      }
    }

    /*
     * PIPES THROUGH METACLASS EXTENSIONS
     */

    Object.metaClass._ = {final Closure closure ->
      return compose(delegate, new IdentityPipe(), closure)
    }

    [Iterator, Iterable].each {
      it.metaClass.group_count = {final Closure closure ->
        return compose(delegate, new SideEffectCapPipe(new CountCombinePipe()), closure)
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.unique = {final Closure closure ->
        return compose(delegate, new DuplicateFilterPipe())
      }
    }

    /*Pipe.metaClass.split = {final Pipe ... pipes ->
      CopySplitPipe split = new CopySplitPipe(pipes.length);
      for (int i = 0; i < pipes.length; i++) {
        pipes[i].setStarts((Iterator) split.getSplit(i));
      }
      RobinMergePipe merge = new RobinMergePipe();
      merge.setStarts(pipes.iterator());
      compose(delegate, split, null);
      return merge;
    }*/


    [Iterator, Iterable].each {
      it.metaClass.andf = {final Pipe ... pipes ->
        return compose(delegate, new AndFilterPipe(pipes.collect {new HasNextPipe((Pipe) it)} as List))
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.orf = {final Pipe ... pipes ->
        return compose(delegate, new OrFilterPipe(pipes.collect {new HasNextPipe((Pipe) it)} as List))
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.futuref = {final Pipe pipe ->
        return compose(delegate, new FutureFilterPipe(pipe))
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.gather = {final Closure closure ->
        final GremlinPipeline pipeline = new GremlinPipeline();
        pipeline.addPipe(new GatherPipe())
        if (closure)
          pipeline.addPipe(new ClosurePipe(closure));
        return compose(delegate, pipeline)

      }
    }

    [Iterator, Iterable].each {
      it.metaClass.scatter = {final Closure closure ->
        return compose(delegate, new ScatterPipe(), closure)
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.paths = {final Closure closure ->
        return compose(delegate, new PathPipe(), closure)
      }
    }

    [Iterator, Iterable].each {
      it.metaClass.step = {final Closure closure ->
        return compose(delegate, new ClosurePipe(closure))
      }
    }


    [Iterator, Iterable, Vertex, Edge].each {
      it.metaClass.propf = {final String key, final T f, final Object value ->
        if (key.equals(ID)) {
          return compose(delegate, new IdFilterPipe(value, mapFilter(f)), null);
        } else if (key.equals(LABEL)) {
          return compose(delegate, new LabelFilterPipe((String) value, mapFilter(f)), null)
        } else {
          return compose(delegate, new PropertyFilterPipe(key, value, mapFilter(f)), null);
        }
      }
    }

    [Iterator, Iterable, Vertex].each {
      it.metaClass.outE = {final Closure closure ->
        return compose(delegate, new VertexEdgePipe(VertexEdgePipe.Step.OUT_EDGES), closure)
      }
    }

    [Iterator, Iterable, Vertex].each {
      it.metaClass.inE = {final Closure closure ->
        return compose(delegate, new VertexEdgePipe(VertexEdgePipe.Step.IN_EDGES), closure)
      }
    }

    [Iterator, Iterable, Vertex].each {
      it.metaClass.bothE = {final Closure closure ->
        return compose(delegate, new VertexEdgePipe(VertexEdgePipe.Step.BOTH_EDGES), closure)
      }
    }

    [Iterator, Iterable, Edge].each {
      it.metaClass.inV = {final Closure closure ->
        return compose(delegate, new EdgeVertexPipe(EdgeVertexPipe.Step.IN_VERTEX), closure)
      }
    }

    [Iterator, Iterable, Edge].each {
      it.metaClass.outV = {final Closure closure ->
        compose(delegate, new EdgeVertexPipe(EdgeVertexPipe.Step.OUT_VERTEX), closure)
      }
    }


    [Iterator, Iterable, Edge].each {
      it.metaClass.bothV = {final Closure closure ->
        return compose(delegate, new EdgeVertexPipe(EdgeVertexPipe.Step.BOTH_VERTICES), closure)
      }
    }

    Element.metaClass.map = {
      final Map<String, Object> map = new HashMap<String, Object>();
      for (final String key: delegate.getPropertyKeys()) {
        map.put(key, delegate.getProperty(key))
      }
      return map;
    }

    Element.metaClass.keys = {
      return delegate.getPropertyKeys()
    }

    Element.metaClass.values = {
      final List values = new ArrayList();
      for (final String key: delegate.getPropertyKeys()) {
        values.add(delegate.getProperty(key))
      }
      return values;
    }

    Graph.metaClass.V = {final Closure closure ->
      return compose(delegate, new GraphElementPipe(GraphElementPipe.ElementType.VERTEX), closure)
    }

    Graph.metaClass.E = {final Closure closure ->
      return compose(delegate, new GraphElementPipe(GraphElementPipe.ElementType.EDGE), closure)
    }

    Graph.metaClass.v = {final Object id ->
      return delegate.getVertex(id);
    }

    Graph.metaClass.e = {final Object id ->
      return delegate.getEdge(id);
    }

    IndexableGraph.metaClass.idx = {final Object idx ->
      String name;
      if (idx.equals(T.v))
        name = VERTICES else if (idx.equals(T.e))
        name = EDGES else
        name = idx.toString()

      return delegate.getIndices().find {it.getIndexName().equals(name)}
    }

    Index.metaClass.getAt = {final Map query ->
      def entry = query.iterator().next();
      return delegate.get(entry.key, entry.value);
    }

  }

  private static Filter mapFilter(final t) {
    if (t == t.eq)
      return Filter.NOT_EQUAL else if (t == t.neq)
      return Filter.EQUAL else if (t == t.lt)
        return Filter.GREATER_THAN_EQUAL else if (t == t.lte)
          return Filter.GREATER_THAN else if (t == t.gt)
            return Filter.LESS_THAN_EQUAL else
            return Filter.LESS_THAN

  }

  public static GremlinPipeline compose(final Object start) {
    return compose(start, null, null);
  }

  public static GremlinPipeline compose(final Object start, final Pipe pipe) {
    return compose(start, pipe, null);
  }

  public static GremlinPipeline compose(final Object start, final Pipe pipe, final Closure closure) {
    GremlinPipeline pipeline;
    if (start instanceof GremlinPipeline) {
      pipeline = start;
      if (null != pipe)
        pipeline.addPipe(pipe);
    } else if (start instanceof Pipe) {
      pipeline = new GremlinPipeline();
      pipeline.addPipe(start);
      if (null != pipe)
        pipeline.addPipe(pipe);
    } else {
      pipeline = new GremlinPipeline();
      if (null != pipe)
        pipeline.addPipe(pipe);
      pipeline.setStarts(start.iterator());
    }
    if (closure) {
      pipeline.addPipe(new ClosureFilterPipe(closure));
    }
    return pipeline;
  }

  public static Pipe compile(final String gremlin) {
    GroovyShell groovy = GroovyShell.newInstance()
    StringBuilder sb = new StringBuilder()
    for (String importItem: Imports.getImports())
      sb.append("import ").append(importItem).append("\n");
    sb.append(gremlin);
    return (Pipe) groovy.evaluate(sb.toString())
  }
}
