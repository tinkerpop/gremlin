package com.tinkerpop.gremlin.groovy.transform

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest
import com.tinkerpop.gremlin.java.GremlinPipeline
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.pipes.util.structures.Pair
import com.tinkerpop.pipes.PipeFunction

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class TransformStepTest extends com.tinkerpop.gremlin.test.transform.TransformStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_transformXnameX() {
        super.test_g_v1_transformXnameX(g.v(1).transform {it.name});
    }

    public void test_g_v1_outE_label_transformXlengthX() {
        super.test_g_v1_outE_label_transformXlengthX(g.v(1).outE.label.transform {it.length()});
    }

    public void test_g_v1_out_transformXnameX_transformXlengthX() {
        super.test_g_v1_out_transformXnameX_transformXlengthX(g.v(1).out.transform {it.name}.transform {it.length()});
    }
}