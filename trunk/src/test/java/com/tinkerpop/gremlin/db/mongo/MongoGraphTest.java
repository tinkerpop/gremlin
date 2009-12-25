package com.tinkerpop.gremlin.db.mongo;

import com.tinkerpop.gremlin.model.*;
import junit.framework.TestCase;

import java.lang.reflect.Method;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class MongoGraphTest extends TestCase {

    /*private static final SuiteConfiguration config = new SuiteConfiguration();

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

    public void testEdgeSuite() throws Exception {
        doSuiteTest(new EdgeTestSuite(config));
    }

    public void testGraphSuite() throws Exception {
        doSuiteTest(new GraphTestSuite(config));
    }*/

    /*public void testIndexSuite() throws Exception {
        doSuiteTest(new IndexTestSuite(config));
    }

    public void testGraphMLReaderSuite() throws Exception {
        doSuiteTest(new GraphMLReaderTestSuite(config));
    }*/


    /*private static void doSuiteTest(ModelTestSuite suite) throws Exception {
        for (Method method : suite.getClass().getDeclaredMethods()) {
            if (method.getName().startsWith("test")) {

                System.out.println("Testing " + method.getName() + "...");
                MongoGraph graph = new MongoGraph("127.0.0.1", 27017, "mongo_test");
                graph.dropCollections();
                method.invoke(suite, graph);
            }
        }
    }

    public void testPlay() throws Exception {
        MongoGraph graph = new MongoGraph("127.0.0.1", 27017, "mongo_test");
        graph.dropCollections();
        Vertex a = graph.addVertex("1");
        Vertex b = graph.addVertex("2");
        Edge e = graph.addEdge("3",a,b,"knows");
        a.setProperty("name", "marko");
        a.setProperty("test", "test1");
        System.out.println(graph.getVertex("1").getPropertyKeys());

    }*/

    public void testTrue() {
        assertTrue(true);
    }
}
