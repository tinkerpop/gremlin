package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.XPathEvaluator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public abstract class SimpleStatement extends Statement {

    public SimpleStatement(final XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public void compileTokens(final String line) {
        super.compileTokens(line);
        this.complete = true;
    }
}
