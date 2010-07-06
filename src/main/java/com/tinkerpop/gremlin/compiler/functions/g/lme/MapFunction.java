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
public class MapFunction extends AbstractFunction {

    private static final String FUNCTION_NAME = "map";

    public Atom compute(List<Operation> params) throws RuntimeException {
        Map<Atom, Atom> map = new HashMap<Atom, Atom>();

        if (params.size() == 1) {
            Atom atom = params.get(0).compute();
            if (atom.isElement()) {
                Element element = (Element) atom.getValue();
                for (String key : element.getPropertyKeys()) {
                    map.put(new Atom(key), new Atom(element.getProperty(key)));
                }
            }

        } else if (params.size() % 2 == 0) {
            for (int i = 0; i < params.size(); i += 2) {
                Atom key = params.get(i).compute();
                Atom value = params.get(i + 1).compute();
                map.put(key, value);
            }
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }

        return new Atom(map);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }


}
