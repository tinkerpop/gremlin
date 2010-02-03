package com.tinkerpop.gremlin.model.paths;

import com.tinkerpop.gremlin.paths.Path;
import com.tinkerpop.gremlin.paths.Paths;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PropertyGraphPathLibrary implements Paths {

    Map<String, Path> paths = new HashMap<String, Path>();

    public PropertyGraphPathLibrary() {
        this.addPaths(new EdgePathLibrary());
    }

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
