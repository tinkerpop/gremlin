package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class WhileStatementTest extends BaseTest {

    public void testIsStatement() {
        assertTrue(WhileStatement.isStatement("while $i"));
        assertTrue(WhileStatement.isStatement("while ./././././././"));
        assertTrue(WhileStatement.isStatement("while true()"));
        assertTrue(WhileStatement.isStatement("  while   true()  "));
        assertFalse(WhileStatement.isStatement("whiletrue()"));
        assertFalse(WhileStatement.isStatement("while"));
        assertFalse(WhileStatement.isStatement("while     "));
        assertTrue(WhileStatement.isStatement("while false()/outEdges/inVertex"));
    }
}
