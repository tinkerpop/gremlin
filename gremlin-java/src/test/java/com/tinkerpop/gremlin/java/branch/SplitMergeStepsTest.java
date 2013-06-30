package com.tinkerpop.gremlin.java.branch;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SplitMergeStepsTest extends com.tinkerpop.gremlin.test.branch.SplitMergeStepsTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_copySplitXpropertyXnameX__propertyXageXX_fairMerge() {
        super.test_g_v1_out_copySplitXpropertyXnameX__propertyXageXX_fairMerge(new GremlinPipeline(g.getVertex(1)).out().copySplit(new GremlinPipeline().property("name"), new GremlinPipeline().property("age")).fairMerge());
        super.test_g_v1_out_copySplitXpropertyXnameX__propertyXageXX_fairMerge(new GremlinPipeline(g.getVertex(1)).optimize(false).out().copySplit(new GremlinPipeline().optimize(false).property("name"), new GremlinPipeline().property("age")).fairMerge());
    }

    public void test_g_v1_outXknowsX_copySplitXpropertyXnameX__propertyXageXX_exhaustMerge() {
        super.test_g_v1_outXknowsX_copySplitXpropertyXnameX__propertyXageXX_exhaustMerge(new GremlinPipeline(g.getVertex(1)).out("knows").copySplit(new GremlinPipeline().property("name"), new GremlinPipeline().property("age")).exhaustMerge());
        super.test_g_v1_outXknowsX_copySplitXpropertyXnameX__propertyXageXX_exhaustMerge(new GremlinPipeline(g.getVertex(1)).optimize(false).out("knows").copySplit(new GremlinPipeline().optimize(false).property("name"), new GremlinPipeline().property("age")).exhaustMerge());
    }

    public void test_g_v1_outXknowsX_copySplitXpropertyXnameX__propertyXageXX_exhaustMerge_path() {
        super.test_g_v1_outXknowsX_copySplitXpropertyXnameX__propertyXageXX_exhaustMerge_path(new GremlinPipeline(g.getVertex(1)).out("knows").copySplit(new GremlinPipeline().property("name"), new GremlinPipeline().property("age")).exhaustMerge().path());
        super.test_g_v1_outXknowsX_copySplitXpropertyXnameX__propertyXageXX_exhaustMerge_path(new GremlinPipeline(g.getVertex(1)).optimize(false).out("knows").copySplit(new GremlinPipeline().property("name"), new GremlinPipeline().property("age")).exhaustMerge().path());

    }
}
