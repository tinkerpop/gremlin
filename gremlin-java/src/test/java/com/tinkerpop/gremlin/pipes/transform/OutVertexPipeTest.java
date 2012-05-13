package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OutVertexPipeTest extends TestCase {

    public void testInVertex() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        OutVertexPipe pipe = new OutVertexPipe();
        pipe.setStarts(marko.getOutEdges());
        assertTrue(pipe.hasNext());
        int counter = 0;
        while (pipe.hasNext()) {
            Vertex v = pipe.next();
            assertTrue(v.getId().equals("1"));
            counter++;
        }
        assertEquals(counter, 3);
    }
}
