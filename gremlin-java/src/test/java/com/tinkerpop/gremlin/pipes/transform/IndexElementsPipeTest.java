package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Index;
import com.tinkerpop.blueprints.IndexableGraph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IndexElementsPipeTest extends TestCase {

    public void testPipeBasic() {
        IndexableGraph graph = TinkerGraphFactory.createTinkerGraph();
        Index idx = graph.createIndex("idx", Vertex.class);
        idx.put("lang", "java", graph.getVertex(3));
        idx.put("lang", "java", graph.getVertex(5));
        Pipe<Vertex, Vertex> pipe = new IndexElementsPipe<Vertex>(graph.getIndex("idx", Vertex.class), "lang", "java");
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            Vertex vertex = pipe.next();
            assertTrue(vertex.equals(graph.getVertex(3)) || vertex.equals(graph.getVertex(5)));
        }
        assertEquals(counter, 2);
    }
}
