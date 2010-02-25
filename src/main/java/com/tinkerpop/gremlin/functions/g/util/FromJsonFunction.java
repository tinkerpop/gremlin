package com.tinkerpop.gremlin.functions.g.util;

import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.g.GremlinFunctionLibrary;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FromJsonFunction implements Function {

    public static final String FUNCTION_NAME = "from-json";

    public Object invoke(final ExpressionContext context, final Object[] parameters) {

        if (null != parameters && parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof String) {
                String jsonString = (String) object;
                JSONParser parser = new JSONParser();
                ContainerFactory containerFactory = new ContainerFactory() {
                    public List creatArrayContainer() {
                        return new ArrayList();
                    }

                    public Map createObjectContainer() {
                        return new HashMap();
                    }

                };
                try {
                    return parser.parse(jsonString, containerFactory);
                } catch (ParseException e) {
                    throw new EvaluationException("Unable to JSON parse: " + jsonString + " [at position " + e.getPosition() + "]");
                }
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctionLibrary.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    public String getName() {
        return FUNCTION_NAME;
    }

}
