package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IdVertexPipeTest extends TestCase {

    public void testIdVertexPipeGraph() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        List<String> ids = Arrays.asList("1", "6", "5");
        Pipe<String, Vertex> pipe = new IdVertexPipe<String>(graph);
        pipe.setStarts(ids);
        int counter = 0;
        while (pipe.hasNext()) {
            Vertex vertex = pipe.next();
            if (counter == 0) {
                assertEquals(vertex.getId(), "1");
                assertEquals(vertex.getProperty("name"), "marko");
            } else if (counter == 1) {
                assertEquals(vertex.getId(), "6");
                assertEquals(vertex.getProperty("name"), "peter");
            } else if (counter == 2) {
                assertEquals(vertex.getId(), "5");
                assertEquals(vertex.getProperty("name"), "ripple");
            } else {
                throw new RuntimeException("Illegal state.");
            }
            counter++;
        }
        assertEquals(counter, 3);

    }
}
