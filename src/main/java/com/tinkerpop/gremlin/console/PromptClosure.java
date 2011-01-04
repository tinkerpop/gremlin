package com.tinkerpop.gremlin.console;

import groovy.lang.Closure;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PromptClosure extends Closure {

    private static final String PROMPT = "gremlin> ";

    public PromptClosure(final Object owner) {
        super(owner);
    }

    public Object call() {
        return PROMPT;
    }
}
