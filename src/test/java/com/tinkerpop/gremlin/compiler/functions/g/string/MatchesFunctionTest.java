package com.tinkerpop.gremlin.compiler.functions.g.string;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class MatchesFunctionTest extends BaseTest {

    public void testMatches() {
        Function<Boolean> function = new MatchesFunction();
        this.stopWatch();
        GremlinScriptContext context = new GremlinScriptContext();
        Atom<Boolean> atom = function.compute(createUnaryArgs("marko",".*"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.getValue());
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko","[m][a][r][k][o]"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.getValue());
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko","pa"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertFalse(atom.getValue());
    }
}