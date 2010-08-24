package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RangeFunction extends AbstractFunction<Set> {

    public static final String FUNCTION_NAME = "range";


    public Atom<Set> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        if (arguments.size() == 2) {
            Set range = new LinkedHashSet();
            for (int i = ((Number) arguments.get(0).compute().getValue()).intValue(); i < ((Number) arguments.get(1).compute().getValue()).intValue(); i++) {
                range.add(i);
            }
            return new Atom<Set>(range);
        }

        throw new RuntimeException(this.createUnsupportedArgumentMessage());
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}