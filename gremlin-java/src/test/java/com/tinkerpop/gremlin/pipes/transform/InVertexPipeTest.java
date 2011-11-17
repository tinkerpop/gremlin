package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import junit.framework.TestCase;

import java.util.NoSuchElementException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class InVertexPipeTest extends TestCase {

    public void testInVertex() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        InVertexPipe pipe = new InVertexPipe();
        pipe.setStarts(marko.getOutEdges());
        assertTrue(pipe.hasNext());
        int counter = 0;
        while (pipe.hasNext()) {
            Vertex v = pipe.next();
            assertTrue(v.getId().equals("2") || v.getId().equals("3") || v.getId().equals("4"));
            counter++;
        }
        assertEquals(counter, 3);

        Vertex josh = graph.getVertex("4");
        pipe = new InVertexPipe();
        pipe.setStarts(josh.getOutEdges().iterator());
        assertTrue(pipe.hasNext());
        counter = 0;
        while (pipe.hasNext()) {
            Vertex v = pipe.next();
            assertTrue(v.getId().equals("5") || v.getId().equals("3"));
            counter++;
        }
        assertEquals(counter, 2);
        try {
            pipe.next();
            assertTrue(false);
        } catch (NoSuchElementException e) {
            assertFalse(false);
        }
    }
}
