package com.tinkerpop.gremlin.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class CeilingFunctionTest extends BaseTest {

    public void testCeiling() {
        Function<Long> function = new CeilingFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        this.stopWatch();
        Atom<Long> atom = function.compute(createUnaryArgs(1.4), context);
        printPerformance(function.getFunctionName() + " function", 1, "argument", this.stopWatch());
        assertEquals(atom.getValue(), new Long(2));

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1.5), context);
        printPerformance(function.getFunctionName() + " function", 1, "argument", this.stopWatch());
        assertEquals(atom.getValue(), new Long(2));

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1), context);
        printPerformance(function.getFunctionName() + " function", 1, "argument", this.stopWatch());
        assertEquals(atom.getValue(), new Long(1));

    }
}

