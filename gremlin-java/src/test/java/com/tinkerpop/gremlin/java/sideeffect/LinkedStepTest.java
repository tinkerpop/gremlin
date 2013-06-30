package com.tinkerpop.gremlin.java.sideeffect;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LinkedStepTest extends com.tinkerpop.gremlin.test.sideeffect.LinkStepTest {

    public void test_g_v1_asXaX_outXcreatedX_inXcreatedX_linkBothXcocreator_aX() {
        Graph g = TinkerGraphFactory.createTinkerGraph();
        super.test_g_v1_asXaX_outXcreatedX_inXcreatedX_linkBothXcocreator_aX(
                new GremlinPipeline(g.getVertex(1)).as("a").out("created").in("created").linkBoth("cocreator", "a"));

        g = TinkerGraphFactory.createTinkerGraph();
        super.test_g_v1_asXaX_outXcreatedX_inXcreatedX_linkBothXcocreator_aX(
                new GremlinPipeline(g.getVertex(1)).optimize(false).as("a").out("created").in("created").linkBoth("cocreator", "a"));
    }
}