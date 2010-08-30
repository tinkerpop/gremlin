package com.tinkerpop.gremlin.functions.g.ime;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pavel A. Yaskevich
 */
public class MapFunction extends AbstractFunction<Map> {

    private static final String FUNCTION_NAME = "map";

    public Atom<Map> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        final Map map = new HashMap();
        final int size = arguments.size();
        if (size == 1) {
            final Object object = arguments.get(0).compute().getValue();
            if (object instanceof Map) {
                final Map<?, ?> map2 = (Map) object;
                for (Map.Entry<?, ?> entry : map2.entrySet()) {
                    map.put(entry.getKey(), entry.getValue());
                }
            } else if (object instanceof List) {
                final List list = (List) object;
                if (list.size() % 2 == 0) {
                    for (int i = 0; i < list.size(); i += 2) {
                        map.put(list.get(i), list.get(i + 1));
                    }
                } else {

                    throw new RuntimeException(this.createUnsupportedArgumentMessage("List size must be divisible by 2"));
                }
            } else if (object instanceof Element) {
                final Element element = (Element) object;
                for (String key : element.getPropertyKeys()) {
                    map.put(key, element.getProperty(key));
                }
            } else {
                throw new RuntimeException(this.createUnsupportedArgumentMessage("Single argument must be a map, list, or element"));
            }

        } else if (size % 2 == 0) {
            for (int i = 0; i < size; i += 2) {
                map.put(arguments.get(i).compute().getValue(), arguments.get(i + 1).compute().getValue());
            }
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage("Argument size must be divisible by 2"));
        }

        return new Atom<Map>(map);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }


}
