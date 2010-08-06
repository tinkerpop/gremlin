package com.tinkerpop.gremlin.compiler.functions.g.string;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ReplaceFunctionTest extends BaseTest {

    public void testReplaceSpace() {
        Function<String> function = new ReplaceFunction();
        this.stopWatch();
        GremlinScriptContext context = new GremlinScriptContext();
        Atom<String> atom = function.compute(createUnaryArgs("marko",".", "a"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "aaaaa");
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko","[m][a]", "z"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertEquals(atom.getValue(), "zrko");
    }
}