package com.tinkerpop.gremlin.java.sideeffect;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;
import com.tinkerpop.pipes.PipeFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SideEffectStepTest extends com.tinkerpop.gremlin.test.sideeffect.SideEffectStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_sideEffectXstore_aX_propertyXnameX() {
        final List<Vertex> a = new ArrayList<Vertex>();
        super.test_g_v1_sideEffectXstore_aX_propertyXnameX(new GremlinPipeline(g.getVertex(1)).sideEffect(new PipeFunction<Vertex, Object>() {
            public Object compute(Vertex vertex) {
                a.clear();
                a.add(vertex);
                return null;
            }
        }).property("name"));
        assertEquals(a.get(0), g.getVertex(1));
    }

    public void test_g_v1_out_sideEffectXincr_cX_propertyXnameX() {
        final List<Integer> c = new ArrayList<Integer>();
        c.add(0);
        super.test_g_v1_out_sideEffectXincr_cX_propertyXnameX(new GremlinPipeline(g.getVertex(1)).out().sideEffect(new PipeFunction<Vertex, Object>() {
            public Object compute(Vertex vertex) {
                Integer temp = c.get(0);
                c.clear();
                c.add(temp + 1);
                return null;
            }
        }).property("name"));
        assertEquals(c.get(0), new Integer(3));
    }

    public void test_g_v1_out_sideEffectXfalseX_propertyXnameX() {
        super.test_g_v1_out_sideEffectXfalseX_propertyXnameX(new GremlinPipeline(g.getVertex(1)).out().sideEffect(new PipeFunction<Vertex, Object>() {
            public Object compute(Vertex vertex) {
                return false;
            }
        }).property("name"));

        super.test_g_v1_out_sideEffectXfalseX_propertyXnameX(new GremlinPipeline(g.getVertex(1)).optimize(false).out().sideEffect(new PipeFunction<Vertex, Object>() {
            public Object compute(Vertex vertex) {
                return false;
            }
        }).property("name"));
    }

}
