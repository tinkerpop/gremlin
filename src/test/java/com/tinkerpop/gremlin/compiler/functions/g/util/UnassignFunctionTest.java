package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.context.VariableLibrary;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class UnassignFunctionTest extends BaseTest {

    public void testAssign() {
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
}