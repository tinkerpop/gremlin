package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ToJsonFunctionTest extends BaseTest {

    public void testToJsonPrimitive() {
        Function<String> function = new ToJsonFunction();
        GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        String json = function.compute(createUnaryArgs("marko"), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluations - primitive", this.stopWatch());
        assertEquals(json, "marko");
        this.stopWatch();
        json = function.compute(createUnaryArgs(1), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluations - primitive", this.stopWatch());
        assertEquals(json, "1");
        this.stopWatch();
        json = function.compute(createUnaryArgs(true), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluations - primitive", this.stopWatch());
        assertEquals(json, "true");
    }

    public void testToJsonList() {
        Function<String> function = new ToJsonFunction();
        GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        String json = function.compute(createUnaryArgs(Arrays.asList(1, 2, 3)), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluations - list", this.stopWatch());
        assertEquals(json, "[1,2,3]");
        this.stopWatch();
        json = function.compute(createUnaryArgs(Arrays.asList(1, 2, new HashMap())), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluations - list", this.stopWatch());
        assertEquals(json, "[1,2,{}]");
    }

    public void testToJsonMap() {
        Function<String> function = new ToJsonFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        Map map = new HashMap();
        map.put("marko", 1);
        map.put("josh", 2);
        map.put("peter", 3);


        this.stopWatch();
        String json = function.compute(createUnaryArgs(map), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluations - map", this.stopWatch());
        assertEquals(json, "{\"marko\":1,\"peter\":3,\"josh\":2}");

        map.put("josh", new HashMap());
        this.stopWatch();
        json = function.compute(createUnaryArgs(map), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluations - map", this.stopWatch());
        assertEquals(json, "{\"marko\":1,\"peter\":3,\"josh\":{}}");
    }
}
