package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.DynamicFunction;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Pavel A. Yaskevich
 */
public class FunctionStatement extends CompoundStatement {
    
    // instance variables
    private String namespace;
    private String functionName;
    private ArrayList<String> functionArguments;
    private ArrayList<String> functionBody; 
   
    // messages
    private static final String ALREADY_DEFINED   = " already defined";
    private static final String BAD_FUNCTION_DEFINITION = "bad function definition";
    // regex
    private static final Pattern functionPattern = Pattern.compile("^func\\s+([\\w-]+):([\\w-]+){1}\\s*\\(([^\\)]*)\\)");
    private static final Pattern variablePattern = Pattern.compile(Tokens.VARIABLE_REGEX);
     
    public FunctionStatement(final XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);

        this.functionBody = new ArrayList<String>();
        this.functionArguments = new ArrayList<String>();
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public ArrayList getArguments() {
        return this.functionArguments;
    }

    public ArrayList getFunctionBody() {
        return this.functionBody;
    }

    public void compileTokens(final String line) throws SyntaxException {
        super.compileTokens(line);
        
        if(null == this.functionName) {
            Matcher function = functionPattern.matcher(line);
            
            if (function.find()) {
                // if function definition is not contain func and function name and params
                if (function.groupCount() < 3) 
                    throw new SyntaxException(BAD_FUNCTION_DEFINITION);
                
                this.namespace = function.group(1);
                this.functionName = function.group(2);
                
                Matcher variable  = variablePattern.matcher(function.group(3));
                while (variable.find()) 
                    this.functionArguments.add(variable.group());
            } else {
                throw new SyntaxException(BAD_FUNCTION_DEFINITION);
            }
        } else {
            this.updateStatementList(line);
        }
    }


    protected void updateStatementList(final String line) {
        StatementGenerator.generateStatement(line, this.xPathEvaluator);

        if (endPattern.matcher(line).find()) {
            if (this.xPathEvaluator.getDepth() == 1) {
                this.complete = true;
            } else {
                this.functionBody.add(line); 
            }

            this.xPathEvaluator.decrDepth(); 
        } else {
            this.functionBody.add(line); 
        }
    }

    public List evaluate() throws EvaluationException {
        DynamicFunction.register(this);
        return null;
    }

    public static boolean isStatement(final String firstLine) {
        return functionPattern.matcher(firstLine).find();
    }

}

