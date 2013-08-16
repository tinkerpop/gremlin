package com.tinkerpop.gremlin.groovy.console;

import org.codehaus.groovy.tools.shell.IO;

/**
 * Wrapper for the standard IO that is sent to the plugin so that the plugin name can be appended to the start of
 * any writing to the console that the plugin does.
 *
 * @author Stephen Mallette (http://stephen.genoprime.com)
 */
public class ConsoleIO {
    private final IO io;
    private final ConsolePlugin plugin;

    private boolean startedWrite = false;

    public ConsoleIO(final ConsolePlugin plugin, final IO io) {
        this.io = io;
        this.plugin = plugin;
    }

    public void println() {
        writeLn("");
    }

    public void println(final boolean b) {
        writeLn(String.valueOf(b));
    }

    public void println(final char c) {
        writeLn(String.valueOf(c));
    }

    public void println(final int i) {
        writeLn(String.valueOf(i));
    }

    public void println(final long x) {
        writeLn(String.valueOf(x));
    }

    public void println(final float f) {
        writeLn(String.valueOf(f));
    }

    public void println(final double d) {
        writeLn(String.valueOf(d));
    }

    public void println(final char[] s) {
        writeLn(new String(s));
    }

    public void println(final String s) {
        writeLn(s);
    }

    public void println(final Object x){
        writeLn(String.valueOf(x));
    }

    public void print(final boolean b) {
        write(String.valueOf(b));
    }

    public void print(final char c) {
        write(String.valueOf(c));
    }

    public void print(final int i) {
        write(String.valueOf(i));
    }

    public void print(final long x) {
        write(String.valueOf(x));
    }

    public void print(final float f) {
        write(String.valueOf(f));
    }

    public void print(final double d) {
        write(String.valueOf(d));
    }

    public void print(final char[] s) {
        write(new String(s));
    }

    public void print(final String s) {
        write(s);
    }

    public void print(final Object x) {
        write(String.valueOf(x));
    }

    private void write(final String s) {
        if (startedWrite)
            io.out.print(s);
        else
            io.out.print(String.format("%s[%s] %s", Console.STANDARD_RESULT_PROMPT, this.plugin.getName(), s));

        startedWrite = true;
    }

    private void writeLn(final String s) {
        write(s);
        io.out.println();
        startedWrite = false;
    }
}
