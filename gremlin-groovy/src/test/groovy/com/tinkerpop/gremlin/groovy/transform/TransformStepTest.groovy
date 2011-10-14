package com.tinkerpop.gremlin.groovy.transform

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.test.UtilitiesTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class TransformStepTest extends com.tinkerpop.gremlin.test.transform.TransformStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        UtilitiesTest.testCompliance(this.getClass());
    }

    public void test_g_v1_transformXnameX() {
        super.test_g_v1_transformXnameX(g.v(1)._.transform {it.name});
    }

    public void test_g_v1_outE_label_transformXlengthX() {
        super.test_g_v1_outE_label_transformXlengthX(g.v(1).outE.label.transform {it.length()});
    }

    public void test_g_v1_out_transformXnameX_transformXlengthX() {
        super.test_g_v1_out_transformXnameX_transformXlengthX(g.v(1).out.transform {it.name}.transform {it.length()});
    }
}