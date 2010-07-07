package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DeduplicateFunction extends AbstractFunction<Iterable<Atom>> {

    private static final String FUNCTION_NAME = "dedup";

    public Atom<Iterable<Atom>> compute(final List<Operation> parameters) throws RuntimeException {

        if (parameters.size() == 0) {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        } else {
            Set<Atom> set = new HashSet<Atom>();
            for (Operation operation : parameters) {
                Atom atom = operation.compute();
                if (atom.isIterable()) {
                    for (Object object : (Iterable) atom.getValue()) {
                        set.add(new Atom(object));
                    }
                } else {
                    set.add(atom);
                }

            }
            return new Atom<Iterable<Atom>>(set);
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}