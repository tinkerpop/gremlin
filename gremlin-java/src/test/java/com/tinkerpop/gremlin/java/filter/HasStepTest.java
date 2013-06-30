package com.tinkerpop.gremlin.java.filter;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.Tokens.T;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;

import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class HasStepTest extends com.tinkerpop.gremlin.test.filter.HasStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_V_hasXname_markoX() {
        super.test_g_V_hasXname_markoX(new GremlinPipeline(g).V().has("name", "marko"));
        super.test_g_V_hasXname_markoX(new GremlinPipeline(g.getVertices()).optimize(false).has("name", "marko"));
    }

    public void test_g_V_hasXname_blahX() {
        super.test_g_V_hasXname_blahX(new GremlinPipeline(g.getVertices()).has("name", "blah"));
        super.test_g_V_hasXname_blahX(new GremlinPipeline(g.getVertices()).optimize(false).has("name", "blah"));
    }

    public void test_g_V_hasXblahX() {
        super.test_g_V_hasXblahX(new GremlinPipeline(g.getVertices()).has("blah"));
        super.test_g_V_hasXblahX(new GremlinPipeline(g).V().optimize(false).has("blah"));
    }

    public void test_g_v1_out_hasXid_2X() {
        super.test_g_v1_out_hasXid_2X(new GremlinPipeline(g.getVertex(1)).out().has("id", "2"));
        super.test_g_v1_out_hasXid_2X(new GremlinPipeline(g.getVertex(1)).optimize(false).out().has("id", "2"));
    }

    public void test_g_V_hasXage_gt_30X() {
        super.test_g_V_hasXage_gt_30X(new GremlinPipeline(g).V().has("age", T.gt, 30));
        super.test_g_V_hasXage_gt_30X(new GremlinPipeline(g).V().optimize(false).has("age", T.gt, 30));
    }

    public void test_g_E_hasXlabelXknowsX() {
        super.test_g_E_hasXlabelXknowsX(new GremlinPipeline(g).E().has("label", T.eq, "knows"));
        super.test_g_E_hasXlabelXknowsX(new GremlinPipeline(g).optimize(false).E().has("label", T.eq, "knows"));
    }

    public void test_g_E_hasXlabelXknows_createdX() {
        super.test_g_E_hasXlabelXknows_createdX(new GremlinPipeline(g.getEdges()).has("label", T.in, Arrays.asList("knows", "created")));
        super.test_g_E_hasXlabelXknows_createdX(new GremlinPipeline(g).E().optimize(false).has("label", T.in, Arrays.asList("knows", "created")));

    }
}