package com.tinkerpop.gremlin.groovy.console;

import org.codehaus.groovy.tools.shell.Groovysh;

/**
 * Wrapper for the Groovysh class that gets passed to a plugin.
 *
 * @author Stephen Mallette (http://stephen.genoprime.com)
 */
public class ConsoleGroovy {
    private final Groovysh groovysh;

    public ConsoleGroovy(final Groovysh groovysh) {
        this.groovysh = groovysh;
    }

    /**
     * Execute some groovy in the REPL. For plugin developers, this is typically use to execute import statements
     * for classes that should be available in the REPL so that the user does not need to type the entire
     * package name.
     */
    public Object execute(final String line) {
        return this.groovysh.execute(line);
    }
}
