package com.tinkerpop.gremlin.groovy.transform

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class TraversalStepsTest extends com.tinkerpop.gremlin.test.transform.TraversalStepsTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_V() {
        super.test_g_V(g.V);
    }

    public void test_g_v1_out() {
        super.test_g_v1_out(g.v(1).out);
    }

    public void test_g_v2_in() {
        super.test_g_v2_in(g.v(2).in);
    }

    public void test_g_v4_both() {
        super.test_g_v4_both(g.v(4).both);
    }

    public void test_g_v1_outX1_knowsX_name() {
        super.test_g_v1_outX1_knowsX_name(g.v(1).out(1, "knows").property("name"));
    }

    public void test_g_V_bothX1_createdX_name() {
        super.test_g_V_bothX1_createdX_name(g.V.both(1, "created").name);
    }

    public void test_g_E() {
        super.test_g_E(g.E);
    }

    public void test_g_v1_outE() {
        super.test_g_v1_outE(g.v(1).outE);
    }

    public void test_g_v2_inE() {
        super.test_g_v2_inE(g.v(2).inE);
    }

    public void test_g_v4_bothE() {
        super.test_g_v4_bothE(g.v(4).bothE);
    }

    public void test_g_v4_bothEX1_createdX() {
        super.test_g_v4_bothEX1_createdX(g.v(4).bothE(1, "created"));
    }

    public void test_g_V_inEX2_knowsX_outV_name() {
        super.test_g_V_inEX2_knowsX_outV_name(g.V.inE(2, 'knows').outV.name);
    }

    public void test_g_v1_outE_inV() {
        super.test_g_v1_outE_inV(g.v(1).outE.inV);
    }

    public void test_g_v2_inE_outV() {
        super.test_g_v2_inE_outV(g.v(2).inE.outV);
    }

    public void test_g_v1_outXknowsX() {
        super.test_g_v1_outXknowsX(g.v(1).out('knows'));
    }

    public void test_g_v1_outXknows_createdX() {
        super.test_g_v1_outXknows_createdX(g.v(1).out('knows', 'created'));
    }

    public void test_g_v1_outEXknowsX_inV() {
        super.test_g_v1_outEXknowsX_inV(g.v(1).outE('knows').inV);
    }

    public void test_g_v1_outEXknows_createdX_inV() {
        super.test_g_v1_outEXknows_createdX_inV(g.v(1).outE('knows', 'created').inV);
    }

    public void test_g_V_out_out() {
        super.test_g_V_out_out(g.V.out.out);
    }

    public void test_g_v1_out_out_out() {
        super.test_g_v1_out_out_out(g.v(1).out.out.out);
    }

    public void test_g_v1_out_propertyXnameX() {
        super.test_g_v1_out_propertyXnameX(g.v(1).out.name);
    }
}
