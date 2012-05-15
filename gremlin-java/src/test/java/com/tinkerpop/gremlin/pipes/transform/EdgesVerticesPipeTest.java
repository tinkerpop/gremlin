package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.pipes.util.iterators.SingleIterator;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.NoSuchElementException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class EdgesVerticesPipeTest extends TestCase {

    public void testBothVertices() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex josh = graph.getVertex("4");
        Edge tempEdge = null;
        for (Edge edge : josh.getEdges(Direction.OUT)) {
            if (edge.getId().equals("11"))
                tempEdge = edge;
        }
        EdgesVerticesPipe pipe = new EdgesVerticesPipe(Direction.BOTH);
        pipe.setStarts(new SingleIterator<Edge>(tempEdge));
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            Vertex vertex = pipe.next();
            assertTrue(vertex.getId().equals("4") || vertex.getId().equals("3"));
        }
        assertEquals(counter, 2);

    }

    public void testInVertex1() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        EdgesVerticesPipe pipe = new EdgesVerticesPipe(Direction.IN);
        pipe.setStarts(marko.getEdges(Direction.OUT));
        assertTrue(pipe.hasNext());
        int counter = 0;
        while (pipe.hasNext()) {
            Vertex v = pipe.next();
            assertTrue(v.getId().equals("2") || v.getId().equals("3") || v.getId().equals("4"));
            counter++;
        }
        assertEquals(counter, 3);

        Vertex josh = graph.getVertex("4");
        pipe = new EdgesVerticesPipe(Direction.IN);
        pipe.setStarts(josh.getEdges(Direction.OUT).iterator());
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


    public void testInVertex2() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        EdgesVerticesPipe pipe = new EdgesVerticesPipe(Direction.OUT);
        pipe.setStarts(marko.getEdges(Direction.OUT));
        Assert.assertTrue(pipe.hasNext());
        int counter = 0;
        while (pipe.hasNext()) {
            Vertex v = pipe.next();
            Assert.assertTrue(v.getId().equals("1"));
            counter++;
        }
        Assert.assertEquals(counter, 3);
    }

}
