package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IdEdgePipeTest extends TestCase {

    public void testIdEdgePipeGraph() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        List<String> ids = Arrays.asList("9", "11", "12");
        Pipe<String, Edge> pipe = new IdEdgePipe<String>(graph);
        pipe.setStarts(ids);
        int counter = 0;
        while (pipe.hasNext()) {
            Edge edge = pipe.next();
            if (counter == 0) {
                assertEquals(edge.getId(), "9");
                assertEquals(edge.getProperty("weight"), 0.4f);
            } else if (counter == 1) {
                assertEquals(edge.getId(), "11");
                assertEquals(edge.getInVertex(), graph.getVertex("3"));
            } else if (counter == 2) {
                assertEquals(edge.getId(), "12");
                assertEquals(edge.getLabel(), "created");
            } else {
                throw new RuntimeException("Illegal state.");
            }
            counter++;
        }
        assertEquals(counter, 3);

    }
}
