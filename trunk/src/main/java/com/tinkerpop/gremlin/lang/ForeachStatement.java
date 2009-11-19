package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class ForeachStatement extends Statement{

    public static final String FOREACH = "foreach";
    public static final String IN = "in";

    protected String variable;
    protected XPathStatement loopSet;
    protected XPathStatement loopBody;

    /* foreach $i in ./././
         do ./././
     */

    public ForeachStatement(XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public boolean compileTokens(String line) throws SyntaxErrorException {
        super.compileTokens(line);
        if (variable == null && null == loopSet) {
            if (line.startsWith(FOREACH)) {
                String[] parts = line.split(SINGLESPACE);
                if(!parts[0].equals(FOREACH))
                    throw new SyntaxErrorException("A foreach statement must start with 'foreach': " + this.fullStatement);
                else if(!parts[1].startsWith(DOLLAR_SIGN))
                    throw new SyntaxErrorException("a foreach statement must have a variable component: " + this.fullStatement);
                else if(!parts[2].equals(IN))
                    throw new SyntaxErrorException("A foreach statement must have an 'in' component: " + this.fullStatement);

                this.variable = parts[1];

                int startXPath = line.indexOf(" " + "in" + " ");
                XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
                xPathStatement.compileTokens(line.substring(startXPath + 4));
                this.loopSet = xPathStatement;

                return false;
            } else {
                throw new SyntaxErrorException("A foreach statement must start with 'foreach': " + this.fullStatement);
            }
        } else if(null == loopBody) {
            if(line.startsWith(DO)) {
                XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
                xPathStatement.compileTokens(line.substring(3));
                this.loopBody = xPathStatement;
                return true;
            } else {
                throw new SyntaxErrorException("A foreach statement must contain a 'do' component: " + this.fullStatement);
            }
        } else {
            throw new SyntaxErrorException("Malformed foreach statement: " + this.fullStatement);
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
        return firstLine.startsWith(FOREACH + SINGLESPACE);
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
