package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.db.tg.TinkerGraph;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.Tokens;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddIndexFunctionTest extends TestCase {

    public void testAddIndexFunction() {
        Graph graph = new TinkerGraph();
        graph.getIndex().indexAll(false);
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);
        Vertex v = graph.addVertex("1");
        v.setProperty("name", "marko");
        v.setProperty("age", 30);
        assertEquals(xe.evaluateList("g:key('name','marko')").size(), 0);
        assertEquals(xe.evaluateList("g:key('age', 30)").size(), 0);
        xe.evaluateList("g:add-idx('name')");
        v = graph.addVertex("1");
        v.setProperty("name", "jen");
        v.setProperty("age", 26);
        assertEquals(xe.evaluateList("g:key('name','marko')").size(), 0);
        assertEquals(xe.evaluateList("g:key('age', 30)").size(), 0);
        assertEquals(xe.evaluateList("g:key('name','jen')").size(), 1);
        assertEquals(xe.evaluateList("g:key('age', 26)").size(), 0);
    }


}
