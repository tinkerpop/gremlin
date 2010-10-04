package com.tinkerpop.gremlin.compiler.context;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.types.Atom;

import javax.script.ScriptContext;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinScriptContextTest extends BaseTest {

    public void testVariableHandling() {
        this.stopWatch();
        GremlinScriptContext context = new GremlinScriptContext();


        context.getBindings(ScriptContext.ENGINE_SCOPE).put("w", new Atom<Double>(1.0d));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put("x", new Atom(null));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put("y", new Atom<String>("1"));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put("z", new Atom<Boolean>(true));
        printPerformance("evaluator", 4, "variable declarations", this.stopWatch());

        this.stopWatch();
        assertEquals(context.getBindings(ScriptContext.ENGINE_SCOPE).get("w"), 1.0d);
        assertNull(context.getBindings(ScriptContext.ENGINE_SCOPE).get("x"));
        assertEquals(context.getBindings(ScriptContext.ENGINE_SCOPE).get("y"), "1");
        assertTrue((Boolean) context.getBindings(ScriptContext.ENGINE_SCOPE).get("z"));
        printPerformance("evaluator", 4, "variable gets", this.stopWatch());

        this.stopWatch();
        context.getBindings(ScriptContext.ENGINE_SCOPE).remove("w");
        context.getBindings(ScriptContext.ENGINE_SCOPE).remove("x");
        context.getBindings(ScriptContext.ENGINE_SCOPE).remove("y");
        context.getBindings(ScriptContext.ENGINE_SCOPE).remove("z");
        printPerformance("evaluator", 4, "variable undeclarations", this.stopWatch());
        assertNull(context.getBindings(ScriptContext.ENGINE_SCOPE).get("w"));
        assertNull(context.getBindings(ScriptContext.ENGINE_SCOPE).get("x"));
        assertNull(context.getBindings(ScriptContext.ENGINE_SCOPE).get("y"));
        assertNull(context.getBindings(ScriptContext.ENGINE_SCOPE).get("z"));
    }

    public void testFunctionsLoading() {
        GremlinScriptContext context = new GremlinScriptContext();
        try {
            context.getFunctionLibrary().getFunction("play", "play");
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }
        context.loadLibrary("com.tinkerpop.gremlin.functions.PlayFunctions");
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

    public void testStepsLoading() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        try {
            context.getStepLibrary().getStep("play-string");
//            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }
        context.loadLibrary("com.tinkerpop.gremlin.steps.PlaySteps");
        assertNotNull(context.getStepLibrary().getStep("play-string"));
        assertEquals(evaluateGremlinScriptPrimitive("'a'/play-string", context, true), "aa");
    }

    public void testStepsLoadingInlineNotWorking() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        try {
            evaluateGremlinScriptPrimitive("'a'/play-string", context, true);
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    // TODO: NEED TO CONNECT TO LOADLIBRARY()
    /*public void testStepsLoadingInlineWorking() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        assertTrue((Boolean) evaluateGremlinScriptPrimitive("include 'com.tinkerpop.gremlin.steps.PlaySteps'", context, true));
        assertEquals(evaluateGremlinScriptPrimitive("'a'/play-string", context, true), "aa");
    }*/


}
