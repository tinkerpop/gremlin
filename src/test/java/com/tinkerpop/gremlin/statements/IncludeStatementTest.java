package com.tinkerpop.gremlin.statements;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph;
import com.tinkerpop.gremlin.GremlinEvaluator;
import junit.framework.TestCase;

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

    public void testIncludeStatementFunctionEvaluation() {
        GremlinEvaluator ge = new GremlinEvaluator();
        assertTrue((Boolean) ge.evaluate("include 'com.tinkerpop.gremlin.statements.TestFunctions'").get(0));
        assertEquals(ge.evaluate("test:test-func-1()").get(0), 187);
        assertEquals(ge.evaluate("test:test-func-2()").get(0), "marko was here");
        assertEquals(ge.evaluate("count(9)").get(0), 1.0);

    }

    public void testIncludeStatementPathEvaluation() {
        GremlinEvaluator ge = new GremlinEvaluator();
        Graph graph = new TinkerGraph();
        ge.getVariables().declareVariable(Tokens.AT_VARIABLE, graph.addVertex(null));
        assertTrue((Boolean) ge.evaluate("include 'com.tinkerpop.gremlin.statements.TestPaths'").get(0));
        assertEquals(ge.evaluate("./test-path-1").get(0), "undercover cop");
        assertEquals(ge.evaluate("count(9)").get(0), 1.0);

    }

    /*public void testIncludeStatementGremlinFileEvaluation() {
        GremlinEvaluator ge = new GremlinEvaluator();
        IncludeStatementTest.class.getResourceAsStream("test.grm");
        assertNull(ge.evaluate("include 'src/test/resources/com/tinkerpop/gremlin/statements/test.grm'"));
    }*/
}