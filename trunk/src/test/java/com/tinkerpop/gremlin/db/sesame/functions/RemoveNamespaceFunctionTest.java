package com.tinkerpop.gremlin.db.sesame.functions;

import junit.framework.TestCase;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.db.sesame.SesameGraph;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.Tokens;
import org.openrdf.sail.memory.MemoryStore;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class RemoveNamespaceFunctionTest extends TestCase {

    public void testRemoveNamespaceFunction() {
        Graph graph = new SesameGraph(new MemoryStore());
        XPathEvaluator xe = new XPathEvaluator();
        xe.setVariable("$g", graph);
        assertEquals(xe.evaluateList("sail:ns($g, 'rdf:type')").get(0), "http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
        assertTrue((Boolean)xe.evaluateList("sail:remove-ns($g, 'rdf')").get(0));
        assertEquals(xe.evaluateList("sail:ns($g, 'rdf:type')").get(0), "rdf:type");
        assertEquals(xe.evaluateList("sail:ns($g, 'dag:type')").get(0), "dag:type");
        assertEquals(xe.evaluateList("sail:ns($g, 'rdfs:subClassOf')").get(0), "http://www.w3.org/2000/01/rdf-schema#subClassOf");
        assertTrue((Boolean)xe.evaluateList("sail:remove-ns($g, 'rdfs')").get(0));
        assertEquals(xe.evaluateList("sail:ns($g, 'rdfs:subClassOf')").get(0), "rdfs:subClassOf");
        assertEquals(xe.evaluateList("sail:ns($g, 'rdfs:subPropertyOf')").get(0), "rdfs:subPropertyOf");
        assertEquals(xe.evaluateList("sail:ns($g, 'rdfs:Resource')").get(0), "rdfs:Resource");
        assertEquals(xe.evaluateList("sail:ns($g, 'owl:Thing')").get(0), "http://www.w3.org/2002/07/owl#Thing");
        assertTrue((Boolean)xe.evaluateList("sail:remove-ns($g, 'owl')").get(0));
        assertEquals(xe.evaluateList("sail:ns($g, 'owl:Thing')").get(0), "owl:Thing");
        assertEquals(xe.evaluateList("sail:ns($g, 'owl:inverseOf')").get(0), "owl:inverseOf");
        assertEquals(xe.evaluateList("sail:ns($g, 'owl2:Thing')").get(0), "owl2:Thing");
        assertTrue((Boolean)xe.evaluateList("sail:remove-ns($g, 'owl2')").get(0));
        assertEquals(xe.evaluateList("sail:ns($g, 'owl2:Thing')").get(0), "owl2:Thing");
        graph.shutdown();
    }

    public void testRemoveNamespaceFunctionGraphVariable() {
        Graph graph = new SesameGraph(new MemoryStore());
        XPathEvaluator xe = new XPathEvaluator();
        xe.setVariable(Tokens.GRAPH_VARIABLE, graph);
        assertEquals(xe.evaluateList("sail:ns('rdf:type')").get(0), "http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
        assertTrue((Boolean)xe.evaluateList("sail:remove-ns('rdf')").get(0));
        assertEquals(xe.evaluateList("sail:ns('rdf:type')").get(0), "rdf:type");
        assertEquals(xe.evaluateList("sail:ns('dag:type')").get(0), "dag:type");
        assertEquals(xe.evaluateList("sail:ns('rdfs:subClassOf')").get(0), "http://www.w3.org/2000/01/rdf-schema#subClassOf");
        assertTrue((Boolean)xe.evaluateList("sail:remove-ns('rdfs')").get(0));
        assertEquals(xe.evaluateList("sail:ns('rdfs:subClassOf')").get(0), "rdfs:subClassOf");
        assertEquals(xe.evaluateList("sail:ns('rdfs:subPropertyOf')").get(0), "rdfs:subPropertyOf");
        assertEquals(xe.evaluateList("sail:ns('rdfs:Resource')").get(0), "rdfs:Resource");
        assertEquals(xe.evaluateList("sail:ns('owl:Thing')").get(0), "http://www.w3.org/2002/07/owl#Thing");
        assertTrue((Boolean)xe.evaluateList("sail:remove-ns('owl')").get(0));
        assertEquals(xe.evaluateList("sail:ns('owl:Thing')").get(0), "owl:Thing");
        assertEquals(xe.evaluateList("sail:ns('owl:inverseOf')").get(0), "owl:inverseOf");
        assertEquals(xe.evaluateList("sail:ns('owl2:Thing')").get(0), "owl2:Thing");
        assertTrue((Boolean)xe.evaluateList("sail:remove-ns('owl2')").get(0));
        assertEquals(xe.evaluateList("sail:ns('owl2:Thing')").get(0), "owl2:Thing");
        graph.shutdown();
    }


}
