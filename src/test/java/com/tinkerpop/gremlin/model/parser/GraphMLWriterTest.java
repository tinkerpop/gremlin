package com.tinkerpop.gremlin.model.parser;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.db.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.model.Graph;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GraphMLWriterTest extends BaseTest {

    public void testWritingForTinkerGraph() throws Exception {
        Graph g = TinkerGraphFactory.createTinkerGraph();
        //GraphMLWriter.outputGraph(g, new FileOutputStream("/Users/marko/Desktop/THE_TEST.xml"));
    }

}
