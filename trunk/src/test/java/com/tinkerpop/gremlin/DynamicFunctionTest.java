package com.tinkerpop.gremlin;
import junit.framework.TestCase;

import java.io.InputStream;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.util.Map;

public class DynamicFunctionTest extends TestCase {

   /* public void testFunctionStatements() throws IOException {
        GremlinEvaluator ge = new GremlinEvaluator();
        InputStream simpleFunc = new ByteArrayInputStream("func x:y($i)\n1 + $i\nend\nx:y(1)\n".getBytes());
        assertEquals(ge.evaluate(simpleFunc).get(0), 2.0);
    }

    public void testFunctionWithOneArgument() throws IOException {
        GremlinEvaluator ge = new GremlinEvaluator();
        InputStream twoArgsFunc = new ByteArrayInputStream("func x:y($x, $y)\n$x + $y\nend\nx:y(1,2)\n".getBytes());
        assertEquals(ge.evaluate(twoArgsFunc).get(0), 3.0);
    }

    public void testFunctionWithoutArguments() throws IOException {
        GremlinEvaluator ge = new GremlinEvaluator();
        InputStream noArgsFunc = new ByteArrayInputStream("func x:y()\nend\ng:print(x:y())\n".getBytes());
        assertEquals(ge.evaluate(noArgsFunc).get(0), true);
    }

    public void testFunctionInclusion() throws IOException {
        GremlinEvaluator ge = new GremlinEvaluator();
        InputStream funcInFunc = new ByteArrayInputStream("func x:y($x)\n$x\nend\nfunc x:z()\n$x := 1\nend\nx:y(x:z())".getBytes());
        assertEquals(ge.evaluate(funcInFunc).get(0), 1.0);
    }

    /*public void testFunctionsWithEqualNames() throws IOException {
        GremlinEvaluator ge = new GremlinEvaluator();
        InputStream funcsWithEqualNames1 = new ByteArrayInputStream("func x:y($x)\n$x\nend\nfunc z:y()\n1.0\nend\nx:y(2)".getBytes());
        InputStream funcsWithEqualNames2 = new ByteArrayInputStream("func x:y($x)\n$x\nend\nfunc z:y()\n1.0\nend\nz:y()".getBytes());
        assertEquals(ge.evaluate(funcsWithEqualNames1).get(0), 2.0);
        assertEquals(ge.evaluate(funcsWithEqualNames2).get(0), 1.0);
    }*/

    /*public void testFunctionWithSequance() throws IOException {
        GremlinEvaluator ge = new GremlinEvaluator();
        InputStream funcWithSeq = new ByteArrayInputStream("func x:y($x)\nforeach $i in 1|2\n$x := $x+$i\nend\nend\nx:y(1)".getBytes());
        assertEquals(ge.evaluate(funcWithSeq).get(0), 4.0);
    }

    public void testFunctionReturnsMap() throws IOException {
        GremlinEvaluator ge = new GremlinEvaluator();
        InputStream funcReturnsMap = new ByteArrayInputStream("func x:y()\ng:map(1, 2)\nend\nx:y()".getBytes());
        Map result = (Map) ge.evaluate(funcReturnsMap).get(0);
        
        assertTrue(result instanceof Map);
        assertEquals(result.size(), 1);
        assertEquals(result.get(1.0), 2.0);
    } */

    public void testTrue() {
        assertTrue(true);
    }

}
