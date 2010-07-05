package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ListFunctionTest extends TestCase {

    public void testEmptyList() {
        Function func = new ListFunction();
        Atom result = func.compute(new ArrayList<Operation>());
        assertEquals(((List) result.getValue()).size(), 0);
    }
}
