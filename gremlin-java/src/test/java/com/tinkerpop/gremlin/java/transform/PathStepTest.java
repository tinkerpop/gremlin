package com.tinkerpop.gremlin.java.transform;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;
import com.tinkerpop.pipes.PipeFunction;
import com.tinkerpop.pipes.branch.LoopPipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PathStepTest extends com.tinkerpop.gremlin.test.transform.PathStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_propertyXnameX_path() {
        super.test_g_v1_propertyXnameX_path(new GremlinPipeline(g.getVertex(1)).property("name").path());
        super.test_g_v1_propertyXnameX_path(new GremlinPipeline(g.getVertex(1)).optimize(false).property("name").path());
    }

    public void test_g_v1_out_pathXage__nameX() {
        super.test_g_v1_out_pathXage__nameX(new GremlinPipeline(g.getVertex(1)).out().path(new PipeFunction<Vertex, Integer>() {
                                                                                               public Integer compute(Vertex vertex) {
                                                                                                   return (Integer) vertex.getProperty("age");
                                                                                               }
                                                                                           }, new PipeFunction<Vertex, String>() {
                                                                                               public String compute(Vertex vertex) {
                                                                                                   return (String) vertex.getProperty("name");
                                                                                               }
                                                                                           }
        ));

        super.test_g_v1_out_pathXage__nameX(new GremlinPipeline(g.getVertex(1)).optimize(false).out().path(new PipeFunction<Vertex, Integer>() {
                                                                                                               public Integer compute(Vertex vertex) {
                                                                                                                   return (Integer) vertex.getProperty("age");
                                                                                                               }
                                                                                                           }, new PipeFunction<Vertex, String>() {
                                                                                                               public String compute(Vertex vertex) {
                                                                                                                   return (String) vertex.getProperty("name");
                                                                                                               }
                                                                                                           }
        ));
    }

    public void test_g_V_out_loopX1__loops_lt_3X_pathXit__name__langX() {
        super.test_g_V_out_loopX1__loops_lt_3X_pathXit__name__langX(new GremlinPipeline(g.getVertices()).out().loop(1, new PipeFunction<LoopPipe.LoopBundle, Boolean>() {
            public Boolean compute(LoopPipe.LoopBundle bundle) {
                return bundle.getLoops() < 3;
            }
        }).path(new PipeFunction<Vertex, Vertex>() {
                    public Vertex compute(Vertex vertex) {
                        return vertex;
                    }
                }, new PipeFunction<Vertex, String>() {
                    public String compute(Vertex vertex) {
                        return (String) vertex.getProperty("name");
                    }
                }, new PipeFunction<Vertex, String>() {
                    public String compute(Vertex vertex) {
                        return (String) vertex.getProperty("lang");
                    }
                }
        ));

        super.test_g_V_out_loopX1__loops_lt_3X_pathXit__name__langX(new GremlinPipeline(g).V().optimize(false).out().loop(1, new PipeFunction<LoopPipe.LoopBundle, Boolean>() {
            public Boolean compute(LoopPipe.LoopBundle bundle) {
                return bundle.getLoops() < 3;
            }
        }).path(new PipeFunction<Vertex, Vertex>() {
                    public Vertex compute(Vertex vertex) {
                        return vertex;
                    }
                }, new PipeFunction<Vertex, String>() {
                    public String compute(Vertex vertex) {
                        return (String) vertex.getProperty("name");
                    }
                }, new PipeFunction<Vertex, String>() {
                    public String compute(Vertex vertex) {
                        return (String) vertex.getProperty("lang");
                    }
                }
        ));
    }
}