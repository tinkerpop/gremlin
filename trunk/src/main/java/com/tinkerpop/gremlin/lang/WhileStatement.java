package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class WhileStatement extends Statement {

    private XPathStatement condition;
    private XPathStatement loopBody;

    public WhileStatement(XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public static boolean isStatement(String firstLine) {
        return firstLine.startsWith(Tokens.WHILE + Tokens.SINGLESPACE);
    }

    public boolean compileTokens(String line) {
        super.compileTokens(line);
        if (condition == null) {
            if (line.startsWith(Tokens.WHILE)) {
                String[] parts = line.split(Tokens.SINGLESPACE);
                if (!parts[0].equals(Tokens.WHILE))
                    throw new SyntaxErrorException("Invalid statement: '" + this.getRawStatement() + "'. While must start with 'while'.");

                XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
                xPathStatement.compileTokens(line.substring(6));
                this.condition = xPathStatement;
                return false;
            } else {
                throw new SyntaxErrorException("Invalid statement: '" + this.getRawStatement() + "'. While must start with 'while'.");
            }
        } else if (null == loopBody) {
            if (line.startsWith(Tokens.DO)) {
                XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
                xPathStatement.compileTokens(line.substring(3));
                this.loopBody = xPathStatement;
                return true;
            } else {
                throw new SyntaxErrorException("Invalid statement: '" + this.getRawStatement() + "'. While must have a 'do' component.");
            }
        } else {
            throw new SyntaxErrorException("Invalid statement: " + this.getRawStatement());
        }
    }

    public XPathStatement getCondition() {
        return this.condition;
    }

    public XPathStatement getLoopBody() {
        return this.loopBody;
    }

    public List evaluate() {
        List results = null;
        while ((Boolean) condition.evaluate().get(0)) {
            results = this.loopBody.evaluate();
        }
        return results;
    }

    public String toString() {
        return "(WHILE CONDITION[" + this.condition + "] LOOPBODY[" + this.loopBody + "])";
    }
}
