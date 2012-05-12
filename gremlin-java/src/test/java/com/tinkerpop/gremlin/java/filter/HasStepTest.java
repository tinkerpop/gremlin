package com.tinkerpop.gremlin.java.filter;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.Tokens.T;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class HasStepTest extends com.tinkerpop.gremlin.test.filter.HasStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_V_hasXname_markoX() {
        super.test_g_V_hasXname_markoX(new GremlinPipeline(g.getVertices()).has("name", "marko"));
    }

    public void test_g_V_hasXname_blahX() {
        super.test_g_V_hasXname_blahX(new GremlinPipeline(g.getVertices()).has("name", "blah"));
    }

    public void test_g_V_hasXblah_nullX() {
        super.test_g_V_hasXblah_nullX(new GremlinPipeline(g.getVertices()).has("blah", null));
    }

    public void test_g_v1_out_hasXid_2X() {
        super.test_g_v1_out_hasXid_2X(new GremlinPipeline(g.getVertex(1)).out().has("id", "2"));
    }

    public void test_g_V_hasXage_gt_30X() {
        super.test_g_V_hasXage_gt_30X(new GremlinPipeline(g.getVertices()).has("age", T.gt, 30));
    }
}