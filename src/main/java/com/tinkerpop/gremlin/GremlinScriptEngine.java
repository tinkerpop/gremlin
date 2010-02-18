package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.Tokens;

import javax.script.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinScriptEngine implements ScriptEngine {

    private final GremlinEvaluator gremlinEvaluator;
    private final SimpleScriptContext scriptContext = new SimpleScriptContext();

    public GremlinScriptEngine() {
        this.gremlinEvaluator = new GremlinEvaluator();
    }

    public Bindings createBindings() {
        return new VariableLibrary(new GremlinPathContext(null));
    }

    public Object eval(final Reader reader) {
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

    public Object eval(final Reader reader, final Bindings bindings) {
        this.setBindings(bindings);
        return this.eval(reader);
    }

    public Object eval(final Reader reader, final ScriptContext context) {
        return this.eval(reader);
    }

    public Object eval(final String script) {
        return this.eval(new StringReader(script));
    }

    public Object eval(final String script, final Bindings bindings) {
        this.setBindings(bindings);
        return this.eval(new StringReader(script));
    }

    public Object eval(final String script, ScriptContext context) {
        return this.eval(new StringReader(script));
    }

    public Object get(String key) {
        Object object = this.gremlinEvaluator.getVariables().getVariable(key);
        if (null == object)
            throw new NullPointerException();
        else
            return object;
    }

    public Bindings getBindings(final int scope) {
        return this.gremlinEvaluator.getVariables();
    }

    public ScriptContext getContext() {
        return this.scriptContext;
    }

    public ScriptEngineFactory getFactory() {
        return new GremlinScriptEngineFactory();
    }

    public void put(final String key, final Object value) {
        this.gremlinEvaluator.getVariables().declareVariable(key, value);
    }

    public void setBindings(final Bindings bindings, final int scope) {
        this.setBindings(bindings);
    }

    private void setBindings(final Bindings bindings) {
        for (String key : bindings.keySet()) {
            if(!key.startsWith(Tokens.DOLLAR_SIGN))
                key = Tokens.DOLLAR_SIGN + key;
            this.gremlinEvaluator.getVariables().declareVariable(key, bindings.get(key));
        }
    }

    public void setContext(ScriptContext context) {
    }


}
