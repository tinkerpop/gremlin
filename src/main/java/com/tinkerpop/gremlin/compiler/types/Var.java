package com.tinkerpop.gremlin.compiler.types;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;

/**
 * @author Pavel A. Yaskevich
 */
public class Var extends DynamicEntity {

    private final String var;
    private final GremlinScriptContext context;

    public Var(final String var, final GremlinScriptContext context) {
        this.var = var;
        this.context = context;
    }

    public String getVariableName() {
        return this.var;
    }

    public int hashCode() {
        return this.var.hashCode();
    }

    protected Object value() {
        return this.context.getVariableLibrary().get(this.var);
    }

}
