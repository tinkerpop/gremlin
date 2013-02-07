package com.tinkerpop.gremlin.groovy.transform

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.Vertex
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.java.GremlinPipeline
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.pipes.Pipe

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GatherStepTest extends com.tinkerpop.gremlin.test.transform.GatherStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_gather(final Pipe<Vertex, List<Vertex>> pipe) {
        super.test_g_v1_out_gather(new GremlinPipeline(g.v(1).out.gather));
    }

    public void test_g_v1_out_gatherXget0X(final Pipe<Vertex, Vertex> pipe) {
        super.test_g_v1_out_gatherXget0X(g.v(1).out.gather { it[0] });
    }
}