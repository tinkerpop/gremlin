package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.paths.Path;
import com.tinkerpop.gremlin.paths.PathLibrary;
import com.tinkerpop.gremlin.paths.Paths;
import junit.framework.TestCase;

import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TestPaths extends TestCase implements Paths {

    PathLibrary library = new PathLibrary();

    public TestPaths() {
        this.addPath(new TestPathOne());
    }

    public void addPath(Path path) {
        library.addPath(path);
    }

    public void addPaths(Paths paths) {
        library.addPaths(paths);
    }

    public Set<String> getPathNames() {
        return library.getPathNames();
    }

    public Path getPath(String name) {
        return library.getPath(name);
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
