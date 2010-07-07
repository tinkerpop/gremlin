package com.tinkerpop.gremlin.compiler;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinEvaluatorTest extends BaseTest {

    public void testVariableHandling() {
        this.stopWatch();
        GremlinEvaluator.declareVariable("w", new Atom<Double>(1.0d));
        GremlinEvaluator.declareVariable("x", new Atom(null));
        GremlinEvaluator.declareVariable("y", new Atom<String>("1"));
        GremlinEvaluator.declareVariable("z", new Atom<Boolean>(true));
        printPerformance("evaluator", 4, "variable declarations", this.stopWatch());

        this.stopWatch();
        assertEquals(GremlinEvaluator.getVariable("w").getValue(), 1.0d);
        assertNull(GremlinEvaluator.getVariable("x").getValue());
        assertEquals(GremlinEvaluator.getVariable("y").getValue(), "1");
        assertTrue((Boolean) GremlinEvaluator.getVariable("z").getValue());
        printPerformance("evaluator", 4, "variable gets", this.stopWatch());

        this.stopWatch();
        GremlinEvaluator.freeVariable("w");
        GremlinEvaluator.freeVariable("x");
        GremlinEvaluator.freeVariable("y");
        GremlinEvaluator.freeVariable("z");
        printPerformance("evaluator", 4, "variable undeclarations", this.stopWatch());
        assertNull(GremlinEvaluator.getVariable("w").getValue());
        assertNull(GremlinEvaluator.getVariable("x").getValue());
        assertNull(GremlinEvaluator.getVariable("y").getValue());
        assertNull(GremlinEvaluator.getVariable("z").getValue());

    }

}
