package com.tinkerpop.gremlin.functions.sail;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.models.pgm.Graph;
import com.tinkerpop.gremlin.models.pgm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.statements.Tokens;
import junit.framework.TestCase;
import org.openrdf.sail.memory.MemoryStore;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddNamespaceFunctionTest extends TestCase {

    public void testAddNamespaceFunction() {
        Graph graph = new SailGraph(new MemoryStore());
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable("$g", graph);
        assertEquals(xe.evaluateList("sail:ns($g, 'tg:marko')").get(0), "tg:marko");
        assertTrue((Boolean) xe.evaluateList("sail:add-ns($g,'tg','http://tinkerpop.com#')").get(0));
        assertEquals(xe.evaluateList("sail:ns($g, 'tg:marko')").get(0), "http://tinkerpop.com#marko");
        graph.shutdown();

    }

    public void testAddNamespaceFunctionGraphVariable() {
        Graph graph = new SailGraph(new MemoryStore());
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);
        assertEquals(xe.evaluateList("sail:ns('tg:marko')").get(0), "tg:marko");
        assertTrue((Boolean) xe.evaluateList("sail:add-ns('tg','http://tinkerpop.com#')").get(0));
        assertEquals(xe.evaluateList("sail:ns('tg:marko')").get(0), "http://tinkerpop.com#marko");
        graph.shutdown();
    }
}
