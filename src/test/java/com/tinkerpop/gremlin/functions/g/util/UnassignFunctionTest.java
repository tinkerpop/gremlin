package com.tinkerpop.gremlin.functions.g.util;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.Variable;
import com.tinkerpop.gremlin.functions.Function;

import javax.script.ScriptContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class UnassignFunctionTest extends BaseTest {

    public void testUnassign() {
        Function<Object> function = new UnassignFunction();
        GremlinScriptContext context = new GremlinScriptContext();

        context.getBindings(ScriptContext.ENGINE_SCOPE).put("x", new Atom<Integer>(1));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put("y", new Atom<Integer>(2));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put("z", new Atom<Integer>(3));

        assertEquals(context.getBindings(ScriptContext.ENGINE_SCOPE).get("x"), 1);
        assertEquals(context.getBindings(ScriptContext.ENGINE_SCOPE).get("y"), 2);
        assertEquals(context.getBindings(ScriptContext.ENGINE_SCOPE).get("z"), 3);

        this.stopWatch();
        assertEquals(function.compute(createUnaryArgs(new Variable("x", context)), context).getValue(), 1);
        assertEquals(function.compute(createUnaryArgs(new Variable("y", context)), context).getValue(), 2);
        assertEquals(function.compute(createUnaryArgs(new Variable("z", context)), context).getValue(), 3);
        assertNull(function.compute(createUnaryArgs(new Variable("x", context)), context).getValue());
        printPerformance(function.getFunctionName() + " function", 4, "evaluation", this.stopWatch());
        assertNull(context.getBindings(ScriptContext.ENGINE_SCOPE).get("x"));
        assertNull(context.getBindings(ScriptContext.ENGINE_SCOPE).get("y"));
        assertNull(context.getBindings(ScriptContext.ENGINE_SCOPE).get("z"));
    }

    public void testUnassignMapListElement() {
        Map map = new HashMap();
        map.put("key", "value");
        List list = new ArrayList();
        list.add(0);
        Vertex vertex = TinkerGraphFactory.createTinkerGraph().getVertex(1);

        Function<Object> function = new UnassignFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        this.stopWatch();
        assertEquals(function.compute(createUnaryArgs(map, "key"), context).getValue(), "value");
        assertEquals(function.compute(createUnaryArgs(list, 0), context).getValue(), 0);
        assertEquals(function.compute(createUnaryArgs(vertex, "name"), context).getValue(), "marko");
        assertNull(function.compute(createUnaryArgs(vertex, "name"), context).getValue());
        printPerformance(function.getFunctionName() + " function", 3, "evaluations: map, list, element", this.stopWatch());

        assertNull(map.get("key"));
        assertEquals(list.size(), 0);
        assertNull(vertex.getProperty("name"));
    }
}