package com.tinkerpop.gremlin.groovy.sideeffect

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.test.UtilitiesTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class SideEffectStepTest extends com.tinkerpop.gremlin.test.sideeffect.SideEffectStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        UtilitiesTest.testCompliance(this.getClass());
    }

    public void test_g_v1_sideEffectXstore_aX_propertyXnameX() {
        def a;
        super.test_g_v1_sideEffectXstore_aX_propertyXnameX(g.v(1).sideEffect {a = it}.name);
        assertEquals(a, g.v(1))
    }

    public void test_g_v1_out_sideEffectXincr_cX_propertyXnameX() {
        def c = 0;
        super.test_g_v1_out_sideEffectXincr_cX_propertyXnameX(g.v(1).out.sideEffect {c++}.name);
        assertEquals(c, 3);
    }

    public void test_g_v1_out_sideEffectXfalseX_propertyXnameX() {
        super.test_g_v1_out_sideEffectXfalseX_propertyXnameX(g.v(1).out.sideEffect {false}.name);
    }

}
