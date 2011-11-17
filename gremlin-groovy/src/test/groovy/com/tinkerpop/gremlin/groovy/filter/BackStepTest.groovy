package com.tinkerpop.gremlin.groovy.filter

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.UtilitiesTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class BackStepTest extends com.tinkerpop.gremlin.test.filter.BackStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        UtilitiesTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_backX1X() {
        super.test_g_v1_out_backX1X(g.v(1).out.back(1));
    }

    public void test_g_v1_asXhereX_out_backXhereX() {
        super.test_g_v1_asXhereX_out_backXhereX(g.v(1).as('here').out.back('here'));
    }

    public void test_g_v4_out_filterXlang_eq_javaX_backX1X() {
        super.test_g_v4_out_filterXlang_eq_javaX_backX1X(g.v(4).out.filter {it.lang == 'java'}.back(1));
    }

    public void test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX() {
        super.test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX(g.v(4).out.as('here').filter {it.lang == 'java'}.back('here'));
    }

    public void test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX_propertyXnameX() {
        super.test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX_propertyXnameX(g.v(4).out.as('here').filter {it.lang == 'java'}.back('here').name);
    }
}