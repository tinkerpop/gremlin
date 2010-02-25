package com.tinkerpop.gremlin;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph;
import com.tinkerpop.gremlin.statements.Tokens;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class XPathEvaluatorTest extends BaseTest {

    public void testSetVariables() {
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable("$i", 10);
        assertEquals(xe.getVariables().getVariable("$i"), 10);
        xe.getVariables().undeclareVariable("$i");
        assertNull(xe.getVariables().getVariable("$i"));
    }

    public void testLastVariable() {
        XPathEvaluator xe = new XPathEvaluator();
        xe.evaluateList("1+2");
        assertEquals(xe.getVariables().getVariable("$_last"), 3.0);
        xe.evaluateList("1+2");
        assertEquals(xe.evaluateList("g:type($_last)").get(0), "number");
        xe.evaluateList("g:list(1,2,3)");
        assertEquals(xe.evaluateList("g:type($_last)").get(0), "list");
    }
}
