package com.tinkerpop.gremlin.db.io;

import com.tinkerpop.gremlin.db.StringFactory;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;

import java.io.File;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FileEdge extends FileElement implements Edge {

    private final File outFile;
    private final File inFile;
    private final String label;

    public FileEdge(final File outFile, final File inFile, final String label) {
        this.outFile = outFile;
        this.inFile = inFile;
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public Vertex getInVertex() {
        return new FileVertex(inFile);
    }

    public Vertex getOutVertex() {
        return new FileVertex(outFile);
    }

    public Object getId() {
        return "";
    }

    public String toString() {
        return StringFactory.edgeString(this);
    }
}
