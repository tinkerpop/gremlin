package com.tinkerpop.gremlin.groovy.transform

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class MapStepTest extends com.tinkerpop.gremlin.test.transform.MapStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_map() {
        super.test_g_v1_map(g.v(1).map)
    }

    public void test_g_v1_mapXname_idX() {
        super.test_g_v1_mapXname_idX(g.v(1).map('name', 'id'));
    }

    public void test_g_v1_outXknowsX_map() {
        super.test_g_v1_outXknowsX_map(g.v(1).out('knows').map);
    }
}
