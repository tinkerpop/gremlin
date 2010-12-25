package com.tinkerpop.gremlin.groovy;


import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Element
import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.pipes.IdentityPipe
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.filter.ComparisonFilterPipe.Filter
import com.tinkerpop.pipes.filter.RangeFilterPipe
import com.tinkerpop.pipes.pgm.*
import com.tinkerpop.pipes.AbstractPipe

class GroovyGremlin {
  static {

    final String ID = "id";
    final String LABEL = "label";
    final Set tokens = ["outE", "inE", "outV", "inV", "V", "E", "i"] as Set;

    /*Object.metaClass.propertyMissing = {final String name ->
      return delegate."$name"();
    }*/

    Pipe.metaClass.propertyMissing = {final String name ->
      if (!tokens.contains(name)) {
        if (name.equals(ID)) {
          Pipe pipe = new IdPipe();
          pipe.setStarts(delegate);
          return pipe;
        } else if (name.equals(LABEL)) {
          Pipe pipe = new LabelPipe();
          pipe.setStarts(delegate);
          return pipe;
        } else {
          Pipe pipe = new PropertyPipe(name)
          pipe.setStarts(delegate);
          return pipe;
        }
      } else {
        return delegate."$name"();
      }
    }

    Iterator.metaClass.getAt = {final Range range ->
      Pipe pipe = new RangeFilterPipe(range.getFrom(), range.getTo());
      pipe.setStarts(delegate);
      return pipe;
    }

    VertexEdgePipe.metaClass.getAt = {final String label ->
      if (label.startsWith(":")) {
        Pipe pipe = new LabelFilterPipe(label.substring(1), Filter.NOT_EQUAL);
        pipe.setStarts(delegate);
        return pipe;
      } else {
        return delegate.propertyMissing(label);
      }
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

    def compose = {final Object start, final Pipe pipe, final Closure closure ->
      pipe.setStarts(start.iterator());
      if (closure) {
        final Pipe pipe2 = new ClosureFilterPipe(closure);
        pipe2.setStarts(pipe);
        return pipe2;
      } else {
        return pipe;
      }
    }

    Pipe.metaClass.call = {final Closure closure ->
      return compose.call(delegate, new IdentityPipe(), closure)
    }

    Object.metaClass.i = {final Closure closure ->
      return compose.call(delegate, new IdentityPipe(), closure)
    }

    Object.metaClass.outE = {final Closure closure ->
      return compose.call(delegate, new VertexEdgePipe(VertexEdgePipe.Step.OUT_EDGES), closure)
    }

    Object.metaClass.inE = {final Closure closure ->
      return compose.call(delegate, new VertexEdgePipe(VertexEdgePipe.Step.IN_EDGES), closure)
    }

    Object.metaClass.inV = {final Closure closure ->
      return compose.call(delegate, new EdgeVertexPipe(EdgeVertexPipe.Step.IN_VERTEX), closure)
    }

    Object.metaClass.outV = {final Closure closure ->
      return compose.call(delegate, new EdgeVertexPipe(EdgeVertexPipe.Step.OUT_VERTEX), closure)
    }

    Object.metaClass.V = {final Closure closure ->
      return compose.call(delegate, new GraphElementPipe(GraphElementPipe.ElementType.VERTEX), closure)
    }

    Object.metaClass.E = {final Closure closure ->
      return compose.call(delegate, new GraphElementPipe(GraphElementPipe.ElementType.EDGE), closure)
    }

    Graph.metaClass.v = {final Object id ->
      return delegate.getVertex(id);
    }

    Graph.metaClass.e = {final Object id ->
      return delegate.getEdge(id);
    }
  }
}
