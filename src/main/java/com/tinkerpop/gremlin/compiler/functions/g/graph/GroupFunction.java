package com.tinkerpop.gremlin.compiler.functions.g.graph;

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

        Atom path = parameters.get(0).compute();
        List<Object> scopedValues = new ArrayList<Object>();

        for(Object o : (GPath) path.getValue()) {
            scopedValues.add(o);
        }

        return new Atom<Iterator>(new SingleIterator<List>(scopedValues));
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
