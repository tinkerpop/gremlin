package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AssignFunctionTest extends BaseTest {

    public void testAssign() {
        Function<Boolean> function = new AssignFunction();
        this.stopWatch();
        assertTrue(function.compute(createUnaryArgs("x", 1)).getValue());
        assertTrue(function.compute(createUnaryArgs("y", 2)).getValue());
        assertTrue(function.compute(createUnaryArgs("z", 3)).getValue());
        assertTrue(function.compute(createUnaryArgs("x", 4)).getValue());
        printPerformance(function.getFunctionName() + " function", 4, "evaluation", this.stopWatch());
        assertEquals(GremlinEvaluator.getVariable("x").getValue(), 4);
        assertEquals(GremlinEvaluator.getVariable("y").getValue(), 2);
        assertEquals(GremlinEvaluator.getVariable("z").getValue(), 3);


    }
}
