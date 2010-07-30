package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IntegerFunctionTest extends BaseTest {

    public void testInteger() {
        Function<Integer> function = new IntegerFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        
        this.stopWatch();
        Atom<Integer> atom = function.compute(createUnaryArgs("1.02"), context);
        printPerformance(function.getFunctionName() + " function", 1, "long parse", this.stopWatch());
        assertEquals(atom.getValue(), new Integer(1));

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1.0f), context);
        printPerformance(function.getFunctionName() + " function", 1, "long parse", this.stopWatch());
        assertEquals(atom.getValue(), new Integer(1));

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1l), context);
        printPerformance(function.getFunctionName() + " function", 1, "long parse", this.stopWatch());
        assertEquals(atom.getValue(), new Integer(1));
    }
}