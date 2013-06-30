package com.tinkerpop.gremlin.java.sideeffect;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;
import com.tinkerpop.pipes.PipeFunction;
import com.tinkerpop.pipes.util.structures.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GroupCountStepTest extends com.tinkerpop.gremlin.test.sideeffect.GroupCountStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_V_outXcreatedX_groupCountXm__nameX() {
        Map<String, Number> m = new HashMap<String, Number>();
        super.test_g_V_outXcreatedX_groupCountXm__nameX(new GremlinPipeline(g.getVertices()).out("created").groupCount(m, new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }), m);

        m = new HashMap<String, Number>();
        super.test_g_V_outXcreatedX_groupCountXm__nameX(new GremlinPipeline(g).optimize(false).V().out("created").groupCount(m, new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }), m);
    }

    public void test_g_V_outXcreatedX_groupCountXm__name__plus_2X() {
        Map<String, Number> m = new HashMap<String, Number>();
        super.test_g_V_outXcreatedX_groupCountXm__name__plus_2X(new GremlinPipeline(g).V().out("created").groupCount(m,
                new PipeFunction<Vertex, String>() {
                    public String compute(Vertex vertex) {
                        return (String) vertex.getProperty("name");
                    }
                },
                new PipeFunction<Pair<?, Number>, Number>() {
                    public Number compute(Pair<?, Number> arg) {
                        return arg.getB().longValue() + 2l;
                    }
                }
        ), m);

        m = new HashMap<String, Number>();
        super.test_g_V_outXcreatedX_groupCountXm__name__plus_2X(new GremlinPipeline(g.getVertices()).optimize(false).out("created").groupCount(m,
                new PipeFunction<Vertex, String>() {
                    public String compute(Vertex vertex) {
                        return (String) vertex.getProperty("name");
                    }
                },
                new PipeFunction<Pair<?, Number>, Number>() {
                    public Number compute(Pair<?, Number> arg) {
                        return arg.getB().longValue() + 2l;
                    }
                }
        ), m);
    }

    public void test_g_V_outXcreatedX_groupCountXnameX_cap() {
        super.test_g_V_outXcreatedX_groupCountXnameX_cap(new GremlinPipeline(g.getVertices()).out("created").groupCount(new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }).cap());

        super.test_g_V_outXcreatedX_groupCountXnameX_cap(new GremlinPipeline(g).optimize(false).V().out("created").groupCount(new PipeFunction<Vertex, String>() {
            public String compute(Vertex vertex) {
                return (String) vertex.getProperty("name");
            }
        }).cap());
    }
}


