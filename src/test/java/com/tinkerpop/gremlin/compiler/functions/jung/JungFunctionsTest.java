package com.tinkerpop.gremlin.compiler.functions.jung;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.functions.Functions;
import com.tinkerpop.gremlin.compiler.functions.g.GremlinFunctions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class JungFunctionsTest extends BaseTest {

    public void testForFunctionInclusion() throws Exception {
        Functions functions = new JungFunctions();
        for (Class clazz : getClasses(JungFunctions.class.getPackage().getName())) {
            if (Function.class.isAssignableFrom(clazz)) {
                assertNotNull(functions.getFunction(((Function) (clazz.getConstructor().newInstance())).getFunctionName()));
            }
        }
    }
}
