package com.tinkerpop.gremlin.compiler.functions;

import com.tinkerpop.gremlin.compiler.functions.g.lme.ListFunction;
import com.tinkerpop.gremlin.compiler.functions.g.lme.MapFunction;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AbstractFunctionsTest extends TestCase {

    public void testFunctionRetrieval() {
        Functions testFunctions = new AbstractFunctions() {
            public String getNamespace() {
                return "test";
            }
        };
        assertEquals(testFunctions.getNamespace(), "test");
        testFunctions.addFunction(new MapFunction());
        testFunctions.addFunction(new ListFunction());
        assertEquals(testFunctions.getFunction("map").getClass(), MapFunction.class);
        assertEquals(testFunctions.getFunction("list").getClass(), ListFunction.class);
        try {
            testFunctions.getFunction("blah");
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

}
