package com.tinkerpop.gremlin.groovy.branch

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class LoopStepTest extends com.tinkerpop.gremlin.test.branch.LoopStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_loopX1_loops_lt_3X_propertyXnameX() {
        super.test_g_v1_out_loopX1_loops_lt_3X_propertyXnameX(g.v(1).out.loop(1) { it.loops < 3 }.name);
    }

    public void test_g_v1_asXhereX_out_loopXhere_loops_lt_3X_propertyXnameX() {
        super.test_g_v1_asXhereX_out_loopXhere_loops_lt_3X_propertyXnameX(g.v(1).as('here').out.loop('here') { it.loops < 3 }.property('name'));
    }

    public void test_g_V_out_loopX1_loops_lt_3X_propertyXnameX() {
        super.test_g_V_out_loopX1_loops_lt_3X_propertyXnameX(g.V.out.loop(1) { it.loops < 3 }.property('name'));
    }

    public void test_g_V_asXhereX_out_loopXhere_loops_lt_3X_propertyXnameX() {
        super.test_g_V_asXhereX_out_loopXhere_loops_lt_3X_propertyXnameX(g.V.as('here').out.loop('here') { it.loops < 3 }.name);
    }
}