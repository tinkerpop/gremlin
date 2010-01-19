package com.tinkerpop.gremlin.db.sail;

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
public class SailGraph implements Graph {

    private Sail sail;
    private SailConnection sailConnection;

    private static final String UNSUPPORTED_OPERATION = "This operation is not supported";

    public static final Pattern literalPattern = Pattern.compile("^\"(.*?)\"((\\^\\^<(.+?)>)$|(@(.{2}))$)");
    private static final String LOG4J_PROPERTIES = "log4j.properties";

    public static boolean isBNode(final String resource) {
        return resource.length() > 2 && resource.startsWith(SailTokens.BLANK_NODE_PREFIX);
    }

    public static boolean isLiteral(final String resource) {
        return (literalPattern.matcher(resource).matches() || (resource.startsWith("\"") && resource.endsWith("\"") && resource.length() > 1));
    }

    public static boolean isURI(final String resource) {
        return !isBNode(resource) && !isLiteral(resource) && (resource.contains(":") || resource.contains("/") || resource.contains("#"));
    }

    protected Literal makeLiteral(final String resource) {
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
            return new SailVertex(new BNodeImpl(resource.substring(2)), this.sailConnection);
        } else if ((literal = makeLiteral(resource)) != null) {
            return new SailVertex(literal, this.sailConnection);
        } else if (resource.contains(":") || resource.contains("/") || resource.contains("#")) {
            resource = prefixToNamespace(resource, this.sailConnection);
            return new SailVertex(new URIImpl(resource), this.sailConnection);
        } else {
            throw new EvaluationException(resource + " is not a valid URI, blank node, or literal value");
        }
    }

    public SailGraph(final Sail sail) {
        try {
            PropertyConfigurator.configure(SailGraph.class.getResource(LOG4J_PROPERTIES));
        } catch (Exception e) {
        }
        try {
            this.sail = sail;
            this.sail.initialize();
            this.sailConnection = sail.getConnection();
            this.addNamespace(SailTokens.RDF_PREFIX, SailTokens.RDF_NS);
            this.addNamespace(SailTokens.RDFS_PREFIX, SailTokens.RDFS_NS);
            this.addNamespace(SailTokens.OWL_PREFIX, SailTokens.OWL_NS);
            this.addNamespace(SailTokens.XSD_PREFIX, SailTokens.XSD_NS);
            this.addNamespace(SailTokens.FOAF_PREFIX, SailTokens.FOAF_NS);
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public Vertex addVertex(Object id) {
        if (null == id)
            id = SailTokens.URN_UUID_PREFIX + UUID.randomUUID().toString();

        return createVertex(id.toString());
    }

    public Vertex getVertex(Object id) {
        return createVertex(id.toString());
    }
                                                                    
    public Iterable<Vertex> getVertices() {
        throw new EvaluationException(UNSUPPORTED_OPERATION);
    }

    public Iterable<Edge> getEdges() {
        try {
            return new SesameEdgeIterable(this.sailConnection.getStatements(null, null, null, false), this.sailConnection);
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public void removeVertex(final Vertex vertex) {
        Value vertexValue = ((SailVertex) vertex).getRawValue();
        try {
            if (vertexValue instanceof Resource) {
                this.sailConnection.removeStatements((Resource) vertexValue, null, null);
            }
            this.sailConnection.removeStatements(null, null, vertexValue);
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public Edge addEdge(final Object id, final Vertex outVertex, final Vertex inVertex, final String label) {
        try {
            Value outVertexValue = ((SailVertex) outVertex).getRawValue();
            Value inVertexValue = ((SailVertex) inVertex).getRawValue();

            if (!(outVertexValue instanceof Resource)) {
                throw new EvaluationException(outVertex.toString() + " is not a legal URI or blank node");
            }

            URI labelURI = new URIImpl(prefixToNamespace(label, this.sailConnection));
            Statement statement = new StatementImpl((Resource) outVertexValue, labelURI, inVertexValue);
            SailHelper.addStatement(statement, this.sailConnection);
            this.sailConnection.commit();
            return new SailEdge(statement, this.sailConnection);
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public void removeEdge(final Edge edge) {
        Statement statement = ((SailEdge) edge).getRawStatement();
        try {
            SailHelper.removeStatement(statement, this.sailConnection);
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

    public void addNamespace(final String prefix, final String namespace) {
        try {
            this.sailConnection.setNamespace(prefix, namespace);
            this.sailConnection.commit();
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public void removeNamespace(final String prefix) {
        try {
            this.sailConnection.removeNamespace(prefix);
            this.sailConnection.commit();
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

    public String expandPrefix(final String uri) {
        return SailGraph.prefixToNamespace(uri, this.sailConnection);
    }

    public String prefixNamespace(final String uri) {
        return SailGraph.namespaceToPrefix(uri, this.sailConnection);
    }

    public Index getIndex() {
        throw new EvaluationException(UNSUPPORTED_OPERATION);
    }

    public void clear() {
        try {
            this.sailConnection.clear();
            this.sailConnection.commit();
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public void shutdown() {
        try {
            this.sailConnection.commit();
            this.sailConnection.close();
            this.sail.shutDown();
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public static String prefixToNamespace(String uri, final SailConnection sailConnection) {
        try {
            if (uri.contains(SailTokens.NAMESPACE_SEPARATOR)) {
                String namespace = sailConnection.getNamespace(uri.substring(0, uri.indexOf(SailTokens.NAMESPACE_SEPARATOR)));
                if (null != namespace)
                    uri = namespace + uri.substring(uri.indexOf(SailTokens.NAMESPACE_SEPARATOR) + 1);
            }
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
        return uri;
    }

    public static String namespaceToPrefix(String uri, final SailConnection sailConnection) {

        try {
            CloseableIteration<? extends Namespace, SailException> namespaces = sailConnection.getNamespaces();
            while (namespaces.hasNext()) {
                Namespace namespace = namespaces.next();
                if (uri.contains(namespace.getName()))
                    uri = uri.replace(namespace.getName(), namespace.getPrefix() + SailTokens.NAMESPACE_SEPARATOR);
            }
            namespaces.close();
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
        return uri;
    }


    public String toString() {
        String type = this.sail.getClass().getSimpleName().toLowerCase();
        return "sailgraph[" + type + "]";
    }

    private class SesameEdgeIterable implements Iterable<Edge> {

        private CloseableIteration<? extends Statement, SailException> statements;
        private SailConnection sailConnection;

        public SesameEdgeIterable(final CloseableIteration<? extends Statement, SailException> statements, final SailConnection sailConnection) {
            this.statements = statements;
            this.sailConnection = sailConnection;
        }

        public Iterator<Edge> iterator() {
            return new SesameEdgeIterator(statements, sailConnection);
        }

    }

    private class SesameEdgeIterator implements Iterator<Edge> {

        private CloseableIteration<? extends Statement, SailException> statements;
        private SailConnection sailConnection;

        public SesameEdgeIterator(final CloseableIteration<? extends Statement, SailException> statements, final SailConnection sailConnection) {
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
                Edge edge = new SailEdge(this.statements.next(), this.sailConnection);
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
