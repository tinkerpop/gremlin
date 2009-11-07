package com.tinkerpop.gremlin.core;

import com.tinkerpop.gremlin.Function;
import com.tinkerpop.gremlin.Memory;
import com.tinkerpop.gremlin.Pair;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class WriteMemoryFunction implements Function<Pair<String, Object>, Object> {

    public static final String NAME = "}";
    protected final Memory memory;

    public WriteMemoryFunction(final Memory memory) {
        this.memory = memory;
    }

    public Object evaluate(Pair<String, Object> input) {
        this.memory.put(input.getFirst(), input.getSecond());
        return input.getSecond();
    }

    public String getName() {
        return NAME;
    }

}
