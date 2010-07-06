package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class ListFunction extends AbstractFunction {

    private static final String FUNCTION_NAME = "list";

    public Atom compute(List<Operation> params) throws RuntimeException {
        List<Atom> list = new ArrayList<Atom>();

        for (Operation operation : params) {
            list.add(operation.compute());
        }

        return new Atom(list);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
