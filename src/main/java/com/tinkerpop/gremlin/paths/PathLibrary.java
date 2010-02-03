package com.tinkerpop.gremlin.paths;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PathLibrary implements Paths {

    Map<String, Path> paths = new HashMap<String, Path>();

    public void addPath(Path path) {
        paths.put(path.getPathName(), path);
    }

    public Path getPath(String name) {
        return paths.get(name);
    }

    public Set<String> getPathNames() {
        return paths.keySet();
    }

    public void addPaths(Paths paths) {
        for (String name : paths.getPathNames()) {
            this.paths.put(name, paths.getPath(name));
        }
    }
}
