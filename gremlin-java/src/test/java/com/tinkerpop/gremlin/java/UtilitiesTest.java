package com.tinkerpop.gremlin.java;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.test.ComplianceTest;

import java.util.ArrayList;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class UtilitiesTest extends com.tinkerpop.gremlin.test.UtilitiesTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_toList() {
        super.test_g_v1_out_toList(new GremlinPipeline(g.getVertex(1)).out().toList());
    }

    public void test_g_v1_out_nextX1X() {
        super.test_g_v1_out_nextX1X(new GremlinPipeline(g.getVertex(1)).out().next(1));
    }

    public void test_g_v1_out_fillXlistX() {
        super.test_g_v1_out_fillXlistX(new GremlinPipeline(g.getVertex(1)).out().fill(new ArrayList<Vertex>()));
    }
}
