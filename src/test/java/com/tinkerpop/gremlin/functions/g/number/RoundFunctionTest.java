package com.tinkerpop.gremlin.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RoundFunctionTest extends BaseTest {

    public void testRound() {
        Function<Long> function = new RoundFunction();
        this.stopWatch();
        GremlinScriptContext context = new GremlinScriptContext();
        Atom<Long> atom = function.compute(createUnaryArgs(1.4), context);
        printPerformance(function.getFunctionName() + " function", 1, "argument", this.stopWatch());
        assertEquals(atom.getValue(), new Long(1));

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1.5), context);
        printPerformance(function.getFunctionName() + " function", 1, "argument", this.stopWatch());
        assertEquals(atom.getValue(), new Long(2));

    }
}

