package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FromJsonFunction extends AbstractFunction<Object> {

    private static final String FUNCTION_NAME = "from-json";
    private static final JSONParser parser = new JSONParser();

    public Atom<Object> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        if (arguments.size() == 1) {
            String jsonString = (String) arguments.get(0).compute().getValue();
            ContainerFactory containerFactory = new ContainerFactory() {
                public List creatArrayContainer() {
                    return new ArrayList();
                }

                public Map createObjectContainer() {
                    return new HashMap();
                }

            };
            try {
                return new Atom<Object>(parser.parse(jsonString, containerFactory));
            } catch (ParseException e) {
                throw new RuntimeException(this.createUnsupportedArgumentMessage("Unable to parse JSON: " + jsonString + " [at position " + e.getPosition() + "]"));
            }

        }

        throw new RuntimeException(this.createUnsupportedArgumentMessage());

    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }


}
