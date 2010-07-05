package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class ListFunction implements Function {

    private final String FUNCTION_NAME = "list";

    public Atom compute(List<Operation> params) throws RuntimeException {
        List<Atom> list = new ArrayList<Atom>();

        for (int i = 0; i < params.size(); i++) {
            list.add(params.get(i).compute());
        }

        return new Atom(list);
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }

}
