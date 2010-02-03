package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.GremlinEvaluator;
import com.tinkerpop.gremlin.XPathEvaluator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ScriptStatement extends SimpleStatement implements ReflectiveStatement {

    private String fileNameExpression;
    private GremlinEvaluator gremlinEvaluator;

    private static final Pattern scriptPattern = Pattern.compile("^" + Tokens.ZEROPLUS_WHITESPACE_REGEX + Tokens.SCRIPT +
            Tokens.WHITESPACE_REGEX + Tokens.NONWHITESPACE_REGEX);

    /*
    script ./././
    */

    public ScriptStatement(final XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public void compileTokens(final String line) throws SyntaxException {
        super.compileTokens(line);
        this.fileNameExpression = line.substring(Tokens.SCRIPT.length() + 1);
    }

    public List evaluate() {
        this.xPathEvaluator.setLastStatementLineNumber(this.lineNumber);
        List result = this.xPathEvaluator.evaluateList(this.fileNameExpression);
        if (result.size() > 0) {
            String fileName = result.get(0).toString();
            try {
                return this.gremlinEvaluator.evaluate(new FileInputStream(fileName));
            } catch (IOException e) {
                throw new EvaluationException(e.getMessage());
            }
        } else {
            throw new EvaluationException("Invalid file name expression");
        }
    }

    public void setGremlinEvaluator(final GremlinEvaluator gremlinEvaluator) {
        this.gremlinEvaluator = gremlinEvaluator;
    }

    public static boolean isStatement(final String firstLine) {
        return scriptPattern.matcher(firstLine).find();
    }
}
