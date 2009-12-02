package com.tinkerpop.gremlin.functions;

import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.ExpressionContext;
import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.model.Element;
import com.tinkerpop.gremlin.statements.EvaluationException;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class ValuesFunction implements Function {

    public static final String FUNCTION_NAME = "values";

    public Collection invoke(ExpressionContext context, Object[] parameters) {

        if (null != parameters && parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof Map) {
                return ((Map)object).values();
            } else if (object instanceof Element) {
                return getElementValues((Element)object);
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX,FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
        
    }

    private Collection getElementValues(Element element) {
        Set<String> keys = element.getPropertyKeys();
        List list = new ArrayList();
        for(String key : keys) {
            Object object = element.getProperty(key);
            if(object instanceof Collection) {
                list.addAll((Collection)object);
            } else if(!(object instanceof Map)) {
                list.add(object);
            }
        }
        return list;
    }

}
