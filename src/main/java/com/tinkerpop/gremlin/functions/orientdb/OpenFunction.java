package com.tinkerpop.gremlin.functions.orientdb;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.orientdb.OrientGraph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.io.File;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OpenFunction extends AbstractFunction<Graph> {

    private final String FUNCTION_NAME = "open";
    private static final String ADMIN = "admin";

    public Atom<Graph> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        if (arguments.size() == 1) {
            String url = (String) arguments.get(0).compute().getValue();
            final File directory = new File(url);
            if (!directory.exists())
                directory.mkdirs();

            OrientGraph graph = new OrientGraph("local:" + url);
            if (graph.exists()) {
                graph.open(ADMIN, ADMIN);
            } else
                graph.create();
            return new Atom<Graph>(graph);
        } else {
            throw new RuntimeException(createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }
}