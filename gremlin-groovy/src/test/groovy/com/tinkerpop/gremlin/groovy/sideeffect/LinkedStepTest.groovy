package com.tinkerpop.gremlin.groovy.sideeffect

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class LinkedStepTest extends com.tinkerpop.gremlin.test.sideeffect.LinkStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void test_g_v1_asXaX_outXcreatedX_inXcreatedX_linkBothXcocreator_aX() {
        super.test_g_v1_asXaX_outXcreatedX_inXcreatedX_linkBothXcocreator_aX(g.v(1).as('a').out('created').in('created').linkBoth('cocreator', 'a'));
    }
}
