package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.Statement;
import com.tinkerpop.gremlin.statements.StatementGenerator;
import com.tinkerpop.gremlin.statements.SyntaxException;

import java.util.List;


/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinEvaluator {

    private Statement currentStatement;
    private XPathEvaluator xPathEvaluator;

    public GremlinEvaluator() {
        this.xPathEvaluator = new XPathEvaluator();
        this.currentStatement = null;
    }

    public int getDepth() {
        return this.xPathEvaluator.getDepth();
    }

    public List evaluate(String line) throws SyntaxException, EvaluationException {
        line = line.trim();

        try {
            if (null == this.currentStatement) {
                this.currentStatement = StatementGenerator.generateStatement(line, xPathEvaluator);
                this.currentStatement.compileTokens(line);
            } else {
                this.currentStatement.compileTokens(line);
            }

            if (this.currentStatement.isComplete()) {
                Statement temp = this.currentStatement;
                this.currentStatement = null;
                return temp.evaluate();
            } else {
                return null;
            }
        } catch (EvaluationException e) {
            this.currentStatement = null;
            throw e;
        } catch (SyntaxException e) {
            this.currentStatement = null;
            throw e;
        }
    }

    public boolean inStatement() {
        return null != this.currentStatement;
    }

    public void setVariable(String variable, Object value) {
        this.xPathEvaluator.setVariable(variable, value);
    }

    public void setRoot(Object root) {
        this.xPathEvaluator.setRoot(root);
    }
}
