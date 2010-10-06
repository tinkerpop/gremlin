package com.tinkerpop.gremlin.functions.g.ime;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.Function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AppendFunctionTest extends BaseTest {

    public void testAppendList() {
        GremlinScriptContext context = new GremlinScriptContext();

        Function<Collection> function = new AppendFunction();
        this.stopWatch();
        List list = new ArrayList();
        list.add(1.0d);
        list.add(2.0d);
        Atom<Collection> atom = function.compute(createUnaryArgs(list, 3.0d, 4.0d), context);
        printPerformance(function.getFunctionName() + " function", 3, "arguments", this.stopWatch());
        list = asList(atom.getValue());
        assertEquals(list.size(), 4);

        assertTrue(list.contains(1.0d));
        assertTrue(list.contains(2.0d));
        assertTrue(list.contains(3.0d));
        assertTrue(list.contains(4.0d));

        function = new AppendFunction();
        this.stopWatch();
        atom = function.compute(createUnaryArgs(new HashSet(), 1.0d, 2.0d), context);
        printPerformance(function.getFunctionName() + " function", 4, "arguments", this.stopWatch());
        list = asList(atom.getValue());
        assertEquals(list.size(), 2);
        assertTrue(list.contains(1.0d));
        assertTrue(list.contains(2.0d));

    }

    public void testAppendInline() throws Exception {
        List results = (List) evaluateGremlinScriptPrimitive("g:append(g:list(1,2,3),4)", true);
        assertEquals(results.size(), 4);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 2);
        assertEquals(results.get(2), 3);
        assertEquals(results.get(3), 4);
    }
}
