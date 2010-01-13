package com.tinkerpop.gremlin.db.sail;

import com.tinkerpop.gremlin.statements.EvaluationException;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.URI;
import org.openrdf.model.Value;
import org.openrdf.model.impl.ContextStatementImpl;
import org.openrdf.model.impl.StatementImpl;
import org.openrdf.sail.SailConnection;
import org.openrdf.sail.SailException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SailHelper {

    protected static void removeStatement(final Statement statement, final SailConnection sailConnection) {
        try {
            if (null != statement.getContext()) {
                sailConnection.removeStatements(statement.getSubject(), statement.getPredicate(), statement.getObject(), statement.getContext());
            } else {
                sailConnection.removeStatements(statement.getSubject(), statement.getPredicate(), statement.getObject());
            }
            sailConnection.commit();
        }
        catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    protected static void addStatement(final Statement statement, final SailConnection sailConnection) {
        try {
            if (null != statement.getContext()) {
                sailConnection.addStatement(statement.getSubject(), statement.getPredicate(), statement.getObject(), statement.getContext());
            } else {
                sailConnection.addStatement(statement.getSubject(), statement.getPredicate(), statement.getObject());
            }
            sailConnection.commit();
        }
        catch (SailException e) {
            throw new EvaluationException(e.getMessage());
        }
    }

    protected static void addStatement(final Resource subject, final URI predicate, final Value object, final Resource context, final SailConnection sailConnection) {
        Statement statement;
        if (null != context) {
            statement = new ContextStatementImpl(subject, predicate, object, context);
        } else {
            statement = new StatementImpl(subject, predicate, object);
        }
        SailHelper.addStatement(statement, sailConnection);
    }
}
