package com.tinkerpop.gremlin.java.filter;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class HasNotStepTest extends com.tinkerpop.gremlin.test.filter.HasNotStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_V_hasNotXname_markoX() {
        super.test_g_V_hasNotXname_markoX(new GremlinPipeline(g).V().hasNot("name", "marko"));
        super.test_g_V_hasNotXname_markoX(new GremlinPipeline(g).optimize(false).V().hasNot("name", "marko"));
    }

    public void test_g_V_hasNotXname_blahX() {
        super.test_g_V_hasNotXname_blahX(new GremlinPipeline(g.getVertices()).hasNot("name", "blah"));
        super.test_g_V_hasNotXname_blahX(new GremlinPipeline(g).optimize(false).V().hasNot("name", "blah"));
    }

    public void test_g_V_hasNotXblahX() {
        super.test_g_V_hasNotXblahX(new GremlinPipeline(g).V().hasNot("blah"));
        super.test_g_V_hasNotXblahX(new GremlinPipeline(g.getVertices()).optimize(false).hasNot("blah"));
    }
}