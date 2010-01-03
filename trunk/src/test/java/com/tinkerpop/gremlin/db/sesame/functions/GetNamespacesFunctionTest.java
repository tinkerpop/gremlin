package com.tinkerpop.gremlin.db.sesame.functions;

import junit.framework.TestCase;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.db.sesame.SesameGraph;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.Tokens;
import org.openrdf.sail.memory.MemoryStore;

import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GetNamespacesFunctionTest extends TestCase {

    public void testGetNamespacesFunction() {

        Graph graph = new SesameGraph(new MemoryStore());
        XPathEvaluator xe = new XPathEvaluator();
        xe.setVariable("$g", graph);
        assertTrue(xe.evaluateList("sail:get-ns($g)").get(0) instanceof Map);
        Map map = (Map) xe.evaluateList("sail:get-ns($g)").get(0);
        assertEquals(map.size(), 5);
        assertTrue(map.keySet().contains("rdf"));
        assertTrue(map.keySet().contains("rdfs"));
        assertTrue(map.keySet().contains("owl"));
        assertTrue(map.keySet().contains("foaf"));
        assertTrue(map.keySet().contains("xsd"));
        assertFalse(map.keySet().contains("tg"));
        xe.evaluateList("sail:add-ns($g, 'tg', 'http://tinkerpop.com#')");
        map = (Map) xe.evaluateList("sail:get-ns($g)").get(0);
        assertEquals(map.size(), 6);
        assertTrue(map.keySet().contains("rdf"));
        assertTrue(map.keySet().contains("rdfs"));
        assertTrue(map.keySet().contains("owl"));
        assertTrue(map.keySet().contains("foaf"));
        assertTrue(map.keySet().contains("xsd"));
        assertTrue(map.keySet().contains("tg"));
        xe.evaluateList("sail:remove-ns($g, 'tg')");
        xe.evaluateList("sail:remove-ns($g, 'rdf')");
        xe.evaluateList("sail:remove-ns($g, 'xsd')");
        map = (Map) xe.evaluateList("sail:get-ns($g)").get(0);
        assertEquals(map.size(), 3);
        assertFalse(map.keySet().contains("rdf"));
        assertTrue(map.keySet().contains("rdfs"));
        assertTrue(map.keySet().contains("owl"));
        assertTrue(map.keySet().contains("foaf"));
        assertFalse(map.keySet().contains("xsd"));
        assertFalse(map.keySet().contains("tg"));
    }

     public void testGetNamespacesFunctionGraphVariable() {

        Graph graph = new SesameGraph(new MemoryStore());
        XPathEvaluator xe = new XPathEvaluator();
        xe.setVariable(Tokens.GRAPH_VARIABLE, graph);
        assertTrue(xe.evaluateList("sail:get-ns()").get(0) instanceof Map);
        Map map = (Map) xe.evaluateList("sail:get-ns()").get(0);
        assertEquals(map.size(), 5);
        assertTrue(map.keySet().contains("rdf"));
        assertTrue(map.keySet().contains("rdfs"));
        assertTrue(map.keySet().contains("owl"));
        assertTrue(map.keySet().contains("foaf"));
        assertTrue(map.keySet().contains("xsd"));
        assertFalse(map.keySet().contains("tg"));
        xe.evaluateList("sail:add-ns('tg', 'http://tinkerpop.com#')");
        map = (Map) xe.evaluateList("sail:get-ns()").get(0);
        assertEquals(map.size(), 6);
        assertTrue(map.keySet().contains("rdf"));
        assertTrue(map.keySet().contains("rdfs"));
        assertTrue(map.keySet().contains("owl"));
        assertTrue(map.keySet().contains("foaf"));
        assertTrue(map.keySet().contains("xsd"));
        assertTrue(map.keySet().contains("tg"));
        xe.evaluateList("sail:remove-ns('tg')");
        xe.evaluateList("sail:remove-ns('rdf')");
        xe.evaluateList("sail:remove-ns('xsd')");
        map = (Map) xe.evaluateList("sail:get-ns()").get(0);
        assertEquals(map.size(), 3);
        assertFalse(map.keySet().contains("rdf"));
        assertTrue(map.keySet().contains("rdfs"));
        assertTrue(map.keySet().contains("owl"));
        assertTrue(map.keySet().contains("foaf"));
        assertFalse(map.keySet().contains("xsd"));
        assertFalse(map.keySet().contains("tg"));




    }
}
