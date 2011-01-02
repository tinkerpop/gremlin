package com.tinkerpop.gremlin.groovy;

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Element
import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.gremlin.groovy.Filters.F
import com.tinkerpop.pipes.IdentityPipe
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.PipeHelper
import com.tinkerpop.pipes.filter.ComparisonFilterPipe.Filter
import com.tinkerpop.pipes.filter.FutureFilterPipe
import com.tinkerpop.pipes.filter.RangeFilterPipe
import com.tinkerpop.pipes.merge.RobinMergePipe
import com.tinkerpop.pipes.split.CopySplitPipe
import com.tinkerpop.pipes.util.GatherPipe
import com.tinkerpop.pipes.util.PathPipe
import com.tinkerpop.pipes.util.ScatterPipe
import org.codehaus.groovy.runtime.metaclass.ClosureMetaMethod
import com.tinkerpop.pipes.pgm.*

class GroovyGremlin {

  private final String ID = "id";
  private final String LABEL = "label";
  private final String V = "V";
  private final String E = "E";
  private Set tokens;

  GroovyGremlin() {

    Pipe.metaClass.propertyMissing = {final String name ->
      if (this.tokens.contains(name)) {
        return delegate."$name"();
      } else {
        return delegate.getAt(name);
      }
    }

    Graph.metaClass.propertyMissing = {final String name ->
      if (name.equals(V) | name.equals(E)) {
        return delegate."$name"();
      } else {
        throw new MissingPropertyException(name, delegate.getClass());
      }
    }

    Element.metaClass.propertyMissing = {final String name ->
      if (this.tokens.contains(name)) {
        return delegate."$name"();
      } else {
        if (name.equals(ID)) {
          return delegate.getId();
        } else if (delegate instanceof Edge && name.equals(LABEL)) {
          return delegate.getLabel();
        } else {
          return delegate.getProperty(name)
        }
      }
    }

    Pipe.metaClass.getAt = {final String name ->
      if (name.equals(ID)) {
        return compose(delegate, new IdPipe());
      } else if (name.equals(LABEL)) {
        return compose(delegate, new LabelPipe());
      } else {
        return compose(delegate, new PropertyPipe(name));
      }
    }

    Iterator.metaClass.rightShift = {final Collection collection ->
      PipeHelper.fillCollection((Iterator) delegate, collection);
      return collection;
    }

    Iterator.metaClass.rightShift = {final Integer count ->
      if (count == 1) {
        return delegate.next();
      } else {
        List objects = new ArrayList();
        for (int i = 0; i < count; i++) {
          objects.add(delegate.next());
        }
        return objects;
      }
    }

    Pipe.metaClass.getAt = {final Integer index ->
      return compose(delegate, new RangeFilterPipe(index as Integer, index + 1 as Integer));
    }

    Pipe.metaClass.getAt = {final Range range ->
      return compose(delegate, new RangeFilterPipe(range.getFrom() as Integer, range.getTo() as Integer));
    }

    Pipe.metaClass.getAt = {final Map map ->
      GroovyPipeline pipeline = compose(delegate);
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

    /*
     * PIPES THROUGH METACLASS EXTENSIONS
     */

    Object.metaClass._ = {final Pipe pipe ->
      return compose(delegate, pipe);
    }

    Pipe.metaClass.bitwiseNegate = {
      return new FutureFilterPipe((Pipe) delegate);
    }

    Pipe.metaClass.or = {final Pipe pipe ->
      if (delegate instanceof OrFutureFilterPipe) {
        delegate.addPipe(pipe);
        return delegate;
      } else {
        return new OrFutureFilterPipe((Pipe) delegate, pipe);
      }
    }

    Pipe.metaClass.and = {final Pipe pipe ->
      if (delegate instanceof AndFutureFilterPipe) {
        delegate.addPipe(pipe);
        return delegate;
      } else {
        return new AndFutureFilterPipe((Pipe) delegate, pipe);
      }
    }

    Object.metaClass.split = {final Pipe ... pipes ->
      CopySplitPipe split = new CopySplitPipe(pipes.length);
      for (int i = 0; i < pipes.length; i++) {
        pipes[i].setStarts((Iterator) split.getSplit(i));
      }
      RobinMergePipe merge = new RobinMergePipe();
      merge.setStarts(pipes.iterator());
      compose(delegate, split, null);
      return merge;
    }

    /**
     * PropertyFilterPipe
     */
    Object.metaClass.propf = {final String key, final F f, final Object value ->
      if (key.equals(ID)) {
        return compose(delegate, new IdFilterPipe(value, mapFilter(f)), null);
      } else if (key.equals(LABEL)) {
        return compose(delegate, new LabelFilterPipe((String) value, mapFilter(f)), null)
      } else {
        return compose(delegate, new PropertyFilterPipe(key, value, mapFilter(f)), null);
      }
    }

    /**
     * GatherPipe
     */
    Object.metaClass.gather = {final Closure closure ->
      return compose(delegate, new GatherPipe(), closure);
    }

    /**
     * ScatterPipe
     */
    Object.metaClass.scatter = {final Closure closure ->
      return compose(delegate, new ScatterPipe(), closure);
    }

    /**
     * PathPipe
     */
    Object.metaClass.paths = {final Closure closure ->
      return compose(delegate, new PathPipe(), closure);
    }

    /**
     * ClosurePipe (Anonymous Step)
     */
    Object.metaClass.step = {final Closure closure ->
      return compose(delegate, new ClosurePipe(closure), null);
    }

    /**
     * VertexEdgePipe (OUT_EDGES)
     */
    Object.metaClass.outE = {final Closure closure ->
      return compose(delegate, new VertexEdgePipe(VertexEdgePipe.Step.OUT_EDGES), closure)
    }
    /**
     * VertexEdgePipe (IN_EDGES)
     */
    Object.metaClass.inE = {final Closure closure ->
      return compose(delegate, new VertexEdgePipe(VertexEdgePipe.Step.IN_EDGES), closure)
    }

    /**
     * EdgeVertexPipe (IN_VERTEX)
     */
    Object.metaClass.inV = {final Closure closure ->
      return compose(delegate, new EdgeVertexPipe(EdgeVertexPipe.Step.IN_VERTEX), closure)
    }

    /**
     * EdgeVertexPipe (OUT_VERTEX)
     */
    Object.metaClass.outV = {final Closure closure ->
      return compose(delegate, new EdgeVertexPipe(EdgeVertexPipe.Step.OUT_VERTEX), closure)
    }

    /**
     * IdentityPipe
     */
    Object.metaClass.i = {final Closure closure ->
      return compose(delegate, new IdentityPipe(), closure)
    }

    /**
     * GraphElementPipe (Vertex)
     */
    Graph.metaClass.V = {final Closure closure ->
      return compose(delegate, new GraphElementPipe(GraphElementPipe.ElementType.VERTEX), closure)
    }

    /**
     * GraphElementPipe (Edge)
     */
    Graph.metaClass.E = {final Closure closure ->
      return compose(delegate, new GraphElementPipe(GraphElementPipe.ElementType.EDGE), closure)
    }

    /**
     * getVertex()
     */
    Graph.metaClass.v = {final Object id ->
      return delegate.getVertex(id);
    }

    /**
     * getEdge()
     */
    Graph.metaClass.e = {final Object id ->
      return delegate.getEdge(id);
    }

    this.tokens = new HashSet(Object.metaClass.methods.findAll {it instanceof ClosureMetaMethod}.collect {it.name});
    //this.tokens.addAll(Pipe.metaClass.methods.findAll {it instanceof ClosureMetaMethod}.collect {it.name});
    //this.tokens.addAll(Element.metaClass.methods.findAll {it instanceof ClosureMetaMethod}.collect {it.name});
    this.tokens.remove("propertyMissing");
  }

  private static Filter mapFilter(final f) {
    if (f == f.eq)
      return Filter.NOT_EQUAL; else if (f == f.neq)
      return Filter.EQUAL; else if (f == f.lt)
        return Filter.GREATER_THAN_EQUAL; else if (f == f.lte)
          return Filter.GREATER_THAN; else if (f == f.gt)
            return Filter.LESS_THAN_EQUAL; else
            return Filter.LESS_THAN;

  }

  private static GroovyPipeline compose(final Object start) {
    return compose(start, null, null);
  }

  private static GroovyPipeline compose(final Object start, final Pipe pipe) {
    return compose(start, pipe, null);
  }

  private static GroovyPipeline compose(final Object start, final Pipe pipe, final Closure closure) {
    GroovyPipeline pipeline;
    if (start instanceof GroovyPipeline) {
      pipeline = start;
      if (null != pipe)
        pipeline.addPipe(pipe);
    } else if (start instanceof Pipe) {
      pipeline = new GroovyPipeline();
      pipeline.addPipe(start);
      if (null != pipe)
        pipeline.addPipe(pipe);
    } else {
      pipeline = new GroovyPipeline();
      if (null != pipe)
        pipeline.addPipe(pipe);
      pipeline.setStarts(start.iterator());
    }
    if (closure) {
      pipeline.addPipe(new ClosureFilterPipe(closure));
    }
    return pipeline;
  }

  public static Pipe compile(String gremlin) {
    return (Pipe) GroovyShell.newInstance().evaluate(gremlin);
  }

  public static Collection getSteps(Class clazz) {
    return clazz.metaClass.methods.findAll {it instanceof ClosureMetaMethod & !it.name.equals("propertyMissing")}.collect {it};
  }
}
