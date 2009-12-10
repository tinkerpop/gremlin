package com.tinkerpop.gremlin.db.sesame;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Index;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import info.aduna.iteration.CloseableIteration;
import org.openrdf.model.*;
import org.openrdf.model.impl.*;
import org.openrdf.sail.Sail;
import org.openrdf.sail.SailConnection;
import org.openrdf.sail.SailException;
import org.apache.log4j.PropertyConfigurator;

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
    private static Map<String, String> dataTypeToClass = new HashMap<String, String>();
    private static final String NAMESPACE_SEPARATOR = ":";
    private static final String XSD_PREFIX = "xsd";
    private static final String XSD_NS = "http://www.w3.org/2001/XMLSchema#";
    private static final String RDF_PREFIX = "rdf";
    private static final String RDF_NS = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
    private static final String RDFS_PREFIX = "rdfs";
    private static final String RDFS_NS = "http://www.w3.org/2000/01/rdf-schema#";
    private static final String OWL_PREFIX = "owl";
    private static final String OWL_NS = "http://www.w3.org/2002/07/owl#";
    private static final String FOAF_PREFIX = "foaf";
    private static final String FOAF_NS = "http://xmlns.com/foaf/0.1/";

    private static final String BLANK_NODE_PREFIX = "_:";

   /* private static final Map<String, String> namespaces = new HashMap<String, String>();

    static {
        namespaces.put(RDF_PREFIX, RDF_NS);
        namespaces.put(RDFS_PREFIX, RDFS_NS);
        namespaces.put(OWL_PREFIX, OWL_NS);
        namespaces.put(XSD_PREFIX, XSD_NS);
        namespaces.put(FOAF_PREFIX, FOAF_NS);
    }*/

    public static final Pattern literalPattern = Pattern.compile("^\"(.*?)\"((\\^\\^<(.+?)>)$|(@(.{2}))$)");


    static {
        dataTypeToClass.put(XSD_NS + "string", "java.lang.String");
        dataTypeToClass.put(XSD_NS + "int", "java.lang.Integer");
        dataTypeToClass.put(XSD_NS + "integer", "java.lang.Integer");
        dataTypeToClass.put(XSD_NS + "float", "java.lang.Float");
        dataTypeToClass.put(XSD_NS + "double", "java.lang.Double");
    }

    protected static boolean isBNode(String resource) {
        return resource.length() > 2 && resource.startsWith(BLANK_NODE_PREFIX);
    }

    protected static boolean isLiteral(String resource) {
        return literalPattern.matcher(resource).matches();
    }

    protected Literal makeLiteral(String resource) {
        Matcher matcher = literalPattern.matcher(resource);
        matcher.matches();
        if(null != matcher.group(4))
            return new LiteralImpl(matcher.group(1), new URIImpl(prefixToNamespace(matcher.group(4), this.sailConnection)));
        else
            return new LiteralImpl(matcher.group(1), matcher.group(6));
    }

    protected static boolean isURI(String resource) {
        return !isBNode(resource) && !isLiteral(resource) && (resource.contains(":") || resource.contains("/") || resource.contains("#"));
    }

    protected Vertex createVertex(String resource) {
        if (isBNode(resource)) {
            return new SesameVertex(new BNodeImpl(resource), this.sailConnection);
        } else if (isLiteral(resource)) {
            return new SesameVertex(makeLiteral(resource), this.sailConnection);
        } else if (isURI(resource)) {
            resource = prefixToNamespace(resource, this.sailConnection);
            return new SesameVertex(new URIImpl(resource), this.sailConnection);
        } else {
            throw new EvaluationException(resource + " is not a valid URI, blank node, or literal value");
        }
    }

    public SesameGraph(Sail sail) {
        PropertyConfigurator.configure(SesameGraph.class.getResource("log4j.properties"));
        try {
            this.sail = sail;
            this.sail.initialize();
            this.sailConnection = sail.getConnection();
            this.registerNamespace(RDF_PREFIX, RDF_NS);
            this.registerNamespace(RDFS_PREFIX, RDFS_NS);
            this.registerNamespace(OWL_PREFIX, OWL_NS);
            this.registerNamespace(XSD_PREFIX, XSD_NS);
            this.registerNamespace(FOAF_PREFIX, FOAF_NS);
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public Vertex addVertex(Object id) {
        if(null == id)
            id = "urn:uuid:" + UUID.randomUUID().toString();

        return createVertex(id.toString());
    }

    public Vertex getVertex(Object id) {
        return createVertex(id.toString());
    }

    public Iterator<Vertex> getVertices() {
        throw new EvaluationException("This operation is not supported by sail.");
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
            Statement statement = new ContextStatementImpl((Resource) outVertexValue, labelURI, inVertexValue, null);
            this.sailConnection.addStatement(statement.getSubject(), statement.getPredicate(), statement.getObject());
            this.sailConnection.commit();
            return new SesameEdge(statement, this.sailConnection);
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public void removeEdge(Edge edge) {
        Statement statement = ((SesameEdge) edge).getRawStatement();
        try {
            if (null != statement.getContext())
                this.sailConnection.removeStatements(statement.getSubject(), statement.getPredicate(), statement.getObject(), statement.getContext());
            else
                this.sailConnection.removeStatements(statement.getSubject(), statement.getPredicate(), statement.getObject());
            this.sailConnection.commit();
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public SailConnection getSailConnection() {
        return this.sailConnection;
    }

    public void registerNamespace(String prefix, String namespace) {
        try {
            this.sailConnection.setNamespace(prefix, namespace);
            this.sailConnection.commit();
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    /*public void registerNamespace(String prefix, String namespace) {
        this.namespaces.put(prefix, namespace);
    }*/

    public Map<String, String> getNamespaces() {
        Map<String, String> namespaces = new HashMap<String, String>();
        try {
            CloseableIteration<? extends Namespace, SailException> results = sailConnection.getNamespaces();
            while (results.hasNext()) {
                Namespace namespace = results.next();
                namespaces.put(namespace.getPrefix(), namespace.getName());
            }
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
        return namespaces;
    }

    /*public Map<String, String> getNamespaces() {
        return namespaces;
    }*/

    /*public static String getNamespace(String prefix) {
        return namespaces.get(prefix);
    }*/

    public Index getIndex() {
        return null;
    }

    public void shutdown() {
        try {
            this.sailConnection.close();
            this.sail.shutDown();
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public String toString() {
        String type = this.sail.getClass().getSimpleName().toLowerCase();
        return "sesamegraph[" + type + "]";
    }

    public static String prefixToNamespace(String uri, SailConnection sailConnection) {
        try {
            if (uri.contains(NAMESPACE_SEPARATOR)) {
                String namespace = sailConnection.getNamespace(uri.substring(0, uri.indexOf(NAMESPACE_SEPARATOR)));
                if (null != namespace)
                    uri = namespace + uri.substring(uri.indexOf(NAMESPACE_SEPARATOR) + 1);
            }
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
        return uri;
    }

    /*public static String prefixToNamespace(String uri, SailConnection sailConnection) {

        if (uri.contains(NAMESPACE_SEPARATOR)) {
            String namespace = getNamespace(uri.substring(0, uri.indexOf(NAMESPACE_SEPARATOR)));
            if (null != namespace)
                uri = namespace + uri.substring(uri.indexOf(NAMESPACE_SEPARATOR) + 1);
        }
        System.out.println("!" + uri + "!");
        return uri;
    }*/

    /*public static String namespaceToPrefix(String uri, SailConnection sailConnection) {

        for (String prefix : namespaces.keySet()) {
            String namespace = namespaces.get(prefix);
            if (uri.contains(namespace))
                return uri.replace(namespace, prefix + NAMESPACE_SEPARATOR);
        }

        return uri;
    }*/


    public static String namespaceToPrefix(String uri, SailConnection sailConnection) {

        try {
            CloseableIteration<? extends Namespace, SailException> namespaces = sailConnection.getNamespaces();
            while (namespaces.hasNext()) {
                Namespace namespace = namespaces.next();
                if (uri.contains(namespace.getName()))
                    uri = uri.replace(namespace.getName(), namespace.getPrefix() + NAMESPACE_SEPARATOR);
            }
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
        return uri;
    }


    /*public void registerCastType(String dataType, String className) {
        this.dataTypeToClass.put(dataType, className);
    }*/

    public static Object castLiteral(String literalValue, String dataType) {
        String className = dataTypeToClass.get(dataType);
        if (null == className)
            return literalValue;
        else {
            try {
                Class c = Class.forName(className);
                if (c == String.class) {
                    return literalValue;
                } else if (c == Float.class) {
                    return Float.valueOf(literalValue);
                } else if (c == Integer.class) {
                    return Integer.valueOf(literalValue);
                } else if (c == Double.class) {
                    return Double.valueOf(literalValue);
                } else {
                    return literalValue;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return literalValue;
            }
        }
    }

    private class SesameEdgeIterator implements Iterator<Edge> {

        private CloseableIteration<? extends Statement, SailException> edges;
        private SailConnection sailConnection;

        public SesameEdgeIterator(CloseableIteration<? extends Statement, SailException> edges, SailConnection sailConnection) {
            this.edges = edges;
            this.sailConnection = sailConnection;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            try {
                return this.edges != null && this.edges.hasNext();
            } catch (SailException e) {
                throw new EvaluationException(e.getMessage());
            }
        }

        public Edge next() {
            try {
                Edge edge = new SesameEdge(edges.next(), this.sailConnection);
                if(!this.edges.hasNext()) {
                    this.edges.close();
                    this.edges = null;
                }
                return edge;
            } catch (SailException e) {
                throw new EvaluationException(e.getMessage());
            }
        }
    }


}
