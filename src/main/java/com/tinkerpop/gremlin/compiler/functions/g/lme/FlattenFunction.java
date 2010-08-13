package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FlattenFunction extends AbstractFunction<List<Object>> {

    private static final String FUNCTION_NAME = "flatten";

    public Atom<List<Object>> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() == 0)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        List<Object> results = new ArrayList<Object>();
        flatten(results, generateObjects(arguments));
        return new Atom<List<Object>>(results);
    }

    private static void flatten(List<Object> current, Object object) {
        if (object instanceof Iterable) {
            for (Object o : (Iterable) object) {
                flatten(current, o);
            }
        } else
            current.add(object);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
