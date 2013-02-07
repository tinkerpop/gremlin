package com.tinkerpop.gremlin.groovy.sideeffect

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class StoreStepTest extends com.tinkerpop.gremlin.test.sideeffect.StoreStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_V_propertyXnameX_store_cap() {
        super.test_g_V_propertyXnameX_store_cap(g.V.name.store.cap);
    }

    public void test_g_V_storeXnameX_cap() {
        super.test_g_V_storeXnameX_cap(g.V.store { it.name }.cap);
    }
}