package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class TimeFunction extends AbstractFunction<Double> {

    private static final String FUNCTION_NAME = "time";

    private static final double ONE_MILLION = 1000000d;

    public Atom<Double> compute(final List<Operation> params) throws RuntimeException {
        if (params.size() == 0) {
            return new Atom<Double>(System.nanoTime() / ONE_MILLION);
        } else if (params.size() == 1) {
            Object time = params.get(0).compute().getValue();
            if (time instanceof Number) {
                return new Atom<Double>((System.nanoTime() / ONE_MILLION) - (Double) time);
            }
        }

        throw new RuntimeException(this.createUnsupportedArgumentMessage());
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }


}
