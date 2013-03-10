package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class VertexQueryPipeTest extends TestCase {

    private final Graph graph = TinkerGraphFactory.createTinkerGraph();

    public void testQueryLimit() {

        VertexQueryPipe<Vertex> pipe = new VertexQueryPipe<Vertex>(Vertex.class, Direction.BOTH, null, null, 0, 2);
        pipe.setStarts(Arrays.asList(graph.getVertex(1), graph.getVertex(3)));
        int counter = 0;
        while (pipe.hasNext()) {
            String name = (String) pipe.next().getProperty("name");
            assertTrue(name.equals("vadas") || name.equals("lop") || name.equals("josh"));
            counter++;
        }
        assertEquals(counter, 3);

        pipe.reset();
        counter = 0;
        pipe.setStarts(graph.getVertices());
        while (pipe.hasNext()) {
            pipe.next();
            counter++;
        }
        assertEquals(counter, 3);

        counter = 0;
        pipe = new VertexQueryPipe<Vertex>(Vertex.class, Direction.BOTH, null, null, Long.MIN_VALUE, 4);
        pipe.setStarts(graph.getVertices());
        while (pipe.hasNext()) {
            pipe.next();
            counter++;
        }
        assertEquals(counter, 5);

        counter = 0;
        pipe = new VertexQueryPipe<Vertex>(Vertex.class, Direction.BOTH, null, null, 2, 4);
        pipe.setStarts(graph.getVertices());
        while (pipe.hasNext()) {
            pipe.next();
            counter++;
        }
        assertEquals(counter, 3);

        counter = 0;
        pipe = new VertexQueryPipe<Vertex>(Vertex.class, Direction.OUT, null, null, 2, 5);
        pipe.setStarts(graph.getVertices());
        while (pipe.hasNext()) {
            pipe.next();
            counter++;
        }
        assertEquals(counter, 4);
    }

    public void testDirection() {
        VertexQueryPipe<Vertex> pipe = new VertexQueryPipe<Vertex>(Vertex.class, Direction.IN, null, null, 0, Long.MAX_VALUE);
        pipe.setStarts(Arrays.asList(graph.getVertex(1)));
        assertFalse(pipe.hasNext());

        pipe.reset();
        pipe.setStarts(Arrays.asList(graph.getVertex(3)));
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            pipe.next();
        }
        assertEquals(counter, 3);
    }

}
