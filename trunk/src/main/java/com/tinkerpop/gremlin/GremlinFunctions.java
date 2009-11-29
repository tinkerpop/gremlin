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

    private static final String ASSIGN = "assign";
    private static final String UNASSIGN = "unassign";

    private static final String AS_LIST = "as_list";
    private static final String AS_SET = "as_set";
    //private static final String AS_MAP = "as_map";

    private static final String APPEND = "append";
    private static final String REMOVE = "remove";

    private static final String UNION = "union";
    private static final String INTERSECT = "intersect";
    private static final String DIFFERENCE = "difference";

    private static final String RETAIN = "retain";
    private static final String EXCEPT = "except";


    private static final Map<String, Function> functionMap = new HashMap<String, Function>();

    static {
        functionMap.put(ASSIGN, new AssignFunction());
        functionMap.put(UNASSIGN, new UnassignFunction());
        functionMap.put(AS_LIST, new AsListFunction());
        functionMap.put(AS_SET, new AsSetFunction());
        functionMap.put(APPEND, new AppendFunction());
        functionMap.put(REMOVE, new RemoveFunction());
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
        if (null != function)
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

    public static class AssignFunction implements Function {
        public Object invoke(ExpressionContext context, Object[] parameters) {
            if (parameters.length == 1) {
                // ../..[g:assign('$i')
                if (FunctionHelper.isLastInContext(context))
                    FunctionHelper.getGremlin(context).setVariable(parameters[0].toString(), FunctionHelper.asObject(context.getContextNodeList()));
                return Boolean.TRUE;
            } else if (parameters.length == 2) {
                if (parameters[0] instanceof String) {
                    // g:assign('$i', value)
                    FunctionHelper.getGremlin(context).setVariable(parameters[0].toString(), parameters[1]);
                    return parameters[1];
                } else if (parameters[0] instanceof List) {
                    // ../..[g:assign(list,index)]
                    setListIndex((List) parameters[0], Float.valueOf(parameters[1].toString()).intValue() - 1, context.getContextNodePointer().getValue());
                    return Boolean.TRUE;
                } else if (parameters[0] instanceof Map) {
                    // ../..[g:assign(map,key)]
                    setMapKey((Map) parameters[0], parameters[0], context.getContextNodePointer().getValue());
                    return Boolean.TRUE;
                }
            } else if (parameters.length == 3) {
                if (parameters[0] instanceof List) {
                    // g:assign(list,index,value)
                    return setListIndex((List) parameters[0], Float.valueOf(parameters[1].toString()).intValue() - 1, parameters[2]);
                } else if (parameters[0] instanceof Map) {
                    // g:assign(map,key,value)
                    return setMapKey((Map) parameters[0], parameters[1], parameters[2]);
                }
            }

            throw new JXPathFunctionNotFoundException("Undefined function: g:assign() does not support provided parameters.");
        }

        private static Object setListIndex(List list, Integer index, Object value) {
            list.set(index, value);
            return value;
        }

        private static Object setMapKey(Map map, Object key, Object value) {
            map.put(key, value);
            return value;
        }

    }

    public static class UnassignFunction implements Function {
        public Object invoke(ExpressionContext context, Object[] parameters) {
            if (parameters.length == 1) {
                FunctionHelper.getGremlin(context).removeVariable(parameters[0].toString());
                return Boolean.TRUE;
            } else if (parameters.length == 2) {
                if (parameters[0] instanceof List) {
                    return removeListIndex((List) parameters[0], Float.valueOf(parameters[1].toString()).intValue() - 1);
                } else if (parameters[0] instanceof Map) {
                    return removeMapKey((Map) parameters[0], parameters[1]);
                }
            }
            throw new JXPathFunctionNotFoundException("Undefined function: g:unassign() does not support provided parameters.");
        }

        private static List removeListIndex(List list, Integer index) {
            list.remove(index.intValue());
            return list;
        }

        private static Map removeMapKey(Map map, Object key) {
            map.remove(key);
            return map;
        }
    }

    public static class AsListFunction implements Function {

        public List invoke(ExpressionContext context, Object[] parameters) {
            if (null == parameters) {
                return new ArrayList();
            } else if (parameters.length == 1) {
                if (parameters[0] instanceof Collection)
                    return new ArrayList((Collection) parameters[0]);
                else {
                    List b = new ArrayList();
                    b.add(parameters[0]);
                    return b;
                }
            }
            throw new JXPathFunctionNotFoundException("Undefined function: g:as_list() does not support provided parameters.");
        }
    }

    public static class AsSetFunction implements Function {

        public Set invoke(ExpressionContext context, Object[] parameters) {
            if (null == parameters) {
                return new HashSet();
            } else if (parameters.length == 1) {
                if (parameters[0] instanceof Collection)
                    return new HashSet((Collection) parameters[0]);
                else {
                    Set b = new HashSet();
                    b.add(parameters[0]);
                    return b;
                }
            }
            throw new JXPathFunctionNotFoundException("Undefined function: g:as_set() does not support provided parameters.");
        }
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