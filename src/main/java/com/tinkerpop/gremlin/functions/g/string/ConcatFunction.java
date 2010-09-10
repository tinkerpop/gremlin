package com.tinkerpop.gremlin.functions.g.string;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class ConcatFunction extends AbstractFunction<String> {

    private static final String FUNCTION_NAME = "concat";


    public Atom<String> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        String resultString = "";

        for (Operation operation : arguments) {
            resultString = resultString.concat(operation.compute().toString());
        }

        return new Atom<String>(resultString);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }

}
