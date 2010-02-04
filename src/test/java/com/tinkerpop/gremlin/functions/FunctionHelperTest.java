package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FunctionHelperTest extends TestCase {

    public void testAssertTypes() {
        Object[] objects = new Object[]{new String(), new Object(), new Integer(1)};

        assertTrue(FunctionHelper.assertTypes(objects, new Class[]{String.class, Object.class, Integer.class}));
        assertTrue(FunctionHelper.assertTypes(objects, new Class[]{Object.class, Object.class, Object.class}));
        assertFalse(FunctionHelper.assertTypes(objects, new Class[]{String.class, String.class, String.class}));
    }
}
