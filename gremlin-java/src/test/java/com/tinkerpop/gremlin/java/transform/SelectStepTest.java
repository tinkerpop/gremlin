package com.tinkerpop.gremlin.java.transform;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;
import com.tinkerpop.pipes.PipeFunction;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SelectStepTest extends com.tinkerpop.gremlin.test.transform.SelectStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_asXaX_outXknowsX_asXbX_select() {
        super.test_g_v1_asXaX_outXknowsX_asXbX_select(new GremlinPipeline(g.getVertex(1)).as("a").out("knows").as("b").select());
        super.test_g_v1_asXaX_outXknowsX_asXbX_select(new GremlinPipeline(g.getVertex(1)).optimize(false).as("a").out("knows").as("b").select());
    }

    public void test_g_v1_asXaX_outXknowsX_asXbX_selectXnameX() {
        super.test_g_v1_asXaX_outXknowsX_asXbX_selectXnameX(new GremlinPipeline(g.getVertex(1)).as("a").out("knows").as("b").select(new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }));

        super.test_g_v1_asXaX_outXknowsX_asXbX_selectXnameX(new GremlinPipeline(g.getVertex(1)).optimize(false).as("a").out("knows").as("b").select(new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }));
    }

    public void test_g_v1_asXaX_outXknowsX_asXbX_selectXaX() {
        super.test_g_v1_asXaX_outXknowsX_asXbX_selectXaX(new GremlinPipeline<Vertex, List>(g.getVertex(1)).as("a").out("knows").as("b").select(Arrays.asList("a")));
    }

    public void test_g_v1_asXaX_outXknowsX_asXbX_selectXa_nameX() {
        super.test_g_v1_asXaX_outXknowsX_asXbX_selectXa_nameX(new GremlinPipeline<Vertex, List>(g.getVertex(1)).as("a").out("knows").as("b").select(Arrays.asList("a"), new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }));
    }
}