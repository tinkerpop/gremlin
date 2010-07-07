package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class UnassignFunctionTest extends BaseTest {

    public void testAssign() {
        Function<Boolean> function = new UnassignFunction();
        GremlinEvaluator.declareVariable("x", new Atom<Integer>(1));
        GremlinEvaluator.declareVariable("y", new Atom<Integer>(2));
        GremlinEvaluator.declareVariable("z", new Atom<Integer>(3));

        assertEquals(GremlinEvaluator.getVariable("x"), new Atom<Integer>(1));
        assertEquals(GremlinEvaluator.getVariable("y"), new Atom<Integer>(2));
        assertEquals(GremlinEvaluator.getVariable("z"), new Atom<Integer>(3));

        this.stopWatch();
        assertTrue(function.compute(createUnaryArgs("x")).getValue());
        assertTrue(function.compute(createUnaryArgs("y")).getValue());
        assertTrue(function.compute(createUnaryArgs("z")).getValue());
        assertTrue(function.compute(createUnaryArgs("x")).getValue());
        printPerformance(function.getFunctionName() + " function", 4, "evaluation", this.stopWatch());
        assertNull(GremlinEvaluator.getVariable("x").getValue());
        assertNull(GremlinEvaluator.getVariable("y").getValue());
        assertNull(GremlinEvaluator.getVariable("z").getValue());
    }
}