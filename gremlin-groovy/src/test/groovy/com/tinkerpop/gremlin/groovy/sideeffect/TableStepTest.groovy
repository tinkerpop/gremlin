package com.tinkerpop.gremlin.groovy.sideeffect

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class TableStepTest extends com.tinkerpop.gremlin.test.sideeffect.TableStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_asXaX_out_properyXnameX_asXbX_table_cap() {
        super.test_g_v1_asXaX_out_properyXnameX_asXbX_table_cap(g.v(1).as('a').out.name.as('b').table.cap);
    }

    public void test_g_v1_asXaX_out_asXbX_tableXnameX_cap() {
        super.test_g_v1_asXaX_out_asXbX_tableXnameX_cap(g.v(1).as('a').out.as('b').table {it.name}.cap);
    }

    public void test_g_v1_asXaX_out_propertyXnameX_asXbX_tableXname_lengthX_cap() {
        super.test_g_v1_asXaX_out_propertyXnameX_asXbX_tableXname_lengthX_cap(g.v(1).as('a').out.name.as('b').table {it.name} {it.length()}.cap);
    }
}
