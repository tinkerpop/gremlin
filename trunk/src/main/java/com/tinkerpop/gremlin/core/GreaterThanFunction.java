package com.tinkerpop.gremlin.core;

import com.tinkerpop.gremlin.Function;
import com.tinkerpop.gremlin.Pair;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GreaterThanFunction implements Function<Pair<Float, Float>, Boolean> {

    public static final String NAME = ">";

    public Boolean evaluate(final Pair<Float, Float> input) {
        return input.getFirst() > input.getSecond();
    }

    public String getName() {
        return NAME;
    }
}
