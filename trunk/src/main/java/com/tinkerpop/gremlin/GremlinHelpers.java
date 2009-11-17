package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Pointer;

import java.util.List;
import java.util.LinkedList;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinHelpers {

    public static boolean isLastInContext(ExpressionContext context) {
        return (context.getContextNodeList().size() == context.getPosition()) || (context.getPosition() == 0);      
    }

    public static List<Object> asValue(List<Pointer> nodePointers) {
        List<Object> nodeValues = new LinkedList<Object>();
        for(Pointer p : nodePointers) {
            nodeValues.add(p.getValue());
        }
        return nodeValues;
    }
}
