package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.io.PrintStream;


/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Evaluator {

    protected GremlinPathContext baseContext = (GremlinPathContext)GremlinPathContext.newContext(null);
    protected PrintStream output;

    /*static {
        System.setProperty("org.apache.commons.jxpath.JXPathContextFactory","com.tinkerpop.gremlin.GremlinPathContextFactory");
    }*/

    public List evaluate(String path) throws JXPathInvalidSyntaxException, JXPathInvalidAccessException {

        if(this.baseContext.rootChanged() && null != this.baseContext.getContextBean()) {
            this.baseContext = (GremlinPathContext)GremlinPathContext.newContext(this.baseContext, this.baseContext.getContextBean());
        }
        
        List results = this.baseContext.selectNodes(path);
        this.baseContext.getVariables().declareVariable("_", results);
        return results;
    }
}
