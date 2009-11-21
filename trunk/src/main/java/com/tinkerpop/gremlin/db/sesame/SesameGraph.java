package com.tinkerpop.gremlin.db.sesame;

import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import info.aduna.iteration.CloseableIteration;
import org.openrdf.model.Namespace;
import org.openrdf.model.impl.URIImpl;
import org.openrdf.sail.Sail;
import org.openrdf.sail.SailConnection;
import org.openrdf.sail.SailException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SesameGraph implements Graph {

    Sail sail;
    SailConnection sailConnection;
    private static Map<String, String> dataTypeToClass = new HashMap<String, String>();
    private static final String NAMESPACE_SEPARATOR = ":";
    private static final String XSD_NS = "http://www.w3.org/2001/XMLSchema#";


    static {
        dataTypeToClass.put(XSD_NS + "string", "java.lang.String");
        dataTypeToClass.put(XSD_NS + "int", "java.lang.Integer");
        dataTypeToClass.put(XSD_NS + "integer", "java.lang.Integer");
        dataTypeToClass.put(XSD_NS + "float", "java.lang.Float");
    }


    public SesameGraph(Sail sail) throws SailException {
        this.sail = sail;
        this.sailConnection = sail.getConnection();
    }

    public Vertex getVertex(Object id) {
        id = prefixToNamespace((String) id, this.sailConnection);
        return new SesameVertex(new URIImpl((String) id), this.sailConnection);
    }

    public void removeVertex(Object id) {
        URIImpl uri = new URIImpl((String) id);
        try {
            this.sailConnection.removeStatements(uri, null, null);
            this.sailConnection.removeStatements(null, null, uri);
        } catch (SailException e) {
            e.printStackTrace();
        }
    }

    public SailConnection getSailConnection() {
        return this.sailConnection;
    }

    public void registerNamespace(String prefix, String namespace) {
        try {
            this.sailConnection.setNamespace(prefix, namespace);
        } catch (SailException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getNamespaces() {
        Map<String, String> namespaces = new HashMap<String, String>();
        try {
            CloseableIteration<? extends Namespace, SailException> results = sailConnection.getNamespaces();
            while (results.hasNext()) {
                Namespace namespace = results.next();
                namespaces.put(namespace.getPrefix(), namespace.getName());
            }
        } catch (SailException e) {
            e.printStackTrace();
        }
        return namespaces;
    }

    public void shutdown() {
        try {
            this.sailConnection.close();
            this.sail.shutDown();
        } catch (SailException e) {
            e.printStackTrace();
        }
    }

    public static String prefixToNamespace(String uri, SailConnection sailConnection) {
        try {
            if (uri.contains(NAMESPACE_SEPARATOR)) {
                String namespace = sailConnection.getNamespace(uri.substring(0, uri.indexOf(NAMESPACE_SEPARATOR)));
                if (null != namespace)
                    return namespace + uri.substring(uri.indexOf(NAMESPACE_SEPARATOR) + 1);
            }
        } catch (SailException e) {
            e.printStackTrace();
        }
        return uri;
    }

    public static String namespaceToPrefix(String uri, SailConnection sailConnection) {
        try {
            CloseableIteration<? extends Namespace, SailException> namespaces = sailConnection.getNamespaces();
            while (namespaces.hasNext()) {
                Namespace namespace = namespaces.next();
                if (uri.contains(namespace.getName()))
                    return uri.replace(namespace.getName(), namespace.getPrefix() + NAMESPACE_SEPARATOR);
            }
        } catch (SailException e) {
            e.printStackTrace();
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
                if(c == String.class) {
                    return literalValue;
                } else if(c == Float.class) {
                    return Float.valueOf(literalValue);
                } else if(c == Integer.class) {
                    return Integer.valueOf(literalValue);
                } else  if(c == Double.class) {
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


}
