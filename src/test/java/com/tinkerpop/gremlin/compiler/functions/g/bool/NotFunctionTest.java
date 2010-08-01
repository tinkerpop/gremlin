package com.tinkerpop.gremlin.compiler.functions.g.bool;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class NotFunctionTest extends BaseTest {

    public void testNot() {
        Function<Boolean> function = new NotFunction();
        this.stopWatch();
        Atom<Boolean> atom = function.compute(createUnaryArgs(true), new GremlinScriptContext());
        printPerformance(function.getFunctionName() + " function", 1, "boolean flip", this.stopWatch());
        assertFalse(atom.getValue());
        this.stopWatch();
        atom = function.compute(createUnaryArgs(false), new GremlinScriptContext());
        printPerformance(function.getFunctionName() + " function", 1, "boolean flip", this.stopWatch());
        assertTrue(atom.getValue());
    }

    public void testIllegalArguments() {
        try {
            Function<Boolean> function = new NotFunction();
            function.compute(createUnaryArgs(true, false, true), new GremlinScriptContext());
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}