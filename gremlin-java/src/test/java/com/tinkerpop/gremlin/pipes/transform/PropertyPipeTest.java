package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.Pipeline;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author: Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PropertyPipeTest extends TestCase {

    public void testSingleProperty() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        PropertyPipe<Vertex, String> pp = new PropertyPipe<Vertex, String>("name");
        pp.setStarts(Arrays.asList(marko).iterator());
        assertTrue(pp.hasNext());
        int counter = 0;
        while (pp.hasNext()) {
            String name = pp.next();
            assertEquals(name, "marko");
            counter++;
        }
        assertEquals(counter, 1);
        try {
            pp.next();
            assertTrue(false);
        } catch (NoSuchElementException e) {
            assertFalse(false);
        }
    }

    public void testMultiProperty() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        Pipe evp = new InVertexPipe();
        Pipe<Vertex, String> pp = new PropertyPipe<Vertex, String>("name");
        Pipeline<Edge, String> pipeline = new Pipeline<Edge, String>(evp, pp);
        pipeline.setStarts(marko.getEdges(Direction.OUT).iterator());
        assertTrue(pipeline.hasNext());
        int counter = 0;
        while (pipeline.hasNext()) {
            String name = pipeline.next();
            assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
            counter++;
        }
        assertEquals(counter, 3);
        try {
            pipeline.next();
            assertTrue(false);
        } catch (NoSuchElementException e) {
            assertFalse(false);
        }
    }

    public void testListProperty() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        Vertex vadas = graph.getVertex("2");
        Pipe<Vertex, String> pipe = new PropertyPipe<Vertex, String>("name");
        Pipe<Vertex, String> pipeline = new Pipeline<Vertex, String>(pipe);
        pipeline.setStarts(Arrays.asList(marko, vadas).iterator());
        assertTrue(pipeline.hasNext());
        int counter = 0;
        while (pipeline.hasNext()) {
            String name = pipeline.next();
            assertTrue(name.equals("vadas") || name.equals("marko"));
            counter++;
        }
        assertEquals(counter, 2);
        try {
            pipeline.next();
            assertTrue(false);
        } catch (NoSuchElementException e) {
            assertFalse(false);
        }
    }

    public void testMissingProperty() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        Vertex vadas = graph.getVertex("2");
        Pipe<Vertex, String> pipe = new PropertyPipe<Vertex, String>("blargh");
        Pipe<Vertex, String> pipeline = new Pipeline<Vertex, String>(pipe);
        pipeline.setStarts(Arrays.asList(marko, vadas).iterator());
        assertTrue(pipeline.hasNext());
        int counter = 0;
        while (pipeline.hasNext()) {
            String name = pipeline.next();
            assertNull(name);
            counter++;
        }
        assertEquals(counter, 2);
        try {
            pipeline.next();
            assertTrue(false);
        } catch (NoSuchElementException e) {
            assertFalse(false);
        }
    }

    public void testAllowNull() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        Vertex vadas = graph.getVertex("2");
        vadas.setProperty("other", "value");
        Pipe<Vertex, String> pipe = new PropertyPipe<Vertex, String>("other", false);
        Pipe<Vertex, String> pipeline = new Pipeline<Vertex, String>(pipe);
        pipeline.setStarts(Arrays.asList(marko, vadas).iterator());
        assertTrue(pipeline.hasNext());
        int counter = 0;
        while (pipeline.hasNext()) {
            String name = pipeline.next();
            assertEquals("value", name);
            counter++;
        }
        assertEquals(counter, 1);
    }
}
