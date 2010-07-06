package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;
import java.util.Random;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RandomRealFunction extends AbstractFunction<Double> {

    public static final String FUNCTION_NAME = "rand-real";
    private static final Random random = new Random();


    public Atom<Double> compute(List<Operation> parameters) throws RuntimeException {

        if (parameters.size() == 0) {
            return new Atom<Double>(random.nextDouble());
        }

        throw new RuntimeException(this.createUnsupportedArgumentMessage());
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}