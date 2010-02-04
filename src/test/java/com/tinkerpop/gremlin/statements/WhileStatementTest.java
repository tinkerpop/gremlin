package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.GremlinEvaluator;
import junit.framework.TestCase;

import java.io.ByteArrayInputStream;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class WhileStatementTest extends TestCase {

    public void testWhileStatementSyntax() {
        assertTrue(WhileStatement.isStatement("while $i"));
        assertTrue(WhileStatement.isStatement("while ./././././././"));
        assertTrue(WhileStatement.isStatement("while true()"));
        assertTrue(WhileStatement.isStatement("  while   true()  "));
        assertFalse(WhileStatement.isStatement("whiletrue()"));
        assertFalse(WhileStatement.isStatement("while"));
        assertFalse(WhileStatement.isStatement("while     "));
        assertTrue(WhileStatement.isStatement("while false()/outEdges/inVertex"));
    }

    public void testWhileStatementEvaluation() throws Exception {
        GremlinEvaluator ge = new GremlinEvaluator();
        String sb = "$i := 0\nwhile $i < 10\n$i := $i + 1.0\nend\n";
        assertEquals(ge.evaluate(new ByteArrayInputStream(sb.getBytes())).get(0), 10.0);

        sb = "while $i < null()\n1.0\nend\n";
        assertNull(ge.evaluate(new ByteArrayInputStream(sb.getBytes())));
        sb = "while null()\n1.0\nend\n";
        assertNull(ge.evaluate(new ByteArrayInputStream(sb.getBytes())));
        sb = "while false()\n1.0\nend\n";
        assertNull(ge.evaluate(new ByteArrayInputStream(sb.getBytes())));
    }
}
