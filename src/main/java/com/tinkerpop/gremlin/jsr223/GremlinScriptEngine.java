package com.tinkerpop.gremlin.jsr223;

import com.tinkerpop.gremlin.Gremlin;
import org.codehaus.groovy.jsr223.GroovyScriptEngineImpl;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinScriptEngine extends GroovyScriptEngineImpl {

    public GremlinScriptEngine() {
        new Gremlin();
    }

}
