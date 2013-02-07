package com.tinkerpop.gremlin.groovy

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class FunctionStepTest extends com.tinkerpop.gremlin.test.FunctionStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_stepXnext_nameX() {
        super.test_g_v1_out_stepXnext_nameX(g.v(1).out.step { it.next().name });
    }
}