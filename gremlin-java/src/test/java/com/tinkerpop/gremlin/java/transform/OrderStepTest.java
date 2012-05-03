package com.tinkerpop.gremlin.java.transform;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;
import com.tinkerpop.pipes.PipeFunction;
import com.tinkerpop.pipes.util.structures.Pair;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OrderStepTest extends com.tinkerpop.gremlin.test.transform.OrderStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_V_name_order() {
        super.test_g_V_name_order(new GremlinPipeline(g).V().property("name").order());
    }

    public void test_g_V_name_orderXabX() {
        super.test_g_V_name_orderXabX(new GremlinPipeline(g).V().property("name").order(new PipeFunction<Pair<String, String>, Integer>() {
            public Integer compute(Pair<String, String> argument) {
                return argument.getB().compareTo(argument.getA());
            }
        }));
    }
}
