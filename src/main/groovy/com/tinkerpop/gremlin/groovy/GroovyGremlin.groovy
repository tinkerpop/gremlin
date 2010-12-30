package com.tinkerpop.gremlin.groovy;


import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Element
import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.pipes.IdentityPipe
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.filter.ComparisonFilterPipe.Filter
import com.tinkerpop.pipes.filter.FutureFilterPipe
import com.tinkerpop.pipes.filter.RangeFilterPipe
import com.tinkerpop.pipes.merge.RobinMergePipe
import com.tinkerpop.pipes.split.CopySplitPipe
import com.tinkerpop.pipes.pgm.*
import com.tinkerpop.gremlin.groovy.Filters.F

class GroovyGremlin {

  private final String ID = "id";
  private final String LABEL = "label";
  private final Set tokens = ["outE", "inE", "outV", "inV", "V", "E", "i", "propf", "andf", "orf", "step", "futuref"] as Set;


  GroovyGremlin() {

    Object.metaClass.propertyMissing = {final String name ->
      //println "marko! ${name}"
      if (!tokens.contains(name)) {
        if (name.equals(ID)) {
          return compose(delegate, new IdPipe());
        } else if (name.equals(LABEL)) {
          return compose(delegate, new LabelPipe());
        } else {
          return compose(delegate, new PropertyPipe(name));
        }
      } else {
        return delegate."$name"();
      }
    }

    Iterator.metaClass.getAt = {final Range range ->
      return compose(delegate, new RangeFilterPipe(range.getFrom(), range.getTo()));
    }

    Iterator.metaClass.getAt = {final Map map ->
      GroovyPipeline pipeline = compose(delegate);
      map.each {key, value ->
        if (key.equals(LABEL)) {
          if (value instanceof List) {
            pipeline.addPipe(new LabelFilterPipe(value[1], mapFilter(value[0])))
          } else {
            pipeline.addPipe(new LabelFilterPipe(value, Filter.NOT_EQUAL));
          }
        } else if (key.equals(ID)) {
          pipeline.addPipe(new IdFilterPipe(value, Filter.NOT_EQUAL));
        } else {
          if (value instanceof List) {
            pipeline.addPipe(new PropertyFilterPipe(key, value[1], mapFilter(value[0])))
          } else {
            pipeline.addPipe(new PropertyFilterPipe(key, value, Filter.NOT_EQUAL))
          }
        }

      }
      return pipeline;
    }

    Element.metaClass.propertyMissing = {final String name ->
      if (!tokens.contains(name)) {
        if (name.equals(ID)) {
          return delegate.getId();
        } else if (delegate instanceof Edge && name.equals(LABEL)) {
          return delegate.getLabel();
        } else {
          return delegate.getProperty(name)
        }
      } else {
        return delegate."$name"();
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

    Object.metaClass.futuref = {final Pipe pipe ->
      return compose(delegate, new FutureFilterPipe(pipe), null)
    }

    Object.metaClass.propf = {final String key, final F f, final Object value ->
      if (key.equals(ID)) {
        return compose(delegate, new IdFilterPipe(value, mapFilter(f)), null);
      } else if (key.equals(LABEL)) {
        return compose(delegate, new LabelFilterPipe(value, mapFilter(f)), null)
      } else {
        return compose(delegate, new PropertyFilterPipe(key, value, mapFilter(f)), null);
      }
    }

    Object.metaClass.andf = {final Pipe ... pipes ->
      return compose(delegate, new AndFutureFilterPipe(pipes), null);
    }

    Object.metaClass.orf = {final Pipe ... pipes ->
      return compose(delegate, new OrFutureFilterPipe(pipes), null);
    }

    Object.metaClass.step = {final Closure stepClosure ->
      return compose(delegate, new ClosurePipe(stepClosure), null);
    }

    Object.metaClass.outE = {final Closure closure ->
      return compose(delegate, new VertexEdgePipe(VertexEdgePipe.Step.OUT_EDGES), closure)
    }

    Object.metaClass.inE = {final Closure closure ->
      return compose(delegate, new VertexEdgePipe(VertexEdgePipe.Step.IN_EDGES), closure)
    }

    Object.metaClass.inV = {final Closure closure ->
      return compose(delegate, new EdgeVertexPipe(EdgeVertexPipe.Step.IN_VERTEX), closure)
    }

    Object.metaClass.outV = {final Closure closure ->
      return compose(delegate, new EdgeVertexPipe(EdgeVertexPipe.Step.OUT_VERTEX), closure)
    }

    Object.metaClass.V = {final Closure closure ->
      return compose(delegate, new GraphElementPipe(GraphElementPipe.ElementType.VERTEX), closure)
    }

    Object.metaClass.E = {final Closure closure ->
      return compose(delegate, new GraphElementPipe(GraphElementPipe.ElementType.EDGE), closure)
    }

    Object.metaClass.i = {final Closure closure ->
      return compose(delegate, new IdentityPipe(), closure)
    }

    Graph.metaClass.v = {final Object id ->
      return delegate.getVertex(id);
    }

    Graph.metaClass.e = {final Object id ->
      return delegate.getEdge(id);
    }

  }

  public static Filter mapFilter(final f) {
    if (f == f.eq)
      return Filter.NOT_EQUAL; else if (f == f.neq)
      return Filter.EQUAL; else if (f == f.lt)
        return Filter.GREATER_THAN_EQUAL; else if (f == f.lte)
          return Filter.GREATER_THAN; else if (f == f.gt)
            return Filter.LESS_THAN_EQUAL; else
            return Filter.LESS_THAN;

  }

  private GroovyPipeline compose(final Object start) {
    return compose(start, null, null);
  }

  private GroovyPipeline compose(final Object start, final Pipe pipe) {
    return compose(start, pipe, null);
  }

  private GroovyPipeline compose(final Object start, final Pipe pipe, final Closure closure) {
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
}
