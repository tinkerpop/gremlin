package com.tinkerpop.gremlin.functions.g.string;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class MatchesFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "matches";


    public Atom<Boolean> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() == 2) {
            final String string = (String) arguments.get(0).compute().getValue();
            final String regex = (String) arguments.get(1).compute().getValue();
            return new Atom<Boolean>(string.matches(regex));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}