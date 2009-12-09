package com.tinkerpop.gremlin.db.sesame;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.impl.ContextStatementImpl;
import org.openrdf.model.impl.StatementImpl;
import org.openrdf.sail.SailConnection;
import org.openrdf.sail.SailException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SesameEdge extends SesameElement implements Edge {

    Statement statement;

    protected final static String NAMED_GRAPH = "ng";
    protected static Set<String> keys = new HashSet<String>();

    static {
        keys.add(NAMED_GRAPH);
    }

    public SesameEdge(Statement statement, SailConnection sailConnection) {
        super(sailConnection);
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
                this.sailConnection.commit();
                this.statement = newStatement;
            } catch (SailException e) {
                throw new EvaluationException(e.getMessage());
            }
        }
    }

    public Object removeProperty(String key) {
        if (key.equals(NAMED_GRAPH)) {
            try {
                Resource ng = this.statement.getContext();
                sailConnection.removeStatements(this.statement.getSubject(), this.statement.getPredicate(), this.statement.getObject(), this.statement.getContext());
                Statement newStatement = new StatementImpl(this.statement.getSubject(), this.statement.getPredicate(), this.statement.getObject());
                sailConnection.addStatement(this.statement.getSubject(), this.statement.getPredicate(), this.statement.getObject());
                this.sailConnection.commit();
                this.statement = newStatement;
                return ng;
            } catch (SailException e) {
                throw new EvaluationException(e.getMessage());
            }
        }
        return null;
    }

    public Vertex getInVertex() {
        return new SesameVertex(this.statement.getObject(), this.sailConnection);
    }

    public Vertex getOutVertex() {
        return new SesameVertex(this.statement.getSubject(), this.sailConnection);
    }

    public List<Vertex> getBothVertices() {
        List<Vertex> bothVertices = new ArrayList<Vertex>();
        bothVertices.add(this.getOutVertex());
        bothVertices.add(this.getInVertex());
        return bothVertices;
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
        return object instanceof SesameEdge && object.hashCode() == this.hashCode();
    }

    public Object getId() {
        return this.statement;
    }
}
