package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.GremlinEvaluator;

import java.io.ByteArrayInputStream;

import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class CommentStatementTest extends TestCase {

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
