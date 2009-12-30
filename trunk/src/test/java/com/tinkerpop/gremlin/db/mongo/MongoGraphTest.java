package com.tinkerpop.gremlin.db.mongo;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.model.*;
import com.tinkerpop.gremlin.model.parser.GraphMLReaderTestSuite;

import java.lang.reflect.Method;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class MongoGraphTest extends BaseTest {

    private static final SuiteConfiguration config = new SuiteConfiguration();

    static {
        config.allowsDuplicateEdges = true;
        config.allowsSelfLoops = true;
        config.requiresRDFIds = false;
        config.isRDFModel = false;
        config.supportsVertexIteration = true;
        config.supportsEdgeIteration = true;
        config.supportsVertexIndex = true;
        config.supportsEdgeIteration = true;
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

    private static void doSuiteTest(ModelTestSuite suite) throws Exception {
        for (Method method : suite.getClass().getDeclaredMethods()) {
            if (method.getName().startsWith("test")) {
                System.out.println("Testing " + method.getName() + "...");
                MongoGraph graph = new MongoGraph("127.0.0.1", 27017, "mongo_test");
                graph.clear();
                method.invoke(suite, graph);
                graph.clear();
            }
        }
    }
}
