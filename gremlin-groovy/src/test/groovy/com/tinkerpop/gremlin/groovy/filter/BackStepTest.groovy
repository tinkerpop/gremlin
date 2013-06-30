package com.tinkerpop.gremlin.groovy.filter

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class BackStepTest extends com.tinkerpop.gremlin.test.filter.BackStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_backX1X() {
        super.test_g_v1_out_backX1X(g.v(1).out.back(1));
    }

    public void test_g_v1_asXhereX_out_backXhereX() {
        super.test_g_v1_asXhereX_out_backXhereX(g.v(1).as('here').out.back('here'));
    }

    public void test_g_v4_out_filterXlang_eq_javaX_backX1X() {
        super.test_g_v4_out_filterXlang_eq_javaX_backX1X(g.v(4).out.filter { it.lang == 'java' }.back(1));
    }

    public void test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX() {
        super.test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX(g.v(4).out.as('here').filter { it.lang == 'java' }.back('here'));
    }

    public void test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX_propertyXnameX() {
        super.test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX_propertyXnameX(g.v(4).out.as('here').filter { it.lang == 'java' }.back('here').name);
    }

    public void test_g_v1_outE_inV_hasXname_vadasX_backX2X() {
        super.test_g_v1_outE_inV_hasXname_vadasX_backX2X(g.v(1).outE().inV.has("name", "vadas").back(2));
    }

    public void test_g_v1_outE_asXhereX_inV_hasXname_vadasX_backXhereX() {
        super.test_g_v1_outE_asXhereX_inV_hasXname_vadasX_backXhereX(g.v(1).outE.as("here").inV.has("name", "vadas").back("here"));
    }
}