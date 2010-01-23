package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.GremlinEvaluator;

import java.util.List;
import java.io.ByteArrayInputStream;

/**
 * @author Pavel A. Yaskevich
 */
public class FunctionStatementTest extends BaseTest {

    public void testFunctionStatementSyntax() {
        assertTrue(FunctionStatement.isStatement("func test:name()"));
        assertTrue(FunctionStatement.isStatement("func test:name($x)"));
        assertTrue(FunctionStatement.isStatement("func test:name($x, $y)"));
        assertTrue(FunctionStatement.isStatement("func   test:name($x, $y, $z)"));
        assertTrue(FunctionStatement.isStatement("func test:name ($x, $y, $z, $p)"));
        assertFalse(FunctionStatement.isStatement("func test : name ($x, $y, $z)"));
        assertFalse(FunctionStatement.isStatement("func name($x, $y, $z)"));

    }

    public void testFunctionStatementEvaluation() throws Exception {
       GremlinEvaluator ge = new GremlinEvaluator();
       String funcst = "func x:y()\n1.0\nend\n";
       assertNull(ge.evaluate(new ByteArrayInputStream(funcst.getBytes())));
    
       String funcbigst = "func x:y()\n$x := 1\nrepeat 2\n$x := $x * 2\nend\nend\n";
       assertNull(ge.evaluate(new ByteArrayInputStream(funcbigst.getBytes())));
    }
}
