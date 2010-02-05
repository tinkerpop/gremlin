package com.tinkerpop.gremlin.models.ggm.impls.tg;

import com.tinkerpop.gremlin.models.ggm.*;
import com.tinkerpop.gremlin.models.ggm.parser.GraphMLReaderTestSuite;
import junit.framework.TestCase;

import java.lang.reflect.Method;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TinkerGraphTest extends TestCase {

    private static final SuiteConfiguration config = new SuiteConfiguration();

    static {
        config.allowsDuplicateEdges = true;
        config.allowsSelfLoops = true;
        config.requiresRDFIds = false;
        config.isRDFModel = false;
        config.supportsVertexIteration = true;
        config.supportsEdgeIteration = true;
        config.supportsVertexIndex = true;
        config.supportsEdgeIndex = false;
        config.ignoresSuppliedIds = false;
    }

    public void testVertexSuite() throws Exception {
        doSuiteTest(new VertexTestSuite(config));
    }

    public void testEdgeSuite() throws Exception {
        doSuiteTest(new EdgeTestSuite(config));
    }

    public void testGraphSuite() throws Exception {
        doSuiteTest(new GraphTestSuite(config));
    }

    public void testIndexSuite() throws Exception {
        doSuiteTest(new IndexTestSuite(config));
    }

    public void testGraphMLReaderSuite() throws Exception {
        doSuiteTest(new GraphMLReaderTestSuite(config));
    }


    private void doSuiteTest(ModelTestSuite suite) throws Exception {
        String doTest = System.getProperty("testTinkerGraph");
        if (doTest == null || doTest.equals("true")) {
            for (Method method : suite.getClass().getDeclaredMethods()) {
                if (method.getName().startsWith("test")) {
                    System.out.println("Testing " + method.getName() + "...");
                    method.invoke(suite, new TinkerGraph());
                }
            }
        }
    }
}
