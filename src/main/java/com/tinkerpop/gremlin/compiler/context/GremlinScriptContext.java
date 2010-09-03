package com.tinkerpop.gremlin.compiler.context;

import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.Var;

import javax.script.ScriptContext;
import javax.script.SimpleScriptContext;
import java.io.IOException;

/**
 * @author Marko A. Rodriguez
 */
public class GremlinScriptContext extends SimpleScriptContext {

    // used by DynamicPredicateFilterPipe
    private Object currentPoint;

    //protected Bindings globalBindings;
    //protected Bindings engineBindings;

    protected final FunctionLibrary functions;
    protected final PathLibrary paths;

    public GremlinScriptContext() {
        super();
        this.setBindings(new VariableLibrary(), ScriptContext.ENGINE_SCOPE);
        this.functions = new FunctionLibrary();
        this.paths = new PathLibrary();
    }

    public VariableLibrary getVariableLibrary() {
        return (VariableLibrary) this.getBindings(ScriptContext.ENGINE_SCOPE);
    }

    public FunctionLibrary getFunctionLibrary() {
        return this.functions;
    }

    public PathLibrary getPathLibrary() {
        return this.paths;
    }

    public void setVariableLibrary(final VariableLibrary newLibrary) {
        this.setBindings(newLibrary, ScriptContext.ENGINE_SCOPE);
    }

    public Atom getVariableByName(String name) {
        return new Var(name, this);
    }

    public void writeOutputLine(Object o) throws RuntimeException {
        try {
            this.getWriter().write(o.toString() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeOutput(Object o) throws RuntimeException {
        try {
            this.getWriter().write(o.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void writeError(String message) throws RuntimeException {
        try {
            this.getErrorWriter().write(message + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void flushErrorStream() {
        try {
            this.getErrorWriter().flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setCurrentPoint(Object point) {
        this.currentPoint = point;
    }

    public Object getCurrentPoint() {
        return this.currentPoint;
    }

}
