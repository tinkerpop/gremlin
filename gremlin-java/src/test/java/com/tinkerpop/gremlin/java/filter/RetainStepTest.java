package com.tinkerpop.gremlin.java.filter;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RetainStepTest extends com.tinkerpop.gremlin.test.filter.RetainStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_retainXg_v2X() {
        super.test_g_v1_out_retainXg_v2X(new GremlinPipeline(g.getVertex(1)).out().retain(Arrays.asList(g.getVertex(2))));
        super.test_g_v1_out_retainXg_v2X(new GremlinPipeline(g.getVertex(1)).optimize(false).out().retain(Arrays.asList(g.getVertex(2))));
    }

    public void test_g_v1_out_aggregateXxX_out_retainXxX() {
        Set<Vertex> x = new HashSet<Vertex>();
        super.test_g_v1_out_aggregateXxX_out_retainXxX(new GremlinPipeline(g.getVertex(1)).out().aggregate(x).out().retain(x));

        x = new HashSet<Vertex>();
        super.test_g_v1_out_aggregateXxX_out_retainXxX(new GremlinPipeline(g.getVertex(1)).optimize(false).out().aggregate(x).out().retain(x));
    }
}