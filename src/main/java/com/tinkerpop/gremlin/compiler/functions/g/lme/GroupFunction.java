package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.GPath;
import com.tinkerpop.pipes.SingleIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class GroupFunction extends AbstractFunction<Iterator> {
    private final static String FUNCTION_NAME = "group";

    public Atom<Iterator> compute(final List<Operation> parameters) throws RuntimeException {
        if (parameters.size() != 1)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        GPath path = (GPath) parameters.get(0).compute().getValue();
        List<Object> list = new ArrayList<Object>();

        for (Object object : path) {
            list.add(object);
        }

        return new Atom<Iterator>(new SingleIterator<List>(list));
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
