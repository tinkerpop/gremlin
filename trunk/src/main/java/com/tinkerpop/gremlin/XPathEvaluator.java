package com.tinkerpop.gremlin;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class XPathEvaluator {

    /*static {
        System.setProperty("org.apache.commons.jxpath.JXPathContextFactory", "com.tinkerpop.gremlin.GremlinPathContextFactory");
    }*/
    private static final String DOLLAR_SIGN = "$";
    private static final String EMPTY_STRING = "";
    private static final String AT_VARIABLE = "$_@";
    private static final String LAST_VARIABLE = "$_";
    protected GremlinPathContext baseContext = (GremlinPathContext) GremlinPathContext.newContext(null);

    public List evaluate(String xpath) {
        //System.out.println("Evaluating: " + path);
        if (this.baseContext.rootChanged()) {
            //System.out.println("new root.");
            this.baseContext = (GremlinPathContext) GremlinPathContext.newContext(this.baseContext, this.baseContext.getContextBean());
        }
        List results = this.baseContext.selectNodes(xpath);
        this.setVariable(LAST_VARIABLE, results);
        return results;
    }

    public void setVariable(String variable, Object value) {
        if (variable.equals(AT_VARIABLE)) {
            if (value instanceof List) {
                if (((List) value).size() == 1) {
                    value = ((List) value).get(0);
                }
            }
            this.baseContext.setRoot(value);
        }
        this.baseContext.getVariables().declareVariable(XPathEvaluator.cleanVariable(variable), value);
    }

    public Object getVariable(String variable) {
        return this.baseContext.getVariables().getVariable(XPathEvaluator.cleanVariable(variable));
    }

    public void setRoot(Object rootObject) {
        this.baseContext.setRoot(rootObject);
    }

    private static String cleanVariable(String variable) {
        return variable.replace(DOLLAR_SIGN, EMPTY_STRING);
    }
}
