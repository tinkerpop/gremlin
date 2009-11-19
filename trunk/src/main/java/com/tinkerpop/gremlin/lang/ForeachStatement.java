package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class ForeachStatement extends Statement {


    private String variable;
    private XPathStatement loopSet;
    private XPathStatement loopBody;

    /* foreach $i in ./././
         do ./././
     */

    public ForeachStatement(XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public boolean compileTokens(String line) throws SyntaxErrorException {
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

                return false;
            } else {
                throw new SyntaxErrorException("Invalid statement: '" + this.getRawStatement() + "'. Foreach must start with 'foreach'.");
            }
        } else if (null == loopBody) {
            if (line.startsWith(Tokens.DO)) {
                XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
                xPathStatement.compileTokens(line.substring(3));
                this.loopBody = xPathStatement;
                return true;
            } else {
                throw new SyntaxErrorException("Invalid statement: '" + this.getRawStatement() + "'. Foreach must have a 'do' component.");
            }
        } else {
            throw new SyntaxErrorException("Invalid statement: " + this.getRawStatement());
        }
    }

    public List evaluate() {
        List set = this.loopSet.evaluate();
        List results = null;
        for (Object item : set) {
            xPathEvaluator.setVariable(this.variable, item);
            results = this.loopBody.evaluate();
        }
        return results;
    }

    public static boolean isStatement(String firstLine) {
        return firstLine.startsWith(Tokens.FOREACH + Tokens.SINGLESPACE);
    }

    public String getVariable() {
        return this.variable;
    }

    public XPathStatement getLoopSet() {
        return this.loopSet;
    }

    public XPathStatement getLoopBody() {
        return this.loopBody;
    }

    public String toString() {
        return "(FOREACH VARIABLE[" + this.variable + "] IN LOOPSET[" + this.loopSet + "] DO LOOPBODY[" + this.loopBody + "])";
    }

}
