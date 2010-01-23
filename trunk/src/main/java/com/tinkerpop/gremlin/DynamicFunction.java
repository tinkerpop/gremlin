package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.Function;
import com.tinkerpop.gremlin.GremlinFunctions;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Functions;
import com.tinkerpop.gremlin.statements.FunctionStatement;
import com.tinkerpop.gremlin.statements.SyntaxException;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.GremlinEvaluator;
import com.tinkerpop.gremlin.GremlinPathContext;
import com.tinkerpop.gremlin.model.*;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Pavel A. Yaskevich
 */
public class DynamicFunction implements Function {

    protected final String namespace;
    protected final String functionName;
    protected final ArrayList<String> arguments;
    protected final ArrayList<String> functionBody;

    // messages
    private final SyntaxException PARAMETER_SIZE_EXCEPTION;
 
    public DynamicFunction(final FunctionStatement statement) {
        this.namespace = statement.getNamespace();
        this.functionName = statement.getFunctionName();
        this.arguments = statement.getArguments(); 
        this.functionBody = statement.getFunctionBody();
        this.PARAMETER_SIZE_EXCEPTION = new SyntaxException("Incorrect number of arguments: " + this.namespace + ":" + this.functionName + "()");
    }

    public Object invoke(final ExpressionContext context, final Object[] parameters) 
        throws SyntaxException {
        
        GremlinEvaluator evaluator = new GremlinEvaluator();
        Object[] objects = FunctionHelper.nodeSetConversion(parameters);

        if(null == objects) {
            if(this.arguments.size() > 0)
                throw PARAMETER_SIZE_EXCEPTION;
        } else { 
            if(objects.length != this.arguments.size()) 
                throw this.PARAMETER_SIZE_EXCEPTION;

            for (int i = 0; i < objects.length; i++) 
                evaluator.setVariable(this.arguments.get(i), objects[i]);
        }

        Object result = null;

        for (String line: this.functionBody) {
            result = evaluator.evaluate(line);
        }

        return result;
    }
   
    public static void register(final FunctionStatement statement) {
        GremlinPathContext.registerFunction(new DynamicFunction(statement)); 
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


