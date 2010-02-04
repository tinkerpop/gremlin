package com.tinkerpop.gremlin.functions.lme;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.GremlinFunctions;
import com.tinkerpop.gremlin.models.ggm.Element;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ValuesFunction implements Function {

    public static final String FUNCTION_NAME = "values";

    public Collection invoke(final ExpressionContext context, final Object[] parameters) {

        if (null != parameters && parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof Map) {
                return ((Map) object).values();
            } else if (object instanceof Element) {
                return getElementValues((Element) object);
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    private Collection getElementValues(final Element element) {
        Set<String> keys = element.getPropertyKeys();
        List list = new ArrayList();
        for (String key : keys) {
            Object object = element.getProperty(key);
            if (object instanceof List) {
                list.addAll((List) object);
            } else if (!(object instanceof Map)) {
                list.add(object);
            }
        }
        return list;
    }

}
