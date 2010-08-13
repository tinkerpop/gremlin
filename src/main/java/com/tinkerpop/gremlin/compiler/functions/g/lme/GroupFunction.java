package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.GPath;
import com.tinkerpop.pipes.SingleIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class GroupFunction extends AbstractFunction<Iterator> {
    private final static String FUNCTION_NAME = "g";

    public Atom<Iterator> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() != 1)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        Object path = arguments.get(0).compute().getValue();
        return new Atom<Iterator>(new SingleIterator<Object>(path));
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
