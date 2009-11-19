package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public abstract class Statement {
    public static final String DO = "do";
    public static final String DOLLAR_SIGN = "$";

    protected static final String NEWLINE = "\n";
    protected static final String ANY_WHITESPACE_REGEX = "[' '\t]+";
    protected static final String SINGLESPACE = " ";


    protected XPathEvaluator xPathEvaluator;

    protected String fullStatement = new String();

    public Statement(XPathEvaluator xPathEvaluator) {
        this.xPathEvaluator = xPathEvaluator;
    }

    public boolean compileTokens(String line) {
        this.fullStatement = (this.fullStatement + NEWLINE + line).trim();
        return true;
    }

    public abstract List evaluate();

}
