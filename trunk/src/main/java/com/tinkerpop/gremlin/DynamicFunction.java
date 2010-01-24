package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.statements.FunctionStatement;
import com.tinkerpop.gremlin.statements.SyntaxException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.Functions;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class DynamicFunction implements Function {

    protected final String namespace;
    protected final String functionName;
    protected final List<String> arguments;
    protected final List<String> functionBody;

    private final SyntaxException PARAMETER_SIZE_EXCEPTION;

    public DynamicFunction(final FunctionStatement statement) {
        this.namespace = statement.getNamespace();
        this.functionName = statement.getFunctionName();
        this.arguments = statement.getArguments();
        this.functionBody = statement.getFunctionBody();
        this.PARAMETER_SIZE_EXCEPTION = new SyntaxException("Incorrect number of arguments: " + this.namespace + ":" + this.functionName + "()");
    }

    public Object invoke(final ExpressionContext context, final Object[] parameters) throws SyntaxException {

        GremlinEvaluator evaluator = new GremlinEvaluator();
        Object[] objects = FunctionHelper.nodeSetConversion(parameters);

        if (null == objects) {
            if (this.arguments.size() > 0)
                throw PARAMETER_SIZE_EXCEPTION;
        } else {
            if (objects.length != this.arguments.size())
                throw this.PARAMETER_SIZE_EXCEPTION;

            for (int i = 0; i < objects.length; i++)
                evaluator.setVariable(this.arguments.get(i), objects[i]);
        }

        Object result = null;

        for (String line : this.functionBody) {
            result = evaluator.evaluate(line);
        }

        if (result instanceof List && ((List) result).size() == 1) {
            return ((List) result).get(0);
        } else {
            return result;
        }
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public Functions getDynamicFunctions() {
        return new DynamicFunctions(this);
    }

}


