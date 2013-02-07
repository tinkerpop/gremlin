package com.tinkerpop.gremlin.groovy.sideeffect

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GroupByStepTest extends com.tinkerpop.gremlin.test.sideeffect.GroupByStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }


    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_V_groupByXlang_nameX() {
        def m = [:];
        super.test_g_V_groupByXlang_nameX(g.V.groupBy(m) { it.lang } { it.name }, m);
    }
}