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

    protected GremlinPathContext baseContext;
    protected PrintStream output;

    public Evaluator(Element rootElement) {

        this.baseContext = GremlinPathContext.newContext(rootElement);
        
    }

    public List<Object> evaluate(String path) throws JXPathInvalidSyntaxException {
        List<Object> results = this.baseContext.selectNodes(path);
        this.baseContext.getVariables().declareVariable("_", results);
        this.baseContext.getVariables().declareVariable("_P", path);
        for(Object o : results) {
            System.out.println(o);
        }
        return results;
    }
}
