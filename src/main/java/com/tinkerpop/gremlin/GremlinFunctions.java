package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.functions.flow.ContinueFunction;
import com.tinkerpop.gremlin.functions.flow.HaltFunction;
import com.tinkerpop.gremlin.functions.graph.*;
import com.tinkerpop.gremlin.functions.lme.*;
import com.tinkerpop.gremlin.functions.number.ProbabilityFunction;
import com.tinkerpop.gremlin.functions.number.RandomNaturalFunction;
import com.tinkerpop.gremlin.functions.number.RandomRealFunction;
import com.tinkerpop.gremlin.functions.util.*;
import com.tinkerpop.gremlin.functions.var.AssignFunction;
import com.tinkerpop.gremlin.functions.var.UnassignFunction;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.Functions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinFunctions implements Functions {

    public static final String NAMESPACE_PREFIX = "g";

    private static Set<String> namespaces = new HashSet<String>();
    private static Map<String, Function> functionMap = new HashMap<String, Function>();

    static {
        namespaces.add(NAMESPACE_PREFIX);
        // variables
        functionMap.put(AssignFunction.FUNCTION_NAME, new AssignFunction());
        functionMap.put(UnassignFunction.FUNCTION_NAME, new UnassignFunction());
        // graphs
        functionMap.put(IdFunction.FUNCTION_NAME, new IdFunction());
        functionMap.put(KeyFunction.FUNCTION_NAME, new KeyFunction());
        functionMap.put(LoadFunction.FUNCTION_NAME, new LoadFunction());
        functionMap.put(SaveFunction.FUNCTION_NAME, new SaveFunction());
        functionMap.put(AddVertexFunction.FUNCTION_NAME, new AddVertexFunction());
        functionMap.put(AddEdgeFunction.FUNCTION_NAME, new AddEdgeFunction());
        functionMap.put(RemoveVertexEdgeFunction.FUNCTION_NAME, new RemoveVertexEdgeFunction());
        functionMap.put(AddIndexFunction.FUNCTION_NAME, new AddIndexFunction());
        functionMap.put(IndexAllFunction.FUNCTION_NAME, new IndexAllFunction());
        functionMap.put(RemoveIndexFunction.FUNCTION_NAME, new RemoveIndexFunction());
        functionMap.put(ClearFunction.FUNCTION_NAME, new ClearFunction());
        functionMap.put(CloseFunction.FUNCTION_NAME, new CloseFunction());
        // lists
        functionMap.put(ListFunction.FUNCTION_NAME, new ListFunction());
        functionMap.put(AppendFunction.FUNCTION_NAME, new AppendFunction());
        functionMap.put(RemoveFunction.FUNCTION_NAME, new RemoveFunction());
        functionMap.put(DeduplicateFunction.FUNCTION_NAME, new DeduplicateFunction());
        functionMap.put(UnionFunction.FUNCTION_NAME, new UnionFunction());
        functionMap.put(IntersectFunction.FUNCTION_NAME, new IntersectFunction());
        functionMap.put(DifferenceFunction.FUNCTION_NAME, new DifferenceFunction());
        functionMap.put(RetainFunction.FUNCTION_NAME, new RetainFunction());
        functionMap.put(ExceptFunction.FUNCTION_NAME, new ExceptFunction());
        // maps and elements
        functionMap.put(MapFunction.FUNCTION_NAME, new MapFunction());
        functionMap.put(KeysFunction.FUNCTION_NAME, new KeysFunction());
        functionMap.put(ValuesFunction.FUNCTION_NAME, new ValuesFunction());
        // lists and maps and elements
        functionMap.put(GetFunction.FUNCTION_NAME, new GetFunction());
        functionMap.put(SortFunction.FUNCTION_NAME, new SortFunction());
        functionMap.put(OperateValueFunction.FUNCTION_NAME, new OperateValueFunction());
        // numbers
        functionMap.put(ProbabilityFunction.FUNCTION_NAME, new ProbabilityFunction());
        functionMap.put(RandomRealFunction.FUNCTION_NAME, new RandomRealFunction());
        functionMap.put(RandomNaturalFunction.FUNCTION_NAME, new RandomNaturalFunction());
        // flow control
        functionMap.put(HaltFunction.FUNCTION_NAME, new HaltFunction());
        functionMap.put(ContinueFunction.FUNCTION_NAME, new ContinueFunction());
        // utilities
        functionMap.put(TypeFunction.FUNCTION_NAME, new TypeFunction());
        functionMap.put(PrintFunction.FUNCTION_NAME, new PrintFunction());
        functionMap.put(TimeFunction.FUNCTION_NAME, new TimeFunction());
        functionMap.put(PathFunction.FUNCTION_NAME, new PathFunction());
        functionMap.put(JsonFunction.FUNCTION_NAME, new JsonFunction());
    }

    public Function getFunction(final String namespace, final String name, final Object[] parameters) {
        Function function = functionMap.get(name);
        if (null != function)
            return function;

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(namespace, name), EvaluationException.EvaluationErrorType.NO_FUNCTION);
    }

    public Set getUsedNamespaces() {
        return namespaces;
    }

}
