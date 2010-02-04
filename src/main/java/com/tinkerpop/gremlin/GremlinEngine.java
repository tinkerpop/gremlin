package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.GremlinEvaluator;
import com.tinkerpop.gremlin.GremlinPathContext;
import com.tinkerpop.gremlin.VariableLibrary;
import com.tinkerpop.gremlin.GremlinEngineFactory;
import com.tinkerpop.gremlin.statements.EvaluationException;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinEngine implements ScriptEngine {

    private GremlinEvaluator gremlinEvaluator;

    public GremlinEngine() {
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
        return null;
    }

    public ScriptEngineFactory getFactory() {
        return new GremlinEngineFactory();
    }

    public void put(final String key, final Object value) {
        this.gremlinEvaluator.getVariables().declareVariable(key, value);
    }

    public void setBindings(final Bindings bindings, final int scope) {
        this.setBindings(bindings);
    }

    private void setBindings(Bindings bindings) {
        for (String key : bindings.keySet()) {
            this.gremlinEvaluator.getVariables().declareVariable(key, bindings.get(key));
        }
    }

    public void setContext(ScriptContext context) {
    }


}
