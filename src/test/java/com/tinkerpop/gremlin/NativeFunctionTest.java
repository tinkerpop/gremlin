package com.tinkerpop.gremlin;

import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.tinkerpop.gremlin.GremlinEvaluator;

public class NativeFunctionTest extends TestCase {

    public void testFunctionStatements() throws IOException {
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
        InputStream funcInFunc = new ByteArrayInputStream("func x:y($x)\n$x\nend\nfunc x:z()\n$x := 1\nend\nx:y(x:z())\n".getBytes());
        assertEquals(ge.evaluate(funcInFunc).get(0), 1.0);
    }

    public void testFunctionsWithEqualNames() throws IOException {
        GremlinEvaluator ge = new GremlinEvaluator();
        InputStream funcsWithEqualNames1 = new ByteArrayInputStream("func x:y($x)\n$x\nend\nfunc z:y()\n1.0\nend\nx:y(2)".getBytes());
        InputStream funcsWithEqualNames2 = new ByteArrayInputStream("func x:y($x)\n$x\nend\nfunc z:y()\n1.0\nend\nz:y()".getBytes());
        assertEquals(ge.evaluate(funcsWithEqualNames1).get(0), 2.0);
        assertEquals(ge.evaluate(funcsWithEqualNames2).get(0), 1.0);
    }

    public void testFunctionWithSequance() throws IOException {
        GremlinEvaluator ge = new GremlinEvaluator();
        InputStream funcWithSeq = new ByteArrayInputStream("func x:y($x)\nforeach $i in 1|2\n$x := $x+$i\nend\nend\nx:y(1)\n".getBytes());
        assertEquals(ge.evaluate(funcWithSeq).get(0), 4.0);
    }

    public void testFunctionReturnsMap() throws IOException {
        GremlinEvaluator ge = new GremlinEvaluator();
        InputStream funcReturnsMap = new ByteArrayInputStream("func x:y()\ng:map(1, 2)\nend\nx:y()\n".getBytes());
        Map result = (Map) ge.evaluate(funcReturnsMap).get(0);
        assertTrue(result != null);
        assertEquals(result.size(), 1);
        assertEquals(result.get(1.0), 2.0);
    }

    public void testFunctionCallFromOtherFunction() throws IOException {
        GremlinEvaluator ge = new GremlinEvaluator();
        InputStream funcArgFunc = new ByteArrayInputStream("func x:y($p)\nconcat('hello ', $p)\nend\nfunc y:y()\n'p'\nend\nx:y(y:y())".getBytes());
        assertEquals(ge.evaluate(funcArgFunc).get(0), "hello p");
    }

    public void testFunctionInsideXPath() throws IOException {
        GremlinEvaluator ge = new GremlinEvaluator();
        InputStream funcInsideXPathReturnsPath = new ByteArrayInputStream("$_g := tg:open()\n$p := g:add-v()\n$m := g:add-v()\ng:add-e($p, 'knows', $m)\ng:add-e($p, 'co-developer', $m)\nfunc x:y($w)\n$w\nend\ng:type($p/outE[x:y(1)])".getBytes());
        InputStream funcInsideXPathReturnsLabel = new ByteArrayInputStream("$_g := tg:open()\n$p := g:add-v()\n$m := g:add-v()\ng:add-e($p, 'knows', $m)\ng:add-e($p, 'co-developer', $m)\nfunc x:y($w)\n$w\nend\n$p/outE[x:y(1)]/@label".getBytes());
        assertEquals(ge.evaluate(funcInsideXPathReturnsPath).get(0), "edge");
        assertEquals(ge.evaluate(funcInsideXPathReturnsLabel).get(0), "co-developer");
    }

    public void testUDFunctionCallFromAnotherUDFunction() throws IOException {
        GremlinEvaluator ge = new GremlinEvaluator();
        InputStream funcInsideFuncCall = new ByteArrayInputStream("func x:y($num)\nfunc y:sq($num)\n$num * $num\nend\n$sq := y:sq($num)\n$sq + 6\nend\nx:y(2)".getBytes());
        assertEquals(ge.evaluate(funcInsideFuncCall).get(0), 10.0);
    }
}
