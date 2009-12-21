package com.tinkerpop.gremlin.db.sesame.functions;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.db.sesame.SesameGraph;
import com.tinkerpop.gremlin.model.Graph;
import org.openrdf.sail.memory.MemoryStore;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class AddNamespaceFunctionTest extends TestCase {

    public void testAddNamespaceFunction() {
        Graph graph = new SesameGraph(new MemoryStore());
        XPathEvaluator xe = new XPathEvaluator();
        xe.setVariable("$g", graph);
        assertEquals(xe.evaluateList("sail:ns($g, 'tg:marko')").get(0), "tg:marko");
        assertTrue((Boolean)xe.evaluateList("sail:add-ns($g,'tg','http://tinkerpop.com#')").get(0));
        assertEquals(xe.evaluateList("sail:ns($g, 'tg:marko')").get(0), "http://tinkerpop.com#marko");
        graph.shutdown();

    }
}
