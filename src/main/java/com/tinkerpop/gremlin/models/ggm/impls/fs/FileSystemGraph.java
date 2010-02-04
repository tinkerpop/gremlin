package com.tinkerpop.gremlin.models.ggm.impls.fs;

import com.tinkerpop.gremlin.models.ggm.Edge;
import com.tinkerpop.gremlin.models.ggm.Graph;
import com.tinkerpop.gremlin.models.ggm.Index;
import com.tinkerpop.gremlin.models.ggm.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;

import java.io.File;
import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FileSystemGraph implements Graph {

    public Vertex getVertex(Object id) {
        File file = new File(id.toString());
        return new FileSystemVertex(file);
    }

    public Vertex addVertex(Object id) {
        throw EvaluationException.createException(EvaluationException.EvaluationErrorType.UNSUPPORTED_OPERATION);
    }

    public void removeVertex(Vertex vertex) {
        throw EvaluationException.createException(EvaluationException.EvaluationErrorType.UNSUPPORTED_OPERATION);
    }


    public Edge addEdge(Object id, Vertex outVertex, Vertex inVertex, String label) {
        throw EvaluationException.createException(EvaluationException.EvaluationErrorType.UNSUPPORTED_OPERATION);
    }

    public void removeEdge(Edge edge) {
        throw EvaluationException.createException(EvaluationException.EvaluationErrorType.UNSUPPORTED_OPERATION);
    }

    public Iterable<Vertex> getVertices() {
        throw EvaluationException.createException(EvaluationException.EvaluationErrorType.UNSUPPORTED_OPERATION);
    }

    public Iterable<Edge> getEdges() {
        throw EvaluationException.createException(EvaluationException.EvaluationErrorType.UNSUPPORTED_OPERATION);
    }

    public Index getIndex() {
        throw EvaluationException.createException(EvaluationException.EvaluationErrorType.UNSUPPORTED_OPERATION);
    }

    public void shutdown() {

    }

    public void clear() {
        throw EvaluationException.createException(EvaluationException.EvaluationErrorType.UNSUPPORTED_OPERATION);
    }

    public String toString() {
        String roots = Arrays.asList(File.listRoots()).toString();
        roots = roots.substring(1, roots.length() - 1);
        return "filegraph[" + roots + "]";
    }
}
