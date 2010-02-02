package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.paths.PathLibrary;
import com.tinkerpop.gremlin.paths.Path;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TestPaths extends TestCase {

    public TestPaths() {
        //this.addPath(new TestPathOne());
    }

    private class TestPathOne implements Path {
        public String getPathName() {
            return "test-path-1";
        }

        public Object invoke(Object root) {
            return "undercover cop";
        }
    }

    public void testTrue() {
        assertTrue(true);
    }

}
