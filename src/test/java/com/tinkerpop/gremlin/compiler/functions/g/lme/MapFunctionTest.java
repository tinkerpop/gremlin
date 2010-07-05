package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.TestHelper;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class MapFunctionTest extends TestCase {

    public void testEmptyMap() {
        Function func = new MapFunction();
        Atom result = func.compute(new ArrayList<Operation>());
        assertEquals(((Map) result.getValue()).size(), 0);
    }

    public void testArgumentSizeErrorMap() {
        Function func = new MapFunction();
        try {
            func.compute(TestHelper.createUnaryArgs("key1"));
            assertFalse(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testTwoEntryMap() {
        Function func = new MapFunction();
        Atom result = func.compute(TestHelper.createUnaryArgs("key1", "value1", "key2", 2));
        assertEquals(((Map) result.getValue()).size(), 2);
        assertEquals(((Map<Atom, Atom>) result.getValue()).get(new Atom("key1")).getValue(), "value1");
        assertEquals(((Map<Atom, Atom>) result.getValue()).get(new Atom("key2")).getValue(), 2);

    }
}
