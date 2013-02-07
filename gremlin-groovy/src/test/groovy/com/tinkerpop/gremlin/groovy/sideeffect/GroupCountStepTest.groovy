package com.tinkerpop.gremlin.groovy.sideeffect

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GroupCountStepTest extends com.tinkerpop.gremlin.test.sideeffect.GroupCountStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_V_outXcreatedX_groupCountXm__nameX() {
        def m = [:]
        super.test_g_V_outXcreatedX_groupCountXm__nameX(g.V.out('created').groupCount(m) { it.name }, m);
    }

    public void test_g_V_outXcreatedX_groupCountXm__name__plus_2X() {
        def m = [:]
        super.test_g_V_outXcreatedX_groupCountXm__name__plus_2X(g.V.out('created').groupCount(m) { it.name } { it.b + 2l }, m);
    }

    public void test_g_V_outXcreatedX_groupCountXnameX_cap() {
        super.test_g_V_outXcreatedX_groupCountXnameX_cap(g.V.out('created').groupCount { it.name }.cap);
    }
}

