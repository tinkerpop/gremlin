package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.Gremlin;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IfStatementTest extends BaseTest {

    public void testIfInGremlin() throws Exception {
        List results = (List) Gremlin.evaluate("$x := 0\nif true\n$x := 10\nend\n$x\n");
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), 0);
        assertNull(results.get(1));
        assertEquals(results.get(2), 10);
    }

    public void testIfElseInGremlin() throws Exception {
        List results = (List) Gremlin.evaluate("$x := 0\nif false\n$x := 10\nelse\n$x := 20\nend\n$x\n");
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), 0);
        assertNull(results.get(1));
        assertEquals(results.get(2), 20);
    }

    public void testEmbeddedIfElseInGremlin() throws Exception {
        List results = (List) Gremlin.evaluate("$x := 0\nif false\n$x := 10\nelse\nif true\n$x := 30\nelse\n$x := 20\nend\nend\n$x\n");
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), 0);
        assertNull(results.get(1));
        assertEquals(results.get(2), 30);
    }
}
