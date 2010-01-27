package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.FunctionStatement;
import com.tinkerpop.gremlin.statements.SyntaxException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class DynamicFunction implements Function {

    //protected final String namespace;
    //protected final String functionName;
    //protected final int declarationLine;
    //protected final List<String> arguments;
    //protected final List<String> functionBody;
    private final SyntaxException PARAMETER_SIZE_EXCEPTION;
    private final FunctionStatement functionStatement;

    public DynamicFunction(final FunctionStatement statement) {
        this.functionStatement = statement;
        //this.declarationLine = statement.getDeclarationLine();
        //this.namespace = statement.getNamespace();
        //this.functionName = statement.getFunctionName();
        //this.arguments = statement.getArguments();
        //this.functionBody = statement.getFunctionBody();
        this.PARAMETER_SIZE_EXCEPTION = new SyntaxException("Incorrect number of arguments: " + this.functionStatement.getNamespace() + ":" + this.functionStatement.getFunctionName() + "()");
    }

    public Object invoke(final ExpressionContext context, final Object[] parameters) throws EvaluationException {
        GremlinEvaluator evaluator = new GremlinEvaluator();
        Object[] objects = FunctionHelper.nodeSetConversion(parameters);
        List<String> arguments = this.functionStatement.getArguments();

        if (null == objects) {
            if (arguments.size() > 0)
                throw PARAMETER_SIZE_EXCEPTION;
        } else {
            if (objects.length != arguments.size())
                throw this.PARAMETER_SIZE_EXCEPTION;

            for (int i = 0; i < objects.length; i++)
                evaluator.setVariable(arguments.get(i), objects[i]);
        }


        /*String body = "";
        for (String line : this.functionBody)
            body += line + "\n";*/

        List result;
        try {
            result = evaluator.evaluate(new ByteArrayInputStream(functionStatement.getStatementBody().getBytes()));
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