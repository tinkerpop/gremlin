package com.tinkerpop.gremlin.statements;

import junit.framework.TestCase;
import com.tinkerpop.gremlin.GremlinEvaluator;

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
        //assertFalse(PathStatement.isStatement("path a space path"));  // TODO: make this assertFalse!
        assertFalse(PathStatement.isStatement("path"));

    }

    public void testPathStatementEvaluation() throws Exception {
        GremlinEvaluator ge = new GremlinEvaluator();
        String funcst = "path knows\n1.0\nend\n";
        assertNull(ge.evaluate(new ByteArrayInputStream(funcst.getBytes())));

        String funcbigst = "path friend\n$x := 1\nrepeat 2\n$x := $x * 2\nend\nend\n";
        assertNull(ge.evaluate(new ByteArrayInputStream(funcbigst.getBytes())));
    }
}
