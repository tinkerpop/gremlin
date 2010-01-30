package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.DynamicFunction;
import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Pavel A. Yaskevich
 */
public class FunctionStatement extends CompoundStatement {

    private String namespace;
    private String functionName;
    private List<String> functionArguments = new ArrayList<String>();
    private List<String> functionBody = new ArrayList<String>();
    private int declarationLine;

    private static final String BAD_FUNCTION_DEFINITION = "bad function definition";
    private static final Pattern functionPattern = Pattern.compile("^func\\s+([\\w-]+):([\\w-]+){1}\\s*\\(([^\\)]*)\\)");
    private static final Pattern variablePattern = Pattern.compile(Tokens.VARIABLE_REGEX);

    public FunctionStatement(final XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public List<String> getArguments() {
        return this.functionArguments;
    }

    public List<String> getFunctionBody() {
        return this.functionBody;
    }

    public void compileTokens(final String line) throws SyntaxException {
        super.compileTokens(line);

        if (null == this.functionName) {
            Matcher function = functionPattern.matcher(line);

            if (function.find()) {
                // if function definition does not contain func and function name and params
                if (function.groupCount() < 3)
                    throw new SyntaxException(BAD_FUNCTION_DEFINITION);

                this.namespace = function.group(1);
                this.functionName = function.group(2);
                this.declarationLine = this.xPathEvaluator.getCurrentLineNumber();

                Matcher variable = variablePattern.matcher(function.group(3));
                while (variable.find())
                    this.functionArguments.add(variable.group());
            } else {
                throw new SyntaxException(BAD_FUNCTION_DEFINITION);
            }
        } else {
            this.updateStatementList(line);
        }
    }

    public List evaluate() throws EvaluationException {
        this.xPathEvaluator.getGremlinPathContext().registerFunction(new DynamicFunction(this));
        return null;
    }

    public static boolean isStatement(final String firstLine) {
        return functionPattern.matcher(firstLine).find();
    }

    public int getDeclarationLine() {
        return this.declarationLine;
    }
}
 
