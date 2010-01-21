package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.GremlinEvaluator;

import java.io.ByteArrayInputStream;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IfElseStatementTest extends BaseTest {

    public void testIfElseStatementSyntax() {
        assertTrue(IfElseStatement.isStatement("if true()"));
        assertTrue(IfElseStatement.isStatement("   if false()     "));
        assertTrue(IfElseStatement.isStatement("   if 1"));
        assertTrue(IfElseStatement.isStatement("if ./././././././"));
        assertTrue(IfElseStatement.isStatement("if if if if if if if if"));
        assertFalse(IfElseStatement.isStatement("iftrue()"));
        assertFalse(IfElseStatement.isStatement("if"));
        assertFalse(IfElseStatement.isStatement("     if"));
    }

    public void testIfElseStatementEvaluation() throws Exception{
        GremlinEvaluator ge = new GremlinEvaluator();
        String sb = "if true()\n1.0\nelse\n2.0\nend\n";
        assertEquals(ge.evaluate(new ByteArrayInputStream(sb.getBytes())).size(), 1);
        assertEquals(ge.evaluate(new ByteArrayInputStream(sb.getBytes())).get(0), 1.0);
        assertEquals(ge.evaluate(new ByteArrayInputStream(sb.getBytes())).get(0), 1.0);

        sb = "if null()\n1.0\nelse\n2.0\nend\n";
        assertNull(ge.evaluate(new ByteArrayInputStream(sb.getBytes())));
        sb = "if false()\n1.0\nend\n";
        assertNull(ge.evaluate(new ByteArrayInputStream(sb.getBytes())));

    }

}
