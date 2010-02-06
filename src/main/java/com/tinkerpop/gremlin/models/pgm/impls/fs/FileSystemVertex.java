package com.tinkerpop.gremlin.models.pgm.impls.fs;

import com.tinkerpop.gremlin.models.pgm.Edge;
import com.tinkerpop.gremlin.models.pgm.Vertex;
import com.tinkerpop.gremlin.models.pgm.impls.StringFactory;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FileSystemVertex extends FileSystemElement implements Vertex {

    private File file;
    private static Set<String> properties = new HashSet<String>();

    static {
        properties.add(FileSystemTokens.READ);
        properties.add(FileSystemTokens.WRITE);
        properties.add(FileSystemTokens.EXECUTE);
        properties.add(FileSystemTokens.SIZE);
        properties.add(FileSystemTokens.TYPE);
        properties.add(FileSystemTokens.HIDDEN);
        properties.add(FileSystemTokens.MODIFIED);
    }

    public FileSystemVertex(File file) {
        this.file = file;
    }

    public Iterable<Edge> getInEdges() {
        Set<Edge> fileEdges = new HashSet<Edge>();
        File parentFile = this.file.getParentFile();
        if (null != parentFile)
            fileEdges.add(new FileSystemEdge(parentFile, this.file, "contained_in"));
        return fileEdges;

    }

    public Iterable<Edge> getOutEdges() {
        Set<Edge> fileEdges = new HashSet<Edge>();
        if (this.file.isDirectory()) {
            File[] files = this.file.listFiles();
            for (File file : files) {
                fileEdges.add(new FileSystemEdge(this.file, file, "contains"));
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
        if (key.equals(FileSystemTokens.READ)) {
            return this.file.canRead();
        } else if (key.equals(FileSystemTokens.WRITE)) {
            return this.file.canWrite();
        } else if (key.equals(FileSystemTokens.EXECUTE)) {
            return this.file.canExecute();
        } else if (key.equals(FileSystemTokens.SIZE)) {
            return this.file.length();
        } else if (key.equals(FileSystemTokens.TYPE)) {
            if (this.file.isDirectory()) {
                return "directory";
            } else if (this.file.isFile()) {
                return "file";
            }
        } else if (key.equals(FileSystemTokens.HIDDEN)) {
            return this.file.isHidden();
        } else if (key.equals(FileSystemTokens.MODIFIED)) {
            return this.file.lastModified();
        }
        return null;

    }

    public Set<String> getPropertyKeys() {
        return FileSystemVertex.properties;
    }

    public boolean equals(final Object object) {
        return object instanceof FileSystemVertex && ((FileSystemVertex) object).getId().equals(this.getId());
    }

    public int hashCode() {
        return this.getId().hashCode();
    }

}
