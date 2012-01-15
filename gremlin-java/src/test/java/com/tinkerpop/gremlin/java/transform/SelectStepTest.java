package com.tinkerpop.gremlin.java.transform;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;

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
        super.test_g_v1_asXaX_outXknowsX_asXbX_select(new GremlinPipeline<Vertex, List>(g.getVertex(1)).as("a").out("knows").as("b").select());
    }
}