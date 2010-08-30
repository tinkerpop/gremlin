package com.tinkerpop.gremlin.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.Function;

import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class CountFunctionTest extends BaseTest {

    public void testCountSingleValue() {
        Function function = new CountFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        this.stopWatch();
        assertEquals(function.compute(createUnaryArgs(1), context).getValue(), 1l);
        printPerformance(function.getFunctionName() + " function", 1, "argument", this.stopWatch());
    }

    public void testCountListOfValues() {
        Function function = new CountFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        this.stopWatch();
        assertEquals(function.compute(createUnaryArgs(Arrays.asList(1, 2, 3, 4, 5, 6)), context).getValue(), 6l);
        printPerformance(function.getFunctionName() + " function", 6, "arguments", this.stopWatch());
    }
}
