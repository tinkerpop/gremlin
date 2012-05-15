package com.tinkerpop.gremlin.pipes.filter;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.pipes.transform.EdgesVerticesPipe;
import com.tinkerpop.gremlin.pipes.transform.VerticesEdgesPipe;
import com.tinkerpop.pipes.util.Pipeline;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IntervalFilterPipeTest extends TestCase {

    public void testFilterEdgeWeight1() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        VerticesEdgesPipe pipe1 = new VerticesEdgesPipe(Direction.OUT);
        IntervalFilterPipe pipe2 = new IntervalFilterPipe<Edge>("weight", 0.5f, 1.01f);
        EdgesVerticesPipe pipe3 = new EdgesVerticesPipe(Direction.IN);
        Pipeline<Vertex, Vertex> pipeline = new Pipeline<Vertex, Vertex>(pipe1, pipe2, pipe3);
        pipeline.setStarts(Arrays.asList(marko));
        int counter = 0;
        while (pipeline.hasNext()) {
            Vertex vertex = pipeline.next();
            assertTrue(vertex.equals(graph.getVertex(2)) || vertex.equals(graph.getVertex(4)));
            counter++;
        }
        assertEquals(counter, 2);
    }

    public void testFilterEdgeWeight2() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        VerticesEdgesPipe pipe1 = new VerticesEdgesPipe(Direction.OUT);
        IntervalFilterPipe pipe2 = new IntervalFilterPipe<Edge>("weight", 0.1f, 0.5f);
        EdgesVerticesPipe pipe3 = new EdgesVerticesPipe(Direction.IN);
        Pipeline<Vertex, Vertex> pipeline = new Pipeline<Vertex, Vertex>(pipe1, pipe2, pipe3);
        pipeline.setStarts(Arrays.asList(marko));
        int counter = 0;
        while (pipeline.hasNext()) {
            Vertex vertex = pipeline.next();
            assertTrue(vertex.equals(graph.getVertex(3)));
            counter++;
        }
        assertEquals(counter, 1);
    }

    public void testFilterEdgeWeight3() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        VerticesEdgesPipe pipe1 = new VerticesEdgesPipe(Direction.OUT);
        IntervalFilterPipe pipe2 = new IntervalFilterPipe<Edge>("weight", -0.1f, 0.1f);
        EdgesVerticesPipe pipe3 = new EdgesVerticesPipe(Direction.IN);
        Pipeline<Vertex, Vertex> pipeline = new Pipeline<Vertex, Vertex>(pipe1, pipe2, pipe3);
        pipeline.setStarts(Arrays.asList(marko));
        int counter = 0;
        while (pipeline.hasNext()) {
            pipeline.next();
            counter++;
        }
        assertEquals(counter, 0);
    }

}