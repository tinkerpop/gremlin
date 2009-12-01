package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.functions.*;
import com.tinkerpop.gremlin.statements.EvaluationErrorException;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.Functions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinFunctions implements Functions {

    public static final String NAMESPACE_PREFIX = "g";

    private static Set<String> namespaces = new HashSet<String>();
    private static final Map<String, Function> functionMap = new HashMap<String, Function>();

    static {
        namespaces.add(NAMESPACE_PREFIX);
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
        functionMap.put(KeysFunction.FUNCTION_NAME, new KeysFunction());
        functionMap.put(ValuesFunction.FUNCTION_NAME, new ValuesFunction());
        functionMap.put(IdFunction.FUNCTION_NAME, new IdFunction());
        functionMap.put(RandomRealFunction.FUNCTION_NAME, new RandomRealFunction());
        functionMap.put(RandomNaturalFunction.FUNCTION_NAME, new RandomNaturalFunction());
    }

    public Function getFunction(String namespace, String name, Object[] parameters) {
        Function function = functionMap.get(name);
        if (null != function)
            return function;


        throw new EvaluationErrorException("Function " + namespace + ":" + name + " does not exist.");
    }

    public Set getUsedNamespaces() {
        return namespaces;
    }
}