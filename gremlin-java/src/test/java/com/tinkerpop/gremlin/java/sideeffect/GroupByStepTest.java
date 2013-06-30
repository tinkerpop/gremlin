package com.tinkerpop.gremlin.java.sideeffect;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.gremlin.test.ComplianceTest;
import com.tinkerpop.pipes.PipeFunction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GroupByStepTest extends com.tinkerpop.gremlin.test.sideeffect.GroupByStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_V_groupByXlang_nameX() {
        Map<?, List<?>> m = new HashMap<Object, List<?>>();
        super.test_g_V_groupByXlang_nameX(new GremlinPipeline(g.getVertices()).groupBy(m, new PipeFunction<Vertex, String>() {
                    public String compute(Vertex vertex) {
                        return (String) vertex.getProperty("lang");
                    }
                }, new PipeFunction<Vertex, String>() {
                    public String compute(Vertex vertex) {
                        return (String) vertex.getProperty("name");
                    }
                }
        ), (Map) m);

        m = new HashMap<Object, List<?>>();
        super.test_g_V_groupByXlang_nameX(new GremlinPipeline(g.getVertices()).optimize(false).groupBy(m, new PipeFunction<Vertex, String>() {
                    public String compute(Vertex vertex) {
                        return (String) vertex.getProperty("lang");
                    }
                }, new PipeFunction<Vertex, String>() {
                    public String compute(Vertex vertex) {
                        return (String) vertex.getProperty("name");
                    }
                }
        ), (Map) m);
    }

}