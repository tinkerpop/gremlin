package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GetFunction extends AbstractFunction<Object> {

    private static final String FUNCTION_NAME = "get";

    public Atom<Object> compute(final List<Operation> parameters, final GremlinScriptContext context) throws RuntimeException {
        if (parameters.size() != 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        List<Object> objects = generateObjects(parameters);
        if (objects.get(0) instanceof Map) {
            return new Atom(((Map) objects.get(0)).get(objects.get(1)));
        } else if (objects.get(0) instanceof List) {
            return new Atom(((List) objects.get(0)).get((Integer) objects.get(1)));
        } else if (objects.get(0) instanceof Element) {
            return new Atom(((Element) objects.get(0)).getProperty((String) objects.get(1)));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
