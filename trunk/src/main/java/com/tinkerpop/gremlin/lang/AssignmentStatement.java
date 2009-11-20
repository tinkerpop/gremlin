package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class AssignmentStatement extends Statement {

    private String variable;
    private XPathStatement assignmentBody;

    /*
        $i := ./././
     */

    public AssignmentStatement(XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public boolean compileTokens(String line) throws SyntaxErrorException {
        super.compileTokens(line);
        String[] parts = line.split(Tokens.SINGLESPACE);
        if (!parts[0].startsWith(Tokens.DOLLAR_SIGN)) {
            throw new SyntaxErrorException("Invalid statement: '" + this.getRawStatement() + "'. Assignment must start with a variable.");
        } else if (!parts[1].equals(Tokens.ASSIGNMENT)) {
            throw new SyntaxErrorException("Invalid statement: '" + this.getRawStatement() + "'. Assignment must have the assignment operator.");
        }
        this.variable = parts[0];
        XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
        int xPathStart = line.indexOf(" " + Tokens.ASSIGNMENT + " ");
        xPathStatement.compileTokens(line.substring(xPathStart + 4));
        this.assignmentBody = xPathStatement;
        return true;
    }

    public List evaluate() throws EvaluationErrorException {
        List results = null;
        try {
            results = this.assignmentBody.evaluate();
            this.xPathEvaluator.evaluate("g:set('" + this.variable + "'," + this.assignmentBody.getRawStatement() + ")");
        } catch (Exception e) {
            throw new EvaluationErrorException("Evaluation error: " + e.getMessage());
        }
        return results;
    }

    public static boolean isStatement(String firstLine) {
        return firstLine.startsWith(Tokens.DOLLAR_SIGN) && firstLine.contains(Tokens.SINGLESPACE + Tokens.ASSIGNMENT + Tokens.SINGLESPACE);
    }

    public String getVariable() {
        return this.variable;
    }

    public XPathStatement getAssignmentBody() {
        return this.assignmentBody;
    }

    public String toString() {
        return "(ASSIGNMENT VARIABLE[" + this.variable + "] BODY[" + this.assignmentBody + "])";
    }
}
