package com.tinkerpop.gremlin.models.ggm.parser;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.models.ggm.Graph;
import com.tinkerpop.gremlin.models.ggm.impls.tg.TinkerGraphFactory;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GraphMLWriterTest extends BaseTest {

    public void testWritingForTinkerGraph() throws Exception {
        Graph g = TinkerGraphFactory.createTinkerGraph();
        //GraphMLWriter.outputGraph(g, new FileOutputStream("/Users/marko/Desktop/THE_TEST.xml"));
    }

}
