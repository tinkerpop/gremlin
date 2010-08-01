package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;
import java.util.Random;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RandomNaturalFunction extends AbstractFunction<Integer> {

    public static final String FUNCTION_NAME = "rand-nat";
    private static final Random random = new Random();


    public Atom<Integer> compute(final List<Operation> parameters, final GremlinScriptContext context) throws RuntimeException {


        if (parameters.size() == 0) {
            return new Atom<Integer>(random.nextInt());
        } else if (parameters.size() == 1) {
            Atom atom = parameters.get(0).compute();
            if (atom.isInteger()) {
                return new Atom<Integer>(random.nextInt((Integer) atom.getValue()));
            } else {
                return new Atom<Integer>(random.nextInt(Double.valueOf(atom.getValue().toString()).intValue()));
            }
        }


        throw new RuntimeException(this.createUnsupportedArgumentMessage());
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
