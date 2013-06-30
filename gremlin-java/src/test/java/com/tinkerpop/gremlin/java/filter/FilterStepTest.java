package com.tinkerpop.gremlin.java.filter;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;
import com.tinkerpop.pipes.PipeFunction;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FilterStepTest extends com.tinkerpop.gremlin.test.filter.FilterStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_V_filterXfalseX() {
        super.test_g_V_filterXfalseX(new GremlinPipeline(g.getVertices()).filter(new PipeFunction<Vertex, Boolean>() {
            public Boolean compute(Vertex vertex) {
                return false;
            }
        }));

        super.test_g_V_filterXfalseX(new GremlinPipeline(g).optimize(false).V().filter(new PipeFunction<Vertex, Boolean>() {
            public Boolean compute(Vertex vertex) {
                return false;
            }
        }));
    }

    public void test_g_V_filterXtrueX() {
        super.test_g_V_filterXtrueX(new GremlinPipeline(g).V().filter(new PipeFunction<Vertex, Boolean>() {
            public Boolean compute(Vertex vertex) {
                return true;
            }
        }));

        super.test_g_V_filterXtrueX(new GremlinPipeline(g.getVertices()).optimize(false).filter(new PipeFunction<Vertex, Boolean>() {
            public Boolean compute(Vertex vertex) {
                return true;
            }
        }));
    }

    public void test_g_V_filterXlang_eq_javaX() {
        super.test_g_V_filterXlang_eq_javaX(new GremlinPipeline(g.getVertices()).filter(new PipeFunction<Vertex, Boolean>() {
            public Boolean compute(Vertex vertex) {
                String lang = (String) vertex.getProperty("lang");
                return lang != null && lang.equals("java");
            }
        }));

        super.test_g_V_filterXlang_eq_javaX(new GremlinPipeline(g).optimize(false).V().filter(new PipeFunction<Vertex, Boolean>() {
            public Boolean compute(Vertex vertex) {
                String lang = (String) vertex.getProperty("lang");
                return lang != null && lang.equals("java");
            }
        }));
    }

    public void test_g_v1_out_filterXage_gt_30X() {
        super.test_g_v1_out_filterXage_gt_30X(new GremlinPipeline(g.getVertex(1)).out().filter(new PipeFunction<Vertex, Boolean>() {
            public Boolean compute(Vertex vertex) {
                Integer age = (Integer) vertex.getProperty("age");
                return age != null && age > 30;
            }
        }));

        super.test_g_v1_out_filterXage_gt_30X(new GremlinPipeline(g.getVertex(1)).optimize(false).out().filter(new PipeFunction<Vertex, Boolean>() {
            public Boolean compute(Vertex vertex) {
                Integer age = (Integer) vertex.getProperty("age");
                return age != null && age > 30;
            }
        }));
    }

    public void test_g_V_filterXname_startsWith_m_OR_name_startsWith_pX() {
        super.test_g_V_filterXname_startsWith_m_OR_name_startsWith_pX(new GremlinPipeline(g.getVertices()).filter(new PipeFunction<Vertex, Boolean>() {
            public Boolean compute(Vertex vertex) {
                return ((String) vertex.getProperty("name")).startsWith("m") || ((String) vertex.getProperty("name")).startsWith("p");
            }
        }));

        super.test_g_V_filterXname_startsWith_m_OR_name_startsWith_pX(new GremlinPipeline(g).optimize(false).V().filter(new PipeFunction<Vertex, Boolean>() {
            public Boolean compute(Vertex vertex) {
                return ((String) vertex.getProperty("name")).startsWith("m") || ((String) vertex.getProperty("name")).startsWith("p");
            }
        }));
    }
}
