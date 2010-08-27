package com.tinkerpop.gremlin.compiler.functions.g.ime;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.GPath;

import java.util.List;

/**
 * This function used to force iteration through GPath
 * useful in situations with in-line variable assignment e.g.
 * ./outE[g:p($x := ./@weight)] or ./outE[g:p(g:op-value('+', $map, ./inV/@name, ./@weight))]
 * when user does not use manual iteration using foreach
 * 
 * @author Pavel A. Yaskevich
 */
public class ForceFunction extends AbstractFunction<Object> {
    private static final String FUNCTION_NAME = "force";

    public Atom<Object> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() != 1)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        Atom<Object> argument = arguments.get(0).compute();

        if (argument instanceof GPath) {
            ((GPath) argument).iterate();
        }

        return new Atom<Object>(null);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
