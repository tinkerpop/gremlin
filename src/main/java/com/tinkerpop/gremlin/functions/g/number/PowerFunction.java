package com.tinkerpop.gremlin.functions.g.number;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PowerFunction extends AbstractFunction<Double> {

    public static final String FUNCTION_NAME = "power";

    public Atom<Double> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        if (arguments.size() == 2) {
            Double base = ((Number) arguments.get(0).compute().getValue()).doubleValue();
            Double power = ((Number) arguments.get(1).compute().getValue()).doubleValue();
            return new Atom<Double>(Math.pow(base, power));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}