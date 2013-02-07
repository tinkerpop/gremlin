package com.tinkerpop.gremlin.groovy.filter

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class DedupStepTest extends com.tinkerpop.gremlin.test.filter.DedupStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_V_both_dedup_name() {
        super.test_g_V_both_dedup_name(g.V.both.dedup.name);
    }

    public void test_g_V_both_dedupXlangX_name() {
        super.test_g_V_both_dedupXlangX_name(g.V.both.dedup { it.lang }.name);
    }

}