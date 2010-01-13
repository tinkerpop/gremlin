package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class RepeatStatement extends CompoundStatement {

    private XPathStatement times;

    private static final Pattern repeatPattern = Pattern.compile("^" + Tokens.ZEROPLUS_WHITESPACE_REGEX + Tokens.REPEAT +
            Tokens.WHITESPACE_REGEX + Tokens.NONWHITESPACE_REGEX);

    /* repeat ./././
        ./././
        end
    */

    public RepeatStatement(final XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public void compileTokens(final String line) {
        super.compileTokens(line);
        if (times == null) {
            Matcher matcher = repeatPattern.matcher(line);
            if (matcher.find()) {
                XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
                xPathStatement.compileTokens(line.substring(matcher.end() - 1));
                this.times = xPathStatement;
            } else {
                throw new SyntaxException(this.toString());
            }
        } else {
            this.updateStatementList(line);
        }
    }

    public List evaluate() throws EvaluationException {
        List results = null;
        try {
            List timesList = times.evaluate();
            if (timesList != null && timesList.size() > 0) {
                int numberOfTimes = Double.valueOf(timesList.get(0).toString()).intValue();
                for (int i = 0; i < numberOfTimes; i++) {
                    for (Statement statement : this.statementList) {
                        results = statement.evaluate();
                    }
                }
            }
        } catch (Exception e) {
            throw new EvaluationException(e.getMessage());
        }
        return results;
    }

    public static boolean isStatement(final String firstLine) {
        return repeatPattern.matcher(firstLine).find();
    }
}
