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
public class AggregateStepTest extends com.tinkerpop.gremlin.test.sideeffect.AggregateStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_aggregateXxX_outXcreatedX_inXcreatedX_exceptXxX() {
        List<Vertex> x = new ArrayList<Vertex>();
        super.test_g_v1_aggregateXxX_outXcreatedX_inXcreatedX_exceptXxX(new GremlinPipeline(g.getVertex(1)).aggregate(x).out("created").in("created").except(x));

        x = new ArrayList<Vertex>();
        super.test_g_v1_aggregateXxX_outXcreatedX_inXcreatedX_exceptXxX(new GremlinPipeline(g.getVertex(1)).optimize(false).aggregate(x).out("created").in("created").except(x));
    }

    public void test_g_V_propertyXnameX_aggregate_cap() {
        super.test_g_V_propertyXnameX_aggregate_cap(new GremlinPipeline(g.getVertices()).property("name").aggregate().cap());
        super.test_g_V_propertyXnameX_aggregate_cap(new GremlinPipeline(g).optimize(false).V().property("name").aggregate().cap());
    }

    public void test_g_V_aggregateXnameX_cap() {
        super.test_g_V_aggregateXnameX_cap(new GremlinPipeline(g).V().aggregate(new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }).cap());

        super.test_g_V_aggregateXnameX_cap(new GremlinPipeline(g.getVertices()).optimize(false).aggregate(new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }).cap());
    }
}