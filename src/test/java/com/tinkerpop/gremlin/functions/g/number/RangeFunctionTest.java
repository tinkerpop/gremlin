package com.tinkerpop.gremlin.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.Function;

import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RangeFunctionTest extends BaseTest {

    public void testRange() {
        Function<Set> function = new RangeFunction();
        this.stopWatch();
        GremlinScriptContext context = new GremlinScriptContext();
        Atom<Set> atom = function.compute(createUnaryArgs(1, 4), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue().size(), 3);
        assertTrue(atom.getValue().contains(1));
        assertTrue(atom.getValue().contains(2));
        assertTrue(atom.getValue().contains(3));

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1, -1), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue().size(), 0);

    }
}

