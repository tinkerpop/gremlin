package com.tinkerpop.gremlin.java.transform;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class MapStepTest extends com.tinkerpop.gremlin.test.transform.MapStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_map() {
        super.test_g_v1_map(new GremlinPipeline(g.getVertex(1)).map());
        super.test_g_v1_map(new GremlinPipeline(g.getVertex(1)).optimize(false).map());
    }

    public void test_g_v1_mapXname_idX() {
        super.test_g_v1_mapXname_idX(new GremlinPipeline(g.getVertex(1)).map("name", "id"));
        super.test_g_v1_mapXname_idX(new GremlinPipeline(g.getVertex(1)).optimize(false).map("name", "id"));
    }

    public void test_g_v1_outXknowsX_map() {
        super.test_g_v1_outXknowsX_map(new GremlinPipeline(g.getVertex(1)).out("knows").map());
        super.test_g_v1_outXknowsX_map(new GremlinPipeline(g.getVertex(1)).optimize(false).out("knows").map());
    }
}
