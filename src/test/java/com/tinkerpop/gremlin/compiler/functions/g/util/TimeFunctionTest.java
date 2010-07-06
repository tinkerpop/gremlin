package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TimeFunctionTest extends BaseTest {

    public void testBasicTimeAxioms() {
        Function function = new TimeFunction();
        this.stopWatch();
        double timeA = (Double) function.compute(new ArrayList<Operation>()).getValue();
        double timeB = (Double) function.compute(new ArrayList<Operation>()).getValue();
        printPerformance(function.getFunctionName() + " function", 2, "evaluations", this.stopWatch());
        assertTrue(timeB >= timeA);
    }
}
