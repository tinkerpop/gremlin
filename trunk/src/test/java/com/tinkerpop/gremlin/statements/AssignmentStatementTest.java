package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.GremlinEvaluator;

import java.io.ByteArrayInputStream;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AssignmentStatementTest extends BaseTest {

    public void testAssignmentStatementSyntax() {
        assertTrue(AssignmentStatement.isStatement("$i := 1"));
        assertTrue(AssignmentStatement.isStatement("   $i := 1"));
        assertTrue(AssignmentStatement.isStatement("   $i :=     1"));
        assertTrue(AssignmentStatement.isStatement("$_13abadcz3e35z.435._dadf4 := 723454224"));
        assertTrue(AssignmentStatement.isStatement("$i := 0945lklnm1n,12mn4,m124"));
        assertFalse(AssignmentStatement.isStatement("$i : = 1234"));
        //assertFalse(AssignmentStatement.isStatement("$09 := 1234"));
        assertFalse(AssignmentStatement.isStatement("$i:=1234"));
        assertTrue(AssignmentStatement.isStatement(" $i[@name='juan la baptista'] := 1234"));
        assertTrue(AssignmentStatement.isStatement("$i[1] := 1234"));
        assertTrue(AssignmentStatement.isStatement("$i/@marko   :=   1234"));
        assertTrue(AssignmentStatement.isStatement("  $i/marko   :=    1234"));
    }

    public void testCommentStatementEvaluation() throws Exception {
        GremlinEvaluator ge = new GremlinEvaluator();
        String sb = "$i := 2";
        assertEquals(ge.evaluate(new ByteArrayInputStream(sb.getBytes())).get(0), 2.0);
        sb = "$i := 'marko'";
        assertEquals(ge.evaluate(new ByteArrayInputStream(sb.getBytes())).get(0), "marko");
        // TODO null() handling ?
        //sb = "$i := null()";
        //assertNull(ge.evaluate(new ByteArrayInputStream(sb.getBytes())));

    }
}
