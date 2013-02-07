package com.tinkerpop.gremlin.groovy.branch

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class IfThenElseStepTest extends com.tinkerpop.gremlin.test.branch.IfThenElseStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_ifThenElseXlang_eq_java__it__outX_name() {
        super.test_g_v1_out_ifThenElseXlang_eq_java__it__outX_name(g.v(1).out.ifThenElse { it.lang == 'java' } { it } { it.out }.name);
    }
}