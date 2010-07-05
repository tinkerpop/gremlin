package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.TestHelper;
import com.tinkerpop.gremlin.compiler.functions.Function;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class CountFunctionTest extends TestCase {

    public void testCountSingleValue() {
        Function func = new CountFunction();
        assertEquals(func.compute(TestHelper.createUnaryArgs(1)).getValue(), 1l);
    }

    public void testCountListOfValues() {
        Function func = new CountFunction();
        assertEquals(func.compute(TestHelper.createUnaryArgs(Arrays.asList(1, 2, 3, 4, 5, 6))).getValue(), 6l);
    }
}
