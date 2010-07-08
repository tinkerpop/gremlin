package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pavel A. Yaskevich
 */
public class MapFunction extends AbstractFunction<Map<Atom, Atom>> {

    private static final String FUNCTION_NAME = "map";

    public Atom<Map<Atom, Atom>> compute(final List<Operation> parameters) throws RuntimeException {
        final Map<Atom, Atom> map = new HashMap<Atom, Atom>();
        final int size = parameters.size();
        if (size == 1) {
            final Atom atom = parameters.get(0).compute();
            if (atom.isElement()) {
                final Element element = (Element) atom.getValue();
                for (String key : element.getPropertyKeys()) {
                    map.put(new Atom<String>(key), new Atom(element.getProperty(key)));
                }
            }

        } else if (size % 2 == 0) {
            for (int i = 0; i < parameters.size(); i += 2) {
                final Atom key = parameters.get(i).compute();
                final Atom value = parameters.get(i + 1).compute();
                map.put(key, value);
            }
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }

        return new Atom<Map<Atom, Atom>>(map);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }


}
