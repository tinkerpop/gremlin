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
public class DedupStepTest extends com.tinkerpop.gremlin.test.filter.DedupStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_V_both_dedup_name() {
        super.test_g_V_both_dedup_name(new GremlinPipeline(g.getVertices()).both().dedup().property("name"));
        super.test_g_V_both_dedup_name(new GremlinPipeline(g.getVertices()).optimize(false).both().dedup().property("name"));
    }

    public void test_g_V_both_dedupXlangX_name() {
        super.test_g_V_both_dedupXlangX_name(new GremlinPipeline(g.getVertices()).both().dedup(new PipeFunction<Vertex, String>() {
            public String compute(final Vertex vertex) {
                return (String) vertex.getProperty("lang");
            }
        }).property("name"));

        super.test_g_V_both_dedupXlangX_name(new GremlinPipeline(g).optimize(false).V().both().dedup(new PipeFunction<Vertex, String>() {
            public String compute(final Vertex vertex) {
                return (String) vertex.getProperty("lang");
            }
        }).property("name"));
    }
}
