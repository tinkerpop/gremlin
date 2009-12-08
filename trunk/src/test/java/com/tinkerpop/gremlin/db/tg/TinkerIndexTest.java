package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.model.Graph;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerIndexTest extends BaseTest {

    public void testAddVertexIndex() {
        TinkerGraph graph = new TinkerGraph();
        Vertex marko = graph.addVertex("1");
        Vertex jen = graph.addVertex("2");
        marko.setProperty("name", "marko");
        assertEquals(graph.getIndex().get("name", "marko").size(), 1);
        assertEquals(graph.getIndex().get("name", "marko").iterator().next(), marko);
        marko.setProperty("name", "marko a. rodriguez");
        assertNull(graph.getIndex().get("name", "marko"));
        assertEquals(graph.getIndex().get("name", "marko a. rodriguez").size(), 1);
        assertNull(graph.getIndex().get("name", "jen"));
        jen.setProperty("name", "jen");
        assertEquals(graph.getIndex().get("name", "jen").size(), 1);
        assertEquals(graph.getIndex().get("name", "jen").iterator().next(), jen);
        marko.setProperty("location", 87501);
        jen.setProperty("location", 87501);
        assertEquals(graph.getIndex().get("location", 87501).size(), 2);
        // TODO removing propeties? jen.setProperty("location", null);
        //System.out.println(graph.getIndex());

    }

}
