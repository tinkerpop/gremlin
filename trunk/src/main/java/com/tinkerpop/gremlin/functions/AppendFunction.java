package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationErrorException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class AppendFunction implements Function {

    public static final String FUNCTION_NAME = "append";

    public List invoke(ExpressionContext context, Object[] parameters) {

        Object[] objects = FunctionHelper.nodeSetConversion(parameters);

        if (null != objects && objects.length > 1) {
            List list = new ArrayList();
            for (Object object : objects) {
                if (object instanceof Collection)
                    list.addAll((Collection) object);
                else if (!(object instanceof Map))
                    list.add(object);

            }
            return list;
        }
        throw new EvaluationErrorException(GremlinFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " does not support provided parameters.");
    }
}