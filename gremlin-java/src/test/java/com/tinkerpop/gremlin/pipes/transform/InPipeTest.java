package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.iterators.SingleIterator;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class InPipeTest extends TestCase {

    public void testUnlabeledIn() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Pipe<Vertex, Vertex> pipe = new InPipe();
        pipe.setStarts(new SingleIterator<Vertex>(graph.getVertex(3)));
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            String name = (String) pipe.next().getProperty("name");
            assertTrue(name.equals("josh") || name.equals("marko") || name.equals("peter"));
        }
        assertEquals(counter, 3);
    }

    public void testLabeledIn() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Pipe<Vertex, Vertex> pipe = new InPipe("knows");
        pipe.setStarts(new SingleIterator<Vertex>(graph.getVertex(4)));
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            String name = (String) pipe.next().getProperty("name");
            assertTrue(name.equals("marko"));
        }
        assertEquals(counter, 1);
    }
}
