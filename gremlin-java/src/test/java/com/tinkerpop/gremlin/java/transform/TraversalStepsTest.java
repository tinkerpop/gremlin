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
        super.test_g_V(new GremlinPipeline(g).V());
        super.test_g_V(new GremlinPipeline(g.getVertices()).optimize(false));
        super.test_g_V(new GremlinPipeline(g).optimize(false).V());
    }

    public void test_g_v1_out() {
        super.test_g_v1_out(new GremlinPipeline(g.getVertex(1)).out());
        super.test_g_v1_out(new GremlinPipeline(g.getVertex(1)).optimize(false).out());
    }

    public void test_g_v2_in() {
        super.test_g_v2_in(new GremlinPipeline(g.getVertex(2)).in());
        super.test_g_v2_in(new GremlinPipeline(g.getVertex(2)).optimize(false).in());
    }

    public void test_g_v4_both() {
        super.test_g_v4_both(new GremlinPipeline(g.getVertex(4)).both());
        super.test_g_v4_both(new GremlinPipeline(g.getVertex(4)).optimize(false).both());
    }

    public void test_g_v1_outX1_knowsX_name() {
        super.test_g_v1_outX1_knowsX_name(new GremlinPipeline(g.getVertex(1)).out(1, "knows").property("name"));
        super.test_g_v1_outX1_knowsX_name(new GremlinPipeline(g.getVertex(1)).optimize(false).out(1, "knows").property("name"));
    }

    public void test_g_V_bothX1_createdX_name() {
        super.test_g_V_bothX1_createdX_name(new GremlinPipeline(g).V().both(1, "created").property("name"));
        super.test_g_V_bothX1_createdX_name(new GremlinPipeline(g).optimize(false).V().both(1, "created").property("name"));
    }

    public void test_g_E() {
        super.test_g_E(new GremlinPipeline(g.getEdges()));
        super.test_g_E(new GremlinPipeline(g).E());
        super.test_g_E(new GremlinPipeline(g.getEdges()).optimize(false));
        super.test_g_E(new GremlinPipeline(g).optimize(false).E());
    }

    public void test_g_v1_outE() {
        super.test_g_v1_outE(new GremlinPipeline(g.getVertex(1)).outE());
        super.test_g_v1_outE(new GremlinPipeline(g.getVertex(1)).optimize(false).outE());
    }

    public void test_g_v2_inE() {
        super.test_g_v2_inE(new GremlinPipeline(g.getVertex(2)).inE());
        super.test_g_v2_inE(new GremlinPipeline(g.getVertex(2)).optimize(false).inE());
    }

    public void test_g_v4_bothE() {
        super.test_g_v4_bothE(new GremlinPipeline(g.getVertex(4)).bothE());
        super.test_g_v4_bothE(new GremlinPipeline(g.getVertex(4)).optimize(false).bothE());
    }

    public void test_g_v4_bothEX1_createdX() {
        super.test_g_v4_bothEX1_createdX(new GremlinPipeline(g.getVertex(4)).bothE(1, "created"));
        super.test_g_v4_bothEX1_createdX(new GremlinPipeline(g.getVertex(4)).optimize(false).bothE(1, "created"));
    }

    public void test_g_V_inEX2_knowsX_outV_name() {
        super.test_g_V_inEX2_knowsX_outV_name(new GremlinPipeline(g).V().inE(2, "knows").outV().property("name"));
        super.test_g_V_inEX2_knowsX_outV_name(new GremlinPipeline(g).optimize(false).V().inE(2, "knows").outV().property("name"));
    }

    public void test_g_v1_outE_inV() {
        super.test_g_v1_outE_inV(new GremlinPipeline(g.getVertex(1)).outE().inV());
        super.test_g_v1_outE_inV(new GremlinPipeline(g.getVertex(1)).optimize(false).outE().inV());
    }

    public void test_g_v2_inE_outV() {
        super.test_g_v2_inE_outV(new GremlinPipeline(g.getVertex(2)).inE().outV());
        super.test_g_v2_inE_outV(new GremlinPipeline(g.getVertex(2)).optimize(false).inE().outV());
    }

    public void test_g_v1_outXknowsX() {
        super.test_g_v1_outXknowsX(new GremlinPipeline(g.getVertex(1)).out("knows"));
        super.test_g_v1_outXknowsX(new GremlinPipeline(g.getVertex(1)).optimize(false).out("knows"));
    }

    public void test_g_v1_outXknows_createdX() {
        super.test_g_v1_outXknows_createdX(new GremlinPipeline(g.getVertex(1)).out("knows", "created"));
        super.test_g_v1_outXknows_createdX(new GremlinPipeline(g.getVertex(1)).optimize(false).out("knows", "created"));
    }

    public void test_g_v1_outEXknowsX_inV() {
        super.test_g_v1_outEXknowsX_inV(new GremlinPipeline(g.getVertex(1)).outE("knows").inV());
        super.test_g_v1_outEXknowsX_inV(new GremlinPipeline(g.getVertex(1)).optimize(false).outE("knows").inV());
    }

    public void test_g_v1_outEXknows_createdX_inV() {
        super.test_g_v1_outEXknows_createdX_inV(new GremlinPipeline(g.getVertex(1)).outE("knows", "created").inV());
        super.test_g_v1_outEXknows_createdX_inV(new GremlinPipeline(g.getVertex(1)).optimize(false).outE("knows", "created").inV());
    }

    public void test_g_V_out_out() {
        super.test_g_V_out_out(new GremlinPipeline(g.getVertices()).out().out());
        super.test_g_V_out_out(new GremlinPipeline(g).V().out().out());
        super.test_g_V_out_out(new GremlinPipeline(g.getVertices()).optimize(false).out().out());
        super.test_g_V_out_out(new GremlinPipeline(g).optimize(false).V().out().out());
    }

    public void test_g_v1_out_out_out() {
        super.test_g_v1_out_out_out(new GremlinPipeline(g.getVertex(1)).out().out().out());
        super.test_g_v1_out_out_out(new GremlinPipeline(g.getVertex(1)).optimize(false).out().out().out());
    }

    public void test_g_v1_out_propertyXnameX() {
        super.test_g_v1_out_propertyXnameX(new GremlinPipeline(g.getVertex(1)).out().property("name"));
        super.test_g_v1_out_propertyXnameX(new GremlinPipeline(g.getVertex(1)).optimize(false).out().property("name"));
    }
}