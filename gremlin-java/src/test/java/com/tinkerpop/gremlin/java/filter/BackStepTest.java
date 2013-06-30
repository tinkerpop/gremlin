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
public class BackStepTest extends com.tinkerpop.gremlin.test.filter.BackStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_backX1X() {
        super.test_g_v1_out_backX1X(new GremlinPipeline(g.getVertex(1)).out().back(1));
        super.test_g_v1_out_backX1X(new GremlinPipeline(g.getVertex(1)).optimize(false).out().back(1));
    }

    public void test_g_v1_asXhereX_out_backXhereX() {
        super.test_g_v1_asXhereX_out_backXhereX(new GremlinPipeline(g.getVertex(1)).as("here").out().back("here"));
        super.test_g_v1_asXhereX_out_backXhereX(new GremlinPipeline(g.getVertex(1)).optimize(false).as("here").out().back("here"));
    }

    public void test_g_v4_out_filterXlang_eq_javaX_backX1X() {
        super.test_g_v4_out_filterXlang_eq_javaX_backX1X(new GremlinPipeline(g.getVertex(4)).out().filter(new PipeFunction<Vertex, Boolean>() {
            public Boolean compute(Vertex v) {
                return v.getProperty("lang").equals("java");
            }
        }).back(1));

        super.test_g_v4_out_filterXlang_eq_javaX_backX1X(new GremlinPipeline(g.getVertex(4)).optimize(false).out().filter(new PipeFunction<Vertex, Boolean>() {
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

        super.test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX(new GremlinPipeline(g.getVertex(4)).optimize(false).out().as("here").filter(new PipeFunction<Vertex, Boolean>() {
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

        super.test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX_propertyXnameX(new GremlinPipeline(g.getVertex(4)).optimize(false).out().as("here").filter(new PipeFunction<Vertex, Boolean>() {
            public Boolean compute(Vertex v) {
                return v.getProperty("lang").equals("java");
            }
        }).back("here").property("name"));
    }

    public void test_g_v1_outE_inV_hasXname_vadasX_backX2X() {
        super.test_g_v1_outE_inV_hasXname_vadasX_backX2X(new GremlinPipeline(g.getVertex(1)).outE().inV().has("name", "vadas").back(2));
        super.test_g_v1_outE_inV_hasXname_vadasX_backX2X(new GremlinPipeline(g.getVertex(1)).optimize(false).outE().inV().has("name", "vadas").back(2));
    }

    public void test_g_v1_outE_asXhereX_inV_hasXname_vadasX_backXhereX() {
        super.test_g_v1_outE_asXhereX_inV_hasXname_vadasX_backXhereX(new GremlinPipeline(g.getVertex(1)).outE().as("here").inV().has("name", "vadas").back("here"));
        super.test_g_v1_outE_asXhereX_inV_hasXname_vadasX_backXhereX(new GremlinPipeline(g.getVertex(1)).optimize(false).outE().as("here").inV().has("name", "vadas").back("here"));
    }

}