package com.tinkerpop.gremlin.groovy.branch

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.test.UtilitiesTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class LoopStepTest extends com.tinkerpop.gremlin.test.branch.LoopStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testTrue() {
        assertTrue(true);
    }

    public void testCompliance() {
        UtilitiesTest.testCompliance(this.getClass());
    }

    public void test_g_v1_loopXstep_lt_3__outX_propertyXnameX() {
        super.test_g_v1_loopXstep_lt_3__outX_propertyXnameX(g.v(1).loop{it.step < 3}{_().out}.property('name'));
    }

    public void test_g_V_loopXstep_lt_3__outX_propertyXnameX() {
        super.test_g_V_loopXstep_lt_3__outX_propertyXnameX(g.V.loop{it.step < 3}{_().out}.name);
    }
}