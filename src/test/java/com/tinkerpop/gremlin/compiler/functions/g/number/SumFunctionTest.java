package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.TestHelper;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SumFunctionTest extends TestCase {

    public void testSumSimpleList() {
        Function function = new SumFunction();
        assertEquals(function.compute(TestHelper.createUnaryArgs(1.0, 2.0, 3.0, 4.0)).getValue(), 10.0d);
    }

    public void testSumEmbeddedList() {
        Function function = new SumFunction();
        assertEquals(function.compute(TestHelper.createUnaryArgs(1.0, 2.0, Arrays.asList(new Atom(3.0), new Atom(4.0)))).getValue(), 10.0d);
    }
}
