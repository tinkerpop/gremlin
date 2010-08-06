package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
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
public class AssignFunctionTest extends BaseTest {

    public void testAssignVariable() {
        Function<Boolean> function = new AssignFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        this.stopWatch();
        assertTrue(function.compute(createUnaryArgs("x", 1), context).getValue());
        assertTrue(function.compute(createUnaryArgs("y", 2), context).getValue());
        assertTrue(function.compute(createUnaryArgs("z", 3), context).getValue());
        assertTrue(function.compute(createUnaryArgs("x", 4), context).getValue());
        printPerformance(function.getFunctionName() + " function", 4, "evaluation", this.stopWatch());

        final VariableLibrary variables = context.getVariableLibrary();

        assertEquals(variables.getVariableByName("x").getValue(), 4);
        assertEquals(variables.getVariableByName("y").getValue(), 2);
        assertEquals(variables.getVariableByName("z").getValue(), 3);

    }

    public void testAssignListMapElement() {
        Map map = new HashMap();
        List list = new ArrayList();
        list.add(0);
        Vertex vertex = TinkerGraphFactory.createTinkerGraph().getVertex(1);

        Function<Boolean> function = new AssignFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        this.stopWatch();
        assertTrue(function.compute(createUnaryArgs(map, "key", "value"), context).getValue());
        assertTrue(function.compute(createUnaryArgs(list, 0, "value"), context).getValue());
        assertTrue(function.compute(createUnaryArgs(vertex, "name", "marko2"), context).getValue());
        printPerformance(function.getFunctionName() + " function", 3, "evaluations: map, list, element", this.stopWatch());

        assertEquals(map.get("key"), "value");
        assertEquals(list.get(0), "value");
        assertEquals(vertex.getProperty("name"), "marko2");


    }
}
