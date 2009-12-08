package com.tinkerpop.gremlin.model;

import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class IndexTestSuite extends ModelTestSuite {

    public void testVertexIndex(Graph graph) {
        Vertex v1 = graph.addVertex("1");
        Vertex v2 = graph.addVertex("2");

        v1.setProperty("name", "marko");
        assertEquals(graph.getIndex().get("name", "marko").size(), 1);
        assertEquals(graph.getIndex().get("name", "marko").iterator().next(), v1);
        v1.setProperty("name", "marko a. rodriguez");
        assertNull(graph.getIndex().get("name", "marko"));
        assertEquals(graph.getIndex().get("name", "marko a. rodriguez").size(), 1);

        assertNull(graph.getIndex().get("name", "jen"));
        v2.setProperty("name", "jen");
        assertEquals(graph.getIndex().get("name", "jen").size(), 1);
        assertEquals(graph.getIndex().get("name", "jen").iterator().next(), v2);

        v1.setProperty("location", 87501);
        v2.setProperty("location", 87501);
        assertEquals(graph.getIndex().get("location", 87501).size(), 2);
        v1.removeProperty("location");
        assertEquals(graph.getIndex().get("location", 87501).size(), 1);
        v2.removeProperty("location");
        assertNull(graph.getIndex().get("location", 87501));
    }
}
