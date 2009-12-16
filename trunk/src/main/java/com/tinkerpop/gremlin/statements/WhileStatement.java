package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class WhileStatement extends CompoundStatement {

    private XPathStatement condition;

    private static final Pattern whilePattern = Pattern.compile("^" + Tokens.ZEROPLUS_WHITESPACE_REGEX + Tokens.WHILE +
            Tokens.WHITESPACE_REGEX + Tokens.NONWHITESPACE_REGEX);

    /* while ./././
        ./././
        end
    */

    public WhileStatement(XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public void compileTokens(String line) {
        super.compileTokens(line);
        if (condition == null) {
            Matcher matcher = whilePattern.matcher(line);
            if (matcher.find()) {
                XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
                xPathStatement.compileTokens(line.substring(matcher.end() - 1));
                this.condition = xPathStatement;
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
            while (true) {
                List conditionList = condition.evaluate();
                if (null != conditionList && conditionList.size() > 0) {
                    if ((Boolean) conditionList.get(0)) {
                        for (Statement statement : this.statementList) {
                            results = statement.evaluate();
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        catch (Exception e) {
            throw new EvaluationException(e.getMessage());
        }
        return results;
    }

    public static boolean isStatement(String firstLine) {
        return whilePattern.matcher(firstLine).find();
    }
}
