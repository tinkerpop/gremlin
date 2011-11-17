package com.tinkerpop.gremlin.java.filter;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.UtilitiesTest;
import com.tinkerpop.pipes.PipeFunction;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BackStepTest extends com.tinkerpop.gremlin.test.filter.BackStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        UtilitiesTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_backX1X() {
        super.test_g_v1_out_backX1X(new GremlinPipeline(g.getVertex(1)).out().back(1));
    }

    public void test_g_v1_asXhereX_out_backXhereX() {
        super.test_g_v1_asXhereX_out_backXhereX(new GremlinPipeline(g.getVertex(1)).as("here").out().back("here"));
    }

    public void test_g_v4_out_filterXlang_eq_javaX_backX1X() {
        super.test_g_v4_out_filterXlang_eq_javaX_backX1X(new GremlinPipeline(g.getVertex(4)).out().filter(new PipeFunction<Vertex, Boolean>() {
            public Boolean compute(Vertex v) {
                return v.getProperty("lang").equals("java");
            }
        }).back(1));
    }

    public void test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX() {
        super.test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX(new GremlinPipeline(g.getVertex(4)).out().as("here").filter(new PipeFunction<Vertex, Boolean>() {
            public Boolean compute(Vertex v) {
                return v.getProperty("lang").equals("java");
            }
        }).back("here"));
    }

    public void test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX_propertyXnameX() {
        super.test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX_propertyXnameX(new GremlinPipeline(g.getVertex(4)).out().as("here").filter(new PipeFunction<Vertex, Boolean>() {
            public Boolean compute(Vertex v) {
                return v.getProperty("lang").equals("java");
            }
        }).back("here").property("name"));
    }
}