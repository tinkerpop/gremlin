package com.tinkerpop.gremlin.core;

import com.tinkerpop.gremlin.Function;
import com.tinkerpop.gremlin.Triple;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class ComposeFunction implements Function<Triple<String, Function, Function>, Function>{

    public static final String NAME = "o";

    public Function evaluate(final Triple<String, Function, Function> input) {
        return new Function() {
            public Object evaluate(Object tempInput) {
                return input.getSecond().evaluate(input.getThird().evaluate(tempInput));
            }

            public String getName() {
                return input.getFirst();
            }
        };
    }

    public String getName() {
        return NAME;
    }
}
