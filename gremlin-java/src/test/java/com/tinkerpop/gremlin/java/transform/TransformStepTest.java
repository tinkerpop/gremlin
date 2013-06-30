package com.tinkerpop.gremlin.java.transform;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;
import com.tinkerpop.pipes.PipeFunction;
import com.tinkerpop.pipes.util.PipesFunction;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TransformStepTest extends com.tinkerpop.gremlin.test.transform.TransformStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_transformXnameX() {
        super.test_g_v1_transformXnameX(new GremlinPipeline(g.getVertex(1)).transform(new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }));

        super.test_g_v1_transformXnameX(new GremlinPipeline(g.getVertex(1)).optimize(false).transform(new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }));
    }

    public void test_g_v1_outE_label_transformXlengthX() {
        super.test_g_v1_outE_label_transformXlengthX(new GremlinPipeline(g.getVertex(1)).outE().label().transform(new PipeFunction<String, Integer>() {
            public Integer compute(String name) {
                return name.length();
            }
        }));

        super.test_g_v1_outE_label_transformXlengthX(new GremlinPipeline(g.getVertex(1)).optimize(false).outE().label().transform(new PipeFunction<String, Integer>() {
            public Integer compute(String name) {
                return name.length();
            }
        }));
    }

    public void test_g_v1_out_transformXnameX_transformXlengthX() {
        super.test_g_v1_out_transformXnameX_transformXlengthX(new GremlinPipeline(g.getVertex(1)).out().transform(new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }).transform(new PipeFunction<String, Integer>() {
            public Integer compute(String name) {
                return name.length();
            }
        }));

        super.test_g_v1_out_transformXnameX_transformXlengthX(new GremlinPipeline(g.getVertex(1)).optimize(false).out().transform(new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }).transform(new PipeFunction<String, Integer>() {
            public Integer compute(String name) {
                return name.length();
            }
        }));
    }

    public void test_g_V_asXaX_out_transformXa_nameX() {
        super.test_g_V_asXaX_out_transformXa_nameX(new GremlinPipeline(g).V().as("a").out().transform(
                new PipesFunction() {
                    public Object compute(Object argument) {
                        return ((Vertex) this.asMap.get("a")).getProperty("name");
                    }
                }
        ));

        super.test_g_V_asXaX_out_transformXa_nameX(new GremlinPipeline(g.getVertices()).optimize(false).as("a").out().transform(
                new PipesFunction() {
                    public Object compute(Object argument) {
                        return ((Vertex) this.asMap.get("a")).getProperty("name");
                    }
                }
        ));
    }
}
