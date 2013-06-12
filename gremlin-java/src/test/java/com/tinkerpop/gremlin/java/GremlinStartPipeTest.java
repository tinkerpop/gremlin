package com.tinkerpop.gremlin.java;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.StartPipe;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinStartPipeTest extends TestCase {

    public void testNoGraphInPath() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();

        Pipe pipe = new GremlinStartPipe(graph);
        pipe.enablePath(true);
        assertEquals(pipe.getCurrentPath().size(), 0);

        pipe = new StartPipe(graph);
        pipe.enablePath(true);
        assertEquals(pipe.getCurrentPath().size(), 1);
    }
}
