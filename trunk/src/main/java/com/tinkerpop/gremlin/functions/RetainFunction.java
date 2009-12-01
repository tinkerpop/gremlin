package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationErrorException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RetainFunction implements Function {
    public static final String FUNCTION_NAME = "retain";

    public Boolean invoke(ExpressionContext context, Object[] parameters) {

        if (null != parameters) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            Set setA = new HashSet();
            for (Object object : objects) {
                if (object instanceof Collection)
                    setA.addAll((Collection) object);
                else if (!(object instanceof Map))
                    setA.add(object);

            }
            Set setB = new HashSet();
            setB.add(context.getContextNodePointer().getValue());
            setA.retainAll(setB);
            return setA.size() > 0;
        }
        throw new EvaluationErrorException(GremlinFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " does not support provided parameters.");
    }

}