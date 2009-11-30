package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.functions.*;
import com.tinkerpop.gremlin.statements.EvaluationErrorException;
import org.apache.commons.jxpath.ClassFunctions;
import org.apache.commons.jxpath.Function;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinFunctions extends ClassFunctions {

    public static final String NAMESPACE_PREFIX = "g";

    private static final Map<String, Function> functionMap = new HashMap<String, Function>();

    static {
        functionMap.put(AssignFunction.FUNCTION_NAME, new AssignFunction());
        functionMap.put(UnassignFunction.FUNCTION_NAME, new UnassignFunction());
        functionMap.put(AsListFunction.FUNCTION_NAME, new AsListFunction());
        functionMap.put(AsSetFunction.FUNCTION_NAME, new AsSetFunction());
        functionMap.put(AsMapFunction.FUNCTION_NAME, new AsMapFunction());
        functionMap.put(AppendFunction.FUNCTION_NAME, new AppendFunction());
        functionMap.put(RemoveFunction.FUNCTION_NAME, new RemoveFunction());
        functionMap.put(UnionFunction.FUNCTION_NAME, new UnionFunction());
        functionMap.put(IntersectFunction.FUNCTION_NAME, new IntersectFunction());
        functionMap.put(DifferenceFunction.FUNCTION_NAME, new DifferenceFunction());
        functionMap.put(RetainFunction.FUNCTION_NAME, new RetainFunction());
        functionMap.put(ExceptFunction.FUNCTION_NAME, new ExceptFunction());
        functionMap.put(TypeFunction.FUNCTION_NAME, new TypeFunction());
        functionMap.put(HaltFunction.FUNCTION_NAME, new HaltFunction());
        functionMap.put(ContinueFunction.FUNCTION_NAME, new ContinueFunction());

    }

    public GremlinFunctions(String namespace) {
        super(GremlinClassFunctions.class, namespace);
    }

    public Function getFunction(String namespace, String name, Object[] parameters) {
        Function function = functionMap.get(name);
        if (null != function)
            return function;

        try {
            function = super.getFunction(namespace, name, parameters);
        } catch (NoClassDefFoundError e) {
            throw new EvaluationErrorException("Function " + namespace + ":" + name + " does not exist.");
        }
        if (null != function)
            return function;
        else
            throw new EvaluationErrorException("Function " + namespace + ":" + name + " does not exist.");


    }
}