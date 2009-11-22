package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class ForeachStatement extends CompoundStatement {


    private String variable;
    private XPathStatement loopSet;

    /* foreach $i in ./././
         do ./././
     */

    public ForeachStatement(XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public void compileTokens(String line) throws SyntaxErrorException {
        super.compileTokens(line);
        if (variable == null && null == loopSet) {
            if (line.startsWith(Tokens.FOREACH)) {
                String[] parts = line.split(Tokens.SINGLESPACE);
                if (!parts[0].equals(Tokens.FOREACH))
                    throw new SyntaxErrorException("Invalid statement: '" + this.getRawStatement() + "'. Foreach must start with 'foreach'.");
                else if (!parts[1].startsWith(Tokens.DOLLAR_SIGN))
                    throw new SyntaxErrorException("Invalid statement: '" + this.getRawStatement() + "'. Foreach must have a variable component.");
                else if (!parts[2].equals(Tokens.IN))
                    throw new SyntaxErrorException("Invalid statement: '" + this.getRawStatement() + "'. Foreach must have an 'in' component.");

                this.variable = parts[1];

                int startXPath = line.indexOf(Tokens.SINGLESPACE + Tokens.IN + Tokens.SINGLESPACE);
                XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
                xPathStatement.compileTokens(line.substring(startXPath + 4));
                this.loopSet = xPathStatement;

            } else {
                throw new SyntaxErrorException("Invalid statement: '" + this.getRawStatement() + "'. Foreach must start with 'foreach'.");
            }
        } else {
            this.updateStatementList(line);
        }
    }

    public List evaluate() throws EvaluationErrorException {
        List results = null;
        try {
            List set = this.loopSet.evaluate();
            for (Object item : set) {
                xPathEvaluator.setVariable(this.variable, item);
                for (Statement statement : this.statementList) {
                    results = statement.evaluate();
                }
            }
        } catch (Exception e) {
            throw new EvaluationErrorException("Evaluation error: " + e.getMessage());
        }
        return results;
    }

    public static boolean isStatement(String firstLine) {
        return firstLine.startsWith(Tokens.FOREACH + Tokens.SINGLESPACE);
    }

    public String toString() {
        return "FOREACH";
    }

}
