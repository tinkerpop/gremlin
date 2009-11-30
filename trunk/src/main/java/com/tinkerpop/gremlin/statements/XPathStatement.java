package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class XPathStatement extends SimpleStatement {

    private String xPath;

    public XPathStatement(XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public void compileTokens(String line) {
        super.compileTokens(line);
        this.xPath = line;
    }

    public List evaluate() {
        return this.xPathEvaluator.evaluate(this.xPath);
    }
}
