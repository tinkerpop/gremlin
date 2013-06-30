package com.tinkerpop.gremlin.java.sideeffect;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;
import com.tinkerpop.pipes.PipeFunction;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class StoreStepTest extends com.tinkerpop.gremlin.test.sideeffect.StoreStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_V_propertyXnameX_store_cap() {
        super.test_g_V_propertyXnameX_store_cap(new GremlinPipeline(g).V().property("name").store().cap());
        super.test_g_V_propertyXnameX_store_cap(new GremlinPipeline(g).optimize(false).V().property("name").store().cap());
    }

    public void test_g_V_storeXnameX_cap() {
        super.test_g_V_storeXnameX_cap(new GremlinPipeline(g.getVertices()).store(new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }).cap());

        super.test_g_V_storeXnameX_cap(new GremlinPipeline(g).optimize(false).V().store(new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }).cap());
    }
}