package com.tinkerpop.gremlin.pipes.sideeffect;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LinkPipeTest extends TestCase {

    public void testBasicLinking() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        LinkPipe pipe = new LinkPipe(Direction.OUT, "made", graph.getVertices("name", "lop").iterator().next());
        pipe.setStarts(Arrays.asList(graph.getVertex(1), graph.getVertex(2), graph.getVertex(6)));
        int counter = 0;
        while (pipe.hasNext()) {
            Vertex vertex = pipe.next();
            assertTrue(vertex.getId().equals("1") || vertex.getId().equals("2") || vertex.getId().equals("6"));
            counter++;
        }
        assertEquals(counter, 3);
        assertTrue(graph.getVertex(1).getEdges(Direction.OUT, "made").iterator().hasNext());
        assertTrue(graph.getVertex(2).getEdges(Direction.OUT, "made").iterator().hasNext());
        assertFalse(graph.getVertex(3).getEdges(Direction.OUT, "made").iterator().hasNext());
        assertFalse(graph.getVertex(4).getEdges(Direction.OUT, "made").iterator().hasNext());
        assertFalse(graph.getVertex(5).getEdges(Direction.OUT, "made").iterator().hasNext());
        assertTrue(graph.getVertex(6).getEdges(Direction.OUT, "made").iterator().hasNext());
    }
}
