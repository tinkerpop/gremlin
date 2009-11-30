package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class IfElseStatementTest extends BaseTest {

    public void testIsStatement() {
        assertTrue(IfElseStatement.isStatement("if true()"));
        assertTrue(IfElseStatement.isStatement("   if false()     "));
        assertTrue(IfElseStatement.isStatement("   if 1"));
        assertTrue(IfElseStatement.isStatement("if ./././././././"));
        assertTrue(IfElseStatement.isStatement("if if if if if if if if"));
        assertFalse(IfElseStatement.isStatement("iftrue()"));
        assertFalse(IfElseStatement.isStatement("if"));
        assertFalse(IfElseStatement.isStatement("     if"));
    }

}
