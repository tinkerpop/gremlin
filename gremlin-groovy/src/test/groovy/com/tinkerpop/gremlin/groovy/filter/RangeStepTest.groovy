package com.tinkerpop.gremlin.groovy.filter

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class RangeStepTest extends com.tinkerpop.gremlin.test.filter.RangeStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_rangeX0_1X() {
        super.test_g_v1_out_rangeX0_1X(g.v(1).out[0..1]);
    }

    public void test_g_v1_outXknowsX_outEXcreatedX_rangeX0_0X_inV() {
        super.test_g_v1_outXknowsX_outEXcreatedX_rangeX0_0X_inV(g.v(1).out('knows').outE('created')[0..0].inV);
    }

    public void test_g_v1_outXknowsX_outXcreatedX_rangeX0_0X() {
        super.test_g_v1_outXknowsX_outXcreatedX_rangeX0_0X(g.v(1).out('knows').out('created')[0..0]);
    }

    public void test_g_v1_outXcreatedX_inXcreatedX_rangeX1_2X() {
        super.test_g_v1_outXcreatedX_inXcreatedX_rangeX1_2X(g.v(1).out('created').in('created')[1..2]);
    }

    public void test_g_v1_outXcreatedX_inEXcreatedX_rangeX1_2X_outV() {
        super.test_g_v1_outXcreatedX_inXcreatedX_rangeX1_2X(g.v(1).out('created').inE('created')[1..2].outV);
    }

}
