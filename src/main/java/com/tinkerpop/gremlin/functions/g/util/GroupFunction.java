package com.tinkerpop.gremlin.functions.g.util;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.pipes.PipeHelper;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class GroupFunction extends AbstractFunction<List> {
    private final static String FUNCTION_NAME = "g";

    public Atom<List> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() != 1)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        Object object = arguments.get(0).compute().getValue();
        Iterator itty;
        if (object instanceof Iterable)
            itty = ((Iterable) object).iterator();
        else if (object instanceof Iterator)
            itty = (Iterator) object;
        else
            throw new RuntimeException(this.createUnsupportedArgumentMessage("Iterable object required"));

        List group = new LinkedList();
        PipeHelper.fillCollection(itty, group);
        return new Atom<List>(group);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
