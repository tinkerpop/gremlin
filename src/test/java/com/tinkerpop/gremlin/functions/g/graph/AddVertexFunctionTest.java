package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.Tokens;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddVertexFunctionTest extends BaseTest {

    public void testAddVertexFunction() {
        Graph graph = new TinkerGraph();
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);
        assertEquals(count(graph.getVertices()), 0);
        xe.evaluateList("g:add-v()");
        assertEquals(count(graph.getVertices()), 1);
        xe.evaluateList("g:add-v('11111')");
        assertEquals(count(graph.getVertices()), 2);
        xe.evaluateList("g:add-v($_g)");
        assertEquals(count(graph.getVertices()), 3);
        xe.evaluateList("g:add-v($_g, '22222')");
        assertEquals(count(graph.getVertices()), 4);

    }

    public void testAddVertexFunctionWithMap() {
        Graph graph = new TinkerGraph();
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);
        List result = xe.evaluateList("g:add-v(g:map('name','marko','age',30))");
        assertEquals(result.size(), 1);
        assertTrue(result.get(0) instanceof Vertex);
        Vertex vertex = (Vertex) result.get(0);
        assertEquals(vertex.getProperty("name"), "marko");
        assertEquals(vertex.getProperty("age"), 30.0);
        assertEquals(vertex.getPropertyKeys().size(), 2);

        result = xe.evaluateList("g:add-v($_g, g:map('id','abcd','name','peter','age',37))");
        assertEquals(result.size(), 1);
        assertTrue(result.get(0) instanceof Vertex);
        vertex = (Vertex) result.get(0);
        assertEquals(vertex.getProperty("name"), "peter");
        assertEquals(vertex.getProperty("age"), 37.0);
        assertEquals(vertex.getId(), "abcd");
        assertEquals(vertex.getPropertyKeys().size(), 2);
        assertEquals(count(graph.getIndex().get("name", "peter")), 1);
        assertEquals(graph.getIndex().get("name", "peter").iterator().next(), vertex);
        assertEquals(count(graph.getIndex().get("age", 37.0)), 1);
        assertEquals(graph.getIndex().get("age", 37.0).iterator().next(), vertex);
        assertEquals(count(graph.getIndex().get("name", "marko")), 1);
        assertEquals(count(graph.getIndex().get("age", 30.0)), 1);

    }

}
