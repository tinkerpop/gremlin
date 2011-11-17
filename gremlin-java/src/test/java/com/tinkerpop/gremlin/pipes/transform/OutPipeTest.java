package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.SingleIterator;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OutPipeTest extends TestCase {

    public void testUnlabeledOut() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Pipe<Vertex, Vertex> pipe = new OutPipe();
        pipe.setStarts(new SingleIterator<Vertex>(graph.getVertex(1)));
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            String name = (String) pipe.next().getProperty("name");
            assertTrue(name.equals("josh") || name.equals("vadas") || name.equals("lop"));
        }
        assertEquals(counter, 3);
    }

    public void testLabeledOut() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Pipe<Vertex, Vertex> pipe = new OutPipe("knows");
        pipe.setStarts(new SingleIterator<Vertex>(graph.getVertex(1)));
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            String name = (String) pipe.next().getProperty("name");
            assertTrue(name.equals("josh") || name.equals("vadas"));
        }
        assertEquals(counter, 2);
    }
}
