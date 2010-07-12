package com.tinkerpop.gremlin.compiler.operations;

import com.tinkerpop.gremlin.compiler.Atom;
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
        return (this.operand.isPersistent()) ? this.operand : this.operand.recalculated();
    }

    public Type getType() {
        if (this.operand.isNull()) {
            return Type.MATH;
        } else {
            return (this.operand.isNumber()) ? Type.MATH : Type.LOGIC;
        }
    }

    public boolean isFunctionCall() {
        return this.operand.isFunctionCall();
    }

    public boolean isVariableCall() {
        return this.operand.isVariableCall();
    }

    public Function getFunctionObject() {
        return this.operand.getFunctionObject();
    }

    public List<Operation> getFunctionParameters() {
        return this.operand.getFunctionParameters();
    }

    /*
     * Used to return positions of "." identifiers in function params
     */
    public List<Integer> pipeObjectIndicesInFunctionParams() {
        List<Integer> pipeObjectIndices = new ArrayList<Integer>();

        int position = 0;
        for (Operation parameter : this.getFunctionParameters()) {
            Atom atom = parameter.compute();

            if (atom.isIdentifier()) {
                String token = atom.getValue().toString();
                
                if (token.equals("."))
                    pipeObjectIndices.add(position);
            }

            position++;
        }

        return pipeObjectIndices;
    }
}
