package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinScriptContextTest extends BaseTest {

    public void testFunctionsLoading() {
        GremlinScriptContext context = new GremlinScriptContext();
        try {
            context.getFunctionLibrary().getFunction("play", "play");
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }
        context.getFunctionLibrary().loadFunctions("com.tinkerpop.gremlin.compiler.functions.PlayFunctions");
        assertNotNull(context.getFunctionLibrary().getFunction("play", "play"));
        assertEquals(context.getFunctionLibrary().getFunction("play", "play").compute(createUnaryArgs(), context).getValue(), "Goodbye.");
    }

    public void testFunctionsLoadingWithEngineNotWorking() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        try {
            evaluateGremlinScriptPrimitive("play:play()", context, true);
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }


    public void testFunctionsLoadingWithEngineWorking() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        assertTrue((Boolean) evaluateGremlinScriptPrimitive("include 'com.tinkerpop.gremlin.compiler.functions.PlayFunctions'", context, true));
        assertEquals(evaluateGremlinScriptPrimitive("play:play()", context, true), "Goodbye.");
    }


}
