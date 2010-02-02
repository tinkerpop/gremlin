package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.GremlinEvaluator;
import junit.framework.TestCase;

import java.io.ByteArrayInputStream;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IncludeStatementTest extends TestCase {

    public void testIncludeStatementSyntax() {
        assertTrue(IncludeStatement.isStatement("include 'com.test.Java'"));
        assertTrue(IncludeStatement.isStatement("include       'com.test.Java'"));
        assertTrue(IncludeStatement.isStatement("      include 'com.test.Java'"));
        assertTrue(IncludeStatement.isStatement("include 'gremlin.grm'"));
        assertFalse(IncludeStatement.isStatement(""));
        assertFalse(IncludeStatement.isStatement("include"));
//        assertFalse(IncludeFunctionsStatement.isStatement("include com.test.Java gremlin.grm"));
    }

    public void testIncludeStatementFunctionEvaluation() throws Exception {
        GremlinEvaluator ge = new GremlinEvaluator();
        assertNull(ge.evaluate("include 'com.tinkerpop.gremlin.statements.TestFunctions'"));
        assertEquals(ge.evaluate("test:test-func-1()").get(0), 187);
        assertEquals(ge.evaluate("test:test-func-2()").get(0), "marko was here");
        assertEquals(ge.evaluate("count(9)").get(0), 1.0);

    }

     /*public void testIncludeStatementPathEvaluation() throws Exception {
        GremlinEvaluator ge = new GremlinEvaluator();
        assertNull(ge.evaluate("include 'com.tinkerpop.gremlin.statements.TestPaths'"));
        assertEquals(ge.evaluate("./test-path-1").get(0), "");
        assertEquals(ge.evaluate("test:test-func-2()").get(0), "marko was here");
        assertEquals(ge.evaluate("count(9)").get(0), 1.0);

    }*/
}