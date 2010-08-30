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
        context.getFunctionLibrary().loadFunctions("com.tinkerpop.gremlin.functions.PlayFunctions");
        assertNotNull(context.getFunctionLibrary().getFunction("play", "play-string"));
        assertEquals(context.getFunctionLibrary().getFunction("play", "play-string").compute(createUnaryArgs(), context).getValue(), "Goodbye.");
    }

    public void testFunctionsLoadingInlineNotWorking() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        try {
            evaluateGremlinScriptPrimitive("play:play-string()", context, true);
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }


    public void testFunctionsLoadingInlineWorking() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        assertTrue((Boolean) evaluateGremlinScriptPrimitive("include 'com.tinkerpop.gremlin.functions.PlayFunctions'", context, true));
        assertEquals(evaluateGremlinScriptPrimitive("play:play-string()", context, true), "Goodbye.");
    }


}
