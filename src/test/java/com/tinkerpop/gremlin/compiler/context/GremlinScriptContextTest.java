package com.tinkerpop.gremlin.compiler.context;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinScriptContextTest extends BaseTest {

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
        assertEquals(context.getVariableByName("w").getValue(), 1.0d);
        assertNull(context.getVariableByName("x").getValue());
        assertEquals(context.getVariableByName("y").getValue(), "1");
        assertTrue((Boolean) context.getVariableByName("z").getValue());
        printPerformance("evaluator", 4, "variable gets", this.stopWatch());

        this.stopWatch();
        variables.free("w");
        variables.free("x");
        variables.free("y");
        variables.free("z");
        printPerformance("evaluator", 4, "variable undeclarations", this.stopWatch());
        assertNull(context.getVariableByName("w").getValue());
        assertNull(context.getVariableByName("x").getValue());
        assertNull(context.getVariableByName("y").getValue());
        assertNull(context.getVariableByName("z").getValue());
    }

}
