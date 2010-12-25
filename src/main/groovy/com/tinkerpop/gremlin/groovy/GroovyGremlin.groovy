package com.tinkerpop.gremlin.groovy;

import com.tinkerpop.blueprints.pgm.Element
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.pgm.EdgeVertexPipe
import com.tinkerpop.pipes.pgm.GraphElementPipe
import com.tinkerpop.pipes.pgm.IdPipe
import com.tinkerpop.pipes.pgm.VertexEdgePipe

class GroovyGremlin {
  static {
    Set tokens = ["outE", "inE", "outV", "inV", "V", "E"] as Set;

    Object.metaClass.propertyMissing = {final String name ->
      if (delegate instanceof Element && !tokens.contains(name)) {
        return delegate.getProperty(name)
      } else {
        return delegate."$name"();
      }
    }

    def compose = {final Object start, final Pipe pipe, final Closure c ->
      pipe.setStarts(start.iterator());
      if (c) {
        final Pipe pipe2 = new ClosureFilterPipe(c);
        pipe2.setStarts(pipe);
        return pipe2;
      } else {
        return pipe;
      }
    }

    Object.metaClass.outE = {final Closure c ->
      return compose.call(delegate, new VertexEdgePipe(VertexEdgePipe.Step.OUT_EDGES), c)
    }

    Object.metaClass.inE = {final Closure c ->
      return compose.call(delegate, new VertexEdgePipe(VertexEdgePipe.Step.IN_EDGES), c)
    }

    Object.metaClass.inV = {final Closure c ->
      return compose.call(delegate, new EdgeVertexPipe(EdgeVertexPipe.Step.IN_VERTEX), c)
    }

    Object.metaClass.outV = {final Closure c ->
      return compose.call(delegate, new EdgeVertexPipe(EdgeVertexPipe.Step.OUT_VERTEX), c)
    }

    Object.metaClass.V = {final Closure c ->
      return compose.call(delegate, new GraphElementPipe(GraphElementPipe.ElementType.VERTEX), c)
    }

    Object.metaClass.E = {final Closure c ->
      return compose.call(delegate, new GraphElementPipe(GraphElementPipe.ElementType.EDGE), c)
    }

    Object.metaClass.id = {final Closure c ->
      return compose.call(delegate, new IdPipe(), c);
    }

    // todo: determine if findAll{} is truly iterator friendly. If so, findAll{} is !filter{}
    Object.metaClass.filter = {final Closure c ->
      final Pipe pipe = new ClosureFilterPipe(c);
      pipe.setStarts(delegate.iterator());
      return pipe;
    }

    // todo: determine if each{} is truly iterator friendly. If so, pipe{} is each{}
    Object.metaClass.pipe = {final Closure c ->
      final Pipe pipe = new ClosurePipe(c);
      pipe.setStarts(delegate.iterator());
      return pipe;
    }

    // todo: determine if each{} is truly iterator friendly. if so, eval{} is each{} with no closure
    Object.metaClass.eval() {
      final Iterator itty = delegate.iterator();
      while (itty.hasNext()) {
        itty.next();
      }
    }
  }
}
