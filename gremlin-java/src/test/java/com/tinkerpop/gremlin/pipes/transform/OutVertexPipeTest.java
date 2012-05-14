package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OutVertexPipeTest {

    @Test
    public void testInVertex() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        OutVertexPipe pipe = new OutVertexPipe();
        pipe.setStarts(marko.getEdges(Direction.OUT));
        Assert.assertTrue(pipe.hasNext());
        int counter = 0;
        while (pipe.hasNext()) {
            Vertex v = pipe.next();
            Assert.assertTrue(v.getId().equals("1"));
            counter++;
        }
        Assert.assertEquals(counter, 3);
    }
}
