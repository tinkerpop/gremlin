package com.tinkerpop.gremlin.db.sesame;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.impl.ContextStatementImpl;
import org.openrdf.sail.SailConnection;
import org.openrdf.sail.SailException;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SesameEdge extends SesameElement implements Edge {

    Statement statement;

    protected final static String NAMED_GRAPH = "named_graph";
    protected static Set<String> keys = new HashSet<String>();

    static {
        keys.add(NAMED_GRAPH);
    }

    public SesameEdge(Statement statement, SailConnection sailConnection) {
        super(statement.toString(), sailConnection);
        this.statement = statement;
    }

    public String getLabel() {
        return SesameGraph.namespaceToPrefix(this.statement.getPredicate().stringValue(), this.sailConnection);
    }

    public Set<String> getPropertyKeys() {
        return keys;
    }

    public Object getProperty(String key) {
        if (key.equals(NAMED_GRAPH))
            return this.statement.getContext();
        else
            return null;
    }

    public void setProperty(String key, Object value) {
        if (key.equals(NAMED_GRAPH)) {
            try {
                sailConnection.removeStatements(this.statement.getSubject(), this.statement.getPredicate(), this.statement.getObject(), this.statement.getContext());
                Statement newStatement = new ContextStatementImpl(this.statement.getSubject(), this.statement.getPredicate(), this.statement.getObject(), (Resource) value);
                sailConnection.addStatement(newStatement.getSubject(), this.statement.getPredicate(), this.statement.getObject(), this.statement.getContext());
                this.statement = newStatement;
            } catch (SailException e) {
                e.printStackTrace();
            }
        }
    }

    public Object removeProperty(String key) {
        return null;
    }

    public Vertex getInVertex() {
        return new SesameVertex(this.statement.getObject(), this.sailConnection);
    }

    public Vertex getOutVertex() {
        return new SesameVertex(this.statement.getSubject(), this.sailConnection);
    }

    public Statement getRawStatement() {
        return this.statement;
    }

    public String toString() {
        //return this.statement.toString();
        return SesameGraph.namespaceToPrefix(this.statement.getSubject().stringValue(), this.sailConnection) +
                "--" + this.getLabel() + "-->" +
                SesameGraph.namespaceToPrefix(this.statement.getObject().stringValue(), this.sailConnection);
    }

    public int hashCode() {
        return this.statement.hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof SesameEdge)
            return object.hashCode() == this.hashCode();
        else
            return false;
    }
}
