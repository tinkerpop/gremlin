package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.lang.Tokens;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class XPathEvaluator {

    /*static {
        System.setProperty("org.apache.commons.jxpath.JXPathContextFactory", "com.tinkerpop.gremlin.GremlinPathContextFactory");
    }*/

    private GremlinPathContext baseContext;

    public XPathEvaluator() {
        this.baseContext = GremlinPathContext.newContext(null);
        this.baseContext.setLenient(false);

    }

    public List evaluate(String xPathString) {
        if (this.baseContext.rootChanged()) {
            this.baseContext = GremlinPathContext.newContext(this.baseContext, this.baseContext.getRoot());
        }
        List results = this.baseContext.selectNodes(xPathString);
        this.setVariable(Tokens.LAST_VALUE, results);
        return results;
    }

    public void setVariable(String variable, Object value) {
        this.baseContext.setVariable(variable, value);
    }

    public Object getVariable(String variable) {
        return this.baseContext.getVariable(variable);
    }

    public void setRoot(Object root) {
        this.baseContext.setRoot(root);
    }

    public Object getRoot() {
        return this.baseContext;
    }
}
