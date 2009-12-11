package com.tinkerpop.gremlin.db.sesame;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Index;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import info.aduna.iteration.CloseableIteration;
import org.apache.log4j.PropertyConfigurator;
import org.openrdf.model.*;
import org.openrdf.model.impl.BNodeImpl;
import org.openrdf.model.impl.LiteralImpl;
import org.openrdf.model.impl.StatementImpl;
import org.openrdf.model.impl.URIImpl;
import org.openrdf.sail.Sail;
import org.openrdf.sail.SailConnection;
import org.openrdf.sail.SailException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SesameGraph implements Graph {

    private Sail sail;
    private SailConnection sailConnection;

    private static final String UNSUPPORTED_OPERATION = "This operation is not supported";

    public static final Pattern literalPattern = Pattern.compile("^\"(.*?)\"((\\^\\^<(.+?)>)$|(@(.{2}))$)");
    private static final String LOG4J_PROPERTIES = "log4j.properties";

    public static boolean isBNode(String resource) {
        return resource.length() > 2 && resource.startsWith(SesameTokens.BLANK_NODE_PREFIX);
    }

    public static boolean isLiteral(String resource) {
        return (literalPattern.matcher(resource).matches() || (resource.startsWith("\"") && resource.endsWith("\"") && resource.length() > 1));
    }

    public static boolean isURI(String resource) {
        return !isBNode(resource) && !isLiteral(resource) && (resource.contains(":") || resource.contains("/") || resource.contains("#"));
    }

    protected Literal makeLiteral(String resource) {
        Matcher matcher = literalPattern.matcher(resource);
        if (matcher.matches()) {
            if (null != matcher.group(4))
                return new LiteralImpl(matcher.group(1), new URIImpl(prefixToNamespace(matcher.group(4), this.sailConnection)));
            else
                return new LiteralImpl(matcher.group(1), matcher.group(6));
        } else {
            if (resource.startsWith("\"") && resource.endsWith("\"") && resource.length() > 1) {
                return new LiteralImpl(resource.substring(1, resource.length() - 1));
            } else {
                return null;
            }
        }
    }

    protected Vertex createVertex(String resource) {
        Literal literal;
        if (isBNode(resource)) {
            return new SesameVertex(new BNodeImpl(resource.substring(2)), this.sailConnection);
        } else if ((literal = makeLiteral(resource)) != null) {
            return new SesameVertex(literal, this.sailConnection);
        } else if (resource.contains(":") || resource.contains("/") || resource.contains("#")) {
            resource = prefixToNamespace(resource, this.sailConnection);
            return new SesameVertex(new URIImpl(resource), this.sailConnection);
        } else {
            throw new EvaluationException(resource + " is not a valid URI, blank node, or literal value");
        }
    }

    public SesameGraph(Sail sail) {
        try {
            PropertyConfigurator.configure(SesameGraph.class.getResource(LOG4J_PROPERTIES));
        } catch (Exception e) {
        }
        try {
            this.sail = sail;
            this.sail.initialize();
            this.sailConnection = sail.getConnection();
            this.addNamespace(SesameTokens.RDF_PREFIX, SesameTokens.RDF_NS);
            this.addNamespace(SesameTokens.RDFS_PREFIX, SesameTokens.RDFS_NS);
            this.addNamespace(SesameTokens.OWL_PREFIX, SesameTokens.OWL_NS);
            this.addNamespace(SesameTokens.XSD_PREFIX, SesameTokens.XSD_NS);
            this.addNamespace(SesameTokens.FOAF_PREFIX, SesameTokens.FOAF_NS);
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public Vertex addVertex(Object id) {
        if (null == id)
            id = SesameTokens.URN_UUID_PREFIX + UUID.randomUUID().toString();

        return createVertex(id.toString());
    }

    public Vertex getVertex(Object id) {
        return createVertex(id.toString());
    }

    public Iterator<Vertex> getVertices() {
        throw new EvaluationException(UNSUPPORTED_OPERATION);
    }

    public Iterator<Edge> getEdges() {
        try {
            return new SesameEdgeIterator(this.sailConnection.getStatements(null, null, null, false), this.sailConnection);
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public void removeVertex(Vertex vertex) {
        Value vertexValue = ((SesameVertex) vertex).getRawValue();
        try {
            if (vertexValue instanceof Resource) {
                this.sailConnection.removeStatements((Resource) vertexValue, null, null);
            }
            this.sailConnection.removeStatements(null, null, vertexValue);
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public Edge addEdge(Object id, Vertex outVertex, Vertex inVertex, String label) {
        try {
            Value outVertexValue = ((SesameVertex) outVertex).getRawValue();
            Value inVertexValue = ((SesameVertex) inVertex).getRawValue();

            if (!(outVertexValue instanceof Resource)) {
                throw new EvaluationException(outVertex.toString() + " is not a legal URI or blank node");
            }

            URI labelURI = new URIImpl(prefixToNamespace(label, this.sailConnection));
            Statement statement = new StatementImpl((Resource) outVertexValue, labelURI, inVertexValue);
            SesameHelper.addStatement(statement, this.sailConnection);
            this.sailConnection.commit();
            return new SesameEdge(statement, this.sailConnection);
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public void removeEdge(Edge edge) {
        Statement statement = ((SesameEdge) edge).getRawStatement();
        try {
            SesameHelper.removeStatement(statement, this.sailConnection);
            this.sailConnection.commit();
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public SailConnection getSailConnection() {
        return this.sailConnection;
    }

    public Sail getSail() {
        return this.sail;
    }

    public void addNamespace(String prefix, String namespace) {
        try {
            this.sailConnection.setNamespace(prefix, namespace);
            this.sailConnection.commit();
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public void removeNamespace(String prefix) {
        try {
            this.sailConnection.removeNamespace(prefix);
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public Map<String, String> getNamespaces() {
        Map<String, String> namespaces = new HashMap<String, String>();
        try {
            CloseableIteration<? extends Namespace, SailException> results = this.sailConnection.getNamespaces();
            while (results.hasNext()) {
                Namespace namespace = results.next();
                namespaces.put(namespace.getPrefix(), namespace.getName());
            }
            results.close();
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
        return namespaces;
    }

    public Index getIndex() {
        throw new EvaluationException(UNSUPPORTED_OPERATION);
    }

    public void shutdown() {
        try {
            this.sailConnection.close();
            this.sail.shutDown();
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public static String prefixToNamespace(String uri, SailConnection sailConnection) {
        try {
            if (uri.contains(SesameTokens.NAMESPACE_SEPARATOR)) {
                String namespace = sailConnection.getNamespace(uri.substring(0, uri.indexOf(SesameTokens.NAMESPACE_SEPARATOR)));
                if (null != namespace)
                    uri = namespace + uri.substring(uri.indexOf(SesameTokens.NAMESPACE_SEPARATOR) + 1);
            }
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
        return uri;
    }

    public static String namespaceToPrefix(String uri, SailConnection sailConnection) {

        try {
            CloseableIteration<? extends Namespace, SailException> namespaces = sailConnection.getNamespaces();
            while (namespaces.hasNext()) {
                Namespace namespace = namespaces.next();
                if (uri.contains(namespace.getName()))
                    uri = uri.replace(namespace.getName(), namespace.getPrefix() + SesameTokens.NAMESPACE_SEPARATOR);
            }
            namespaces.close();
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
        return uri;
    }


    public String toString() {
        String type = this.sail.getClass().getSimpleName().toLowerCase();
        return "sesamegraph[" + type + "]";
    }

    private class SesameEdgeIterator implements Iterator<Edge> {

        private CloseableIteration<? extends Statement, SailException> statements;
        private SailConnection sailConnection;

        public SesameEdgeIterator(CloseableIteration<? extends Statement, SailException> statements, SailConnection sailConnection) {
            this.statements = statements;
            this.sailConnection = sailConnection;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            try {
                return this.statements != null && this.statements.hasNext();
            } catch (SailException e) {
                throw new EvaluationException(e.getMessage());
            }
        }

        public Edge next() {
            try {
                Edge edge = new SesameEdge(this.statements.next(), this.sailConnection);
                if (!this.statements.hasNext()) {
                    this.statements.close();
                    this.statements = null;
                }
                return edge;
            } catch (SailException e) {
                throw new EvaluationException(e.getMessage());
            }
        }
    }


}
