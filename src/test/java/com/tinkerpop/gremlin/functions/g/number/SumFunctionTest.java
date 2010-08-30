package com.tinkerpop.gremlin.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.Function;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SumFunctionTest extends BaseTest {

    public void testSumSimpleList() {
        Function function = new SumFunction();
        this.stopWatch();
        GremlinScriptContext context = new GremlinScriptContext();
        assertEquals(function.compute(createUnaryArgs(1, 2.0d, 3.0f, 4l), context).getValue(), 10.0d);
        printPerformance(function.getFunctionName() + " function", 4, "arguments", this.stopWatch());
    }

    public void testSumEmbeddedList() {
        Function function = new SumFunction();
        this.stopWatch();
        GremlinScriptContext context = new GremlinScriptContext();
        assertEquals(function.compute(createUnaryArgs(1.0, 2.0, Arrays.asList(3.0, 4.0)), context).getValue(), 10.0d);
        printPerformance(function.getFunctionName() + " function", 4, "arguments (with list embedding)", this.stopWatch());
    }

    public void testSumEmbeddedSet() {
        Function function = new SumFunction();
        Set set = new HashSet();
        set.add(3.0d);
        set.add(4.0d);
        this.stopWatch();
        GremlinScriptContext context = new GremlinScriptContext();
        assertEquals(function.compute(createUnaryArgs(1.0, 2.0, set), context).getValue(), 10.0d);
        printPerformance(function.getFunctionName() + " function", 4, "arguments (with list embedding)", this.stopWatch());
    }
}
