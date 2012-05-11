package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.KeyIndexableGraph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.iterators.SingleIterator;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class EdgesPipeTest extends TestCase {

    public void testEdgeIterator() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Pipe<Graph, Edge> pipe = new EdgesPipe();
        pipe.setStarts(new SingleIterator<Graph>(graph));
        int counter = 0;
        Set<Edge> edges = new HashSet<Edge>();
        while (pipe.hasNext()) {
            counter++;
            Edge edge = pipe.next();
            edges.add(edge);
            //System.out.println(edge);
        }
        assertEquals(6, counter);
        assertEquals(6, edges.size());
    }

    public void testEdgeIteratorThreeGraphs() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Pipe<Graph, Edge> pipe = new EdgesPipe();
        pipe.setStarts(Arrays.asList(graph, graph, graph));
        int counter = 0;
        Set<Edge> edges = new HashSet<Edge>();
        while (pipe.hasNext()) {
            counter++;
            Edge edge = pipe.next();
            edges.add(edge);
            //System.out.println(edge);
        }
        assertEquals(18, counter);
        assertEquals(6, edges.size());
    }

    public void testEdgeKeyIndexIterator() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Pipe<Graph, Edge> pipe = new EdgesPipe("weight", 0.4f);
        pipe.setStarts(new SingleIterator<Graph>(graph));
        int counter = 0;
        Set<Edge> edges = new HashSet<Edge>();
        while (pipe.hasNext()) {
            counter++;
            Edge edge = pipe.next();
            edges.add(edge);
            //System.out.println(edge);
        }
        assertEquals(2, counter);
        assertEquals(2, edges.size());
    }
}