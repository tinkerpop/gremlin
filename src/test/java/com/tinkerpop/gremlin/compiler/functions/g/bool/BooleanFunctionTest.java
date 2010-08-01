package com.tinkerpop.gremlin.compiler.functions.g.bool;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BooleanFunctionTest extends BaseTest {

    public void testBoolean() {
        Function<Boolean> function = new BooleanFunction();
        this.stopWatch();
        Atom<Boolean> atom = function.compute(createUnaryArgs("True"), new GremlinScriptContext());
        printPerformance(function.getFunctionName() + " function", 1, "boolean parse", this.stopWatch());
        assertTrue(atom.getValue());
        this.stopWatch();
        atom = function.compute(createUnaryArgs(1), new GremlinScriptContext());
        printPerformance(function.getFunctionName() + " function", 1, "boolean parse", this.stopWatch());
        assertTrue(atom.getValue());
        this.stopWatch();
        atom = function.compute(createUnaryArgs(-0.2), new GremlinScriptContext());
        printPerformance(function.getFunctionName() + " function", 1, "boolean parse", this.stopWatch());
        assertFalse(atom.getValue());
    }

    public void testIllegalArguments() {
        try {
            Function<Boolean> function = new BooleanFunction();
            function.compute(createUnaryArgs(true, false, true), new GremlinScriptContext());
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}