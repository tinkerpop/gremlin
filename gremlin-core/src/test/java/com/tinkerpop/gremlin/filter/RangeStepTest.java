package com.tinkerpop.gremlin.filter;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.pipes.GremlinPipeline;
import com.tinkerpop.gremlin.test.UtilitiesTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RangeStepTest extends com.tinkerpop.gremlin.test.filter.RangeStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        UtilitiesTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_rangeX0_1X() {
        super.test_g_v1_out_rangeX0_1X(new GremlinPipeline<Vertex, Vertex>(g.getVertex(1)).out().range(0, 1));
    }

}
