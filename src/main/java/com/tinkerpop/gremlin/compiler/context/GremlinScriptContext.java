package com.tinkerpop.gremlin.compiler.context;

import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.Var;

import javax.script.SimpleScriptContext;
import java.io.IOException;

/**
 * @author Pavel A. Yaskevich
 */
public class GremlinScriptContext extends SimpleScriptContext {

    protected VariableLibrary variables;
    
    protected final FunctionLibrary functions;
    protected final PathLibrary paths;

    public GremlinScriptContext() {
        this.variables = new VariableLibrary();
        this.functions = new FunctionLibrary();
        this.paths = new PathLibrary();
    }

    public VariableLibrary getVariableLibrary() {
        return this.variables;
    }

    public FunctionLibrary getFunctionLibrary() {
        return this.functions;
    }

    public PathLibrary getPathLibrary() {
        return this.paths;
    }

    public void setVariableLibrary(final VariableLibrary newLibrary) {
        this.variables = newLibrary;
    }

    public Atom getVariableByName(String name) {
        return new Var(name, this);
    }
    public void writeOutput(Object o) throws RuntimeException {
        try {
            this.getWriter().write(o.toString() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
