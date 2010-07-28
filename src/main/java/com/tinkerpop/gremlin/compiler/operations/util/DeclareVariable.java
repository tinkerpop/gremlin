package com.tinkerpop.gremlin.compiler.operations.util;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.DynamicEntity;

/**
 * @author Pavel A. Yaskevich
 */
public class DeclareVariable implements Operation {

    private final String name;
    private final Operation valueOperation;

    public DeclareVariable(final String name, final Operation valueOp) {
        this.name = name;
        this.valueOperation = valueOp;
    }

    public Atom compute() {
        Atom atom = this.valueOperation.compute();

        if (!(atom instanceof DynamicEntity)) {
            GremlinEvaluator.declareVariable(this.name, atom);
        } else {
            GremlinEvaluator.declareVariable(this.name, new Atom<Object>(atom.getValue()));
        }

        return atom;
    }

    public static void decalareWithInit(String var, Atom value) {
        GremlinEvaluator.declareVariable(var, value);
    }
    
    public Type getType() {
        return Type.STATEMENT;
    }

}
