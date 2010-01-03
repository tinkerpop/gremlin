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
        assertTrue(RootStatement.isStatement("rt 1 2 3 4"));
        assertTrue(RootStatement.isStatement("rt '1' 2 $g 'a'        "));
        assertTrue(RootStatement.isStatement("   rt $abc 2 1"));
        assertFalse(RootStatement.isStatement("rt"));
        assertFalse(RootStatement.isStatement("rt "));
        assertFalse(RootStatement.isStatement("rt       "));
    }

    public void testRootStatementEvaluation() throws Exception {

        GremlinEvaluator ge = new GremlinEvaluator();
        String sb = "rt 1 2 3";
        //assertEquals(ge.evaluate(new ByteArrayInputStream(sb.getBytes())).size(), 3);
        
    }
}
