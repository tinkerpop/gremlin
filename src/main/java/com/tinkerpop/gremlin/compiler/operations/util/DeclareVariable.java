package com.tinkerpop.gremlin.compiler.operations.util;

import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.DynamicEntity;
import com.tinkerpop.gremlin.compiler.types.Var;

/**
 * @author Pavel A. Yaskevich
 */
public class DeclareVariable implements Operation {

    private final String name;
    private final Operation valueOperation;
    private final GremlinScriptContext context;

    public DeclareVariable(final String name, final Operation valueOp, final GremlinScriptContext context) {
        this.name = name;
        this.valueOperation = valueOp;
        this.context = context;
    }

    public Atom compute() {
        final Atom atom = this.valueOperation.compute();
        final Atom value = (!(atom instanceof DynamicEntity)) ? atom : dynamicValue(atom);

        this.context.getVariableLibrary().declare(this.name, value);
        return atom;
    }

    public Type getType() {
        return Type.STATEMENT;
    }

    private Atom<Object> dynamicValue(final Atom atom) {
        if (atom instanceof Var) {
            final Var variable = (Var) atom;
            if (variable.getVariableName().equals(Tokens.IDENTITY)) {
                return new Atom<Object>(this.context.getCurrentPoint());
            }
        }

        return new Atom<Object>(atom.getValue());
    }
}
