package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AssignmentStatement extends SimpleStatement {

    private String variable;
    private XPathStatement assignmentBody;

    /*private static final Pattern assignmentPattern = Pattern.compile("^" + Tokens.ZEROPLUS_WHITESPACE_REGEX +
             Tokens.VARIABLE_REGEX + "[/[^' '\t]+]*" + Tokens.WHITESPACE_REGEX + Tokens.ASSIGNMENT + Tokens.WHITESPACE_REGEX + Tokens.NONWHITESPACE_REGEX);*/
    private static final Pattern assignmentPattern = Pattern.compile(Tokens.NONWHITESPACE_REGEX + "+" + Tokens.WHITESPACE_REGEX + Tokens.ASSIGNMENT + Tokens.WHITESPACE_REGEX + Tokens.NONWHITESPACE_REGEX);

    /*
        $i := ./././
        $i[1] := ./././
        $i/@key := ./././
        $i/key := ./././
        $i[@name='key with space'] := ./././
     */

    public AssignmentStatement(final XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public void compileTokens(final String line) throws SyntaxException {
        super.compileTokens(line);
        String[] parts = line.split(Tokens.ASSIGNMENT);
        this.variable = parts[0].trim();
        Matcher matcher = assignmentPattern.matcher(line);
        if (matcher.find()) {
            XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
            xPathStatement.compileTokens(line.substring(matcher.end() - 2));
            this.assignmentBody = xPathStatement;
        } else {
            throw new SyntaxException(this.toString());
        }
    }

    public List evaluate() throws EvaluationException {
        List results;
        try {
            this.xPathEvaluator.setLastStatementLineNumber(this.lineNumber);
            // TODO better escaping of string quotes
            results = this.xPathEvaluator.evaluateList("g:assign(\"" + this.variable + "\"," + this.assignmentBody.toString() + ")");
        } catch (Exception e) {
            throw new EvaluationException(e.getMessage());
        }
        return results;
    }

    public static boolean isStatement(final String firstLine) {
        return assignmentPattern.matcher(firstLine).find();
    }
}
