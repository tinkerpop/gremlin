package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.pipes.util.SingleIterator;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BothVerticesPipeTest extends TestCase {

    public void testBothVertices() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex josh = graph.getVertex("4");
        Edge tempEdge = null;
        for (Edge edge : josh.getOutEdges()) {
            if (edge.getId().equals("11"))
                tempEdge = edge;
        }
        BothVerticesPipe pipe = new BothVerticesPipe();
        pipe.setStarts(new SingleIterator<Edge>(tempEdge));
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            Vertex vertex = pipe.next();
            assertTrue(vertex.getId().equals("4") || vertex.getId().equals("3"));
        }
        assertEquals(counter, 2);

    }
}
