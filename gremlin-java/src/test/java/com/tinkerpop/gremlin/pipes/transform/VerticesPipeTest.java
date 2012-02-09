package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.iterators.SingleIterator;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class VerticesPipeTest extends TestCase {

    public void testVertexIterator() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Pipe<Graph, Vertex> pipe = new VerticesPipe();
        pipe.setStarts(new SingleIterator<Graph>(graph));
        int counter = 0;
        Set<Vertex> vertices = new HashSet<Vertex>();
        while (pipe.hasNext()) {
            counter++;
            Vertex vertex = pipe.next();
            vertices.add(vertex);
            //System.out.println(vertex);
        }
        assertEquals(counter, 6);
        assertEquals(vertices.size(), 6);
    }
}
