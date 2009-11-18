package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.JXPathContext;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class FunctionHelper {

    private static final String DOLLAR_SIGN = "$";
    private static final String EMPTY_STRING = "";

    public static boolean isLastInContext(ExpressionContext context) {
        return (context.getContextNodeList().size() == context.getPosition()) || (context.getPosition() == 0);      
    }

    public static GremlinPathContext getGremlin(ExpressionContext context) {
        return (GremlinPathContext)context.getJXPathContext();
    }

    public static List<Object> asValue(List<Pointer> nodePointers) {
        List<Object> nodeValues = new ArrayList<Object>();
        for(Pointer p : nodePointers) {
            nodeValues.add(p.getValue());
        }
        return nodeValues;
    }

    public static String getVariable(String variable) {
        return variable.replace(DOLLAR_SIGN, EMPTY_STRING);
    }
}
