package com.tinkerpop.gremlin.groovy.transform

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class SelectStepTest extends com.tinkerpop.gremlin.test.transform.SelectStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_asXaX_outXknowsX_asXbX_select() {
        super.test_g_v1_asXaX_outXknowsX_asXbX_select(g.v(1).as('a').out('knows').as('b').select)
    }

    public void test_g_v1_asXaX_outXknowsX_asXbX_selectXnameX() {
        super.test_g_v1_asXaX_outXknowsX_asXbX_selectXnameX(g.v(1).as('a').out('knows').as('b').select { it.name });
    }

    public void test_g_v1_asXaX_outXknowsX_asXbX_selectXaX() {
        super.test_g_v1_asXaX_outXknowsX_asXbX_selectXaX(g.v(1).as('a').out('knows').as('b').select(['a']));
    }

    public void test_g_v1_asXaX_outXknowsX_asXbX_selectXa_nameX() {
        super.test_g_v1_asXaX_outXknowsX_asXbX_selectXa_nameX(g.v(1).as('a').out('knows').as('b').select(['a']) { it.name });
    }
}
