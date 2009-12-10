package com.tinkerpop.gremlin.db.sesame;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.model.EdgeTestSuite;
import com.tinkerpop.gremlin.model.ModelTestSuite;
import com.tinkerpop.gremlin.model.SuiteConfiguration;
import com.tinkerpop.gremlin.model.VertexTestSuite;
import info.aduna.iteration.CloseableIteration;
import org.openrdf.model.Statement;
import org.openrdf.model.impl.URIImpl;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.rio.RDFFormat;
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
        config.supportsEdgeIteration = true;
        config.supportsVertexIteration = false;
    }


    public static MemoryStore loadMemoryStore(String tripleFile, RDFFormat tripleFileFormat) throws Exception {
        MemoryStore sail = new MemoryStore();
        sail.initialize();
        Repository repo = new SailRepository(sail);
        RepositoryConnection connection = repo.getConnection();
        connection.add(SesameGraph.class.getResourceAsStream(tripleFile), new String(), tripleFileFormat, new URIImpl("http://tinkerpop.com#graph"));
        connection.commit();
        connection.close();
        return sail;
    }

    /*public void testGraphExample1() throws Exception {
        MemoryStore sail = loadMemoryStore("graph-example-1.ntriple", RDFFormat.NTRIPLES);
        SailConnection sc = sail.getConnection();
        CloseableIteration<? extends Statement, SailException> results = sc.getStatements(null, null, null, false);
        assertEquals(18, countStatements(results, true));
        SesameGraph graph = new SesameGraph(sail);
        graph.registerNamespace("tg", "http://tinkerpop.com#");
        Vertex vertex = graph.getVertex("tg:1");
        GremlinEvaluator evaluator = new GremlinEvaluator();
        evaluator.setRoot(vertex);

        assertEquals(vertex.toString(), "http://tinkerpop.com#1");
        assertEquals(5, evaluator.evaluate("./outEdges").size());
        //System.out.println(evaluator.evaluate("./outEdges"));
        //printList(evaluator.evaluate("./outEdges[@label='tg:knows']"));
        assertEquals(2, evaluator.evaluate("./outEdges[@label='tg:knows']/inVertex").size());
        assertEquals(asList(new URIImpl(TP_NS + "graph"), 5), evaluator.evaluate("./outEdges/@named_graph"));
        assertEquals(asList("marko",1), evaluator.evaluate("@tg:name"));
        assertEquals(asList("marko",1), evaluator.evaluate("./@tg:name"));
        assertTrue((Boolean) evaluator.evaluate("@tg:name='marko'").get(0));
        assertTrue((Boolean) evaluator.evaluate("@tg:age='29'").get(0));

        graph.shutdown();
    }*/

    public void testTypeConversion() {
        assertEquals(SesameGraph.castLiteral("marko", "http://www.w3.org/2001/XMLSchema#string").getClass(), String.class);
        assertEquals(SesameGraph.castLiteral("marko", "").getClass(), String.class);
        assertEquals(SesameGraph.castLiteral("27", "http://www.w3.org/2001/XMLSchema#int").getClass(), Integer.class);
        assertEquals(SesameGraph.castLiteral("27", "http://www.w3.org/2001/XMLSchema#float").getClass(), Float.class);
        assertEquals(SesameGraph.castLiteral("27.0134", "http://www.w3.org/2001/XMLSchema#double").getClass(), Double.class);
    }

    public void testNamespaceConversion() throws Exception {
        MemoryStore sail = new MemoryStore();
        SesameGraph graph = new SesameGraph(sail);
        graph.registerNamespace("tg", "http://tinkerpop.com#");
        graph.registerNamespace("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
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


    public static int countStatements(CloseableIteration<? extends Statement, SailException> itty, boolean print) throws SailException {
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
