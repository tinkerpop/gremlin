package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.GremlinEvaluator;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.IOException;
import java.util.Map;

public class DynamicFunctionTest extends BaseTest {
   
    private static GremlinEvaluator ge = new GremlinEvaluator(); 
    private static InputStream simpleFunc = new StringBufferInputStream("func x:y($i)\n1 + $i\nend\nx:y(1)\n");
    private static InputStream twoArgsFunc = new StringBufferInputStream("func x:y($x, $y)\n$x + $y\nend\nx:y(1,2)\n");
    private static InputStream noArgsFunc = new StringBufferInputStream("func x:y()\nend\ng:print(x:y())\n");
    private static InputStream funcInFunc = new StringBufferInputStream("func x:y($x)\n$x\nend\nfunc x:z()\n$x := 1\nend\nx:y(x:z())");
    private static InputStream funcsWithEqualNames1 = new StringBufferInputStream("func x:y($x)\n$x\nend\nfunc z:y()\n1.0\nend\nx:y(2)");
    private static InputStream funcsWithEqualNames2 = new StringBufferInputStream("func x:y($x)\n$x\nend\nfunc z:y()\n1.0\nend\nz:y()");
    private static InputStream funcWithSeq = new StringBufferInputStream("func x:y($x)\nforeach $i in 1|2\n$x := $x+$i\nend\nend\nx:y(1)");
    private static InputStream funcReturnsMap = new StringBufferInputStream("func x:y()\ng:map(1, 2)\nend\nx:y()");


    public void testFunctionStatements() throws IOException {
        assertEquals(ge.evaluate(simpleFunc).get(0), 2.0);
    }

    public void testFunctionWithOneArgument() throws IOException {
        assertEquals(ge.evaluate(twoArgsFunc).get(0), 3.0);
    }

    public void testFunctionWithoutArguments() throws IOException {
        assertEquals(ge.evaluate(noArgsFunc).get(0), true);
    }

    public void testFunctionInclusion() throws IOException {
        assertEquals(ge.evaluate(funcInFunc).get(0), 1.0);
    }

    public void testFunctionsWithEqualNames() throws IOException {
        assertEquals(ge.evaluate(funcsWithEqualNames1).get(0), 2.0);
        assertEquals(ge.evaluate(funcsWithEqualNames2).get(0), 1.0);
    }

    public void testFunctionWithSequance() throws IOException {
        assertEquals(ge.evaluate(funcWithSeq).get(0), 4.0);
    }

    public void testFunctionReturnsMap() throws IOException {
        Map result = (Map) ge.evaluate(funcReturnsMap).get(0);
        
        assertTrue((result instanceof Map));
        assertEquals(result.size(), 1);
        assertEquals(result.get(1.0), 2.0);
    }

}
