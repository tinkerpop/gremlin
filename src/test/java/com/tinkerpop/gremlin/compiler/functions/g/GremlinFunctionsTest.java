package com.tinkerpop.gremlin.compiler.functions.g;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.functions.Functions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinFunctionsTest extends BaseTest {

    public void testForFunctionInclusion() throws Exception {
        Functions functions = new GremlinFunctions();
        for (Class clazz : getClasses(GremlinFunctions.class.getPackage().getName())) {
            if (Function.class.isAssignableFrom(clazz)) {
                assertNotNull(functions.getFunction(((Function) (clazz.getConstructor().newInstance())).getFunctionName()));
            }
        }
    }
}
