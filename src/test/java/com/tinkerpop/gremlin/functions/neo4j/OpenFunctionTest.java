package com.tinkerpop.gremlin.functions.neo4j;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.GremlinScriptEngineFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OpenFunctionTest extends BaseTest {

    public void testOpenFunction() throws ScriptException {

        ScriptEngine engine = new GremlinScriptEngineFactory().getScriptEngine();
        System.out.println(engine.eval("neo4j:open('/tmp/test')"));
    }
}
