package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.SingleIterator;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BothPipeTest extends TestCase {

    public void testBoth() {
        Graph graph = new TinkerGraph();
        Vertex a = graph.addVertex(1);
        Vertex b = graph.addVertex(2);
        Vertex c = graph.addVertex(3);
        Vertex d = graph.addVertex(4);
        graph.addEdge(null, a, b, "knows");
        graph.addEdge(null, b, a, "knows");
        graph.addEdge(null, a, c, "knows");
        graph.addEdge(null, c, a, "created");
        graph.addEdge(null, d, a, "created");
        graph.addEdge(null, d, b, "knows");

        Pipe<Vertex, Vertex> pipe = new BothPipe("knows");
        pipe.setStarts(new SingleIterator<Vertex>(a));
        int counter = 0;
        List<Vertex> list = new ArrayList<Vertex>();
        while (pipe.hasNext()) {
            Vertex v = pipe.next();
            counter++;
            assertTrue(v.equals(b) || v.equals(c));
            list.add(v);
        }
        assertEquals(counter, 3);
        assertEquals(list.size(), 3);
        int t = 0;
        for (Vertex temp : list) {
            if (temp.equals(b))
                t++;
        }
        assertEquals(t, 2);
        t = 0;
        for (Vertex temp : list) {
            if (temp.equals(c))
                t++;
        }
        assertEquals(t, 1);
    }

    public void testBothSelfLoop() {
        Graph graph = new TinkerGraph();
        Vertex a = graph.addVertex(1);
        Vertex b = graph.addVertex(2);
        graph.addEdge(null, a, b, "knows");
        graph.addEdge(null, b, a, "knows");
        graph.addEdge(null, a, a, "knows");

        Pipe<Vertex, Vertex> pipe = new BothPipe("knows");
        pipe.setStarts(new SingleIterator<Vertex>(a));
        int counter = 0;
        List<Vertex> list = new ArrayList<Vertex>();
        while (pipe.hasNext()) {
            Vertex v = pipe.next();
            counter++;
            assertTrue(v.equals(a) || v.equals(b));
            list.add(v);
        }
        //System.out.println(list);
        assertEquals(counter, 4);
        assertEquals(list.size(), 4);
        int t = 0;
        for (Vertex temp : list) {
            if (temp.equals(a))
                t++;
        }
        assertEquals(t, 2);
        t = 0;
        for (Vertex temp : list) {
            if (temp.equals(b))
                t++;
        }
        assertEquals(t, 2);
    }
}
