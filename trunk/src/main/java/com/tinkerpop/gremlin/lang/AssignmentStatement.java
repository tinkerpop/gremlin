package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
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

    public AssignmentStatement(XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public void compileTokens(String line) throws SyntaxErrorException {
        super.compileTokens(line);
        //String[] parts = line.split(Tokens.WHITESPACE_REGEX);
        String[] parts = line.split(Tokens.ASSIGNMENT);
        this.variable = parts[0].trim();
        Matcher matcher = assignmentPattern.matcher(line);
        if (matcher.find()) {
            XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
            xPathStatement.compileTokens(line.substring(matcher.end() - 2));
            this.assignmentBody = xPathStatement;
        } else {
            throw new SyntaxErrorException("Invalid statement: '" + this.toString());
        }
    }

    public List evaluate() throws EvaluationErrorException {
        List results;
        try {
            // TODO better escaping of string quotes
            results = this.xPathEvaluator.evaluate("g:assign(\"" + this.variable + "\"," + this.assignmentBody.toString() + ")");
        } catch (Exception e) {
            throw new EvaluationErrorException("Evaluation error: " + e.getMessage());
        }
        return results;
    }

    public static boolean isStatement(String firstLine) {
        return assignmentPattern.matcher(firstLine).find();
    }
}
