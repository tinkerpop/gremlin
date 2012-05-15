package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.iterators.SingleIterator;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class VerticesEdgesPipeTest extends TestCase {

    public void testBothEdges() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex josh = graph.getVertex("4");
        VerticesEdgesPipe pipe = new VerticesEdgesPipe(Direction.BOTH);
        pipe.setStarts(new SingleIterator<Vertex>(josh));
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            Edge edge = pipe.next();
            assertTrue(edge.getId().equals("8") || edge.getId().equals("10") || edge.getId().equals("11"));
        }
        assertEquals(counter, 3);
    }

    public void testBothEdgesWithLabels() {

        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        VerticesEdgesPipe pipe = new VerticesEdgesPipe(Direction.BOTH, "knows");
        pipe.setStarts(new SingleIterator<Vertex>(marko));
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            Edge edge = pipe.next();
            assertTrue(edge.getVertex(Direction.IN).getProperty("name").equals("josh") || edge.getVertex(Direction.IN).getProperty("name").equals("vadas"));
        }
        assertEquals(counter, 2);
    }

    public void testInEdges() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex josh = graph.getVertex("4");
        VerticesEdgesPipe pipe = new VerticesEdgesPipe(Direction.IN);
        pipe.setStarts(new SingleIterator<Vertex>(josh));
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            Edge edge = pipe.next();
            assertEquals(edge.getId(), "8");
        }
        assertEquals(counter, 1);
    }

    public void testOutGoingEdges() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        VerticesEdgesPipe pipe = new VerticesEdgesPipe(Direction.OUT);
        pipe.setStarts(Arrays.asList(marko).iterator());
        assertTrue(pipe.hasNext());
        int counter = 0;
        while (pipe.hasNext()) {
            Edge e = pipe.next();
            assertEquals(e.getVertex(Direction.OUT), marko);
            assertTrue(e.getVertex(Direction.IN).getId().equals("2") || e.getVertex(Direction.IN).getId().equals("3") || e.getVertex(Direction.IN).getId().equals("4"));
            counter++;
        }
        assertEquals(counter, 3);
        try {
            pipe.next();
            assertTrue(false);
        } catch (NoSuchElementException e) {
            assertFalse(false);
        }

        Vertex josh = graph.getVertex("4");
        pipe = new VerticesEdgesPipe(Direction.OUT);
        pipe.setStarts(Arrays.asList(josh).iterator());
        assertTrue(pipe.hasNext());
        counter = 0;
        while (pipe.hasNext()) {
            Edge e = pipe.next();
            assertEquals(e.getVertex(Direction.OUT), josh);
            assertTrue(e.getVertex(Direction.IN).getId().equals("5") || e.getVertex(Direction.IN).getId().equals("3"));
            counter++;
        }
        assertEquals(counter, 2);
        try {
            pipe.next();
            assertTrue(false);
        } catch (NoSuchElementException e) {
            assertFalse(false);
        }

        Vertex lop = graph.getVertex("3");
        pipe = new VerticesEdgesPipe(Direction.OUT);
        pipe.setStarts(Arrays.asList(lop).iterator());
        assertFalse(pipe.hasNext());
        counter = 0;
        while (pipe.hasNext()) {
            counter++;
        }
        assertEquals(counter, 0);
        try {
            pipe.next();
            assertTrue(false);
        } catch (NoSuchElementException e) {
            assertFalse(false);
        }
    }

    public void testReset() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex josh = graph.getVertex("4");
        VerticesEdgesPipe oep = new VerticesEdgesPipe(Direction.OUT);
        oep.setStarts(Arrays.asList(josh).iterator());
        assertTrue(oep.hasNext());
        assertEquals("5", oep.next().getVertex(Direction.IN).getId());
        assertEquals("3", oep.next().getVertex(Direction.IN).getId());
        assertFalse(oep.hasNext());
        oep.setStarts(Arrays.asList(josh).iterator());
        assertEquals("5", oep.next().getVertex(Direction.IN).getId());
        oep.setStarts(Arrays.asList(josh).iterator());
        // reset is only needed if iteration is abandoned partway through the edge list.
        oep.reset();
        assertEquals("5", oep.next().getVertex(Direction.IN).getId());
        assertEquals("3", oep.next().getVertex(Direction.IN).getId());
        assertFalse(oep.hasNext());
        oep.setStarts(Arrays.asList(josh).iterator());
        // reset does not have a negative effect in a normal case.
        oep.reset();
        assertEquals("5", oep.next().getVertex(Direction.IN).getId());
    }

    public void testBigGraphWithNoEdges() {
        // This used to cause a stack overflow. Not crashing makes this a success.
        TinkerGraph graph = new TinkerGraph();
        for (int i = 0; i < 10000; i++) {
            graph.addVertex(null);
        }
        VerticesEdgesPipe outEdges = new VerticesEdgesPipe(Direction.OUT);
        outEdges.setStarts(graph.getVertices());
        int counter = 0;
        while (outEdges.hasNext()) {
            outEdges.next();
            counter++;
        }
        assertEquals(counter, 0);
    }

    public void testLabelFilterEdges() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex(1);
        Pipe<Vertex, Edge> pipe = new VerticesEdgesPipe(Direction.OUT, "knows");
        pipe.setStarts(Arrays.asList(marko).iterator());
        assertTrue(pipe.hasNext());
        int counter = 0;
        while (pipe.hasNext()) {
            Edge e = pipe.next();
            assertEquals(e.getVertex(Direction.OUT), marko);
            assertTrue(e.getVertex(Direction.IN).getId().equals("2") || e.getVertex(Direction.IN).getId().equals("4"));
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
