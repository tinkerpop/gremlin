package com.tinkerpop.gremlin.db.fs;

import com.tinkerpop.gremlin.db.StringFactory;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;

import java.io.File;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FileSystemEdge extends FileSystemElement implements Edge {

    private final File outFile;
    private final File inFile;
    private final String label;

    public FileSystemEdge(final File outFile, final File inFile, final String label) {
        this.outFile = outFile;
        this.inFile = inFile;
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public Vertex getInVertex() {
        return new FileSystemVertex(inFile);
    }

    public Vertex getOutVertex() {
        return new FileSystemVertex(outFile);
    }

    public Object getId() {
        return (outFile.toString() + inFile.toString()).hashCode();
    }

    public String toString() {
        return StringFactory.edgeString(this);
    }

    public boolean equals(final Object object) {
        return object instanceof FileSystemEdge && ((FileSystemEdge) object).getId().equals(this.getId());
    }

    public int hashCode() {
        return this.getId().hashCode();
    }
}
