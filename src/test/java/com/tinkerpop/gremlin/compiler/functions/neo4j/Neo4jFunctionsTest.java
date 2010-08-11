package com.tinkerpop.gremlin.compiler.functions.neo4j;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.functions.Functions;
import com.tinkerpop.gremlin.compiler.functions.jung.JungFunctions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Neo4jFunctionsTest extends BaseTest {

    public void testForFunctionInclusion() throws Exception {
        Functions functions = new Neo4jFunctions();
        for (Class clazz : getClasses(Neo4jFunctions.class.getPackage().getName())) {
            if (Function.class.isAssignableFrom(clazz)) {
                assertNotNull(functions.getFunction(((Function) (clazz.getConstructor().newInstance())).getFunctionName()));
            }
        }
    }
}
