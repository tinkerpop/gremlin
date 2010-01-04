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
        String doTest = System.getProperty("testMongoDB");
        if (doTest == null || doTest.equals("true")) {

            String mongoIP = System.getProperty("mongoIP");
            String mongoPort = System.getProperty("mongoPort");
            String mongoDatabase = System.getProperty("mongoDatabase");

            if(null == mongoIP)
                mongoIP = "127.0.0.1";
            if(null == mongoPort)
                mongoPort = "27017";
            if(null == mongoDatabase)
                mongoDatabase = "gremlin_test";

            for (Method method : suite.getClass().getDeclaredMethods()) {
                if (method.getName().startsWith("test")) {
                    System.out.println("Testing " + method.getName() + "...");
                    MongoGraph graph = new MongoGraph(mongoIP, Integer.valueOf(mongoPort), mongoDatabase);
                    graph.clear();
                    method.invoke(suite, graph);
                    graph.clear();
                }
            }
        }
    }
}
