package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.statements.EvaluationException;

import javax.script.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinScriptEngine extends AbstractScriptEngine {

    private final GremlinEvaluator gremlinEvaluator;

    public GremlinScriptEngine() {
        this.gremlinEvaluator = new GremlinEvaluator();
    }

    public Bindings createBindings() {
        return new VariableLibrary(new GremlinPathContext(null));
    }

    public Object eval(final Reader reader, final ScriptContext context) {
        BufferedReader bReader = new BufferedReader(reader);
        String line;
        List result = null;
        try {
            while ((line = bReader.readLine()) != null) {
                result = this.gremlinEvaluator.evaluate(line);
            }
        } catch (IOException e) {
            throw new EvaluationException(e.getMessage());
        }
        return result;
    }

    public Object eval(final String script, ScriptContext context) {
        return this.eval(new StringReader(script), context);
    }

    public ScriptEngineFactory getFactory() {
        return new GremlinScriptEngineFactory();
    }

    public GremlinEvaluator getGremlinEvaluator() {
        return this.gremlinEvaluator;
    }
}
