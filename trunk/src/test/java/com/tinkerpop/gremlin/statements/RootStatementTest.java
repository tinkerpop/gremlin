package com.tinkerpop.gremlin.statements;

import junit.framework.TestCase;
import com.tinkerpop.gremlin.GremlinEvaluator;

import java.io.ByteArrayInputStream;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class RootStatementTest extends TestCase {

    public void testRootStatementSyntax() {
        assertTrue(RootStatement.isStatement("root 1 2 3 4"));
        assertTrue(RootStatement.isStatement("root '1' 2 $g 'a'        "));
        assertTrue(RootStatement.isStatement("   root $abc 2 1"));
        assertFalse(RootStatement.isStatement("root"));
        assertFalse(RootStatement.isStatement("root "));
        assertFalse(RootStatement.isStatement("root       "));
    }

    public void testRootStatementEvaluation() throws Exception {

        GremlinEvaluator ge = new GremlinEvaluator();
        String sb = "rt 1 2 3";
        //assertEquals(ge.evaluate(new ByteArrayInputStream(sb.getBytes())).size(), 3);
        
    }
}
