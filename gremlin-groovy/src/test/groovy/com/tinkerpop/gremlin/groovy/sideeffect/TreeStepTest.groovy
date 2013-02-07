package com.tinkerpop.gremlin.groovy.sideeffect

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class TreeStepTest extends com.tinkerpop.gremlin.test.sideeffect.TreeStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_out_treeXnameX_cap() {
        super.test_g_v1_out_out_treeXnameX_cap(g.v(1).out.out.tree { it.name }.cap);
    }
}