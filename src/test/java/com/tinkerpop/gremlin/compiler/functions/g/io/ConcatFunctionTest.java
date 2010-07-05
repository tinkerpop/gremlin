package com.tinkerpop.gremlin.compiler.functions.g.io;

import com.tinkerpop.gremlin.TestHelper;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ConcatFunctionTest extends TestCase {

    public void testTwoStringConcat() {
        Function func = new ConcatFunction();
        Atom result = func.compute(TestHelper.createUnaryArgs("marko", "rodriguez"));
        assertEquals(result.getValue(), "markorodriguez");
    }
}
