package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class ListFunction extends AbstractFunction<Iterable> {

    private static final String FUNCTION_NAME = "list";

    public Atom<Iterable> compute(final List<Operation> parameters, final GremlinScriptContext context) throws RuntimeException {

        final List<Object> list = new ArrayList<Object>();
        for (Operation operation : parameters) {
            list.add(operation.compute().getValue());
        }

        return new Atom<Iterable>(list);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
