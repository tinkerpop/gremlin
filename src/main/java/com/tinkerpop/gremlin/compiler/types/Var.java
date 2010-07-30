package com.tinkerpop.gremlin.compiler.types;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.context.VariableLibrary;

/**
 * @author Pavel A. Yaskevich
 */
public class Var extends DynamicEntity {

    private final String var;
    private final VariableLibrary variables;
    
    public Var(final String var, final VariableLibrary variables) {
        this.var = var;
        this.variables = variables;
    }
    
    protected Object value() {
        Atom atom = (Atom) variables.get(this.var);
        return (atom == null) ? null : atom.getValue();
    }
}
