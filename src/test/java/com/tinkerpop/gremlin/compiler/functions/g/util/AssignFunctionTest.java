package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.context.VariableLibrary;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AssignFunctionTest extends BaseTest {

    public void testAssign() {
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
}
