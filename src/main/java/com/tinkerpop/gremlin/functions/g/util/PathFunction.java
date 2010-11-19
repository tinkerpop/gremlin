package com.tinkerpop.gremlin.functions.g.util;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.GPath;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.pipes.PathSequence;
import com.tinkerpop.pipes.Pipeline;
import com.tinkerpop.pipes.SingleIterator;

import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PathFunction extends AbstractFunction<Iterable> {

    private static final String FUNCTION_NAME = "path";

    public Atom<Iterable> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() != 1)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        else {
            Atom atom = arguments.get(0).compute();
            if (atom instanceof GPath) {
                GPath gPath = (GPath) atom;
                Pipeline pipeline = new Pipeline(gPath.getPipes());
                pipeline.enablePath();

                Object root = gPath.getRoot().getValue();
                if (root instanceof Iterable)
                    pipeline.setStarts((Iterable) root);
                else if (root instanceof Iterator)
                    pipeline.setStarts((Iterator) root);
                else
                    pipeline.setStarts(new SingleIterator(root));

                return new Atom<Iterable>(new PathSequence(pipeline));
            } else {
                throw new RuntimeException(this.createUnsupportedArgumentMessage());
            }
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}