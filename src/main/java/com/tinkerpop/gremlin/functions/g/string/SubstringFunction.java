package com.tinkerpop.gremlin.functions.g.string;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SubstringFunction extends AbstractFunction<String> {

    private static final String FUNCTION_NAME = "substring";


    public Atom<String> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        final int size = arguments.size();
        if (size == 2) {
            final String string = (String) arguments.get(0).compute().getValue();
            final Number start = (Number) arguments.get(1).compute().getValue();
            return new Atom<String>(string.substring(start.intValue()));
        } else if (size == 3) {
            final String string = (String) arguments.get(0).compute().getValue();
            final Number start = (Number) arguments.get(1).compute().getValue();
            final Number end = (Number) arguments.get(2).compute().getValue();
            return new Atom<String>(string.substring(start.intValue(), end.intValue()));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}