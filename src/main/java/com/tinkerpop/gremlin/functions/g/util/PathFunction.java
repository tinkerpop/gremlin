package com.tinkerpop.gremlin.functions.g.util;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.DynamicEntity;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PathFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "p";

    public Atom<Boolean> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        try {
            for (Operation o : arguments) {
                final Atom atom = o.compute();
                
                if (atom instanceof DynamicEntity) {
                    atom.getValue();
                }
            }
        } catch (Exception e) { /* returning true anyway */ }
        
        return new Atom<Boolean>(true);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
