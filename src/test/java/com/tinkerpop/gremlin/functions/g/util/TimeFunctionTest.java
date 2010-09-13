package com.tinkerpop.gremlin.functions.g.util;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.functions.Function;

import java.util.ArrayList;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TimeFunctionTest extends BaseTest {

    public void testBasicTimeAxioms() {
        Function function = new TimeFunction();
        this.stopWatch();
        GremlinScriptContext context = new GremlinScriptContext();

        double timeA = (Double) function.compute(new ArrayList<Operation>(), context).getValue();
        double timeB = (Double) function.compute(new ArrayList<Operation>(), context).getValue();
        printPerformance(function.getFunctionName() + " function", 2, "evaluations", this.stopWatch());
        assertTrue(timeB >= timeA);
    }
}
