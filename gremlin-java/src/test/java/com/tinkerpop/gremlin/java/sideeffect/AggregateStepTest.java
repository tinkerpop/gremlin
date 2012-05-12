package com.tinkerpop.gremlin.java.sideeffect;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;
import com.tinkerpop.pipes.PipeFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AggregateStepTest extends com.tinkerpop.gremlin.test.sideeffect.AggregateStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_aggregateXxX_outXcreatedX_inXcreatedX_exceptXxX() {
        List<Vertex> x = new ArrayList<Vertex>();
        super.test_g_v1_aggregateXxX_outXcreatedX_inXcreatedX_exceptXxX(new GremlinPipeline(g.getVertex(1)).aggregate(x).out("created").in("created").except(x));
    }

    public void test_g_V_propertyXnameX_aggregate_cap() {
        super.test_g_V_propertyXnameX_aggregate_cap(new GremlinPipeline(g.getVertices()).property("name").aggregate().cap());
    }

    public void test_g_V_aggregateXnameX_cap() {
        super.test_g_V_aggregateXnameX_cap(new GremlinPipeline(g.getVertices()).aggregate(new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }).cap());
    }
}