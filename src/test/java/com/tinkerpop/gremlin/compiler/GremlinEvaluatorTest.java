package com.tinkerpop.gremlin.compiler;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.context.VariableLibrary;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinEvaluatorTest extends BaseTest {

    public void testVariableHandling() {
        this.stopWatch();
        GremlinScriptContext context = new GremlinScriptContext();
        VariableLibrary variables = context.getVariableLibrary();
        
        variables.declare("w", new Atom<Double>(1.0d));
        variables.declare("x", new Atom(null));
        variables.declare("y", new Atom<String>("1"));
        variables.declare("z", new Atom<Boolean>(true));
        printPerformance("evaluator", 4, "variable declarations", this.stopWatch());

        this.stopWatch();
        assertEquals(variables.getVariableByName("w").getValue(), 1.0d);
        assertNull(variables.getVariableByName("x").getValue());
        assertEquals(variables.getVariableByName("y").getValue(), "1");
        assertTrue((Boolean) variables.getVariableByName("z").getValue());
        printPerformance("evaluator", 4, "variable gets", this.stopWatch());

        this.stopWatch();
        variables.free("w");
        variables.free("x");
        variables.free("y");
        variables.free("z");
        printPerformance("evaluator", 4, "variable undeclarations", this.stopWatch());
        assertNull(variables.getVariableByName("w").getValue());
        assertNull(variables.getVariableByName("x").getValue());
        assertNull(variables.getVariableByName("y").getValue());
        assertNull(variables.getVariableByName("z").getValue());
    }

}
