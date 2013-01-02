package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
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
            assertEquals(map.size(), 2);
        }
        assertEquals(counter, 1);
    }

    public void testPropertMapPipeWithArguments() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Pipe<Vertex, Map<String, Object>> pipe = new PropertyMapPipe<Vertex>("name", "id");
        pipe.setStarts(new SingleIterator<Vertex>(graph.getVertex(1)));
        int counter = 0;
        while (pipe.hasNext()) {
            Map<String, Object> map = pipe.next();
            counter++;
            assertEquals(map.get("name"), "marko");
            assertNull(map.get("age"));
            assertNull(map.get("blah"));
            assertEquals(map.get("id"), graph.getVertex(1).getId());
            assertEquals(map.size(), 2);
        }
        assertEquals(counter, 1);
    }

    public void testPropertMapPipeWithArgumentsEdges() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Pipe<Edge, Map<String, Object>> pipe = new PropertyMapPipe<Edge>("id", "label");
        pipe.setStarts(new SingleIterator<Edge>(graph.getVertex(1).getEdges(Direction.OUT, "knows").iterator().next()));
        int counter = 0;
        while (pipe.hasNext()) {
            Map<String, Object> map = pipe.next();
            counter++;
            assertEquals(map.get("label"), graph.getVertex(1).getEdges(Direction.OUT, "knows").iterator().next().getLabel());
            assertEquals(map.get("id"), graph.getVertex(1).getEdges(Direction.OUT, "knows").iterator().next().getId());
            assertEquals(map.size(), 2);
        }
        assertEquals(counter, 1);
    }
}
