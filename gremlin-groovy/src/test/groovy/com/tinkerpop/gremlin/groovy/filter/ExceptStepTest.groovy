package com.tinkerpop.gremlin.groovy.filter

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ExceptStepTest extends com.tinkerpop.gremlin.test.filter.ExceptStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_exceptXg_v2X() {
        super.test_g_v1_out_exceptXg_v2X(g.v(1).out.except([g.v(2)]));
    }

    public void test_g_v1_out_aggregateXxX_out_exceptXxX() {
        def x = [] as Set;
        super.test_g_v1_out_aggregateXxX_out_exceptXxX(g.v(1).out.aggregate(x).out.except(x));
    }

    public void test_g_v1_outXcreatedX_inXcreatedX_exceptXg_v1X_propertyXnameX() {
        super.test_g_v1_outXcreatedX_inXcreatedX_exceptXg_v1X_propertyXnameX(g.v(1).out("created").in("created").except([g.v(1)]).property("name"));
    }
}