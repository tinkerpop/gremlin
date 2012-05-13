package com.tinkerpop.gremlin.java.transform;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TraversalStepsTest extends com.tinkerpop.gremlin.test.transform.TraversalStepsTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_V() {
        super.test_g_V(new GremlinPipeline(g.getVertices()));
    }

    public void test_g_v1_out() {
        super.test_g_v1_out(new GremlinPipeline(g.getVertex(1)).out());
    }

    public void test_g_v2_in() {
        super.test_g_v2_in(new GremlinPipeline(g.getVertex(2)).in());
    }

    public void test_g_v4_both() {
        super.test_g_v4_both(new GremlinPipeline(g.getVertex(4)).both());
    }

    public void test_g_E() {
        super.test_g_E(new GremlinPipeline(g.getEdges()));
    }

    public void test_g_v1_outE() {
        super.test_g_v1_outE(new GremlinPipeline(g.getVertex(1)).outE());
    }

    public void test_g_v2_inE() {
        super.test_g_v2_inE(new GremlinPipeline(g.getVertex(2)).inE());
    }

    public void test_g_v4_bothE() {
        super.test_g_v4_bothE(new GremlinPipeline(g.getVertex(4)).bothE());
    }

    public void test_g_v1_outE_inV() {
        super.test_g_v1_outE_inV(new GremlinPipeline(g.getVertex(1)).outE().inV());
    }

    public void test_g_v2_inE_outV() {
        super.test_g_v2_inE_outV(new GremlinPipeline(g.getVertex(2)).inE().outV());
    }

    public void test_g_v1_outXknowsX() {
        super.test_g_v1_outXknowsX(new GremlinPipeline(g.getVertex(1)).out("knows"));
    }

    public void test_g_v1_outXknows_createdX() {
        super.test_g_v1_outXknows_createdX(new GremlinPipeline(g.getVertex(1)).out("knows", "created"));
    }

    public void test_g_v1_outEXknowsX_inV() {
        super.test_g_v1_outEXknowsX_inV(new GremlinPipeline(g.getVertex(1)).outE("knows").inV());
    }

    public void test_g_v1_outEXknows_createdX_inV() {
        super.test_g_v1_outEXknows_createdX_inV(new GremlinPipeline(g.getVertex(1)).outE("knows", "created").inV());
    }

    public void test_g_V_out_out() {
        super.test_g_V_out_out(new GremlinPipeline(g.getVertices()).out().out());
    }

    public void test_g_v1_out_out_out() {
        super.test_g_v1_out_out_out(new GremlinPipeline(g.getVertex(1)).out().out().out());
    }

    public void test_g_v1_out_propertyXnameX() {
        super.test_g_v1_out_propertyXnameX(new GremlinPipeline(g.getVertex(1)).out().property("name"));
    }

}