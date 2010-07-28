package com.tinkerpop.gremlin.compiler.types;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;

/**
 * @author Pavel A. Yaskevich
 */
public class Var extends DynamicEntity {

    private final String var;

    public Var(final String var) {
        this.var = var;
    }
    
    // TODO: de-static
    protected Object value() {
        Atom atom = (Atom) GremlinEvaluator.getVariableValue(this.var);
        return (atom == null) ? null : atom.getValue();
    }
}
