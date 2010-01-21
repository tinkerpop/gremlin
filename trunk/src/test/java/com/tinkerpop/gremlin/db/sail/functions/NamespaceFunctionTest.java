package com.tinkerpop.gremlin.db.sail.functions;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.Tokens;
import com.tinkerpop.gremlin.db.sail.SailGraph;
import com.tinkerpop.gremlin.model.Graph;
import junit.framework.TestCase;
import org.openrdf.sail.memory.MemoryStore;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class NamespaceFunctionTest extends TestCase {

    public void testNamespaceFunction() {
        Graph graph = new SailGraph(new MemoryStore());
        XPathEvaluator xe = new XPathEvaluator();
        xe.setVariable("$g", graph);
        assertEquals(xe.evaluateList("sail:ns($g, 'rdf:type')").get(0), "http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
        assertEquals(xe.evaluateList("sail:ns($g, 'rdf:label')").get(0), "http://www.w3.org/1999/02/22-rdf-syntax-ns#label");
        assertEquals(xe.evaluateList("sail:ns($g, 'dag:type')").get(0), "dag:type");
        assertEquals(xe.evaluateList("sail:ns($g, 'rdfs:subClassOf')").get(0), "http://www.w3.org/2000/01/rdf-schema#subClassOf");
        assertEquals(xe.evaluateList("sail:ns($g, 'rdfs:subPropertyOf')").get(0), "http://www.w3.org/2000/01/rdf-schema#subPropertyOf");
        assertEquals(xe.evaluateList("sail:ns($g, 'rdfs:Resource')").get(0), "http://www.w3.org/2000/01/rdf-schema#Resource");
        assertEquals(xe.evaluateList("sail:ns($g, 'owl:Thing')").get(0), "http://www.w3.org/2002/07/owl#Thing");
        assertEquals(xe.evaluateList("sail:ns($g, 'owl:inverseOf')").get(0), "http://www.w3.org/2002/07/owl#inverseOf");
        assertEquals(xe.evaluateList("sail:ns($g, 'owl2:Thing')").get(0), "owl2:Thing");
        graph.shutdown();
    }

    public void testNamespaceFunctionGraphVariable() {
        Graph graph = new SailGraph(new MemoryStore());
        XPathEvaluator xe = new XPathEvaluator();
        xe.setVariable(Tokens.GRAPH_VARIABLE, graph);
        assertEquals(xe.evaluateList("sail:ns('rdf:type')").get(0), "http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
        assertEquals(xe.evaluateList("sail:ns('rdf:label')").get(0), "http://www.w3.org/1999/02/22-rdf-syntax-ns#label");
        assertEquals(xe.evaluateList("sail:ns('dag:type')").get(0), "dag:type");
        assertEquals(xe.evaluateList("sail:ns('rdfs:subClassOf')").get(0), "http://www.w3.org/2000/01/rdf-schema#subClassOf");
        assertEquals(xe.evaluateList("sail:ns('rdfs:subPropertyOf')").get(0), "http://www.w3.org/2000/01/rdf-schema#subPropertyOf");
        assertEquals(xe.evaluateList("sail:ns('rdfs:Resource')").get(0), "http://www.w3.org/2000/01/rdf-schema#Resource");
        assertEquals(xe.evaluateList("sail:ns('owl:Thing')").get(0), "http://www.w3.org/2002/07/owl#Thing");
        assertEquals(xe.evaluateList("sail:ns('owl:inverseOf')").get(0), "http://www.w3.org/2002/07/owl#inverseOf");
        assertEquals(xe.evaluateList("sail:ns('owl2:Thing')").get(0), "owl2:Thing");
        graph.shutdown();
    }

}
