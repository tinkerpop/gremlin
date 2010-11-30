package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
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


        final IndexableGraph graph;
        List<Object> objects = FunctionHelper.generateObjects(arguments);
        if (objects.get(0) instanceof Graph)
            graph = (IndexableGraph) objects.get(0);
        else
            graph = (IndexableGraph) FunctionHelper.getGlobalGraph(context);

        final String indexName;
        final String key;
        final Object value;

        if (size == 2) {
            indexName = Index.EDGES;
            key = (String) objects.get(0);
            value = objects.get(1);
        } else if (size == 3) {
            if (objects.get(0) instanceof Graph) {
                indexName = Index.EDGES;
                key = (String) objects.get(1);
                value = objects.get(2);
            } else {
                indexName = (String) objects.get(0);
                key = (String) objects.get(1);
                value = objects.get(2);
            }
        } else {
            indexName = (String) objects.get(1);
            key = (String) objects.get(2);
            value = objects.get(3);
        }

        return new Atom<Iterable<Edge>>(graph.getIndex(indexName, Edge.class).get(key, value));
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }

}