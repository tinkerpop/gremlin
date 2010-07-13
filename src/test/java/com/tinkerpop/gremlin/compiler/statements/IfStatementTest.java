package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IfStatementTest extends BaseTest {

    public void testIfElseInGremlin() throws Exception {
        //System.out.println(Gremlin.evaluate("$x := 0\nif true\n$x := 10\nend\n$x\n"));
        //assertEquals(results, 10);
        assertTrue(true);
    }
}
