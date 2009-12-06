package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class CommentStatementTest extends BaseTest {

    public void testIsStatement() {
        assertTrue(CommentStatement.isStatement("# a comment"));
        assertTrue(CommentStatement.isStatement("#acomment"));
        assertTrue(CommentStatement.isStatement("#"));
        assertTrue(CommentStatement.isStatement("     #"));
        assertTrue(CommentStatement.isStatement("  # a comment"));
        assertTrue(CommentStatement.isStatement("#$a comment"));
        assertFalse(CommentStatement.isStatement("the # a comment"));
        assertFalse(CommentStatement.isStatement(""));
        assertFalse(CommentStatement.isStatement("comment"));
    }
}
