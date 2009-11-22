package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class RepeatStatement extends CompoundStatement {

    private XPathStatement times;

    public RepeatStatement(XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public static boolean isStatement(String firstLine) {
        return firstLine.startsWith(Tokens.REPEAT + Tokens.SINGLESPACE);
    }

    public void compileTokens(String line) {
        super.compileTokens(line);
        if (times == null) {
            if (line.startsWith(Tokens.REPEAT)) {
                String[] parts = line.split(Tokens.SINGLESPACE);
                if (!parts[0].equals(Tokens.REPEAT))
                    throw new SyntaxErrorException("Invalid statement: '" + this.getRawStatement() + "'. Repeat must start with 'repeat'.");

                XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
                xPathStatement.compileTokens(line.substring(7));
                this.times = xPathStatement;
            } else {
                throw new SyntaxErrorException("Invalid statement: '" + this.getRawStatement() + "'. Repeat must start with 'repeat'.");
            }
        } else {
            this.updateStatementList(line);
        }
    }

    public List evaluate() throws EvaluationErrorException {
        List results = null;
        try {
            int numberOfTimes = Float.valueOf(times.evaluate().get(0).toString()).intValue();
            for (int i = 0; i < numberOfTimes; i++) {
                for(Statement statement : this.statementList) {
                    results = statement.evaluate();
                }
            }
        } catch (Exception e) {
            throw new EvaluationErrorException("Evaluation error: " + e.getMessage());
        }
        return results;
    }

    public String toString() {
        return "REPEAT";
    }
}
