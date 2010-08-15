package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PowerFunctionTest extends BaseTest {

    public void testPower() {
        Function<Double> function = new PowerFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        this.stopWatch();
        Atom<Double> atom = function.compute(createUnaryArgs(2, 6), context);
        printPerformance(function.getFunctionName() + " function", 1, "argument", this.stopWatch());
        assertEquals(atom.getValue(), 64d);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1,100000), context);
        printPerformance(function.getFunctionName() + " function", 1, "argument", this.stopWatch());
        assertEquals(atom.getValue(), 1.0d);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(2.1,2), context);
        printPerformance(function.getFunctionName() + " function", 1, "argument", this.stopWatch());
        assertEquals(atom.getValue(), 4.41d);

    }
}
