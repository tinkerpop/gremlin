package com.tinkerpop.gremlin.functions.g.util;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.Function;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FromJsonFunctionTest extends BaseTest {

    public void testFromJsonPrimitive() {

        GremlinScriptContext context = new GremlinScriptContext();
        Function<Object> function = new FromJsonFunction();

        this.stopWatch();
        Object object = function.compute(createUnaryArgs("1"), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluations - primitive", this.stopWatch());
        assertEquals(object, 1l);

        this.stopWatch();
        object = function.compute(createUnaryArgs("1.234"), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluations - primitive", this.stopWatch());
        assertEquals(object, 1.234d);

        this.stopWatch();
        object = function.compute(createUnaryArgs("true"), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluations - primitive", this.stopWatch());
        assertTrue((Boolean) object);

        this.stopWatch();
        object = function.compute(createUnaryArgs("\"null\""), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluations - primitive", this.stopWatch());
        assertNull(object);

        /*this.stopWatch();
        object = function.compute(createUnaryArgs("\"marko\""), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluations - primitive", this.stopWatch());
        assertEquals(object, "marko");*/

    }

    public void testFromJsonList() {

        GremlinScriptContext context = new GremlinScriptContext();
        Function<Object> function = new FromJsonFunction();

        this.stopWatch();
        Object object = function.compute(createUnaryArgs("[1,2.0,true,4,\"marko\"]"), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluations - list", this.stopWatch());

        assertTrue(object instanceof List);
        assertEquals(((List) object).get(0), 1l);
        assertEquals(((List) object).get(1), 2.0d);
        assertEquals(((List) object).get(2), true);
        assertEquals(((List) object).get(3), 4l);
        assertEquals(((List) object).get(4), "marko");
    }


    public void testFromJsonMap() {

        GremlinScriptContext context = new GremlinScriptContext();
        Function<Object> function = new FromJsonFunction();

        this.stopWatch();
        Object object = function.compute(createUnaryArgs("{\"key1\":[1,2.0,true], \"key2\":\"marko\"}"), context).getValue();
        printPerformance(function.getFunctionName() + " function", 1, "evaluations - map", this.stopWatch());
        assertTrue(object instanceof Map);
        Map map = (Map) object;
        List array = (List) map.get("key1");
        assertEquals(array.get(0), 1l);
        assertEquals(array.get(1), 2.0d);
        assertEquals(array.get(2), true);
        assertEquals(map.get("key2"), "marko");
    }


}
