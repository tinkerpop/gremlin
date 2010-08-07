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
public class AssignFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "assign";

    public Atom<Boolean> compute(final List<Operation> parameters, final GremlinScriptContext context) throws RuntimeException {
        final int size = parameters.size();
        if (size == 2) {
            final Atom variable = parameters.get(0).compute();
            
            if (!(variable instanceof Var))
                throw new RuntimeException(this.createUnsupportedArgumentMessage("Two argument evaluation requires first argument to be a variable"));

            final Atom atom = parameters.get(1).compute();
            context.getVariableLibrary().declare(((Var) variable).getVariableName(), atom);
            
            return new Atom<Boolean>(true);
        } else if (size == 3) {
            final Object object = parameters.get(0).compute().getValue();
            final Object key = parameters.get(1).compute().getValue();
            final Object value = parameters.get(2).compute().getValue();
            if (object instanceof Map) {
                ((Map) object).put(key, value);
            } else if (object instanceof List) {
                ((List) object).set((Integer) key, value);
            } else if (object instanceof Element) {
                ((Element) object).setProperty((String) key, value);
            } else {
                throw new RuntimeException(this.createUnsupportedArgumentMessage("Three argument evaluation required the first argument to be a list, map, or element"));
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
