package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.GremlinEvaluator;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.functions.Functions;
import com.tinkerpop.gremlin.paths.Paths;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IncludeStatement extends SimpleStatement implements ReflectiveStatement {

    // include 'com.example.FunctionLibrary'
    // include 'gremlin.sh'
    // include ./././

    private String includeLocation;
    private GremlinEvaluator gremlinEvaluator;

    private static final Pattern includePattern = Pattern.compile("^" + Tokens.ZEROPLUS_WHITESPACE_REGEX + Tokens.INCLUDE +
            Tokens.WHITESPACE_REGEX + Tokens.NONWHITESPACE_REGEX);

    public IncludeStatement(final XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public void compileTokens(final String line) throws SyntaxException {
        super.compileTokens(line);
        this.includeLocation = line.substring(Tokens.INCLUDE.length() + 1).trim();
    }

    public List evaluate() {
        this.xPathEvaluator.setLastStatementLineNumber(this.lineNumber);
        List result = this.xPathEvaluator.evaluateList(this.includeLocation);
        if (result.size() > 0 && result.get(0) instanceof String) {
            String name = (String) result.get(0);
            try {
                // assume that it is a java class reference first
                Class aClass = Class.forName(name);
                if (Functions.class.isAssignableFrom(aClass)) {
                    this.xPathEvaluator.getFunctions().addFunctions((Functions) aClass.newInstance());
                    return Arrays.asList(Boolean.TRUE);
                } else if (Paths.class.isAssignableFrom(aClass)) {
                    this.xPathEvaluator.getPaths().addPaths((Paths) aClass.newInstance());
                    return Arrays.asList(Boolean.TRUE);
                }
            } catch (ClassNotFoundException e) {
                // if it is not a java class reference, assume it is a gremlin file
                try {
                    this.gremlinEvaluator.evaluate(new FileInputStream(name));
                    return Arrays.asList(Boolean.TRUE);
                } catch (IOException f) {
                    throw new EvaluationException(f.getMessage());
                }
            } catch (Exception e) {
                throw new EvaluationException(e.getMessage());
            }
        }
        return Arrays.asList(Boolean.FALSE);
    }

    public void setGremlinEvaluator(final GremlinEvaluator gremlinEvaluator) {
        this.gremlinEvaluator = gremlinEvaluator;
    }

    public static boolean isStatement(final String firstLine) {
        return includePattern.matcher(firstLine).find();
    }
}
