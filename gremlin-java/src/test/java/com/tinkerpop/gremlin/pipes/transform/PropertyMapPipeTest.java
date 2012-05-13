package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.iterators.SingleIterator;
import junit.framework.TestCase;

import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PropertyMapPipeTest extends TestCase {

    public void testPropertyMapPipe() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Pipe<Vertex, Map<String, Object>> pipe = new PropertyMapPipe<Vertex>();
        pipe.setStarts(new SingleIterator<Vertex>(graph.getVertex(1)));
        int counter = 0;
        while (pipe.hasNext()) {
            Map<String, Object> map = pipe.next();
            counter++;
            assertEquals(map.get("name"), "marko");
            assertEquals(map.get("age"), 29);
            assertNull(map.get("blah"));
        }
        assertEquals(counter, 1);
    }
}
