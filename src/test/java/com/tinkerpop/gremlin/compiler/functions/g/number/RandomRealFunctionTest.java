package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.ArrayList;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RandomRealFunctionTest extends BaseTest {

    public void testRangeOfReal() {
        Function<Double> function = new RandomRealFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        this.stopWatch();
        Atom<Double> atom = function.compute(new ArrayList<Operation>(), context);
        printPerformance(function.getFunctionName() + " function", 1, "random generation", this.stopWatch());
        assertTrue(atom.isNumber());
        Double real = atom.getValue();
        assertTrue(real < 1.000001d);
        assertTrue(real > -0.000001d);
    }
}
