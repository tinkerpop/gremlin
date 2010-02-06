package com.tinkerpop.gremlin.models.pgm.impls.sail.functions;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.models.pgm.Graph;
import com.tinkerpop.gremlin.models.pgm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.statements.Tokens;
import junit.framework.TestCase;
import org.openrdf.sail.memory.MemoryStore;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RemoveNamespaceFunctionTest extends TestCase {

    public void testRemoveNamespaceFunction() {
        Graph graph = new SailGraph(new MemoryStore());
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable("$g", graph);
        assertEquals(xe.evaluateList("sail:ns($g, 'rdf:type')").get(0), "http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
        assertTrue((Boolean) xe.evaluateList("sail:remove-ns($g, 'rdf')").get(0));
        assertEquals(xe.evaluateList("sail:ns($g, 'rdf:type')").get(0), "rdf:type");
        assertEquals(xe.evaluateList("sail:ns($g, 'dag:type')").get(0), "dag:type");
        assertEquals(xe.evaluateList("sail:ns($g, 'rdfs:subClassOf')").get(0), "http://www.w3.org/2000/01/rdf-schema#subClassOf");
        assertTrue((Boolean) xe.evaluateList("sail:remove-ns($g, 'rdfs')").get(0));
        assertEquals(xe.evaluateList("sail:ns($g, 'rdfs:subClassOf')").get(0), "rdfs:subClassOf");
        assertEquals(xe.evaluateList("sail:ns($g, 'rdfs:subPropertyOf')").get(0), "rdfs:subPropertyOf");
        assertEquals(xe.evaluateList("sail:ns($g, 'rdfs:Resource')").get(0), "rdfs:Resource");
        assertEquals(xe.evaluateList("sail:ns($g, 'owl:Thing')").get(0), "http://www.w3.org/2002/07/owl#Thing");
        assertTrue((Boolean) xe.evaluateList("sail:remove-ns($g, 'owl')").get(0));
        assertEquals(xe.evaluateList("sail:ns($g, 'owl:Thing')").get(0), "owl:Thing");
        assertEquals(xe.evaluateList("sail:ns($g, 'owl:inverseOf')").get(0), "owl:inverseOf");
        assertEquals(xe.evaluateList("sail:ns($g, 'owl2:Thing')").get(0), "owl2:Thing");
        assertTrue((Boolean) xe.evaluateList("sail:remove-ns($g, 'owl2')").get(0));
        assertEquals(xe.evaluateList("sail:ns($g, 'owl2:Thing')").get(0), "owl2:Thing");
        graph.shutdown();
    }

    public void testRemoveNamespaceFunctionGraphVariable() {
        Graph graph = new SailGraph(new MemoryStore());
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);
        assertEquals(xe.evaluateList("sail:ns('rdf:type')").get(0), "http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
        assertTrue((Boolean) xe.evaluateList("sail:remove-ns('rdf')").get(0));
        assertEquals(xe.evaluateList("sail:ns('rdf:type')").get(0), "rdf:type");
        assertEquals(xe.evaluateList("sail:ns('dag:type')").get(0), "dag:type");
        assertEquals(xe.evaluateList("sail:ns('rdfs:subClassOf')").get(0), "http://www.w3.org/2000/01/rdf-schema#subClassOf");
        assertTrue((Boolean) xe.evaluateList("sail:remove-ns('rdfs')").get(0));
        assertEquals(xe.evaluateList("sail:ns('rdfs:subClassOf')").get(0), "rdfs:subClassOf");
        assertEquals(xe.evaluateList("sail:ns('rdfs:subPropertyOf')").get(0), "rdfs:subPropertyOf");
        assertEquals(xe.evaluateList("sail:ns('rdfs:Resource')").get(0), "rdfs:Resource");
        assertEquals(xe.evaluateList("sail:ns('owl:Thing')").get(0), "http://www.w3.org/2002/07/owl#Thing");
        assertTrue((Boolean) xe.evaluateList("sail:remove-ns('owl')").get(0));
        assertEquals(xe.evaluateList("sail:ns('owl:Thing')").get(0), "owl:Thing");
        assertEquals(xe.evaluateList("sail:ns('owl:inverseOf')").get(0), "owl:inverseOf");
        assertEquals(xe.evaluateList("sail:ns('owl2:Thing')").get(0), "owl2:Thing");
        assertTrue((Boolean) xe.evaluateList("sail:remove-ns('owl2')").get(0));
        assertEquals(xe.evaluateList("sail:ns('owl2:Thing')").get(0), "owl2:Thing");
        graph.shutdown();
    }


}
