package com.tinkerpop.gremlin.compiler.functions.g.io;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class PrintFunction extends AbstractFunction<Object> {

    private static final String FUNCTION_NAME = "print";


    public Atom<Object> compute(final List<Operation> parameters) throws RuntimeException {

        for (Operation operation : parameters) {
            System.out.println(operation.compute());
        }

        return new Atom<Object>(null);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
