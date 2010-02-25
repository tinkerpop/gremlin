package com.tinkerpop.gremlin.functions.g.lme;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.g.GremlinFunctionLibrary;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ValuesFunction implements Function {

    public static final String FUNCTION_NAME = "values";

    public List invoke(final ExpressionContext context, final Object[] parameters) {

        if (null != parameters && parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof Map) {
                return new ArrayList(((Map) object).values());
            } else if (object instanceof Element) {
                return new ArrayList(getElementValues((Element) object));
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctionLibrary.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    public String getName() {
        return FUNCTION_NAME;
    }

    private List getElementValues(final Element element) {
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
