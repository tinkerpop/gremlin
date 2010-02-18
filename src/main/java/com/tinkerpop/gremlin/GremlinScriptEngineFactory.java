package com.tinkerpop.gremlin;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinScriptEngineFactory implements ScriptEngineFactory {

    public String getEngineName() {
        return "TinkerGremlin";
    }

    public String getEngineVersion() {
        return "0.1";
    }

    public List<String> getExtensions() {
        return Arrays.asList("grm");
    }

    public String getLanguageName() {
        return "gremlin";
    }

    public String getLanguageVersion() {
        return "0.2";
    }

    public String getMethodCallSyntax(final String obj, final String m, final String... args) {
        return null;
    }

    public List<String> getMimeTypes() {
        return Arrays.asList("plain");
    }

    public List<String> getNames() {
        return Arrays.asList("GremlinEngine", "Gremlin");
    }

    public String getOutputStatement(final String toDisplay) {
        return "g:print(" + toDisplay + ")";
    }

    public Object getParameter(final String key) {
        return null;
    }

    public String getProgram(final String... statements) {
        String program = new String();
        for (String statement : statements) {
            program = program + statement + "\n";
        }
        return program;
    }

    public ScriptEngine getScriptEngine() {
        return new GremlinScriptEngine();
    }
}
