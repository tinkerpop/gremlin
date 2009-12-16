package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.GremlinEvaluator;

import java.io.ByteArrayInputStream;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class CommentStatementTest extends BaseTest {

    public void testCommentStatementSyntax() {
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

    public void testCommentStatementEvaluation() throws Exception {
        GremlinEvaluator ge = new GremlinEvaluator();
        String sb = "# this is a comment";
        assertNull(ge.evaluate(new ByteArrayInputStream(sb.getBytes())));
    }
}
