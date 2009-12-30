package com.tinkerpop.gremlin.db.sesame;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.model.*;
import info.aduna.iteration.CloseableIteration;
import org.openrdf.model.Statement;
import org.openrdf.model.impl.LiteralImpl;
import org.openrdf.model.impl.URIImpl;
import org.openrdf.sail.SailException;
import org.openrdf.sail.memory.MemoryStore;

import java.lang.reflect.Method;
import java.util.regex.Matcher;


/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SesameGraphTest extends BaseTest {

    public static final String TP_NS = "http://tinkerpop.com#";
    private static final SuiteConfiguration config = new SuiteConfiguration();

    static {
        config.allowsDuplicateEdges = false;
        config.allowsSelfLoops = true;
        config.requiresRDFIds = true;
        config.isRDFModel = true;
        config.supportsVertexIteration = false;
        config.supportsEdgeIteration = true;
        config.supportsVertexIndex = false;
        config.supportsEdgeIndex = false;
    }

    public void testTypeConversion() {
        assertEquals(SesameVertex.castLiteral(new LiteralImpl("marko", new URIImpl("http://www.w3.org/2001/XMLSchema#string"))).getClass(), String.class);
        assertEquals(SesameVertex.castLiteral(new LiteralImpl("marko")).getClass(), String.class);
        assertEquals(SesameVertex.castLiteral(new LiteralImpl("27", new URIImpl("http://www.w3.org/2001/XMLSchema#int"))).getClass(), Integer.class);
        assertEquals(SesameVertex.castLiteral(new LiteralImpl("27", new URIImpl("http://www.w3.org/2001/XMLSchema#float"))).getClass(), Float.class);
        assertEquals(SesameVertex.castLiteral(new LiteralImpl("27.0134", new URIImpl("http://www.w3.org/2001/XMLSchema#double"))).getClass(), Double.class);
        assertEquals(SesameVertex.castLiteral(new LiteralImpl("hello", "en")), "hello");
    }

    public void testNamespaceConversion() throws Exception {
        MemoryStore sail = new MemoryStore();
        SesameGraph graph = new SesameGraph(sail);
        graph.addNamespace("tg", "http://tinkerpop.com#");
        graph.addNamespace("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        assertEquals(SesameGraph.prefixToNamespace("tg:name", graph.getSailConnection()), "http://tinkerpop.com#name");
        assertEquals(SesameGraph.prefixToNamespace("rdf:label", graph.getSailConnection()), "http://www.w3.org/1999/02/22-rdf-syntax-ns#label");
        assertEquals(SesameGraph.namespaceToPrefix("http://www.w3.org/1999/02/22-rdf-syntax-ns#label", graph.getSailConnection()), "rdf:label");
        assertEquals(SesameGraph.namespaceToPrefix("http://tinkerpop.com#name", graph.getSailConnection()), "tg:name");
        graph.shutdown();

    }

    public void testBNodes() {
        assertTrue(SesameGraph.isBNode("_:1234"));
        assertTrue(SesameGraph.isBNode("_:abcdefghijklmnopqrstuvwxyz"));
        assertFalse(SesameGraph.isBNode("_:"));
    }

    public void testLiterals() {
        assertTrue(SesameGraph.isLiteral("\"java\"^^<http://www.w3.org/2001/XMLSchema#string>"));
        assertFalse(SesameGraph.isLiteral("http://www.w3.org/2001/XMLSchema#string"));
        assertFalse(SesameGraph.isLiteral("^^<http://www.w3.org/2001/XMLSchema#string>"));
        assertTrue(SesameGraph.isLiteral("\"\"^^<http://www.w3.org/2001/XMLSchema#string>"));
        assertTrue(SesameGraph.isLiteral("\"\""));
        assertTrue(SesameGraph.isLiteral("\"marko\""));
        assertFalse(SesameGraph.isLiteral("\"marko\"marko"));
        assertFalse(SesameGraph.isLiteral("\""));
        // TODO: make this true assertFalse(SesameGraph.isLiteral("\"marko\"marko\""));


        Matcher matcher = SesameGraph.literalPattern.matcher("\"java\"^^<http://www.w3.org/2001/XMLSchema#string>");
        matcher.matches();
        assertNull(matcher.group(6));
        assertEquals(matcher.group(1), "java");
        assertEquals(matcher.group(4), "http://www.w3.org/2001/XMLSchema#string");

        matcher = SesameGraph.literalPattern.matcher("\"java\"@en");
        matcher.matches();
        assertNull(matcher.group(4));
        assertEquals(matcher.group(1), "java");
        assertEquals(matcher.group(6), "en");
    }

    public void testURIs() {
        assertFalse(SesameGraph.isURI("_:1234"));
        assertFalse(SesameGraph.isURI("_:abcdefghijklmnopqrstuvwxyz"));
        assertTrue(SesameGraph.isURI("http://marko"));
        assertTrue(SesameGraph.isURI("http://www.w3.org/2001/XMLSchema#string"));
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

    private static void doSuiteTest(ModelTestSuite suite) throws Exception {
        for (Method method : suite.getClass().getDeclaredMethods()) {
            if (method.getName().startsWith("test")) {
                System.out.println("Testing " + method.getName() + "...");
                SesameGraph graph = new SesameGraph(new MemoryStore());
                method.invoke(suite, graph);
                graph.shutdown();
            }
        }
    }

    private static int countStatements(CloseableIteration<? extends Statement, SailException> itty, boolean print) throws SailException {
        int counter = 0;
        while (itty.hasNext()) {
            Statement s = itty.next();
            if (print)
                System.out.println(s);
            counter++;
        }
        itty.close();
        return counter;
    }

}
