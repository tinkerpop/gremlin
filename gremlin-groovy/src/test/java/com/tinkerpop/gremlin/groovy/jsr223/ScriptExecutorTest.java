package com.tinkerpop.gremlin.groovy.jsr223;

import junit.framework.TestCase;

import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ScriptExecutorTest extends TestCase {

    public void testArguments() {
        ScriptExecutor.evaluate(new InputStreamReader(ScriptExecutorTest.class.getResourceAsStream("GremlinScript.groovy")), Arrays.asList("1", "2", "3"));
    }
}
