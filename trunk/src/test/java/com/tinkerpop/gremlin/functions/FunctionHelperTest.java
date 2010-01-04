package com.tinkerpop.gremlin.functions;

import junit.framework.TestCase;
import com.tinkerpop.gremlin.FunctionHelper;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class FunctionHelperTest extends TestCase {

    public void testAssertTypes() {
        Object[] objects = new Object[]{new String(), new Object(), new Integer(1)};

        assertTrue(FunctionHelper.assertTypes(objects, new Class[]{String.class, Object.class, Integer.class}));
        assertTrue(FunctionHelper.assertTypes(objects, new Class[]{Object.class, Object.class, Object.class}));
        assertFalse(FunctionHelper.assertTypes(objects, new Class[]{String.class, String.class, String.class}));
    }
}
