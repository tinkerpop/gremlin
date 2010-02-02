package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.FunctionStatement;
import com.tinkerpop.gremlin.statements.SyntaxException;
import com.tinkerpop.gremlin.GremlinEvaluator;
import com.tinkerpop.gremlin.FunctionHelper;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class NativeFunction implements Function {

    private final SyntaxException PARAMETER_SIZE_EXCEPTION;
    private final FunctionStatement functionStatement;

    public NativeFunction(final FunctionStatement statement) {
        this.functionStatement = statement;
        this.PARAMETER_SIZE_EXCEPTION = new SyntaxException("Incorrect number of arguments: " + this.functionStatement.getNamespace() + ":" + this.functionStatement.getFunctionName() + "()");
    }

    public Object invoke(final ExpressionContext context, final Object[] parameters) throws EvaluationException {
        GremlinEvaluator gremlinEvaluator = new GremlinEvaluator();
        Object[] objects = FunctionHelper.nodeSetConversion(parameters);
        List<String> arguments = this.functionStatement.getArguments();

        if (null == objects) {
            if (arguments.size() > 0)
                throw PARAMETER_SIZE_EXCEPTION;
        } else {
            if (objects.length != arguments.size())
                throw this.PARAMETER_SIZE_EXCEPTION;

            for (int i = 0; i < objects.length; i++)
                gremlinEvaluator.getVariables().declareVariable(arguments.get(i), objects[i]);
        }

        List result;
        try {
            result = gremlinEvaluator.evaluate(new ByteArrayInputStream(functionStatement.getStatementBody().getBytes()));
        } catch (Exception e) {
            String fullname = FunctionHelper.makeFunctionName(this.functionStatement.getNamespace(), this.functionStatement.getFunctionName());
            throw new EvaluationException(fullname + "() [declared at line " + this.functionStatement.getDeclarationLine() + "]: " + e.getMessage());
        }

        if (null != result && result.size() == 1) {
            return result.get(0);
        } else {
            return result;
        }
    }

    public String getFunctionName() {
        return this.functionStatement.getFunctionName();
    }

    public String getNamespace() {
        return this.functionStatement.getNamespace();
    }
}
