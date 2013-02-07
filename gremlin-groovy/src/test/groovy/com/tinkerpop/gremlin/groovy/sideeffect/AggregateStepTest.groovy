package com.tinkerpop.gremlin.groovy.sideeffect

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class AggregateStepTest extends com.tinkerpop.gremlin.test.sideeffect.AggregateStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_aggregateXxX_outXcreatedX_inXcreatedX_exceptXxX() {
        def x = [];
        super.test_g_v1_aggregateXxX_outXcreatedX_inXcreatedX_exceptXxX(g.v(1).aggregate(x).out('created').in('created').except(x))
    }

    public void test_g_V_propertyXnameX_aggregate_cap() {
        super.test_g_V_propertyXnameX_aggregate_cap(g.V.name.aggregate.cap);
    }

    public void test_g_V_aggregateXnameX_cap() {
        super.test_g_V_aggregateXnameX_cap(g.V.aggregate { it.name }.cap);
    }
}