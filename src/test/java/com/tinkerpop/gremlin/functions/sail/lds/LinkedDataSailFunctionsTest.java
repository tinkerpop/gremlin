package com.tinkerpop.gremlin.functions.sail.lds;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.Functions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LinkedDataSailFunctionsTest extends BaseTest {

    public void testForFunctionInclusion() throws Exception {
        Functions functions = new LinkedDataSailFunctions();
        for (Class clazz : getClasses(LinkedDataSailFunctions.class.getPackage().getName())) {
            if (Function.class.isAssignableFrom(clazz)) {
                assertNotNull(functions.getFunction(((Function) (clazz.getConstructor().newInstance())).getFunctionName()));
            }
        }
    }
}
