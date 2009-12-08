package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.model.EdgeTestSuite;
import com.tinkerpop.gremlin.model.IndexTestSuite;
import com.tinkerpop.gremlin.model.ModelTestSuite;
import com.tinkerpop.gremlin.model.VertexTestSuite;
import com.tinkerpop.gremlin.model.parser.GraphMLReaderTestSuite;

import java.lang.reflect.Method;

import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerGraphTest extends TestCase {

    public void testVertexSuite() throws Exception {
        doSuiteTest(new VertexTestSuite());
    }

    public void testIndexSuite() throws Exception {
        doSuiteTest(new IndexTestSuite());
    }


    public void testEdgeSuite() throws Exception {
        doSuiteTest(new EdgeTestSuite());
    }

    public void testGraphMLReaderSuite() throws Exception {
        doSuiteTest(new GraphMLReaderTestSuite());
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
