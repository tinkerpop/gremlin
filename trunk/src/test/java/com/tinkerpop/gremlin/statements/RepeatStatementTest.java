package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class RepeatStatementTest extends BaseTest {

    public void testIsStatement() {
        assertTrue(RepeatStatement.isStatement("repeat $i"));
        assertTrue(RepeatStatement.isStatement("repeat ./././././././"));
        assertTrue(RepeatStatement.isStatement("repeat 135"));
        assertTrue(RepeatStatement.isStatement("   repeat    135"));
        assertFalse(RepeatStatement.isStatement("repeat123"));
        assertFalse(RepeatStatement.isStatement("repet 123"));
        assertFalse(RepeatStatement.isStatement("repeat "));
        assertFalse(RepeatStatement.isStatement("repeat"));
        assertTrue(RepeatStatement.isStatement("repeat 1 | 2 | 3 | 4"));
    }
}
