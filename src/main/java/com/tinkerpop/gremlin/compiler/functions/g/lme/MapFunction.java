package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pavel A. Yaskevich
 */
public class MapFunction extends AbstractFunction<Map> {

    private static final String FUNCTION_NAME = "map";

    public Atom<Map> compute(final List<Operation> parameters, final GremlinScriptContext context) throws RuntimeException {
        final Map map = new HashMap();
        final int size = parameters.size();
        if (size == 1) {
            final Object object = parameters.get(0).compute().getValue();
            if (object instanceof Element) {
                final Element element = (Element) object;
                for (String key : element.getPropertyKeys()) {
                    map.put(key, element.getProperty(key));
                }
            }

        } else if (size % 2 == 0) {
            for (int i = 0; i < parameters.size(); i += 2) {
                map.put(parameters.get(i).compute().getValue(), parameters.get(i + 1).compute().getValue());
            }
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }

        return new Atom<Map>(map);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }


}
