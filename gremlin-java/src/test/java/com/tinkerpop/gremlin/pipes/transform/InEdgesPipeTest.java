package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.pipes.util.iterators.SingleIterator;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class InEdgesPipeTest extends TestCase {

    public void testInEdges() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex josh = graph.getVertex("4");
        InEdgesPipe pipe = new InEdgesPipe();
        pipe.setStarts(new SingleIterator<Vertex>(josh));
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            Edge edge = pipe.next();
            assertEquals(edge.getId(), "8");
        }
        assertEquals(counter, 1);
    }
}
