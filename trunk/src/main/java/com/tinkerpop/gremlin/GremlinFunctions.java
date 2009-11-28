package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.ClassFunctions;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.JXPathFunctionNotFoundException;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinFunctions extends ClassFunctions {

    public static final String NAMESPACE_PREFIX = "g";


    private static final String APPEND = "append";
    private static final String REMOVE = "remove";
    private static final String REMOVE_I = "remove_i";

    private static final String UNION = "union";
    private static final String INTERSECT = "intersect";
    private static final String DIFFERENCE = "difference";

    private static final String RETAIN = "retain";
    private static final String EXCEPT = "except";


    private static final Map<String, Function> functionMap = new HashMap<String, Function>();

    static {
        functionMap.put(APPEND, new AppendFunction());
        functionMap.put(REMOVE, new RemoveFunction());
        functionMap.put(REMOVE_I, new RemoveIFunction());
        functionMap.put(UNION, new UnionFunction());
        functionMap.put(INTERSECT, new IntersectFunction());
        functionMap.put(DIFFERENCE, new DifferenceFunction());
        functionMap.put(RETAIN, new RetainFunction());
        functionMap.put(EXCEPT, new ExceptFunction());

    }

    public GremlinFunctions(String namespace) {
        super(GremlinClassFunctions.class, namespace);
    }

    public Function getFunction(String namespace, String name, Object[] parameters) throws JXPathFunctionNotFoundException {
        Function function = functionMap.get(name);
        if (null != function && parameters.length > 0)
            return function;

        try {
            function = super.getFunction(namespace, name, parameters);
        } catch (NoClassDefFoundError e) {
            throw new JXPathFunctionNotFoundException("Undefined function: " + namespace + ":" + name);
        }
        if (null != function)
            return function;
        else
            throw new JXPathFunctionNotFoundException("Undefined function: " + namespace + ":" + name);


    }

    public static class AppendFunction implements Function {

        public List invoke(ExpressionContext context, Object[] parameters) {
            List list = new ArrayList();
            for (Object object : parameters) {
                if (object instanceof Collection)
                    list.addAll((Collection) object);
                else
                    list.add(object);

            }
            return list;
        }
    }

    public static class RemoveFunction implements Function {

        public List invoke(ExpressionContext context, Object[] parameters) {
            List list = new ArrayList();
            if (parameters[0] instanceof Collection)
                list.addAll((Collection) parameters[0]);
            else
                list.add(parameters[0]);

            for (int i = 1; i < parameters.length; i++) {
                Object object = parameters[i];
                if (object instanceof Collection)
                    list.removeAll((Collection) object);
                else
                    list.remove(object);
                if (list.size() == 0)
                    return list;
            }
            return list;
        }
    }

    public static class RemoveIFunction implements Function {

        public List invoke(ExpressionContext context, Object[] parameters) {
            List list = new ArrayList();
            if (parameters[0] instanceof Collection)
                list.addAll((Collection) parameters[0]);
            else
                list.add(parameters[0]);

            list.remove(Float.valueOf(parameters[1].toString()).intValue()+1);
            return list;
        }
    }

    public static class UnionFunction implements Function {

        public Set invoke(ExpressionContext context, Object[] parameters) {
            Set set = new HashSet();
            for (Object object : parameters) {
                if (object instanceof Collection)
                    set.addAll((Collection) object);
                else
                    set.add(object);

            }
            return set;
        }
    }

    public static class IntersectFunction implements Function {

        public Set invoke(ExpressionContext context, Object[] parameters) {
            Set set = new HashSet();
            if (parameters[0] instanceof Collection)
                set.addAll((Collection) parameters[0]);
            else
                set.add(parameters[0]);

            for (int i = 1; i < parameters.length; i++) {
                Object object = parameters[i];
                if (object instanceof Collection)
                    set.retainAll((Collection) object);
                else {
                    Set tempSet = new HashSet();
                    tempSet.add(object);
                    set.retainAll(tempSet);
                }
                if (set.size() == 0)
                    return set;
            }
            return set;
        }
    }

    public static class DifferenceFunction implements Function {

        public Set invoke(ExpressionContext context, Object[] parameters) {
            Set set = new HashSet();
            if (parameters[0] instanceof Collection)
                set.addAll((Collection) parameters[0]);
            else
                set.add(parameters[0]);

            for (int i = 1; i < parameters.length; i++) {
                Object object = parameters[i];
                if (object instanceof Collection)
                    set.removeAll((Collection) object);
                else {
                    set.remove(object);
                }
                if (set.size() == 0)
                    return set;
            }
            return set;
        }
    }

    public static class RetainFunction implements Function {

        public Boolean invoke(ExpressionContext context, Object[] parameters) {
            Set setA = new HashSet();
            for (Object object : parameters) {
                if (object instanceof Collection)
                    setA.addAll((Collection) object);
                else
                    setA.add(object);

            }
            Set setB = new HashSet();
            setB.add(context.getContextNodePointer().getValue());
            setA.retainAll(setB);
            return setA.size() > 0;
        }
    }

    public static class ExceptFunction implements Function {

        public Boolean invoke(ExpressionContext context, Object[] parameters) {
            Set setA = new HashSet();
            for (Object object : parameters) {
                if (object instanceof Collection)
                    setA.addAll((Collection) object);
                else
                    setA.add(object);

            }
            Set setB = new HashSet();
            setB.add(context.getContextNodePointer().getValue());
            setB.removeAll(setA);
            return setB.size() > 0;
        }
    }
}