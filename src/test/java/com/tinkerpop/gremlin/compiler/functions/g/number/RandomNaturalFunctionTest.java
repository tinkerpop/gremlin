package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.ArrayList;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RandomNaturalFunctionTest extends BaseTest {

    public void testRandomNatural() {
        Function<Integer> function = new RandomNaturalFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        this.stopWatch();
        Atom<Integer> atom = function.compute(new ArrayList<Operation>(), context);
        printPerformance(function.getFunctionName() + " function", 1, "random generation", this.stopWatch());
        assertTrue(atom.isNumber());
        assertTrue(atom.isInteger());
        Integer natural = atom.getValue();
        assertTrue(natural >= 0 || natural <= Integer.MAX_VALUE);
    }

    public void testRandomNaturalWithCap() {
        Function<Integer> function = new RandomNaturalFunction();
        GremlinScriptContext context = new GremlinScriptContext();
        this.stopWatch();
        Atom<Integer> atom = function.compute(createUnaryArgs(10l), context);
        printPerformance(function.getFunctionName() + " function", 1, "random generation with cap", this.stopWatch());
        assertTrue(atom.isNumber());
        assertTrue(atom.isInteger());
        Integer natural = atom.getValue();
        assertTrue(natural >= 0 && natural < 10);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(10.0), context);
        printPerformance(function.getFunctionName() + " function", 1, "random generation with cap", this.stopWatch());
        assertTrue(atom.isNumber());
        assertTrue(atom.isInteger());
        natural = atom.getValue();
        assertTrue(natural >= 0 && natural < 10);
    }
}