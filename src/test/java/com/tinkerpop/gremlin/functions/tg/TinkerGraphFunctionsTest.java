package com.tinkerpop.gremlin.functions.tg;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.Functions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TinkerGraphFunctionsTest extends BaseTest {

    public void testForFunctionInclusion() throws Exception {
        Functions functions = new TinkerGraphFunctions();
        for (Class clazz : getClasses(TinkerGraphFunctions.class.getPackage().getName())) {
            if (Function.class.isAssignableFrom(clazz)) {
                assertNotNull(functions.getFunction(((Function) (clazz.getConstructor().newInstance())).getFunctionName()));
            }
        }
    }
}
