package com.tinkerpop.gremlin.compiler.functions.sail;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.functions.Functions;
import com.tinkerpop.gremlin.compiler.functions.jung.JungFunctions;

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
