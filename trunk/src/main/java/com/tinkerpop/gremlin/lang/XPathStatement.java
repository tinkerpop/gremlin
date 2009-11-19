package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class XPathStatement extends Statement {

    private String xPath;

    public XPathStatement(XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public boolean compileTokens(String line) {
        super.compileTokens(line);
        this.xPath = line;
        return true;
    }

    public List evaluate() {
        return this.xPathEvaluator.evaluate(this.xPath);
    }


    public String toString() {
        return "(XPATH " + this.xPath + ")";
    }
}
