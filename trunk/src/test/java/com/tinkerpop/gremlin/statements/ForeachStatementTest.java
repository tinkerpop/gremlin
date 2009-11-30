package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class ForeachStatementTest extends BaseTest {

    public void testIsStatement() {
        assertTrue(ForeachStatement.isStatement("foreach $i in 123"));
        assertTrue(ForeachStatement.isStatement("foreach $_ in ./outEdges/inVertex"));
        assertTrue(ForeachStatement.isStatement("   foreach $abc in function()"));
        assertFalse(ForeachStatement.isStatement("for each $i in 123"));
        assertFalse(ForeachStatement.isStatement("foreach $i in "));
        assertTrue(ForeachStatement.isStatement("  foreach $i in 1 | 2 | 3 | 4"));
    }
}
