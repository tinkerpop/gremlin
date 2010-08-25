package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.Var;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class UnassignFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "unassign";

    public Atom<Boolean> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        final int size = arguments.size();
        if (size == 1) {
            final Atom variable = arguments.get(0).compute();

            if (!(variable instanceof Var))
                throw new RuntimeException(this.createUnsupportedArgumentMessage());

            context.getVariableLibrary().remove(((Var) variable).getVariableName());
            return new Atom<Boolean>(true);
        } else if (size == 2) {
            final Object object = arguments.get(0).compute().getValue();
            final Object key = arguments.get(1).compute().getValue();
            if (object instanceof Map) {
                ((Map) object).remove(key);
            } else if (object instanceof List) {
                ((List) object).remove(((Integer) key).intValue());
            } else if (object instanceof Element) {
                ((Element) object).removeProperty((String) key);
            } else {
                throw new RuntimeException(this.createUnsupportedArgumentMessage());
            }
            return new Atom<Boolean>(true);
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }


    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
