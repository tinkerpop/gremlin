package com.tinkerpop.gremlin.compiler.types;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class Func extends DynamicEntity {

    private final Function function;
    private final List<Operation> parameters;
    
    public Func(final Function function, final List<Operation> parameters) {
        this.function = function;
        this.parameters = parameters;
    }

    protected Object value() {
        return function.compute(parameters).getValue();
    }

    public Function getFunction() {
        return function;
    }

    public List<Operation> getParameters() {
        return parameters;
    }

    /*
     * Used to return positions of "." identifiers in function params
     */
    public List<Integer> pipeObjectIndicesInFunctionParams() {
        List<Integer> pipeObjectIndices = new ArrayList<Integer>();

        int position = 0;
        Atom rootVariable = GremlinEvaluator.getVariable(Tokens.ROOT_VARIABLE);

        for (Operation parameter : parameters) {
            Atom atom = parameter.compute();

            if (atom.isIdentifier()) {
                String token = atom.getValue().toString();

                if (token.equals(".") || rootVariable.equals(atom)) {
                    pipeObjectIndices.add(position);
                }
            }

            position++;
        }

        return pipeObjectIndices;
    }
    
}
