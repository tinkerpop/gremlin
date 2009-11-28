package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class AssignmentStatementTest extends BaseTest {

    public void testIsStatement() {
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
}
