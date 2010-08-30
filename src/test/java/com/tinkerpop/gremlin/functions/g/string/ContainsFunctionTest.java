package com.tinkerpop.gremlin.functions.g.string;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ContainsFunctionTest extends BaseTest {

    public void testContains() {
        Function<Boolean> function = new ContainsFunction();
        this.stopWatch();
        GremlinScriptContext context = new GremlinScriptContext();
        Atom<Boolean> atom = function.compute(createUnaryArgs("marko", "rk"), context);
        printPerformance(function.getFunctionName() + " function", 1, "starts with check", this.stopWatch());
        assertTrue(atom.getValue());
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko", "pa"), context);
        printPerformance(function.getFunctionName() + " function", 1, "starts with check", this.stopWatch());
        assertFalse(atom.getValue());
    }
}