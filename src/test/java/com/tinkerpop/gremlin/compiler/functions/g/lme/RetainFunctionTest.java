package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RetainFunctionTest extends BaseTest {

    public void testRetain() {
        Function<Boolean> function = new RetainFunction();
        List<Atom> list = Arrays.asList(new Atom("pavel"), new Atom(23));
        assertTrue(list.contains(new Atom("pavel")));

        this.stopWatch();
        Atom<Boolean> atom = function.compute(createUnaryArgs("pavel", list));
        printPerformance(function.getFunctionName() + " function", 1, "list check", this.stopWatch());
        assertTrue(atom.getValue());

        this.stopWatch();
        atom = function.compute(createUnaryArgs("pavel", "pavel"));
        printPerformance(function.getFunctionName() + " function", 1, "single object check", this.stopWatch());
        assertTrue(atom.getValue());

        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko", list));
        printPerformance(function.getFunctionName() + " function", 1, "list check", this.stopWatch());
        assertFalse(atom.getValue());


    }
}
