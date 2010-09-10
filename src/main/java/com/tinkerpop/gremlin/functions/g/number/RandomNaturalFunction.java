package com.tinkerpop.gremlin.functions.g.number;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;

import java.util.List;
import java.util.Random;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RandomNaturalFunction extends AbstractFunction<Integer> {

    public static final String FUNCTION_NAME = "rand-nat";
    private static final Random random = new Random();


    public Atom<Integer> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {


        if (arguments.size() == 0) {
            return new Atom<Integer>(random.nextInt());
        } else if (arguments.size() == 1) {
            Atom atom = arguments.get(0).compute();
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
