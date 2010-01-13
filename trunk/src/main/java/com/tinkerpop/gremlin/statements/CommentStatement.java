package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class CommentStatement extends SimpleStatement {

    private static final Pattern commentPattern = Pattern.compile("^" + Tokens.ZEROPLUS_WHITESPACE_REGEX + Tokens.COMMENT);

    /*
    # a comment
    */

    public CommentStatement(final XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }
    
    public List evaluate() {
        return null;
    }

    public static boolean isStatement(final String firstLine) {
        return commentPattern.matcher(firstLine).find();
    }
}
