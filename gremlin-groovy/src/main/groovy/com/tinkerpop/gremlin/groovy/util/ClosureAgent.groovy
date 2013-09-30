package com.tinkerpop.gremlin.groovy.util

import java.lang.instrument.Instrumentation

/**
 * @author Stephen Mallette (http://stephen.genoprime.com)
 */
class ClosureAgent {
    private static Instrumentation instrumentation;

    public static void premain(final String args, final Instrumentation inst) {
        try {
            instrumentation = inst;
            instrumentation.addTransformer(new ClosureTransformer());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void agentmain(final String args, final Instrumentation inst) {
        instrumentation = inst;
        instrumentation.addTransformer(new ClosureTransformer());
    }

    static Instrumentation getInstrumentation() {
        return instrumentation
    }
}
