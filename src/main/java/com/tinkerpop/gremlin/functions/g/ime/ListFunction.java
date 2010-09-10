package com.tinkerpop.gremlin.functions.g.ime;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class ListFunction extends AbstractFunction<List> {

    private static final String FUNCTION_NAME = "list";

    public Atom<List> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        final List list = new ArrayList();
        for (Operation operation : arguments) {
            list.add(operation.compute().getValue());
        }

        return new Atom<List>(list);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
