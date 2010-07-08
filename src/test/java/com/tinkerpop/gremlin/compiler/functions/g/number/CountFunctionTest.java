package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.functions.Function;

import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class CountFunctionTest extends BaseTest {

    public void testCountSingleValue() {
        Function function = new CountFunction();
        this.stopWatch();
        assertEquals(function.compute(createUnaryArgs(1)).getValue(), 1l);
        printPerformance(function.getFunctionName() + " function", 1, "argument", this.stopWatch());
    }

    public void testCountListOfValues() {
        Function function = new CountFunction();
        this.stopWatch();
        assertEquals(function.compute(createUnaryArgs(Arrays.asList(1, 2, 3, 4, 5, 6))).getValue(), 6l);
        printPerformance(function.getFunctionName() + " function", 6, "arguments", this.stopWatch());
    }
}
