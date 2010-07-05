package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pavel A. Yaskevich
 */
public class MapFunction implements Function {

    private final String FUNCTION_NAME = "map";

    public Atom compute(List<Operation> params) throws RuntimeException {
        Map<Atom, Atom> map = new HashMap<Atom, Atom>();

        if (params.size() % 2 != 0)
            throw new RuntimeException(Function.UNSUPPORTED_ARGUMENTS + this.FUNCTION_NAME);

        for (int i = 0; i < params.size(); i += 2) {
            Atom key = params.get(i).compute();
            Atom value = params.get(i + 1).compute();
            map.put(key, value);
        }

        return new Atom(map);
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }

}
