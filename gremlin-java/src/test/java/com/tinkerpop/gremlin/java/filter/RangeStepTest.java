package com.tinkerpop.gremlin.java.filter;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RangeStepTest extends com.tinkerpop.gremlin.test.filter.RangeStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_rangeX0_1X() {
        super.test_g_v1_out_rangeX0_1X(new GremlinPipeline<Vertex, Vertex>(g.getVertex(1)).out().range(0, 1));
    }
    
    public void test_g_v1_outXknowsX_outEXcreatedX_rangeX0_0X_inV() {
        super.test_g_v1_outXknowsX_outEXcreatedX_rangeX0_0X_inV(new GremlinPipeline<Vertex, Vertex>(g.getVertex(1)).out("knows").outE("created").range(0, 0).inV());
    }
    
    public void test_g_v1_outXknowsX_outXcreatedX_rangeX0_0X() {
        super.test_g_v1_outXknowsX_outXcreatedX_rangeX0_0X(new GremlinPipeline<Vertex, Vertex>(g.getVertex(1)).out("knows").out("created").range(0,0));
    }

}
