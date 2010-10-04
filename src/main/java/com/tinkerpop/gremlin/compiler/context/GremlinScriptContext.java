package com.tinkerpop.gremlin.compiler.context;

import com.tinkerpop.gremlin.compiler.util.StringHelper;
import com.tinkerpop.gremlin.functions.Functions;
import com.tinkerpop.gremlin.steps.Steps;

import javax.script.ScriptContext;
import javax.script.SimpleScriptContext;
import java.io.IOException;

/**
 * @author Marko A. Rodriguez
 */
public class GremlinScriptContext extends SimpleScriptContext {

    // used by DynamicPredicateFilterPipe
    private Object currentPoint;

    protected final FunctionLibrary functions;
    protected final StepLibrary steps;

    public GremlinScriptContext() {
        super();
        this.setBindings(new VariableLibrary(), ScriptContext.ENGINE_SCOPE);
        this.functions = new FunctionLibrary();
        this.steps = new StepLibrary();
    }

    public FunctionLibrary getFunctionLibrary() {
        return this.functions;
    }

    public StepLibrary getStepLibrary() {
        return this.steps;
    }

    public void loadLibrary(String className) {
        try {
            Class libraryClass = Class.forName(StringHelper.clearQuotes(className));
            if (Functions.class.isAssignableFrom(libraryClass))
                this.getFunctionLibrary().loadFunctions(className);
            else if (Steps.class.isAssignableFrom(libraryClass))
                this.getStepLibrary().loadSteps(className);
            else
                throw new RuntimeException("Unable to load " + className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void writeOutput(Object o) throws RuntimeException {
        try {
            this.getWriter().write(o.toString());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void writeError(String message) throws RuntimeException {
        try {
            this.getErrorWriter().write(message + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void flushErrorStream() {
        try {
            this.getErrorWriter().flush();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void setCurrentPoint(Object point) {
        this.currentPoint = point;
    }

    public Object getCurrentPoint() {
        return this.currentPoint;
    }

}
