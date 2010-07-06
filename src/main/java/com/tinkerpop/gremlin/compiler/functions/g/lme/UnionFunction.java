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
public class UnionFunction extends AbstractFunction {

    private static final String FUNCTION_NAME = "union";

    public Atom compute(List<Operation> parameters) throws RuntimeException {

        if (parameters.size() < 2) {
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
            return new Atom(set);
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}