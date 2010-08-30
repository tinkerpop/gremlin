package com.tinkerpop.gremlin.functions.g.util;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.context.VariableLibrary;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.Var;

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
        VariableLibrary variables = context.getVariableLibrary();

        variables.putAtom("x", new Atom<Integer>(1));
        variables.putAtom("y", new Atom<Integer>(2));
        variables.putAtom("z", new Atom<Integer>(3));

        assertEquals(context.getVariableByName("x").getValue(), 1);
        assertEquals(context.getVariableByName("y").getValue(), 2);
        assertEquals(context.getVariableByName("z").getValue(), 3);

        this.stopWatch();
        assertEquals(function.compute(createUnaryArgs(new Var("x", context)), context).getValue(), 1);
        assertEquals(function.compute(createUnaryArgs(new Var("y", context)), context).getValue(), 2);
        assertEquals(function.compute(createUnaryArgs(new Var("z", context)), context).getValue(), 3);
        assertNull(function.compute(createUnaryArgs(new Var("x", context)), context).getValue());
        printPerformance(function.getFunctionName() + " function", 4, "evaluation", this.stopWatch());
        assertNull(context.getVariableByName("x").getValue());
        assertNull(context.getVariableByName("y").getValue());
        assertNull(context.getVariableByName("z").getValue());
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