package com.tinkerpop.gremlin.compiler.functions.g.string;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class MatchesFunctionTest extends BaseTest {

    public void testNormalizeSpace() {
        Function<Boolean> function = new MatchesFunction();
        this.stopWatch();
        Atom<Boolean> atom = function.compute(createUnaryArgs("marko",".*"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.getValue());
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko","[m][a][r][k][o]"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.getValue());
        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko","pa"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertFalse(atom.getValue());
    }
}