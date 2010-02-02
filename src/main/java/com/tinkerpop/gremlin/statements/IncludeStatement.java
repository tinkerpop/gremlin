package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.paths.PathLibrary;
import org.apache.commons.jxpath.Functions;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IncludeStatement extends SimpleStatement {

    // include 'com.example.FunctionLibrary'
    // include 'gremlin.sh'
    // include ./././

    private String includeLocation;

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
                Class aClass = Class.forName(name);
                if (Functions.class.isAssignableFrom(aClass)) {
                    this.xPathEvaluator.getFunctions().addFunctions((Functions) aClass.newInstance());
                } else if(PathLibrary.class.isAssignableFrom(aClass)) {
                    this.xPathEvaluator.getPaths().addPaths((PathLibrary)aClass.newInstance());
                }
            } catch (ClassNotFoundException e) {
                System.out.println("try for gremlin file.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public static boolean isStatement(final String firstLine) {
        return includePattern.matcher(firstLine).find();
    }
}
