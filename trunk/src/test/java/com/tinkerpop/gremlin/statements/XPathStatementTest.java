package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class XPathStatementTest extends BaseTest {

    public void testBasicXpath() {
        XPathEvaluator xPathEvaluator = new XPathEvaluator();
        XPathStatement xPathStatement = new XPathStatement(xPathEvaluator);
        xPathStatement.compileTokens("matches('marko','peter')");
        assertFalse((Boolean) xPathStatement.evaluate().get(0));
        xPathStatement.compileTokens("(((matches('marko','marko'))))");
        assertTrue((Boolean) xPathStatement.evaluate().get(0));
        xPathStatement.compileTokens("matches(\"marko\",\"marko\")");
        assertTrue((Boolean) xPathStatement.evaluate().get(0));
        xPathStatement.compileTokens("'marko'");
        assertEquals("marko", xPathStatement.evaluate().get(0));
        xPathStatement.compileTokens("\"marko\"");
        assertEquals("marko", xPathStatement.evaluate().get(0));
    }
}
