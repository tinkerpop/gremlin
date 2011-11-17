package com.tinkerpop.gremlin.java;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.test.UtilitiesTest;
import com.tinkerpop.pipes.PipeFunction;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FunctionStepTest extends com.tinkerpop.gremlin.test.FunctionStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        UtilitiesTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_stepXnext_nameX() {
        super.test_g_v1_out_stepXnext_nameX(new GremlinPipeline(g.getVertex(1)).out().step(new PipeFunction<Iterator<Vertex>, Vertex>() {
            public Vertex compute(Iterator<Vertex> iterator) {
                return iterator.next();
            }
        }).property("name"));
    }
}