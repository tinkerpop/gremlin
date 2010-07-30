package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DoubleFunctionTest extends BaseTest {

    public void testDouble() {
        Function<Double> function = new DoubleFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        this.stopWatch();
        Atom<Double> atom = function.compute(createUnaryArgs("1.0"), context);
        printPerformance(function.getFunctionName() + " function", 1, "double parse", this.stopWatch());
        assertEquals(atom.getValue(), 1.0d);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1.0f), context);
        printPerformance(function.getFunctionName() + " function", 1, "double parse", this.stopWatch());
        assertEquals(atom.getValue(), 1.0d);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1l), context);
        printPerformance(function.getFunctionName() + " function", 1, "double parse", this.stopWatch());
        assertEquals(atom.getValue(), 1.0d);
    }
}