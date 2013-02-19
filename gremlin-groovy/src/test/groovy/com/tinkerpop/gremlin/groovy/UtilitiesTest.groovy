package com.tinkerpop.gremlin.groovy

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class UtilitiesTest extends com.tinkerpop.gremlin.test.UtilitiesTest {
    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_toList() {
        super.test_g_v1_out_toList(g.v(1).out.toList());
    }

    public void test_g_v1_out_nextX1X() {
        super.test_g_v1_out_nextX1X(g.v(1).out.next(1));
    }

    public void test_g_v1_out_fillXlistX() {
        super.test_g_v1_out_fillXlistX(g.v(1).out().fill([]));
    }

    public void test_g_V_countXX() {
        super.test_g_V_countXX(g.V.count());
    }

    public void test_g_E_remove() {
        def temp = TinkerGraphFactory.createTinkerGraph();
        temp.E.remove();
        super.test_g_E_remove(temp);
    }

    public void test_g_V_hasXidX1X_name_equals_g_v1_name() {
        super.test_g_V_hasXidX1X_name_equals_g_v1_name(g.V.has('id', '1').name, g.v(1)._().name);
    }
}
