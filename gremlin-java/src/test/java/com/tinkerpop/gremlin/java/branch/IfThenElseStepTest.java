package com.tinkerpop.gremlin.java.branch;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;
import com.tinkerpop.pipes.PipeFunction;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IfThenElseStepTest extends com.tinkerpop.gremlin.test.branch.IfThenElseStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_ifThenElseXlang_eq_java__it__outX_name() {
        super.test_g_v1_out_ifThenElseXlang_eq_java__it__outX_name(new GremlinPipeline(g.getVertex(1)).out().ifThenElse(new PipeFunction<Vertex, Boolean>() {
                                                                                                                            public Boolean compute(Vertex vertex) {
                                                                                                                                return vertex.getProperty("lang") != null && vertex.getProperty("lang").equals("java");
                                                                                                                            }
                                                                                                                        }, new PipeFunction<Vertex, Vertex>() {
                                                                                                                            public Vertex compute(Vertex vertex) {
                                                                                                                                return vertex;
                                                                                                                            }
                                                                                                                        }, new PipeFunction<Vertex, Iterable<Vertex>>() {
                                                                                                                            public Iterable<Vertex> compute(Vertex vertex) {
                                                                                                                                return new GremlinPipeline(vertex).out();
                                                                                                                            }
                                                                                                                        }
        ));

        super.test_g_v1_out_ifThenElseXlang_eq_java__it__outX_name(new GremlinPipeline(g.getVertex(1)).optimize(false).out().ifThenElse(new PipeFunction<Vertex, Boolean>() {
                                                                                                                                            public Boolean compute(Vertex vertex) {
                                                                                                                                                return vertex.getProperty("lang") != null && vertex.getProperty("lang").equals("java");
                                                                                                                                            }
                                                                                                                                        }, new PipeFunction<Vertex, Vertex>() {
                                                                                                                                            public Vertex compute(Vertex vertex) {
                                                                                                                                                return vertex;
                                                                                                                                            }
                                                                                                                                        }, new PipeFunction<Vertex, Iterable<Vertex>>() {
                                                                                                                                            public Iterable<Vertex> compute(Vertex vertex) {
                                                                                                                                                return new GremlinPipeline(vertex).out();
                                                                                                                                            }
                                                                                                                                        }
        ));
    }
}