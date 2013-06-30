package com.tinkerpop.gremlin.java.transform;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.PipeFunction;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GatherStepTest extends com.tinkerpop.gremlin.test.transform.GatherStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_gather(final Pipe<Vertex, List<Vertex>> pipe) {
        super.test_g_v1_out_gather(new GremlinPipeline(g.getVertex(1)).out().gather());
        super.test_g_v1_out_gather(new GremlinPipeline(g.getVertex(1)).optimize(false).out().gather());
    }

    public void test_g_v1_out_gatherXget0X(final Pipe<Vertex, Vertex> pipe) {
        super.test_g_v1_out_gatherXget0X(new GremlinPipeline(g.getVertex(1)).out().gather(new PipeFunction<List, Vertex>() {
            public Vertex compute(List argument) {
                return (Vertex) argument.get(0);
            }
        }));

        super.test_g_v1_out_gatherXget0X(new GremlinPipeline(g.getVertex(1)).optimize(false).out().gather(new PipeFunction<List, Vertex>() {
            public Vertex compute(List argument) {
                return (Vertex) argument.get(0);
            }
        }));
    }
}