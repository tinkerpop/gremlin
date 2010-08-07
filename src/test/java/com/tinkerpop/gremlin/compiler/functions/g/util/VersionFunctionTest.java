package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class VersionFunctionTest extends BaseTest {

    public void testType() {
        Function<String> function = new VersionFunction();
        this.stopWatch();

        GremlinScriptContext context = new GremlinScriptContext();

        String version = function.compute(createUnaryArgs(), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(version.endsWith(Tokens.VERSION));
    }
}