package com.tinkerpop.gremlin.functions.orientdb;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.Functions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OrientDBFunctionsTest extends BaseTest {

    public void testForFunctionInclusion() throws Exception {
        Functions functions = new OrientDBFunctions();
        for (Class clazz : getClasses(OrientDBFunctions.class.getPackage().getName())) {
            if (Function.class.isAssignableFrom(clazz)) {
                assertNotNull(functions.getFunction(((Function) (clazz.getConstructor().newInstance())).getFunctionName()));
            }
        }
    }
}
