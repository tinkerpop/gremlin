package com.tinkerpop.gremlin.groovy.filter

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class RetainStepTest extends com.tinkerpop.gremlin.test.filter.RetainStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_retainXg_v2X() {
        super.test_g_v1_out_retainXg_v2X(g.v(1).out.retain([g.v(2)]));
    }

    public void test_g_v1_out_aggregateXxX_out_retainXxX() {
        def x = [] as Set;
        super.test_g_v1_out_aggregateXxX_out_retainXxX(g.v(1).out.aggregate(x).out.retain(x));
    }
}