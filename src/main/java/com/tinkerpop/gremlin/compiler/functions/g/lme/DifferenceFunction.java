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
public class DifferenceFunction extends AbstractFunction<Iterable<Atom>> {

    private static final String FUNCTION_NAME = "difference";

    public Atom<Iterable<Atom>> compute(final List<Operation> parameters) throws RuntimeException {

        if (parameters.size() < 2) {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        } else {
            Set<Atom> set = null;
            for (Operation operation : parameters) {
                final Atom atom = operation.compute();
                if (atom.isIterable()) {
                    if (null == set) {
                        set = new HashSet<Atom>();
                        fillCollection(set, ((Iterable) atom.getValue()).iterator());
                    } else {
                        Set<Atom> temp = new HashSet<Atom>();
                        fillCollection(temp, ((Iterable) atom.getValue()).iterator());
                        set.removeAll(temp);
                    }
                } else {
                    if (null == set) {
                        set = new HashSet<Atom>();
                        set.add(atom);
                    } else {
                        set.remove(atom);
                    }
                }
            }
            return new Atom<Iterable<Atom>>(set);
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}