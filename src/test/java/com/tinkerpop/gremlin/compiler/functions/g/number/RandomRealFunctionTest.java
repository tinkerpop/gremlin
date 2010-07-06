package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RandomRealFunctionTest extends TestCase {

    public void testRangeOfReal() {
        Function function = new RandomRealFunction();
        Atom atom = function.compute(new ArrayList<Operation>());
        assertTrue(atom.isNumber());
        Double real = (Double) atom.getValue();
        assertTrue(real < 1.000001d);
        assertTrue(real > -0.000001d);
    }
}
