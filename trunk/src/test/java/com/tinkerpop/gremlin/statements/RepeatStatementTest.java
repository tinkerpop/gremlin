package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.GremlinEvaluator;
import junit.framework.TestCase;

import java.io.ByteArrayInputStream;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RepeatStatementTest extends TestCase {

    public void testRepeatStatementSyntax() {
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

    public void testRepeatStatementEvaluation() throws Exception {

        GremlinEvaluator ge = new GremlinEvaluator();
        String sb = "repeat 10\n1.0\nend\n";
        assertEquals(ge.evaluate(new ByteArrayInputStream(sb.getBytes())).size(), 1);
        assertEquals(ge.evaluate(new ByteArrayInputStream(sb.getBytes())).get(0), 1.0);
        assertEquals(ge.evaluate(new ByteArrayInputStream(sb.getBytes())).get(0), 1.0);

        sb = "repeat 0\n1.0\nend\n";
        assertNull(ge.evaluate(new ByteArrayInputStream(sb.getBytes())));

        sb = "repeat null()\n1+2\nend\n";
        assertNull(ge.evaluate(new ByteArrayInputStream(sb.getBytes())));

    }
}
