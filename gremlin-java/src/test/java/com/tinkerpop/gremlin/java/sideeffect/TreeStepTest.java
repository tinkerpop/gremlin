package com.tinkerpop.gremlin.java.sideeffect;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;
import com.tinkerpop.pipes.PipeFunction;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TreeStepTest extends com.tinkerpop.gremlin.test.sideeffect.TreeStepTest {

    Graph graph = TinkerGraphFactory.createTinkerGraph();


    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_out_treeXnameX_cap() {
        super.test_g_v1_out_out_treeXnameX_cap(new GremlinPipeline(graph.getVertex(1)).out().out().tree(new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }).cap());

        super.test_g_v1_out_out_treeXnameX_cap(new GremlinPipeline(graph.getVertex(1)).optimize(false).out().out().tree(new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }).cap());
    }
}