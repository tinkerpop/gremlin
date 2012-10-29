package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class QueryPipeTest extends TestCase {

    private final Graph graph = TinkerGraphFactory.createTinkerGraph();

    public void testQueryLimit() {

        QueryPipe<Vertex> pipe = new QueryPipe<Vertex>(Vertex.class, Direction.BOTH,
                new ArrayList<QueryPipe.HasContainer>(), new ArrayList<QueryPipe.IntervalContainer>(), 3);
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
        pipe = new QueryPipe<Vertex>(Vertex.class, Direction.BOTH,
                new ArrayList<QueryPipe.HasContainer>(), new ArrayList<QueryPipe.IntervalContainer>(), 5);
        pipe.setStarts(graph.getVertices());
        while (pipe.hasNext()) {
            pipe.next();
            counter++;
        }
        assertEquals(counter, 5);
    }

    public void testDirection() {
        QueryPipe<Vertex> pipe = new QueryPipe<Vertex>(Vertex.class, Direction.IN,
                new ArrayList<QueryPipe.HasContainer>(), new ArrayList<QueryPipe.IntervalContainer>(), -1);
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
