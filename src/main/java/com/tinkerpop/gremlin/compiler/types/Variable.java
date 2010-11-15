package com.tinkerpop.gremlin.compiler.types;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;

import javax.script.ScriptContext;

/**
 * @author Pavel A. Yaskevich
 */
public class Variable extends DynamicEntity {

    private final String variableName;
    private final GremlinScriptContext context;

    public Variable(final String variableName, final GremlinScriptContext context) {
        this.variableName = variableName;
        this.context = context;
    }

    public String getVariableName() {
        return this.variableName;
    }

    public int hashCode() {
        return this.variableName.hashCode();
    }

    public Object getValue() {
        return this.context.getBindings(ScriptContext.ENGINE_SCOPE).get(this.variableName);
    }

    public boolean isNull() {
        return this.context.getBindings(ScriptContext.ENGINE_SCOPE).get(this.variableName) == null;
    }
}
