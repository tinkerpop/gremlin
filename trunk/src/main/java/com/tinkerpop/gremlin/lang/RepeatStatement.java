package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class RepeatStatement extends Statement {

    private XPathStatement times;
    private XPathStatement loopBody;

    public RepeatStatement(XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public static boolean isStatement(String firstLine) {
        return firstLine.startsWith(Tokens.REPEAT + Tokens.SINGLESPACE);
    }

    public boolean compileTokens(String line) {
        super.compileTokens(line);
        if (times == null) {
            if (line.startsWith(Tokens.REPEAT)) {
                String[] parts = line.split(Tokens.SINGLESPACE);
                if (!parts[0].equals(Tokens.REPEAT))
                    throw new SyntaxErrorException("Invalid statement: '" + this.getRawStatement() + "'. Repeat must start with 'repeat'.");

                XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
                xPathStatement.compileTokens(line.substring(7));
                this.times = xPathStatement;
                return false;
            } else {
                throw new SyntaxErrorException("Invalid statement: '" + this.getRawStatement() + "'. Repeat must start with 'repeat'.");
            }
        } else if (null == loopBody) {
            if (line.startsWith(Tokens.DO)) {
                XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
                xPathStatement.compileTokens(line.substring(3));
                this.loopBody = xPathStatement;
                return true;
            } else {
                throw new SyntaxErrorException("Invalid statement: '" + this.getRawStatement() + "'. Repeat must have a 'do' component.");
            }
        } else {
            throw new SyntaxErrorException("Invalid statement: " + this.getRawStatement());
        }
    }

    public List evaluate() {
        int numberOfTimes = Float.valueOf(times.evaluate().get(0).toString()).intValue();
        List results = null;
        for(int i=0; i<numberOfTimes; i++) {
            results = loopBody.evaluate();
        }
        return results; 
    }

    public XPathStatement getTimes() {
        return this.times;
    }

    public XPathStatement getLoopBody() {
        return this.loopBody;
    }

    public String toString() {
        return "(REPEAT TIMES[" + this.times + "] LOOPBODY[" + this.loopBody + "])";
    }


}
