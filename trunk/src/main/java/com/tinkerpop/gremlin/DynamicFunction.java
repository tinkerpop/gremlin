package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.statements.FunctionStatement;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.SyntaxException;
import com.tinkerpop.gremlin.statements.Tokens;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.Functions;

import java.util.List;
import java.io.StringBufferInputStream;

/**
 * @author Pavel A. Yaskevich
 */
public class DynamicFunction implements Function {

    // attributes
    protected final String namespace;
    protected final String functionName;
    protected final int declarationLine;
    protected final List<String> arguments;
    protected final List<String> functionBody;

    // messages 
    private final String EXCEPTION_IN_FUNCTION = "Exception in function ";

    // exceptions
    private final SyntaxException PARAMETER_SIZE_EXCEPTION; 

    public DynamicFunction(final FunctionStatement statement) {
        this.declarationLine = statement.getDeclarationLine();
        this.namespace = statement.getNamespace();
        this.functionName = statement.getFunctionName();
        this.arguments = statement.getArguments();
        this.functionBody = statement.getFunctionBody();
        this.PARAMETER_SIZE_EXCEPTION = new SyntaxException("Incorrect number of arguments: " + this.namespace + ":" + this.functionName + "()");
    }

    public Object invoke(final ExpressionContext context, final Object[] parameters) throws EvaluationException {
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
        
        String body = "";
        for (String line : this.functionBody) 
            body += line + "\n";

        try {
            result = evaluator.evaluate(new StringBufferInputStream(body));
        } catch(Exception e) {
            String fullname = this.functionNameWithNamespace();
            int lastLineNumber = evaluator.getLastStatementLineNumber();
            String line = this.functionBody.get(lastLineNumber - 1); 

            System.out.println(EXCEPTION_IN_FUNCTION+"'"+ fullname +"' (declared at line "+this.declarationLine+")");
            System.out.println("Line " + lastLineNumber + ": " + line + " - " + e.getMessage());
            throw new EvaluationException("in '" + fullname + "' function call");
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

    public String functionNameWithNamespace() {
        return this.namespace + ":" + this.functionName;
    }
}


