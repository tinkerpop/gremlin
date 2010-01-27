package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.DynamicPath;
import com.tinkerpop.gremlin.ElementPropertyHandler;
import com.tinkerpop.gremlin.GremlinPathContext;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PathStatement extends CompoundStatement {

    private String pathName;

    private static final Pattern pathPattern = Pattern.compile("^path\\s+([\\w-]+){1}");

    /* path string
        ./././
        end
    */

    public PathStatement(final XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public void compileTokens(final String line) {
        super.compileTokens(line);
        if (null == this.pathName) {
            Matcher function = pathPattern.matcher(line);

            if (function.find()) {
                if (function.groupCount() != 1)
                    throw new SyntaxException("Bad path definition");

                this.pathName = function.group(1);
            } else {
                throw new SyntaxException("Bad path definition");
            }
        } else {
            this.updateStatementList(line);
        }
    }

    public List evaluate() throws EvaluationException {
        List results = null;
        try {
            DynamicPath path = new DynamicPath(this);
            GremlinPathContext.registerPath(path);

        } catch (Exception e) {
            throw new EvaluationException(e.getMessage());
        }
        return results;
    }

    public String getPathName() {
        return this.pathName;
    }

    public static boolean isStatement(final String firstLine) {
        return pathPattern.matcher(firstLine).find();
    }
}
