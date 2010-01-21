package com.tinkerpop.gremlin.db.sail;

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
 */
public class SailGraphTest extends BaseTest {

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
        assertEquals(SailVertex.castLiteral(new LiteralImpl("marko", new URIImpl("http://www.w3.org/2001/XMLSchema#string"))).getClass(), String.class);
        assertEquals(SailVertex.castLiteral(new LiteralImpl("marko")).getClass(), String.class);
        assertEquals(SailVertex.castLiteral(new LiteralImpl("27", new URIImpl("http://www.w3.org/2001/XMLSchema#int"))).getClass(), Integer.class);
        assertEquals(SailVertex.castLiteral(new LiteralImpl("27", new URIImpl("http://www.w3.org/2001/XMLSchema#float"))).getClass(), Float.class);
        assertEquals(SailVertex.castLiteral(new LiteralImpl("27.0134", new URIImpl("http://www.w3.org/2001/XMLSchema#double"))).getClass(), Double.class);
        assertEquals(SailVertex.castLiteral(new LiteralImpl("hello", "en")), "hello");
    }

    public void testNamespaceConversion() throws Exception {
        MemoryStore sail = new MemoryStore();
        SailGraph graph = new SailGraph(sail);
        graph.addNamespace("tg", "http://tinkerpop.com#");
        graph.addNamespace("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        assertEquals(SailGraph.prefixToNamespace("tg:name", graph.getSailConnection()), "http://tinkerpop.com#name");
        assertEquals(SailGraph.prefixToNamespace("rdf:label", graph.getSailConnection()), "http://www.w3.org/1999/02/22-rdf-syntax-ns#label");
        assertEquals(SailGraph.namespaceToPrefix("http://www.w3.org/1999/02/22-rdf-syntax-ns#label", graph.getSailConnection()), "rdf:label");
        assertEquals(SailGraph.namespaceToPrefix("http://tinkerpop.com#name", graph.getSailConnection()), "tg:name");
        graph.shutdown();

    }

    public void testBNodes() {
        assertTrue(SailGraph.isBNode("_:1234"));
        assertTrue(SailGraph.isBNode("_:abcdefghijklmnopqrstuvwxyz"));
        assertFalse(SailGraph.isBNode("_:"));
    }

    public void testLiterals() {
        assertTrue(SailGraph.isLiteral("\"java\"^^<http://www.w3.org/2001/XMLSchema#string>"));
        assertFalse(SailGraph.isLiteral("http://www.w3.org/2001/XMLSchema#string"));
        assertFalse(SailGraph.isLiteral("^^<http://www.w3.org/2001/XMLSchema#string>"));
        assertTrue(SailGraph.isLiteral("\"\"^^<http://www.w3.org/2001/XMLSchema#string>"));
        assertTrue(SailGraph.isLiteral("\"\""));
        assertTrue(SailGraph.isLiteral("\"marko\""));
        assertFalse(SailGraph.isLiteral("\"marko\"marko"));
        assertFalse(SailGraph.isLiteral("\""));
        // TODO: make this true assertFalse(SesameGraph.isLiteral("\"marko\"marko\""));


        Matcher matcher = SailGraph.literalPattern.matcher("\"java\"^^<http://www.w3.org/2001/XMLSchema#string>");
        matcher.matches();
        assertNull(matcher.group(6));
        assertEquals(matcher.group(1), "java");
        assertEquals(matcher.group(4), "http://www.w3.org/2001/XMLSchema#string");

        matcher = SailGraph.literalPattern.matcher("\"java\"@en");
        matcher.matches();
        assertNull(matcher.group(4));
        assertEquals(matcher.group(1), "java");
        assertEquals(matcher.group(6), "en");
    }

    public void testURIs() {
        assertFalse(SailGraph.isURI("_:1234"));
        assertFalse(SailGraph.isURI("_:abcdefghijklmnopqrstuvwxyz"));
        assertTrue(SailGraph.isURI("http://marko"));
        assertTrue(SailGraph.isURI("http://www.w3.org/2001/XMLSchema#string"));
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
        String doTest = System.getProperty("testSesame");
        if (doTest == null || doTest.equals("true")) {
            for (Method method : suite.getClass().getDeclaredMethods()) {
                if (method.getName().startsWith("test")) {
                    System.out.println("Testing " + method.getName() + "...");
                    SailGraph graph = new SailGraph(new MemoryStore());
                    method.invoke(suite, graph);
                    graph.shutdown();
                }
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
