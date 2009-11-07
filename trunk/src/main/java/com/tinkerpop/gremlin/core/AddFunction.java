package com.tinkerpop.gremlin.core;

import com.tinkerpop.gremlin.Function;
import com.tinkerpop.gremlin.Pair;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class AddFunction implements Function<Pair<Number,Number>, Number> {

    public static final String NAME = "+";

    public Number evaluate(final Pair<Number, Number> input) {
        Number a = input.getFirst();
        Number b = input.getSecond();
        Float sum = 0.0f;
        boolean isFloat = false;
        if(a instanceof Integer) {
            sum = sum + (Integer)a;
        } else if(a instanceof Float) {
            sum = sum + (Float)a;
            isFloat = true;
        }

        if(b instanceof Integer) {
            sum = sum + (Integer)b;
        } else if(b instanceof Float) {
            sum = sum + (Float)b;
            isFloat = true;
        }

        if(isFloat)
            return sum;
        else
            return sum.intValue();
    }

    public String getName() {
        return NAME;
    }
}
