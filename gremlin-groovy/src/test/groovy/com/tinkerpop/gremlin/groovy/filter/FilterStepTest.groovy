package com.tinkerpop.gremlin.groovy.filter

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class FilterStepTest extends com.tinkerpop.gremlin.test.filter.FilterStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_V_filterXfalseX() {
        super.test_g_V_filterXfalseX(g.V.filter { false });
    }

    public void test_g_V_filterXtrueX() {
        super.test_g_V_filterXtrueX(g.V.filter { true });
    }

    public void test_g_V_filterXlang_eq_javaX() {
        super.test_g_V_filterXlang_eq_javaX(g.V.filter { it.lang == 'java' });
    }

    public void test_g_v1_out_filterXage_gt_30X() {
        super.test_g_v1_out_filterXage_gt_30X(g.v(1).out.filter { it.age > 30 });
    }

    public void test_g_V_filterXname_startsWith_m_OR_name_startsWith_pX() {
        super.test_g_V_filterXname_startsWith_m_OR_name_startsWith_pX(g.V.filter { it.name.startsWith('m') | it.name.startsWith('p') });
    }
}
