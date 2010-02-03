package com.tinkerpop.gremlin.model.paths;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.paths.Path;
import com.tinkerpop.gremlin.paths.Paths;
import com.tinkerpop.gremlin.paths.handlers.ObjectPropertyHandler;
import com.tinkerpop.gremlin.statements.Tokens;
import org.apache.commons.jxpath.JXPathIntrospector;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class EdgePathLibrary implements Paths {

    Map<String, Path> paths = new HashMap<String, Path>();

    public EdgePathLibrary() {
        this.addPath(new OutVertexPath());
        this.addPath(new InVertexPath());
        this.addPath(new BothVerticesPath());
        this.addPath(new LabelPath());
        JXPathIntrospector.registerDynamicClass(Edge.class, ObjectPropertyHandler.class);

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

    private class OutVertexPath implements Path {
        public String getPathName() {
            return Tokens.OUT_VERTEX;
        }

        public Object invoke(Object root) {
            if (root instanceof Edge) {
                Edge edge = (Edge) root;
                return edge.getOutVertex();
            } else {
                return null;
            }
        }
    }

    private class InVertexPath implements Path {
        public String getPathName() {
            return Tokens.IN_VERTEX;
        }

        public Object invoke(Object root) {
            if (root instanceof Edge) {
                Edge edge = (Edge) root;
                return edge.getInVertex();
            } else {
                return null;
            }
        }
    }

    private class BothVerticesPath implements Path {
        public String getPathName() {
            return Tokens.BOTH_VERTICES;
        }

        public Object invoke(Object root) {
            if (root instanceof Edge) {
                Edge edge = (Edge) root;
                List<Vertex> bothVertices = new ArrayList<Vertex>();
                bothVertices.add(edge.getOutVertex());
                bothVertices.add(edge.getInVertex());
                return bothVertices;
            } else {
                return null;
            }
        }
    }

    private class LabelPath implements Path {
        public String getPathName() {
            return Tokens.LABEL;
        }

        public Object invoke(Object root) {
            if (root instanceof Edge) {
                Edge edge = (Edge) root;
                return edge.getLabel();
            } else {
                return null;
            }
        }
    }
}
