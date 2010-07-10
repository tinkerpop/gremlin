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
            for (final Operation operation : parameters) {
                final Object object = operation.compute().getValue();
                if (object instanceof Number) {
                    sum = sum + ((Number) object).doubleValue();
                } else if (object instanceof Iterable) {
                    sum = sum + countRecursiveIterable((Iterable) object, 0.0d);
                } else {
                    throw new RuntimeException(this.createUnsupportedArgumentMessage());
                }

            }
            return new Atom<Double>(sum);
        }
    }

    private double countRecursiveIterable(final Iterable iterable, double sum) throws RuntimeException {
        for (final Object object : iterable) {
            if (object instanceof Number) {
                sum = sum + ((Number) object).doubleValue();
            } else if (object instanceof Iterable) {
                sum = countRecursiveIterable((Iterable) object, sum);
            } else {
                throw new RuntimeException(this.createUnsupportedArgumentMessage());
            }
        }
        return sum;
    }


    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
