package com.tinkerpop.gremlin.functions.g.util;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.GPath;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.pipes.PathSequence;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.Pipeline;

import java.util.Arrays;
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
                    return new Atom<Iterable>(new PathMaker((Iterable) root, pipeline));
                else
                    return new Atom<Iterable>(new PathMaker(Arrays.asList(root), pipeline));

            } else {
                throw new RuntimeException(this.createUnsupportedArgumentMessage());
            }
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }

    public class PathMaker implements Iterable<List> {

        private Iterable root;
        private Pipe pipe;

        public PathMaker(Iterable root, Pipe pipe) {
            this.root = root;
            this.pipe = pipe;
        }

        public Iterator<List> iterator() {
            pipe.setStarts(this.root);
            return new PathSequence(this.pipe);
        }
    }
}