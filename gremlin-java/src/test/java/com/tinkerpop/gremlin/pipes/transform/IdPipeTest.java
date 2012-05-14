package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IdPipeTest extends TestCase {

    public void testIds() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        IdPipe pipe = new IdPipe();
        pipe.setStarts((Iterable) graph.getVertex("1").getEdges(Direction.OUT));
        Assert.assertTrue(pipe.hasNext());
        int counter = 0;
        while (pipe.hasNext()) {
            Object id = pipe.next();
            Assert.assertTrue(id.equals("7") || id.equals("8") || id.equals("9"));
            counter++;
        }
        Assert.assertEquals(counter, 3);
    }
}
