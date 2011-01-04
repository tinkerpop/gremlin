package com.tinkerpop.gremlin.console;

import groovy.lang.Closure;
import org.codehaus.groovy.tools.shell.IO;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ErrorHookClosure extends Closure {

    private final IO io;

    public ErrorHookClosure(final Object owner, final IO io) {
        super(owner);
        this.io = io;
    }

    public Object call(final Object[] args) {
        final Exception e = (Exception) args[0];
        String message = e.getMessage();
        message = message.replace("startup failed:", "");
        io.err.println(message.trim());
        return null;
    }
}
