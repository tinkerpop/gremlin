package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class ForeachStatement extends CompoundStatement {


    private String variable;
    private XPathStatement loopSet;

    private static final Pattern foreachPattern = Pattern.compile("^" + Tokens.ZEROPLUS_WHITESPACE_REGEX + Tokens.FOREACH + Tokens.WHITESPACE_REGEX +
            Tokens.VARIABLE_REGEX + Tokens.WHITESPACE_REGEX + Tokens.IN + Tokens.WHITESPACE_REGEX + Tokens.NONWHITESPACE_REGEX);

    /* foreach $i in ./././
         ./././
         end
     */

    public ForeachStatement(XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public void compileTokens(String line) throws SyntaxErrorException {
        super.compileTokens(line);
        if (variable == null && null == loopSet) {

            String[] parts = line.split(Tokens.WHITESPACE_REGEX);

            if (parts.length < 4)
                throw new SyntaxErrorException(this.toString());

            this.variable = parts[1];

            Matcher matcher = foreachPattern.matcher(line);
            if (matcher.find()) {
                XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
                xPathStatement.compileTokens(line.substring(matcher.end() - 1));
                this.loopSet = xPathStatement;
            } else {
                throw new SyntaxErrorException(this.toString());
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
            throw new EvaluationErrorException(e.getMessage());
        }
        return results;
    }

    public static boolean isStatement(String firstLine) {
        return foreachPattern.matcher(firstLine).find();
    }

}
