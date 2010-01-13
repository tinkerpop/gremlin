package com.tinkerpop.gremlin.functions.lme;

import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.model.Element;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class MapFunction implements Function {

    public static final String FUNCTION_NAME = "map";

    public Map invoke(final ExpressionContext context, final Object[] parameters) {
        if (null == parameters) {
            return new HashMap();
        } if(parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if(object instanceof Element) {
                Element element = (Element)object;
                Map map = new HashMap();
                for(String key : element.getPropertyKeys()) {
                    map.put(key, element.getProperty(key));
                }
                return map;
            }
        } else if(parameters.length % 2 == 0) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            Map map = new HashMap();
            for(int i=0; i<objects.length; i=i+2) {
                map.put(objects[i], objects[i+1]);
            }
            return map;
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX,FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
