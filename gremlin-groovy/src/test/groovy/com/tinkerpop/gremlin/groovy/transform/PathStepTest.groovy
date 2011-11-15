package com.tinkerpop.gremlin.groovy.transform

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.test.UtilitiesTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class PathStepTest extends com.tinkerpop.gremlin.test.transform.PathStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        UtilitiesTest.testCompliance(this.getClass());
    }

    public void test_g_v1_propertyXnameX_paths() {
        super.test_g_v1_propertyXnameX_paths(g.v(1)._.name.paths);
    }

    public void test_g_v1_out_pathsXage__nameX() {
        super.test_g_v1_out_pathsXage__nameX(g.v(1).out.paths {it.age} {it.name});
    }

    public void test_g_V_out_loopX1__loops_lt_3X_pathsXit__name__langX() {
        super.test_g_V_out_loopX1__loops_lt_3X_pathsXit__name__langX(g.V.out.loop(1){it.loops < 3}.paths {it} {it.name} {it.lang});
    }
}