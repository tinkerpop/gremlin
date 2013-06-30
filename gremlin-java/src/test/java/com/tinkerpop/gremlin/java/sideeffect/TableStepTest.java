package com.tinkerpop.gremlin.java.sideeffect;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;
import com.tinkerpop.pipes.PipeFunction;
import com.tinkerpop.pipes.util.structures.Table;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TableStepTest extends com.tinkerpop.gremlin.test.sideeffect.TableStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_asXaX_out_properyXnameX_asXbX_table_cap() {
        super.test_g_v1_asXaX_out_properyXnameX_asXbX_table_cap(new GremlinPipeline(g.getVertex(1)).as("a").out().property("name").as("b").table().cap());
        super.test_g_v1_asXaX_out_properyXnameX_asXbX_table_cap(new GremlinPipeline(g.getVertex(1)).optimize(false).as("a").out().property("name").as("b").table().cap());
    }

    public void test_g_v1_asXaX_out_asXbX_tableXnameX_cap() {
        super.test_g_v1_asXaX_out_asXbX_tableXnameX_cap(new GremlinPipeline(g.getVertex(1)).as("a").out().as("b").table(new Table(), new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }).cap());

        super.test_g_v1_asXaX_out_asXbX_tableXnameX_cap(new GremlinPipeline(g.getVertex(1)).optimize(false).as("a").out().as("b").table(new Table(), new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }).cap());
    }

    public void test_g_v1_asXaX_out_propertyXnameX_asXbX_tableXname_lengthX_cap() {
        super.test_g_v1_asXaX_out_propertyXnameX_asXbX_tableXname_lengthX_cap(new GremlinPipeline(g.getVertex(1)).as("a").out().property("name").as("b").table(new Table(), new PipeFunction<Vertex, String>() {
                    public String compute(Vertex vertex) {
                        return (String) vertex.getProperty("name");
                    }
                }, new PipeFunction<String, Integer>() {
                    public Integer compute(String name) {
                        return name.length();
                    }
                }
        ).cap());

        super.test_g_v1_asXaX_out_propertyXnameX_asXbX_tableXname_lengthX_cap(new GremlinPipeline(g.getVertex(1)).optimize(false).as("a").out().property("name").as("b").table(new Table(), new PipeFunction<Vertex, String>() {
                    public String compute(Vertex vertex) {
                        return (String) vertex.getProperty("name");
                    }
                }, new PipeFunction<String, Integer>() {
                    public Integer compute(String name) {
                        return name.length();
                    }
                }
        ).cap());
    }
}
