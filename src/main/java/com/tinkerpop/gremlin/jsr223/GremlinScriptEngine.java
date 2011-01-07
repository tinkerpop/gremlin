package com.tinkerpop.gremlin.jsr223;

import com.tinkerpop.gremlin.Gremlin;
import com.tinkerpop.gremlin.console.Imports;
import org.codehaus.groovy.jsr223.GroovyScriptEngineImpl;

import javax.script.ScriptException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinScriptEngine extends GroovyScriptEngineImpl {

    public GremlinScriptEngine() {
        try {
            for (String imps : Imports.getImports()) {
                this.eval("import " + imps + ";");
            }
        } catch (ScriptException e) {
            System.err.println(e.getMessage());
        }
        Gremlin.load();
    }

}
