package com.tinkerpop.gremlin.db.sail.functions;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.db.sail.SailGraph;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.Tokens;
import junit.framework.TestCase;
import org.openrdf.sail.memory.MemoryStore;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PrefixFunctionTest extends TestCase {

    public void testPrefixFunction() {
        Graph graph = new SailGraph(new MemoryStore());
        XPathEvaluator xe = new XPathEvaluator();
        xe.setVariable("$g", graph);
        assertEquals(xe.evaluateList("sail:prefix($g, 'http://www.w3.org/1999/02/22-rdf-syntax-ns#type')").get(0), "rdf:type");
        assertEquals(xe.evaluateList("sail:prefix($g, 'http://www.w3.org/1999/02/22-rdf-syntax-ns#label')").get(0), "rdf:label");
        assertEquals(xe.evaluateList("sail:prefix($g, 'dag:type')").get(0), "dag:type");
        assertEquals(xe.evaluateList("sail:prefix($g, 'http://www.w3.org/2000/01/rdf-schema#subClassOf')").get(0), "rdfs:subClassOf");
        assertEquals(xe.evaluateList("sail:prefix($g, 'http://www.w3.org/2000/01/rdf-schema#subPropertyOf')").get(0), "rdfs:subPropertyOf");
        assertEquals(xe.evaluateList("sail:prefix($g, 'http://www.w3.org/2000/01/rdf-schema#Resource')").get(0), "rdfs:Resource");
        assertEquals(xe.evaluateList("sail:prefix($g, 'http://www.w3.org/2002/07/owl#Thing')").get(0), "owl:Thing");
        assertEquals(xe.evaluateList("sail:prefix($g, 'http://www.w3.org/2002/07/owl#inverseOf')").get(0), "owl:inverseOf");
        assertEquals(xe.evaluateList("sail:prefix($g, 'owl2:Thing')").get(0), "owl2:Thing");
        graph.shutdown();
    }

    public void testPrefixFunctionGraphVariable() {
        Graph graph = new SailGraph(new MemoryStore());
        XPathEvaluator xe = new XPathEvaluator();
        xe.setVariable(Tokens.GRAPH_VARIABLE, graph);
        assertEquals(xe.evaluateList("sail:prefix('http://www.w3.org/1999/02/22-rdf-syntax-ns#type')").get(0), "rdf:type");
        assertEquals(xe.evaluateList("sail:prefix('http://www.w3.org/1999/02/22-rdf-syntax-ns#label')").get(0), "rdf:label");
        assertEquals(xe.evaluateList("sail:prefix('dag:type')").get(0), "dag:type");
        assertEquals(xe.evaluateList("sail:prefix('http://www.w3.org/2000/01/rdf-schema#subClassOf')").get(0), "rdfs:subClassOf");
        assertEquals(xe.evaluateList("sail:prefix('http://www.w3.org/2000/01/rdf-schema#subPropertyOf')").get(0), "rdfs:subPropertyOf");
        assertEquals(xe.evaluateList("sail:prefix('http://www.w3.org/2000/01/rdf-schema#Resource')").get(0), "rdfs:Resource");
        assertEquals(xe.evaluateList("sail:prefix('http://www.w3.org/2002/07/owl#Thing')").get(0), "owl:Thing");
        assertEquals(xe.evaluateList("sail:prefix('http://www.w3.org/2002/07/owl#inverseOf')").get(0), "owl:inverseOf");
        assertEquals(xe.evaluateList("sail:prefix('owl2:Thing')").get(0), "owl2:Thing");
        graph.shutdown();
    }

    public void testPrefixNamespaceFunction() {
        Graph graph = new SailGraph(new MemoryStore());
        XPathEvaluator xe = new XPathEvaluator();
        xe.setVariable("$g", graph);
        assertEquals(xe.evaluateList("sail:prefix($g, sail:ns($g, 'rdf:type'))").get(0), "rdf:type");
        assertEquals(xe.evaluateList("sail:prefix($g, sail:ns($g, 'rdf:label'))").get(0), "rdf:label");
        assertEquals(xe.evaluateList("sail:prefix($g, sail:ns($g, sail:prefix($g, sail:ns($g, 'rdf:label'))))").get(0), "rdf:label");
        graph.shutdown();
    }
}
