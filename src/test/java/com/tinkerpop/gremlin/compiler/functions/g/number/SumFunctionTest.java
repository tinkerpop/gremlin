package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.TestHelper;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SumFunctionTest extends BaseTest {

    public void testSumSimpleList() {
        Function function = new SumFunction();
        this.stopWatch();
        assertEquals(function.compute(TestHelper.createUnaryArgs(1.0, 2.0, 3.0, 4.0)).getValue(), 10.0d);
        printPerformance(function.getFunctionName() + " function", 4, "arguments", this.stopWatch());
    }

    public void testSumEmbeddedList() {
        Function function = new SumFunction();
        this.stopWatch();
        assertEquals(function.compute(TestHelper.createUnaryArgs(1.0, 2.0, Arrays.asList(new Atom<Double>(3.0), new Atom<Double>(4.0)))).getValue(), 10.0d);
        printPerformance(function.getFunctionName() + " function", 4, "arguments (with list embedding)", this.stopWatch());
    }
}
