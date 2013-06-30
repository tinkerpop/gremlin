package com.tinkerpop.gremlin.java.transform;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;
import com.tinkerpop.pipes.PipeFunction;
import com.tinkerpop.pipes.transform.TransformPipe;
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
        super.test_g_V_name_order(new GremlinPipeline(g.getVertices()).property("name").order());
        super.test_g_V_name_order(new GremlinPipeline(g).optimize(false).V().property("name").order());
    }

    public void test_g_V_name_orderXabX() {
        super.test_g_V_name_orderXabX(new GremlinPipeline(g).V().property("name").order(new PipeFunction<Pair<String, String>, Integer>() {
            public Integer compute(Pair<String, String> argument) {
                return argument.getB().compareTo(argument.getA());
            }
        }));

        super.test_g_V_name_orderXabX(new GremlinPipeline(g.getVertices()).optimize(false).property("name").order(new PipeFunction<Pair<String, String>, Integer>() {
            public Integer compute(Pair<String, String> argument) {
                return argument.getB().compareTo(argument.getA());
            }
        }));
    }

    public void test_g_V_orderXa_nameXb_nameX_name() {
        super.test_g_V_orderXa_nameXb_nameX_name(new GremlinPipeline(g.getVertices()).order(new PipeFunction<Pair<Vertex, Vertex>, Integer>() {
            public Integer compute(Pair<Vertex, Vertex> argument) {
                return ((String) argument.getB().getProperty("name")).compareTo((String) argument.getA().getProperty("name"));
            }
        }).property("name"));

        super.test_g_V_orderXa_nameXb_nameX_name(new GremlinPipeline(g.getVertices()).optimize(false).order(new PipeFunction<Pair<Vertex, Vertex>, Integer>() {
            public Integer compute(Pair<Vertex, Vertex> argument) {
                return ((String) argument.getB().getProperty("name")).compareTo((String) argument.getA().getProperty("name"));
            }
        }).property("name"));
    }

    public void test_g_V_name_orderXdecrX() {
        super.test_g_V_name_orderXdecrX(new GremlinPipeline(g.getVertices()).property("name").order(TransformPipe.Order.DECR));
        super.test_g_V_name_orderXdecrX(new GremlinPipeline(g).optimize(false).V().property("name").order(TransformPipe.Order.DECR));
    }

}
