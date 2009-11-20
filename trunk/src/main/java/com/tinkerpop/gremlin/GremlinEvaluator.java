package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.lang.*;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;

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

    public List evaluate(String line) throws SyntaxErrorException, EvaluationErrorException, JXPathException {
        line = line.trim();

        try {
            if (null == this.currentStatement) {
                if (ForeachStatement.isStatement(line)) {
                    this.currentStatement = new ForeachStatement(this.xPathEvaluator);
                    this.currentStatement.compileTokens(line);
                    return null;
                } else if (AssignmentStatement.isStatement(line)) {
                    AssignmentStatement assignmentStatement = new AssignmentStatement(this.xPathEvaluator);
                    assignmentStatement.compileTokens(line);
                    return assignmentStatement.evaluate();
                } else if (WhileStatement.isStatement(line)) {
                    this.currentStatement = new WhileStatement(this.xPathEvaluator);
                    this.currentStatement.compileTokens(line);
                    return null;
                } else if (RepeatStatement.isStatement(line)) {
                    this.currentStatement = new RepeatStatement(this.xPathEvaluator);
                    this.currentStatement.compileTokens(line);
                    return null;
                } else {
                    XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
                    xPathStatement.compileTokens(line);
                    return xPathStatement.evaluate();
                }
            } else {
                if (this.currentStatement.compileTokens(line)) {
                    List results = this.currentStatement.evaluate();
                    this.currentStatement = null;
                    return results;
                } else {
                    return null;
                }
            }
        } catch (JXPathInvalidSyntaxException e) {
            this.currentStatement = null;
            throw new SyntaxErrorException(e.getMessage().replace("Invalid XPath:", "Invalid statement:"));
        } catch (SyntaxErrorException e) {
            this.currentStatement = null;
            throw e;
        } catch (EvaluationErrorException e) {
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
