package com.tinkerpop.gremlin.functions.g.ime;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FlattenFunction extends AbstractFunction<List> {

    private static final String FUNCTION_NAME = "flatten";

    public Atom<List> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() == 0)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        List results = new ArrayList();
        flatten(results, FunctionHelper.generateObjects(arguments));
        return new Atom<List>(results);
    }

    public static void flatten(Collection current, Object object) {
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
