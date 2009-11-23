package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class IfElseStatement extends CompoundStatement {

    private XPathStatement condition;
    private boolean inElse = false;
    private List<Statement> elseStatementList = new ArrayList<Statement>();

    private static final Pattern ifPattern = Pattern.compile("^" + Tokens.ZEROPLUS_WHITESPACE_REGEX + Tokens.IF +
            Tokens.WHITESPACE_REGEX + Tokens.NONWHITESPACE_REGEX);

    private static final Pattern elsePattern = Pattern.compile("^" + Tokens.ZEROPLUS_WHITESPACE_REGEX + Tokens.ELSE);

    /*
       if ./././
           ./././
       end

       if ./././
           ./././
       else
           ./././
       end
    */


    public IfElseStatement(XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);

    }

    public void compileTokens(String line) throws SyntaxErrorException {
        super.compileTokens(line);
        if (condition == null) {
            Matcher matcher = ifPattern.matcher(line);
            if (matcher.find()) {
                XPathStatement xPathStatement = new XPathStatement(this.xPathEvaluator);
                xPathStatement.compileTokens(line.substring(matcher.end() - 1));
                this.condition = xPathStatement;
            } else {
                throw new SyntaxErrorException("Invalid statement: '" + this.toString());
            }
        } else if (elsePattern.matcher(line).find()) {
            this.inElse = true;
        } else if (!this.inElse) {
            this.updateStatementList(line);
        } else if (this.inElse) {
            this.updateElseStatementList(line);
        }
    }

    public List evaluate() throws EvaluationErrorException {
        List results = null;
        try {
            if ((Boolean) condition.evaluate().get(0)) {
                for(Statement statement : this.statementList) {
                    results = statement.evaluate();
                }
            } else {
                for(Statement statement : this.elseStatementList) {
                    results = statement.evaluate();
                }
            }
        } catch (Exception e) {
            throw new EvaluationErrorException("Evaluation error: " + e.getMessage());
        }
        return results;
    }

   public static boolean isStatement(String firstLine) {
        return ifPattern.matcher(firstLine).find();
    }

    protected void updateElseStatementList(String line) {
        Statement currentElseStatement = this.getCurrentElseStatement();
        if (null != currentElseStatement && !currentElseStatement.isComplete()) {
            currentElseStatement.compileTokens(line);
        } else {
            if (CompoundStatement.endPattern.matcher(line).find()) {
                this.complete = true;
                this.xPathEvaluator.decrDepth(); // COMPOUND STATEMENT HAS ENDED: DECREMENT THE DEPTH OF THE EVALUATOR
            } else {
                Statement statement = StatementGenerator.generateStatement(line, this.xPathEvaluator);
                statement.compileTokens(line);
                this.elseStatementList.add(statement);
            }
        }
    }

    private Statement getCurrentElseStatement() {
        if (this.elseStatementList.size() > 0)
            return this.elseStatementList.get(this.statementList.size() - 1);
        else
            return null;
    }

}
