package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class WhileStatement extends CompoundStatement {

    private XPathStatement condition;

    public WhileStatement(XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public void compileTokens(String line) {
        super.compileTokens(line);
        if (condition == null) {
            if (line.startsWith(Tokens.WHILE)) {
                String[] parts = line.split(Tokens.SINGLESPACE);
                if (!parts[0].equals(Tokens.WHILE))
                    throw new SyntaxErrorException("Invalid statement: '" + this.toString() + "'. While must start with 'while'.");

                XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
                xPathStatement.compileTokens(line.substring(6));
                this.condition = xPathStatement;
            } else {
                throw new SyntaxErrorException("Invalid statement: '" + this.toString() + "'. While must start with 'while'.");
            }
        } else {
            this.updateStatementList(line);
        }
    }


    public List evaluate() throws EvaluationErrorException {
        List results = null;
        try {
            while ((Boolean) condition.evaluate().get(0)) {
                for (Statement statement : this.statementList) {
                    results = statement.evaluate();
                }
            }
        }
        catch (Exception e) {
            throw new EvaluationErrorException("Evaluation error: " + e.getMessage());
        }
        return results;
    }

    public static boolean isStatement(String firstLine) {
        return firstLine.matches(Tokens.WHILE + Tokens.WHITESPACE_REGEX + Tokens.ANYTHING_REGEX);
    }
}
