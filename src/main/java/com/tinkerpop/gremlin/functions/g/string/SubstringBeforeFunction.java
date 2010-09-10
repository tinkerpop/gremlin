package com.tinkerpop.gremlin.functions.g.string;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SubstringBeforeFunction extends AbstractFunction<String> {

    private static final String FUNCTION_NAME = "substring-before";


    public Atom<String> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() == 2) {
            String base = (String) arguments.get(0).compute().getValue();
            String check = (String) arguments.get(1).compute().getValue();
            int index = base.indexOf(check);
            if (index == -1)
                return new Atom<String>(base);
            else
                return new Atom<String>(base.substring(0, index));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}