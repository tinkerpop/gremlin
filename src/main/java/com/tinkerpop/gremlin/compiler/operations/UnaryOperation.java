package com.tinkerpop.gremlin.compiler.operations;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.functions.Function;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class UnaryOperation implements Operation {

    private Atom operand;

    public UnaryOperation(Atom op) {
        this.operand = op;
    }

    public Atom compute() {
        return this.operand;
    }

    public Type getType() {
        if (this.operand.isNull()) {
            return Type.MATH;
        } else {
            return (this.operand.isNumber()) ? Type.MATH : Type.LOGIC;
        }
    }

}
