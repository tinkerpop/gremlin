package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FloatFunctionTest extends BaseTest {

    public void testFloat() {
        Function<Float> function = new FloatFunction();
        this.stopWatch();
        Atom<Float> atom = function.compute(createUnaryArgs("1.2"));
        printPerformance(function.getFunctionName() + " function", 1, "float parse", this.stopWatch());
        assertEquals(atom.getValue(), 1.2f);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1.0f));
        printPerformance(function.getFunctionName() + " function", 1, "float parse", this.stopWatch());
        assertEquals(atom.getValue(), 1.0f);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1l));
        printPerformance(function.getFunctionName() + " function", 1, "float parse", this.stopWatch());
        assertEquals(atom.getValue(), 1.0f);
    }
}