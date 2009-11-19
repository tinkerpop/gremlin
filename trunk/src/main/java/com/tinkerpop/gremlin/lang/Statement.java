package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public abstract class Statement {


    protected XPathEvaluator xPathEvaluator;

    private String rawStatement = new String();

    public Statement(XPathEvaluator xPathEvaluator) {
        this.xPathEvaluator = xPathEvaluator;
    }

    public boolean compileTokens(String line) {
        this.rawStatement = (this.rawStatement + Tokens.SINGLESPACE + line).trim();
        return true;
    }

    public String getRawStatement() {
        return this.rawStatement;
    }

    public abstract List evaluate();

}
