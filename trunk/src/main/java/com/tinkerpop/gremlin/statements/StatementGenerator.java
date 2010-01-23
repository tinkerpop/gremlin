package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.XPathEvaluator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class StatementGenerator {

    public static Statement generateStatement(final String line, final XPathEvaluator xPathEvaluator) {

        if (CommentStatement.isStatement(line)) {
            return new CommentStatement(xPathEvaluator);
        } else if (RootStatement.isStatement(line)) {
            return new RootStatement(xPathEvaluator);
        } else if (IfElseStatement.isStatement(line)) {
            return new IfElseStatement(xPathEvaluator);
        } else if (ForeachStatement.isStatement(line)) {
            return new ForeachStatement(xPathEvaluator);
        } else if (AssignmentStatement.isStatement(line)) {
            return new AssignmentStatement(xPathEvaluator);
        } else if (WhileStatement.isStatement(line)) {
            return new WhileStatement(xPathEvaluator);
        } else if (RepeatStatement.isStatement(line)) {
            return new RepeatStatement(xPathEvaluator);
        } else if (ScriptStatement.isStatement(line)) {
            return new ScriptStatement(xPathEvaluator);
        } else if (FunctionStatement.isStatement(line)) {
            return new FunctionStatement(xPathEvaluator);
        } else {
            return new XPathStatement(xPathEvaluator);
        }
    }
}
