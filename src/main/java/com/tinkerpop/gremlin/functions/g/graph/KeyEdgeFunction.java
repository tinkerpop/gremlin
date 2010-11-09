package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Index;
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
public class KeyEdgeFunction extends AbstractFunction<Iterable<Edge>> {

    private static final String FUNCTION_NAME = "key-e";

    public Atom<Iterable<Edge>> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        final int size = arguments.size();
        if (size != 2 && size != 3 && size != 4)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final IndexableGraph graph = (IndexableGraph) FunctionHelper.getGraph(arguments, 0, context);
        final String indexName;
        final String key;
        final Object value;

        if (size == 2) {
            indexName = Index.EDGES;
            key = (String) arguments.get(0).compute().getValue();
            value = arguments.get(1).compute().getValue();
        } else if (size == 3) {
            Object temp = arguments.get(0).compute().getValue();
            if (temp instanceof IndexableGraph) {
                indexName = Index.EDGES;
                key = (String) arguments.get(1).compute().getValue();
                value = arguments.get(2).compute().getValue();
            } else {
                indexName = (String) arguments.get(0).compute().getValue();
                key = (String) arguments.get(1).compute().getValue();
                value = arguments.get(2).compute().getValue();
            }
        } else {
            indexName = (String) arguments.get(1).compute().getValue();
            key = (String) arguments.get(2).compute().getValue();
            value = arguments.get(3).compute().getValue();
        }

        return new Atom<Iterable<Edge>>(graph.getIndex(indexName, Edge.class).get(key, value));
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }

}