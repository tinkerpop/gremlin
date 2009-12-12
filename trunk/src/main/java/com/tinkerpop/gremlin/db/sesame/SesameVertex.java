package com.tinkerpop.gremlin.db.sesame;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.Tokens;
import info.aduna.iteration.CloseableIteration;
import org.openrdf.model.*;
import org.openrdf.model.impl.LiteralImpl;
import org.openrdf.model.impl.URIImpl;
import org.openrdf.sail.SailConnection;
import org.openrdf.sail.SailException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SesameVertex implements Vertex {

    protected Value value;
    protected SailConnection sailConnection;

    private static final String URI_BLANK_NODE_PROPERTIES = "RDF graph URI and blank node vertices can not have properties";
    private static Map<String, String> dataTypeToClass = new HashMap<String, String>();

    static {
        dataTypeToClass.put(SesameTokens.XSD_NS + "string", "java.lang.String");
        dataTypeToClass.put(SesameTokens.XSD_NS + "int", "java.lang.Integer");
        dataTypeToClass.put(SesameTokens.XSD_NS + "integer", "java.lang.Integer");
        dataTypeToClass.put(SesameTokens.XSD_NS + "float", "java.lang.Float");
        dataTypeToClass.put(SesameTokens.XSD_NS + "double", "java.lang.Double");
    }

    public SesameVertex(Value value, SailConnection sailConnection) {
        this.value = value;
        this.sailConnection = sailConnection;
    }

    public Value getRawValue() {
        return this.value;
    }

    private void updateLiteral(Literal oldLiteral, Literal newLiteral) {
        try {
            Set<Statement> statements = new HashSet<Statement>();
            CloseableIteration<? extends Statement, SailException> results = this.sailConnection.getStatements(null, null, oldLiteral, false);
            while (results.hasNext()) {
                statements.add(results.next());
            }
            results.close();
            this.sailConnection.removeStatements(null, null, oldLiteral);
            for (Statement statement : statements) {
                SesameHelper.addStatement(statement.getSubject(), statement.getPredicate(), newLiteral, statement.getContext(), this.sailConnection);
            }
            this.sailConnection.commit();


        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    public void setProperty(String key, Object value) {
        if (this.value instanceof Resource) {
            throw new EvaluationException(URI_BLANK_NODE_PROPERTIES);
        } else {
            boolean update = false;
            Literal oldLiteral = (Literal) this.value;
            if (key.equals(SesameTokens.DATATYPE)) {
                this.value = new LiteralImpl(oldLiteral.getLabel(), new URIImpl(SesameGraph.prefixToNamespace(value.toString(), this.sailConnection)));
                update = true;
            } else if (key.equals(SesameTokens.LANGUAGE)) {
                this.value = new LiteralImpl(oldLiteral.getLabel(), value.toString());
                update = true;
            }
            if (update) {
                this.updateLiteral(oldLiteral, (Literal) this.value);
            }
        }
    }

    public Object removeProperty(String key) {
        if (this.value instanceof Resource) {
            throw new EvaluationException(URI_BLANK_NODE_PROPERTIES);
        } else {
            Literal oldLiteral = (Literal) this.value;
            if (key.equals(SesameTokens.DATATYPE) || key.equals(SesameTokens.LANGUAGE)) {
                this.value = new LiteralImpl(oldLiteral.getLabel());
                this.updateLiteral(oldLiteral, (Literal) this.value);
            }
            if (key.equals(SesameTokens.DATATYPE)) {
                return oldLiteral.getDatatype().toString();
            } else if (key.equals(SesameTokens.LANGUAGE)) {
                return oldLiteral.getLanguage();
            }
        }
        return null;
    }

    public Object getProperty(String key) {
        if (this.value instanceof Literal) {
            Literal literal = (Literal) value;
            if (key.equals(SesameTokens.DATATYPE)) {
                if (null != literal.getDatatype())
                    return literal.getDatatype().stringValue();
                else
                    return null;
            } else if (key.equals(SesameTokens.LANGUAGE)) {
                return literal.getLanguage();
            } else if (key.equals(SesameTokens.VALUE)) {
                return castLiteral(literal);
            }
        }
        return null;
    }

    public Set<String> getPropertyKeys() {
        Set<String> keys = new HashSet<String>();
        if (this.value instanceof Literal) {
            if (null != this.getProperty(SesameTokens.DATATYPE)) {
                keys.add(SesameTokens.DATATYPE);
            } else if (null != this.getProperty(SesameTokens.LANGUAGE)) {
                keys.add(SesameTokens.LANGUAGE);
            }
            keys.add(SesameTokens.VALUE);
        }
        return keys;
    }

    public Set<Edge> getOutEdges() {
        if (this.value instanceof Resource) {
            Set<Edge> edges = new HashSet<Edge>();
            try {
                CloseableIteration<? extends Statement, SailException> results = this.sailConnection.getStatements((Resource) this.value, null, null, false);
                while (results.hasNext()) {
                    edges.add(new SesameEdge(results.next(), this.sailConnection));
                }
                results.close();
            } catch (SailException e) {
                throw new EvaluationException(e.getMessage());
            }
            return edges;
        } else {
            return null;
        }
    }

    public Set<Edge> getInEdges() {
        Set<Edge> edges = new HashSet<Edge>();
        try {
            CloseableIteration<? extends Statement, SailException> results = sailConnection.getStatements(null, null, this.value, false);
            while (results.hasNext()) {
                edges.add(new SesameEdge(results.next(), this.sailConnection));
            }
            results.close();
        } catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
        return edges;
    }

    public Set<Edge> getBothEdges() {
        Set<Edge> bothEdges = new HashSet<Edge>();
        bothEdges.addAll(this.getInEdges());
        if (!(this.value instanceof Resource)) {
            bothEdges.addAll(this.getOutEdges());
        }
        return bothEdges;
    }

    public String toString() {
        return "v[" + this.value.toString() + "]";
    }

    protected static Object castLiteral(Literal literal) {
        if (null != literal.getDatatype()) {
            String className = dataTypeToClass.get(literal.getDatatype().stringValue());
            if (null == className)
                return literal.getLabel();
            else {
                try {
                    Class c = Class.forName(className);
                    if (c == String.class) {
                        return literal.getLabel();
                    } else if (c == Float.class) {
                        return Float.valueOf(literal.getLabel());
                    } else if (c == Integer.class) {
                        return Integer.valueOf(literal.getLabel());
                    } else if (c == Double.class) {
                        return Double.valueOf(literal.getLabel());
                    } else {
                        return literal.getLabel();
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return literal.getLabel();
                }
            }
        } else {
            return literal.getLabel();
        }
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public boolean equals(Object object) {
        return object instanceof SesameVertex && object.hashCode() == this.hashCode();
    }

    public Object getId() {
        return this.value.toString();
        //return SesameGraph.namespaceToPrefix(this.value.toString(), this.sailConnection);

    }
}
