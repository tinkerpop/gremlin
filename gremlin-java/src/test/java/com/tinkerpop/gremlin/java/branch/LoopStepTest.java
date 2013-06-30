package com.tinkerpop.gremlin.java.branch;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;
import com.tinkerpop.pipes.PipeFunction;
import com.tinkerpop.pipes.branch.LoopPipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LoopStepTest extends com.tinkerpop.gremlin.test.branch.LoopStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_loopX1_loops_lt_3X_propertyXnameX() {
        super.test_g_v1_out_loopX1_loops_lt_3X_propertyXnameX(new GremlinPipeline(g.getVertex(1)).out().loop(1, new PipeFunction<LoopPipe.LoopBundle, Boolean>() {
            public Boolean compute(LoopPipe.LoopBundle bundle) {
                return bundle.getLoops() < 3;
            }
        }).property("name"));

        super.test_g_v1_out_loopX1_loops_lt_3X_propertyXnameX(new GremlinPipeline(g.getVertex(1)).optimize(false).out().loop(1, new PipeFunction<LoopPipe.LoopBundle, Boolean>() {
            public Boolean compute(LoopPipe.LoopBundle bundle) {
                return bundle.getLoops() < 3;
            }
        }).property("name"));
    }

    public void test_g_v1_asXhereX_out_loopXhere_loops_lt_3X_propertyXnameX() {
        super.test_g_v1_asXhereX_out_loopXhere_loops_lt_3X_propertyXnameX(new GremlinPipeline(g.getVertex(1)).as("here").out().loop("here", new PipeFunction<LoopPipe.LoopBundle, Boolean>() {
            public Boolean compute(LoopPipe.LoopBundle bundle) {
                return bundle.getLoops() < 3;
            }
        }).property("name"));

        super.test_g_v1_asXhereX_out_loopXhere_loops_lt_3X_propertyXnameX(new GremlinPipeline(g.getVertex(1)).optimize(false).as("here").out().loop("here", new PipeFunction<LoopPipe.LoopBundle, Boolean>() {
            public Boolean compute(LoopPipe.LoopBundle bundle) {
                return bundle.getLoops() < 3;
            }
        }).property("name"));
    }

    public void test_g_V_out_loopX1_loops_lt_3X_propertyXnameX() {
        super.test_g_V_out_loopX1_loops_lt_3X_propertyXnameX(new GremlinPipeline(g.getVertices()).out().loop(1, new PipeFunction<LoopPipe.LoopBundle, Boolean>() {
            public Boolean compute(LoopPipe.LoopBundle bundle) {
                return bundle.getLoops() < 3;
            }
        }).property("name"));

        super.test_g_V_out_loopX1_loops_lt_3X_propertyXnameX(new GremlinPipeline(g).optimize(false).V().out().loop(1, new PipeFunction<LoopPipe.LoopBundle, Boolean>() {
            public Boolean compute(LoopPipe.LoopBundle bundle) {
                return bundle.getLoops() < 3;
            }
        }).property("name"));
    }

    public void test_g_V_asXhereX_out_loopXhere_loops_lt_3X_propertyXnameX() {
        super.test_g_V_asXhereX_out_loopXhere_loops_lt_3X_propertyXnameX(new GremlinPipeline(g).V().as("here").out().loop("here", new PipeFunction<LoopPipe.LoopBundle, Boolean>() {
            public Boolean compute(LoopPipe.LoopBundle bundle) {
                return bundle.getLoops() < 3;
            }
        }).property("name"));

        super.test_g_V_asXhereX_out_loopXhere_loops_lt_3X_propertyXnameX(new GremlinPipeline(g.getVertices()).optimize(false).as("here").out().loop("here", new PipeFunction<LoopPipe.LoopBundle, Boolean>() {
            public Boolean compute(LoopPipe.LoopBundle bundle) {
                return bundle.getLoops() < 3;
            }
        }).property("name"));
    }
}