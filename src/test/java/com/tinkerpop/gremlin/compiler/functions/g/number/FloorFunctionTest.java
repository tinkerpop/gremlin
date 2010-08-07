package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FloorFunctionTest extends BaseTest {

    public void testFloor() {
        Function<Long> function = new FloorFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        this.stopWatch();
        Atom<Long> atom = function.compute(createUnaryArgs(1.4), context);
        printPerformance(function.getFunctionName() + " function", 1, "argument", this.stopWatch());
        assertEquals(atom.getValue(), new Long(1));

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1.5), context);
        printPerformance(function.getFunctionName() + " function", 1, "argument", this.stopWatch());
        assertEquals(atom.getValue(), new Long(1));

        this.stopWatch();
        atom = function.compute(createUnaryArgs(1), context);
        printPerformance(function.getFunctionName() + " function", 1, "argument", this.stopWatch());
        assertEquals(atom.getValue(), new Long(1));

    }
}

