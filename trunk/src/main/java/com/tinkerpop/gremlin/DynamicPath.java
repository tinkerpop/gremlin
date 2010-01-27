package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.PathStatement;
import com.tinkerpop.gremlin.statements.Tokens;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DynamicPath {

    PathStatement pathStatement;

    public DynamicPath(PathStatement pathStatement) {
        this.pathStatement = pathStatement;
    }

    public String getPathName() {
        return pathStatement.getPathName();
    }

    public Object invoke(Object root) throws EvaluationException {
        GremlinEvaluator evaluator = new GremlinEvaluator();
        evaluator.setVariable(Tokens.AT_VARIABLE, root);

        List result;
        try {
            result = evaluator.evaluate(new ByteArrayInputStream(this.pathStatement.getStatementBody().getBytes()));
        } catch (Exception e) {
            throw new EvaluationException(e.getMessage());
        }

        if (null != result && result.size() == 1) {
            return result.get(0);
        } else {
            return result;
        }
    }
}
