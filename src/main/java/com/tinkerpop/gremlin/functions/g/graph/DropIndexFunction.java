package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.IndexableGraph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DropIndexFunction extends AbstractFunction<Object> {

    private static final String FUNCTION_NAME = "drop-idx";

    public Atom<Object> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        final int size = arguments.size();
        if (size != 1 && size != 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final IndexableGraph graph = FunctionHelper.getIndexableGraph(arguments, 0, context);
        String indexName;
        if (size == 1) {
            indexName = (String) arguments.get(0).compute().getValue();
        } else {
            indexName = (String) arguments.get(1).compute().getValue();
        }

        graph.dropIndex(indexName);
        return new Atom<Object>(null);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}