package com.tinkerpop.gremlin.functions.g.string;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SubstringAfterFunction extends AbstractFunction<String> {

    private static final String FUNCTION_NAME = "substring-after";


    public Atom<String> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() == 2) {
            String base = (String) arguments.get(0).compute().getValue();
            String check = (String) arguments.get(1).compute().getValue();
            return new Atom<String>(base.substring(base.indexOf(check)+check.length()));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}