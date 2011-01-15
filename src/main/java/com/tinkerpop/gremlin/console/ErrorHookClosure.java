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
        if (args.length > 0) {
            try {
                final Throwable e = (Throwable) args[0];
                String message = e.getMessage();
                if (null != message) {
                    message = message.replace("startup failed:", "");
                    io.err.println(message.trim());
                } else {
                    io.err.println(e);
                }
                return null;
            } catch (Exception e) {
                io.err.println("An undefined error has occurred: " + args[0]);
                return null;
            }
        } else {
            io.err.println("An undefined error has occurred");
            return null;
        }
    }
}
