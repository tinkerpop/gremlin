package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class ForeachStatementTest extends BaseTest {

    public void testForeach1() {
        XPathEvaluator xPathEvaluator = new XPathEvaluator();
        ForeachStatement foreachStatement = new ForeachStatement(xPathEvaluator);
        assertFalse(foreachStatement.compileTokens("foreach $i in true()"));
        assertEquals(foreachStatement.getVariable(), "$i");
        assertEquals(foreachStatement.getLoopSet().toString(), "true()");
        assertNull(foreachStatement.getLoopBody());
        assertTrue(foreachStatement.compileTokens("do 1+2"));
        assertEquals(foreachStatement.getLoopBody().toString(), "1+2");
        assertEquals(foreachStatement.evaluate(), asList(3.0,1));
    }
}
