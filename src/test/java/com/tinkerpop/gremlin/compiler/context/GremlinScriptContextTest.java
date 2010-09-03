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

}
