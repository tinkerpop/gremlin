package com.tinkerpop.gremlin.paths;

import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public interface Paths {

    public void addPath(Path path);

    public Path getPath(String name);

    public Set<String> getPathNames();

    public void addPaths(Paths paths);
}
