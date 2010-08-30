package com.tinkerpop.gremlin.functions.g.util;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PathFunctionTest extends BaseTest {

    public void testPath() {
        Function<Boolean> function = new PathFunction();
        this.stopWatch();
        GremlinScriptContext context = new GremlinScriptContext();
        
        assertTrue(function.compute(createUnaryArgs(), context).getValue());
        assertTrue(function.compute(createUnaryArgs(1), context).getValue());
        assertTrue(function.compute(createUnaryArgs(null), context).getValue());
        assertTrue(function.compute(createUnaryArgs("marko"), context).getValue());
        assertTrue(function.compute(createUnaryArgs(22.0, "pavel", true), context).getValue());
        printPerformance(function.getFunctionName() + " function", 5, "evaluations", this.stopWatch());
    }
}
