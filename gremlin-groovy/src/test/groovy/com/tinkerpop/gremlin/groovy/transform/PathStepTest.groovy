package com.tinkerpop.gremlin.groovy.transform

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class PathStepTest extends com.tinkerpop.gremlin.test.transform.PathStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_propertyXnameX_path() {
        super.test_g_v1_propertyXnameX_path(g.v(1)._.name.path);
    }

    public void test_g_v1_out_pathXage__nameX() {
        super.test_g_v1_out_pathXage__nameX(g.v(1).out.path { it.age } { it.name });
    }

    public void test_g_V_out_loopX1__loops_lt_3X_pathXit__name__langX() {
        super.test_g_V_out_loopX1__loops_lt_3X_pathXit__name__langX(g.V.out.loop(1) { it.loops < 3 }.path { it } { it.name } { it.lang });
    }
}