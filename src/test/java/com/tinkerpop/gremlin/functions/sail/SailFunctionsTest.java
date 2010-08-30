package com.tinkerpop.gremlin.functions.sail;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.Functions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SailFunctionsTest extends BaseTest {

    public void testForFunctionInclusion() throws Exception {
        Functions functions = new SailFunctions();
        for (Class clazz : getClasses(SailFunctions.class.getPackage().getName())) {
            if (Function.class.isAssignableFrom(clazz)) {
                assertNotNull(functions.getFunction(((Function) (clazz.getConstructor().newInstance())).getFunctionName()));
            }
        }
    }
}
