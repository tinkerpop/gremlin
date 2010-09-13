package com.tinkerpop.gremlin.functions.g.util;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TypeFunctionTest extends BaseTest {

    public void testType() {
        Function<String> function = new TypeFunction();
        this.stopWatch();

        GremlinScriptContext context = new GremlinScriptContext();

        String type = function.compute(createUnaryArgs("marko"), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(type, "string");

        this.stopWatch();
        type = function.compute(createUnaryArgs(true), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(type, "boolean");

        this.stopWatch();
        type = function.compute(createUnaryArgs(1.0f), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(type, "float");

        this.stopWatch();
        type = function.compute(createUnaryArgs(1), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(type, "integer");

        this.stopWatch();
        type = function.compute(createUnaryArgs(1.0d), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(type, "double");

        this.stopWatch();
        type = function.compute(createUnaryArgs(1l), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(type, "long");
    }
}
