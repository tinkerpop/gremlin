package com.tinkerpop.gremlin.functions;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.gremlin.GremlinPathContext;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.Tokens;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.Pointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Collection;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FunctionHelper {

    public static boolean assertTypes(final Object[] objects, final Class[] types) {
        for (int i = 0; i < objects.length; i++) {
            if (!types[i].isInstance(objects[i]))
                return false;
        }
        return true;
    }

    public static boolean isLastInContext(final ExpressionContext context) {
        return (context.getContextNodeList().size() == context.getPosition()) || (context.getPosition() == 0);
    }

    public static boolean isFirstInContext(final ExpressionContext context) {
        return context.getPosition() == 1;
    }

    public static GremlinPathContext getGremlin(final ExpressionContext context) {
        return (GremlinPathContext) context.getJXPathContext();
    }

    public static Graph getGraph(final ExpressionContext context) {
        Object graph = FunctionHelper.getGremlin(context).getVariables().getVariable(Tokens.GRAPH_VARIABLE);
        if (null != graph && graph instanceof Graph)
            return (Graph) graph;
        else
            throw new EvaluationException(Tokens.GRAPH_VARIABLE + " does not reference a graph");

    }

    public static List<Object> asObject(final List<Pointer> nodePointers) {
        List<Object> nodeValues = new ArrayList<Object>();
        for (Pointer p : nodePointers) {
            nodeValues.add(p.getValue());
        }
        return nodeValues;
    }

    public static String makeFunctionName(final String namespace, String name) {
        return namespace + ":" + name;
    }

    public static boolean isUnmodifiable(final Object object) {
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

    public static Object nodeSetConversion(final Object object) {
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

    public static Object[] nodeSetConversion(final Object[] objects) {
        if (null != objects) {
            Object[] converts = new Object[objects.length];
            for (int i = 0; i < objects.length; i++) {
                converts[i] = nodeSetConversion(objects[i]);
            }
            return converts;
        } else {
            return null;
        }
    }

}
