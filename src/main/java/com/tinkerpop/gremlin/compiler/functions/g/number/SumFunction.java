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
            double sum = 0.0d;
            for (Operation operation : parameters) {
                Atom atom = operation.compute();
                if (atom.isNumber()) {
                    sum = incrSum(atom, sum);
                } else if (atom.isIterable()) {
                    sum = sum + countRecursiveIterable((Iterable<Atom>) atom.getValue(), 0.0d);
                } else {
                    throw new RuntimeException(this.createUnsupportedArgumentMessage());
                }

            }
            return new Atom<Double>(sum);
        }
    }

    private double countRecursiveIterable(final Iterable<Atom> iterable, double sum) throws RuntimeException {
        for (Atom atom : iterable) {
            if (atom.isNumber()) {
                sum = incrSum(atom, sum);
            } else if (atom.isIterable()) {
                sum = countRecursiveIterable((Iterable<Atom>) atom.getValue(), sum);
            } else {
                throw new RuntimeException(this.createUnsupportedArgumentMessage());
            }
        }
        return sum;
    }

    private double incrSum(final Atom atom, double sum) {
        if (atom.isInteger()) {
            sum = sum + ((Integer) atom.getValue());
        } else if (atom.isLong()) {
            sum = sum + ((Long) atom.getValue());
        } else if (atom.isFloat()) {
            sum = sum + ((Float) atom.getValue());
        } else {
            sum = sum + ((Double) atom.getValue());
        }
        return sum;
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
