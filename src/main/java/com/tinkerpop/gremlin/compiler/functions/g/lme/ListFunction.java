package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class ListFunction extends AbstractFunction<Iterable<Atom>> {

    private static final String FUNCTION_NAME = "list";

    public Atom<Iterable<Atom>> compute(final List<Operation> parameters) throws RuntimeException {
        List<Atom> list = new ArrayList<Atom>();

        for (Operation operation : parameters) {
            list.add(operation.compute());
        }

        return new Atom<Iterable<Atom>>(list);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
