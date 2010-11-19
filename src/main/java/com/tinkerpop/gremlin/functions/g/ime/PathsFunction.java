package com.tinkerpop.gremlin.functions.g.ime;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.GPath;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.pipes.Pipeline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PathsFunction extends AbstractFunction<List> {

    private static final String FUNCTION_NAME = "path";

    public Atom<List> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() != 1)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        else {
            Operation op = arguments.get(0);
            Atom atom = op.compute();
            if (atom instanceof GPath) {
                GPath path = (GPath) atom;
                Pipeline pipeline = new Pipeline(path.getPipes());
                pipeline.enablePath();
                List paths = new ArrayList();
                pipeline.setStarts(Arrays.asList(path.getRoot().getValue()));
                for (Object object : pipeline) {
                    paths.add(pipeline.path());
                }
                return new Atom<List>(paths);
            } else {
                throw new RuntimeException(this.createUnsupportedArgumentMessage());
            }

        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}