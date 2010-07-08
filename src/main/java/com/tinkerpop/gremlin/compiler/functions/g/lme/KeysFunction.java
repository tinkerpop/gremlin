package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class KeysFunction extends AbstractFunction<Iterable<Atom>> {

    private static final String FUNCTION_NAME = "keys";

    public Atom<Iterable<Atom>> compute(final List<Operation> parameters) throws RuntimeException {

        if (parameters.size() != 1) {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        } else {
            final Atom atom = parameters.get(0).compute();
            if (atom.isMap()) {
                return new Atom<Iterable<Atom>>(((Map<Atom, Atom>) atom.getValue()).keySet());
            } else if (atom.isElement()) {
                final List<Atom> keys = new ArrayList<Atom>();
                final Element element = ((Element) atom.getValue());
                for (String key : element.getPropertyKeys()) {
                    keys.add(new Atom<String>(key));
                }
                return new Atom<Iterable<Atom>>(keys);
            } else {
                throw new RuntimeException(this.createUnsupportedArgumentMessage());
            }
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
