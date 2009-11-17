package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;

import java.util.List;


/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Evaluator {

    protected GremlinPathContext baseContext = (GremlinPathContext) GremlinPathContext.newContext(null);

    /*static {
        System.setProperty("org.apache.commons.jxpath.JXPathContextFactory", "com.tinkerpop.gremlin.GremlinPathContextFactory");
    }*/


    public List evaluate(String path) throws JXPathInvalidSyntaxException, JXPathInvalidAccessException {

        if (this.baseContext.rootChanged()) {
            //System.out.println("new root.");
            this.baseContext = (GremlinPathContext) GremlinPathContext.newContext(this.baseContext, this.baseContext.getContextBean());
        }

        List results = this.baseContext.selectNodes(path);
        this.baseContext.getVariables().declareVariable("_", results);
        return results;
    }
}
