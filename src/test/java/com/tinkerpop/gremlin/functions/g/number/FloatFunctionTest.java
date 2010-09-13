package com.tinkerpop.gremlin.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FloatFunctionTest extends BaseTest {

    public void testFloat() {
        Function<Float> function = new FloatFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        this.stopWatch();
        Atom<Float> atom = function.compute(createUnaryArgs("1.2"), context);
        printPerformance(function.getFunctionName() + " function", 1, "float parse", this.stopWatch());
        assertEquals(atom.getValue(), 1.2f);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1.0f), context);
        printPerformance(function.getFunctionName() + " function", 1, "float parse", this.stopWatch());
        assertEquals(atom.getValue(), 1.0f);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1l), context);
        printPerformance(function.getFunctionName() + " function", 1, "float parse", this.stopWatch());
        assertEquals(atom.getValue(), 1.0f);
    }
}