package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.model.*;
import com.tinkerpop.gremlin.model.parser.GraphMLReaderTestSuite;
import junit.framework.TestCase;

import java.lang.reflect.Method;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerGraphTest extends TestCase {

    private static final SuiteConfiguration config = new SuiteConfiguration();

    static {
        config.allowsDuplicateEdges = true;
        config.allowsSelfLoops = true;
        config.requiresRDFIds = false;
        config.isRDFModel = false;
        config.supportsEdgeIteration = true;
        config.supportsVertexIteration = true;
        config.supportsVertexIndex = true;
    }

    public void testVertexSuite() throws Exception {
        doSuiteTest(new VertexTestSuite(config));
    }

    public void testIndexSuite() throws Exception {
        doSuiteTest(new IndexTestSuite(config));
    }


    public void testEdgeSuite() throws Exception {
        doSuiteTest(new EdgeTestSuite(config));
    }

    public void testGraphMLReaderSuite() throws Exception {
        doSuiteTest(new GraphMLReaderTestSuite(config));
    }


    private static void doSuiteTest(ModelTestSuite suite) throws Exception {
        for (Method method : suite.getClass().getDeclaredMethods()) {
            if (method.getName().startsWith("test")) {
                System.out.println("Testing " + method.getName() + "...");
                method.invoke(suite, new TinkerGraph());
            }
        }
    }
}
