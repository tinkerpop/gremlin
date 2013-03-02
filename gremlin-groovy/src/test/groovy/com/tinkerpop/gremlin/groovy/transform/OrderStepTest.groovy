package com.tinkerpop.gremlin.groovy.transform

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Tokens
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class OrderStepTest extends com.tinkerpop.gremlin.test.transform.OrderStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_V_name_order() {
        super.test_g_V_name_order(g.V.name.order);
    }

    public void test_g_V_name_orderXabX() {
        super.test_g_V_name_orderXabX(g.V.name.order { it.b <=> it.a });
    }

    public void test_g_V_orderXa_nameXb_nameX_name() {
        super.test_g_V_orderXa_nameXb_nameX_name(g.V.order { it.b.name <=> it.a.name }.name);
    }

    public void test_g_V_name_orderXdecrX() {
        super.test_g_V_name_orderXdecrX(g.V.name.order(Tokens.T.decr));
    }
}