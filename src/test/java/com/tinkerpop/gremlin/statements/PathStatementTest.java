package com.tinkerpop.gremlin.statements;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph;
import com.tinkerpop.gremlin.GremlinEvaluator;
import junit.framework.TestCase;

import java.io.ByteArrayInputStream;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PathStatementTest extends TestCase {

    public void testPathStatementSyntax() {
        assertTrue(PathStatement.isStatement("path marko"));
        assertTrue(PathStatement.isStatement("path   marko"));
        assertTrue(PathStatement.isStatement("path hello()"));
        assertFalse(PathStatement.isStatement("path "));
        assertFalse(PathStatement.isStatement("path a space path"));
        assertFalse(PathStatement.isStatement("path"));

    }

    public void testPathStatementEvaluation() throws Exception {
        GremlinEvaluator ge = new GremlinEvaluator();
        Graph graph = new TinkerGraph();
        ge.getVariables().declareVariable(Tokens.AT_VARIABLE, graph.addVertex(null));
        String funcst = "path knows\n1.0\nend\n";
        assertNull(ge.evaluate(new ByteArrayInputStream(funcst.getBytes())));
        assertEquals(ge.evaluate("./knows").get(0), 1.0);

        String funcbigst = "path friend\n$x := 1\nrepeat 2\n$x := $x * 2\nend\nend\n";
        assertNull(ge.evaluate(new ByteArrayInputStream(funcbigst.getBytes())));
    }
}
