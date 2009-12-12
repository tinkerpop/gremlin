package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.functions.*;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.Functions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        // variables
        functionMap.put(AssignFunction.FUNCTION_NAME, new AssignFunction());
        functionMap.put(UnassignFunction.FUNCTION_NAME, new UnassignFunction());
        // graphs
        functionMap.put(IdFunction.FUNCTION_NAME, new IdFunction());
        functionMap.put(KeyFunction.FUNCTION_NAME, new KeyFunction());
        functionMap.put(LoadFunction.FUNCTION_NAME, new LoadFunction());
        functionMap.put(AddVertexFunction.FUNCTION_NAME, new AddVertexFunction());
        functionMap.put(AddEdgeFunction.FUNCTION_NAME, new AddEdgeFunction());
        functionMap.put(RemoveVertexEdgeFunction.FUNCTION_NAME, new RemoveVertexEdgeFunction());
        functionMap.put(AddIndexFunction.FUNCTION_NAME, new AddIndexFunction());
        functionMap.put(RemoveIndexFunction.FUNCTION_NAME, new RemoveIndexFunction());
        functionMap.put(ShutdownFunction.FUNCTION_NAME, new ShutdownFunction());
        // sets
        functionMap.put(SetFunction.FUNCTION_NAME, new SetFunction());
        functionMap.put(UnionFunction.FUNCTION_NAME, new UnionFunction());
        functionMap.put(IntersectFunction.FUNCTION_NAME, new IntersectFunction());
        functionMap.put(DifferenceFunction.FUNCTION_NAME, new DifferenceFunction());
        functionMap.put(RetainFunction.FUNCTION_NAME, new RetainFunction());
        functionMap.put(ExceptFunction.FUNCTION_NAME, new ExceptFunction());
        // lists
        functionMap.put(ListFunction.FUNCTION_NAME, new ListFunction());
        functionMap.put(AppendFunction.FUNCTION_NAME, new AppendFunction());
        functionMap.put(RemoveFunction.FUNCTION_NAME, new RemoveFunction());
        functionMap.put(AssignIndexFunction.FUNCTION_NAME, new AssignIndexFunction());
        // maps
        functionMap.put(MapFunction.FUNCTION_NAME, new MapFunction());
        functionMap.put(KeysFunction.FUNCTION_NAME, new KeysFunction());
        functionMap.put(ValuesFunction.FUNCTION_NAME, new ValuesFunction());
        functionMap.put(AssignKeyFunction.FUNCTION_NAME, new AssignKeyFunction());
        // lists and maps
        functionMap.put(GetFunction.FUNCTION_NAME, new GetFunction());
        functionMap.put(SortFunction.FUNCTION_NAME, new SortFunction());
        functionMap.put(AddValueFunction.FUNCTION_NAME, new AddValueFunction());
        functionMap.put(AssignValueFunction.FUNCTION_NAME, new AssignValueFunction());
        // numbers
        functionMap.put(RandomRealFunction.FUNCTION_NAME, new RandomRealFunction());
        functionMap.put(RandomNaturalFunction.FUNCTION_NAME, new RandomNaturalFunction());
        // flow control
        functionMap.put(HaltFunction.FUNCTION_NAME, new HaltFunction());
        functionMap.put(ContinueFunction.FUNCTION_NAME, new ContinueFunction());
        // utilities
        functionMap.put(TypeFunction.FUNCTION_NAME, new TypeFunction());
        functionMap.put(PrintFunction.FUNCTION_NAME, new PrintFunction());
        functionMap.put(TimeFunction.FUNCTION_NAME, new TimeFunction());
    }

    public Function getFunction(String namespace, String name, Object[] parameters) {
        Function function = functionMap.get(name);
        if (null != function)
            return function;

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(namespace, name), EvaluationException.EvaluationErrorType.NO_FUNCTION);
    }

    public Set getUsedNamespaces() {
        return namespaces;
    }
}