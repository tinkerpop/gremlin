package com.tinkerpop.gremlin.functions.number;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.functions.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.List;
import java.util.Random;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ProbabilityFunction implements Function {

    public static final String FUNCTION_NAME = "prob";
    private static final Random random = new Random();


    public Number invoke(final ExpressionContext context, final Object[] parameters) {

        List objects = null;
        if (null == parameters) {
            if (FunctionHelper.isLastInContext(context)) {
                objects = FunctionHelper.asObject(context.getContextNodeList());
            } else {
                return null;
            }
        } else if (parameters.length == 1) {
            Object temp = FunctionHelper.nodeSetConversion(parameters[0]);
            if (temp instanceof List) {
                objects = (List) temp;
            }
        }

        if (null == objects || objects.size() == 0)
            throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

        Double total = 0.0;
        for (Object o : objects) {
            if (o instanceof Number) {
                total = total + ((Number) o).doubleValue();
            } else {
                throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
            }
        }

        Double pick = random.nextDouble();
        Double running = 0.0d;
        int counter = 1;
        for (Object o : objects) {
            running = running + (((Number) o).doubleValue() / total);
            //System.out.println(total + " --- " + running);
            if (running >= pick) {
                //System.out.println(counter);
                return counter;
            }
            counter++;
        }
        // this should not happen todo: remove this
        System.out.println("it happened!");
        return -1;
    }
}
