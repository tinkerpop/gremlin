package com.tinkerpop.gremlin.functions.sail;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.models.pgm.Graph;
import com.tinkerpop.gremlin.models.pgm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.openrdf.sail.memory.MemoryStore;
import org.openrdf.sail.nativerdf.NativeStore;

import java.io.File;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OpenFunction implements Function {

    public static final String FUNCTION_NAME = "open";

    public Graph invoke(final ExpressionContext context, final Object[] parameters) {

        if (null == parameters) {
            return new SailGraph(new MemoryStore());
        } else if (parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof String) {
                return new SailGraph(new NativeStore(new File((String) object)));
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(SailFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

        public String getName() {
        return FUNCTION_NAME;
    }
}