package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.Pointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class FunctionHelper {

    public static boolean isLastInContext(ExpressionContext context) {
        return (context.getContextNodeList().size() == context.getPosition()) || (context.getPosition() == 0);
    }

    public static boolean isFirstInContext(ExpressionContext context) {
        return context.getPosition() == 1;
    }

    public static GremlinPathContext getGremlin(ExpressionContext context) {
        return (GremlinPathContext) context.getJXPathContext();
    }

    public static List<Object> asObject(List<Pointer> nodePointers) {
        List<Object> nodeValues = new ArrayList<Object>();
        for (Pointer p : nodePointers) {
            nodeValues.add(p.getValue());
        }
        return nodeValues;
    }

    public static boolean isUnmodifiable(Object object) {
        if (object instanceof List) {
            try {
                ((List) object).remove(-1);
            } catch (UnsupportedOperationException e) {
                return true;
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        return false;
    }

    public static Object nodeSetConversion(Object object) {
        if (object instanceof NodeSet) {
            List list = new ArrayList(((NodeSet) object).getValues());
            if (list.size() == 1)
                return list.get(0);
            else
                return list;
        } else {
            return object;
        }
    }

    public static Object[] nodeSetConversion(Object[] objects) {
        if (null != objects) {
            Object[] converts = new Object[objects.length];
            for(int i=0; i<objects.length; i++) {
                converts[i] = nodeSetConversion(objects[i]);
            }
            return converts;
        } else {
            return null;
        }
    }
}
