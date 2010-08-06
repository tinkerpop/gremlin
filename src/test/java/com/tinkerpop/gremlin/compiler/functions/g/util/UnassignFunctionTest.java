package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.context.VariableLibrary;
import com.tinkerpop.gremlin.compiler.functions.Function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class UnassignFunctionTest extends BaseTest {

    public void testUnassign() {
        Function<Boolean> function = new UnassignFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        VariableLibrary variables = context.getVariableLibrary();
        
        variables.declare("x", new Atom<Integer>(1));
        variables.declare("y", new Atom<Integer>(2));
        variables.declare("z", new Atom<Integer>(3));

        assertEquals(variables.getVariableByName("x").getValue(), 1);
        assertEquals(variables.getVariableByName("y").getValue(), 2);
        assertEquals(variables.getVariableByName("z").getValue(), 3);

        this.stopWatch();
        assertTrue(function.compute(createUnaryArgs("x"), context).getValue());
        assertTrue(function.compute(createUnaryArgs("y"), context).getValue());
        assertTrue(function.compute(createUnaryArgs("z"), context).getValue());
        assertTrue(function.compute(createUnaryArgs("x"), context).getValue());
        printPerformance(function.getFunctionName() + " function", 4, "evaluation", this.stopWatch());
        assertNull(variables.getVariableByName("x").getValue());
        assertNull(variables.getVariableByName("y").getValue());
        assertNull(variables.getVariableByName("z").getValue());
    }

     public void testUnassignMapListElement() {
        Map map = new HashMap();
        map.put("key","value");
        List list = new ArrayList();
        list.add(0);
        Vertex vertex = TinkerGraphFactory.createTinkerGraph().getVertex(1);

        Function<Boolean> function = new UnassignFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        this.stopWatch();
        assertTrue(function.compute(createUnaryArgs(map, "key"), context).getValue());
        assertTrue(function.compute(createUnaryArgs(list, 0), context).getValue());
        assertTrue(function.compute(createUnaryArgs(vertex, "name"), context).getValue());
        printPerformance(function.getFunctionName() + " function", 3, "evaluations: map, list, element", this.stopWatch());

        assertNull(map.get("key"));
        assertEquals(list.size(),0);
        assertNull(vertex.getProperty("name"));
    }
}