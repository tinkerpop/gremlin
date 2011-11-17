package com.tinkerpop.gremlin.groovy.filter

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.UtilitiesTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class RetainStepTest extends com.tinkerpop.gremlin.test.filter.RetainStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        UtilitiesTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_retainXg_v2X() {
        super.test_g_v1_out_retainXg_v2X(g.v(1).out.retain([g.v(2)]));
    }

    public void test_g_v1_out_aggregateXxX_out_retainXxX() {
        def x = [] as Set;
        super.test_g_v1_out_aggregateXxX_out_retainXxX(g.v(1).out.aggregate(x).out.retain(x));
    }
}