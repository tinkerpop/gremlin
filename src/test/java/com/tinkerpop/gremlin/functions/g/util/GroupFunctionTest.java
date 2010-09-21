package com.tinkerpop.gremlin.functions.g.util;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.Function;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GroupFunctionTest extends BaseTest {

    public void testGroup() {
        Function<List> function = new GroupFunction();
        Atom<List> atom = function.compute(createUnaryArgs(Arrays.asList(1, 2, 3)), new GremlinScriptContext());
        assertEquals(atom.getValue().get(0), 1);
        assertEquals(atom.getValue().get(1), 2);
        assertEquals(atom.getValue().get(2), 3);
    }

}
