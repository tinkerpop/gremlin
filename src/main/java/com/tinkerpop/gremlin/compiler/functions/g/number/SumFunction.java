package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SumFunction extends AbstractFunction<Double> {

    private static final String FUNCTION_NAME = "sum";

    public Atom<Double> compute(final List<Operation> parameters) throws RuntimeException {

        if (parameters.size() == 0) {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        } else {
            double counter = 0.0d;
            for (Operation operation : parameters) {
                Atom atom = operation.compute();
                if (atom.isNumber()) {
                    counter = counter + ((Double) atom.getValue());
                } else if (atom.isIterable()) {
                    counter = counter + countRecursiveIterable((Iterable<Atom>) atom.getValue(), 0.0d);
                } else {
                    throw new RuntimeException(this.createUnsupportedArgumentMessage());
                }

            }
            return new Atom<Double>(counter);
        }
    }

    private double countRecursiveIterable(final Iterable<Atom> iterable, double counter) throws RuntimeException {
        for (Atom atom : iterable) {
            if (atom.isNumber()) {
                counter = counter + (Double) atom.getValue();
            } else if (atom.isIterable()) {
                counter = countRecursiveIterable((Iterable<Atom>) atom.getValue(), counter);
            } else {
                throw new RuntimeException(this.createUnsupportedArgumentMessage());
            }
        }
        return counter;
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
