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
public class ValuesFunction extends AbstractFunction<Iterable<Atom>> {

    private static final String FUNCTION_NAME = "values";

    public Atom<Iterable<Atom>> compute(final List<Operation> parameters) throws RuntimeException {

        if (parameters.size() != 1) {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        } else {
            Atom atom = parameters.get(0).compute();
            if (atom.isMap()) {
                List<Atom> values = new ArrayList<Atom>();
                for (Atom value : ((Map<Atom, Atom>) atom.getValue()).values()) {
                    values.add(value);
                }
                return new Atom<Iterable<Atom>>(values);
            } else if (atom.isElement()) {
                List<Atom> values = new ArrayList<Atom>();
                Element element = ((Element) atom.getValue());
                for (String key : element.getPropertyKeys()) {
                    values.add(new Atom(element.getProperty(key)));
                }
                return new Atom<Iterable<Atom>>(values);
            } else {
                throw new RuntimeException(this.createUnsupportedArgumentMessage());
            }
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
