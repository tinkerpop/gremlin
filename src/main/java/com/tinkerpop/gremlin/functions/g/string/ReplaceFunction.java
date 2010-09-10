package com.tinkerpop.gremlin.functions.g.string;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ReplaceFunction extends AbstractFunction<String> {

    private static final String FUNCTION_NAME = "replace";


    public Atom<String> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() == 3) {
            final String string = (String) arguments.get(0).compute().getValue();
            final String regex = (String) arguments.get(1).compute().getValue();
            final String replace = (String) arguments.get(2).compute().getValue();
            return new Atom<String>(string.replaceAll(regex, replace));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}