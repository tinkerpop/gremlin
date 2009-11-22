package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class ForeachStatementTest extends BaseTest {

    /*public void testForeach1() {
        XPathEvaluator xPathEvaluator = new XPathEvaluator();
        ForeachStatement foreachStatement = new ForeachStatement(xPathEvaluator);
        assertFalse(foreachStatement.compileTokens("foreach $i in true()"));
        assertEquals(foreachStatement.getVariable(), "$i");
        assertEquals(foreachStatement.getLoopSet().getRawStatement(), "true()");
        assertNull(foreachStatement.getLoopBody());
        assertTrue(foreachStatement.compileTokens("do 1+2"));
        assertEquals(foreachStatement.getLoopBody().getRawStatement(), "1+2");
        assertEquals(foreachStatement.evaluate(), asList(3.0,1));
    }

    public void testForeach2() {
        XPathEvaluator xPathEvaluator = new XPathEvaluator();
        ForeachStatement foreachStatement = new ForeachStatement(xPathEvaluator);
        xPathEvaluator.evaluate("g:set('$x',0)");
        assertFalse(foreachStatement.compileTokens("foreach $i in 1 | 2 | 3 | 4 | 5"));
        assertEquals(foreachStatement.getVariable(), "$i");
        assertEquals(foreachStatement.getLoopSet().getRawStatement(), "1 | 2 | 3 | 4 | 5");
        assertNull(foreachStatement.getLoopBody());
        assertTrue(foreachStatement.compileTokens("do g:set('$x', $x + $i)"));
        assertEquals(foreachStatement.getLoopBody().getRawStatement(), "g:set('$x', $x + $i)");
        assertEquals(foreachStatement.evaluate(), asList(15.0,1));
    }*/
}
