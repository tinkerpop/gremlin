package com.tinkerpop.gremlin;


import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import java.lang.reflect.Method

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class TraversalStepGroovyTest extends TraversalStepTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        Set<String> methodNames = new HashSet<String>();
        for (Method method: this.getClass().getMethods()) {
            if (method.getDeclaringClass().equals(this.getClass()) && method.getName().startsWith("test")) {
                methodNames.add(method.getName());
            }
        }
        for (Method method: this.getClass().getMethods()) {
            if (method.getName().startsWith("test")) {
                assertTrue(methodNames.contains(method.getName()));
            }
        }
    }

    public void test_g_V() {
        super.test_g_V(g.V);
    }

    public void test_g_v1_out() {
        super.test_g_v1_out(g.v(1).out);
    }

    public void test_g_v2_in() {
        super.test_g_v2_in(g.v(2).in);
    }


}
