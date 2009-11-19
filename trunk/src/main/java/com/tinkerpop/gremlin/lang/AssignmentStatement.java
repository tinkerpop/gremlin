package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class AssignmentStatement extends Statement {

    public static final String ASSIGNMENT = ":=";
    public String variable;
    public XPathStatement assignmentBody;

    public AssignmentStatement(XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public boolean compileTokens(String line) throws SyntaxErrorException {
        super.compileTokens(line);
        String[] parts = line.split(SINGLESPACE);
        if (!parts[0].startsWith(DOLLAR_SIGN)) {
            throw new SyntaxErrorException("An assignment statement must start with variable reference: " + this.fullStatement);
        } else if (!parts[1].equals(ASSIGNMENT)) {
            throw new SyntaxErrorException("An assignment statement must have an assignment operator: " + this.fullStatement);
        }
        this.variable = parts[0];
        XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
        int xPathStart = line.indexOf(" " + ASSIGNMENT + " ");
        xPathStatement.compileTokens(line.substring(xPathStart + 4));
        this.assignmentBody = xPathStatement;
        return true;
    }

    public List evaluate() {
        List results = this.assignmentBody.evaluate();
        this.xPathEvaluator.setVariable(variable, results);
        return results;
    }

    public static boolean isStatement(String firstLine) {
        return firstLine.startsWith(DOLLAR_SIGN) && firstLine.contains(SINGLESPACE + ASSIGNMENT + SINGLESPACE);
    }

    public String toString() {
        return "(ASSIGNEMENT VARIABLE["+ this.variable +"] BODY["+ this.assignmentBody +"])";
    }
}
