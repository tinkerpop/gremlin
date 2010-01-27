package com.tinkerpop.gremlin.db.io;

import com.tinkerpop.gremlin.db.StringFactory;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FileVertex extends FileElement implements Vertex {

    private File file;
    private static Set<String> properties = new HashSet<String>();

    static {
        properties.add(FileTokens.READ);
        properties.add(FileTokens.WRITE);
        properties.add(FileTokens.EXECUTE);
        properties.add(FileTokens.SIZE);
        properties.add(FileTokens.TYPE);
        properties.add(FileTokens.HIDDEN);
        properties.add(FileTokens.MODIFIED);
    }

    public FileVertex(File file) {
        this.file = file;
    }

    public Iterable<Edge> getInEdges() {
        Set<Edge> fileEdges = new HashSet<Edge>();
        File parentFile = this.file.getParentFile();
        if(null != parentFile)
            fileEdges.add(new FileEdge(parentFile, this.file, "contained_in"));
        return fileEdges;

    }

    public Iterable<Edge> getOutEdges() {
        Set<Edge> fileEdges = new HashSet<Edge>();
        if (this.file.isDirectory()) {
            File[] files = this.file.listFiles();
            for (File file : files) {
                fileEdges.add(new FileEdge(this.file, file, "contains"));
            }
        }
        return fileEdges;
    }

    public Object getId() {
        return this.file.toString();
    }

    public String toString() {
        return StringFactory.vertexString(this);
    }

    public Object getProperty(String key) {
        if (key.equals(FileTokens.READ)) {
            return this.file.canRead();
        } else if (key.equals(FileTokens.WRITE)) {
            return this.file.canWrite();
        } else if (key.equals(FileTokens.EXECUTE)) {
            return this.file.canExecute();
        } else if (key.equals(FileTokens.SIZE)) {
            return this.file.length();
        } else if (key.equals(FileTokens.TYPE)) {
            if (this.file.isDirectory()) {
                return "directory";
            } else if (this.file.isFile()) {
                return "file";
            }
        } else if (key.equals(FileTokens.HIDDEN)) {
            return this.file.isHidden();
        } else if (key.equals(FileTokens.MODIFIED)) {
            return this.file.lastModified();
        }
        return null;

    }

    public Set<String> getPropertyKeys() {
        return FileVertex.properties;
    }

}
