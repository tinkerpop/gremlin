package com.tinkerpop.gremlin.functions.sail.neo4jsail;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.Functions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Neo4jSailFunctionsTest extends BaseTest {

    public void testForFunctionInclusion() throws Exception {
        Functions functions = new Neo4jSailFunctions();
        for (Class clazz : getClasses(Neo4jSailFunctions.class.getPackage().getName())) {
            if (Function.class.isAssignableFrom(clazz)) {
                assertNotNull(functions.getFunction(((Function) (clazz.getConstructor().newInstance())).getFunctionName()));
            }
        }
    }
}
