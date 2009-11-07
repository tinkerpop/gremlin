package com.tinkerpop.gremlin.core;

import com.tinkerpop.gremlin.Memory;
import com.tinkerpop.gremlin.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class ReadMemoryFunction implements Function<String, Object> {

    public static final String NAME = "{";
    protected final Memory memory;

    public ReadMemoryFunction(final Memory memory) {
        this.memory = memory;
    }

    public Object evaluate(String input) {
        return this.memory.get(input);
    }

    public String getName() {
        return NAME;
    }
}
