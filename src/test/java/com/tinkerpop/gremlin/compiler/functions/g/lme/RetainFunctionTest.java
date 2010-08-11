package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RetainFunctionTest extends BaseTest {

    public void testRetain() {
        GremlinScriptContext context = new GremlinScriptContext();
        
        Function<Boolean> function = new RetainFunction();
        List list = Arrays.asList("pavel", 23);
        assertTrue(list.contains("pavel"));

        this.stopWatch();
        context.setCurrentPoint(list);
        Atom<Boolean> atom = function.compute(createUnaryArgs("pavel"), context);
        printPerformance(function.getFunctionName() + " function", 1, "list check", this.stopWatch());
        assertTrue(atom.getValue());

        this.stopWatch();
        context.setCurrentPoint("pavel");
        atom = function.compute(createUnaryArgs("pavel"), context);
        printPerformance(function.getFunctionName() + " function", 1, "single object check", this.stopWatch());
        assertTrue(atom.getValue());

        this.stopWatch();
        context.setCurrentPoint(list);
        atom = function.compute(createUnaryArgs("marko"), context);
        printPerformance(function.getFunctionName() + " function", 1, "list check", this.stopWatch());
        assertFalse(atom.getValue());


    }
}
