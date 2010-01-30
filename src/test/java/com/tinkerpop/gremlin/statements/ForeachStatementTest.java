package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.GremlinEvaluator;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ForeachStatementTest extends BaseTest {

    public void testForeachStatementSyntax() {
        assertTrue(ForeachStatement.isStatement("foreach $i in 123"));
        assertTrue(ForeachStatement.isStatement("foreach $_ in ./outEdges/inVertex"));
        assertTrue(ForeachStatement.isStatement("   foreach $abc in function()"));
        assertFalse(ForeachStatement.isStatement("for each $i in 123"));
        assertFalse(ForeachStatement.isStatement("foreach $i in "));
        assertTrue(ForeachStatement.isStatement("  foreach $i in 1 | 2 | 3 | 4"));
    }

    public void testForeachStatementEvaluation() throws Exception {
        List x = null;
        try {
            for (Object o : x) {
                assertFalse(true);
            }
        }
        catch (NullPointerException e) {
            assertTrue(true);
        }

        GremlinEvaluator ge = new GremlinEvaluator();
        String sb = "foreach $i in null()\n1.0\nend\n";
        assertNull(ge.evaluate(new ByteArrayInputStream(sb.getBytes())));
        sb = "$x := 0\nforeach $i in g:append(1,2,3,4,5)\n$x := $x + $i\nend\n";
        assertEquals(ge.evaluate(new ByteArrayInputStream(sb.getBytes())).get(0), 15.0);


    }
}
