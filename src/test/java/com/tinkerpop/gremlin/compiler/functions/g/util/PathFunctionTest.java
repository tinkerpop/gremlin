package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PathFunctionTest extends BaseTest {

    public void testPath() {
        Function<Boolean> function = new PathFunction();
        this.stopWatch();
        assertTrue(function.compute(createUnaryArgs()).getValue());
        assertTrue(function.compute(createUnaryArgs(1)).getValue());
        assertTrue(function.compute(createUnaryArgs(null)).getValue());
        assertTrue(function.compute(createUnaryArgs("marko")).getValue());
        assertTrue(function.compute(createUnaryArgs(22.0, "pavel", true)).getValue());
        printPerformance(function.getFunctionName() + " function", 5, "evaluations", this.stopWatch());
    }
}
