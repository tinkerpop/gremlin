package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.AutomaticIndex;
import com.tinkerpop.blueprints.pgm.Index;
import com.tinkerpop.blueprints.pgm.IndexableGraph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.Tokens;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ShowIndicesFunction extends AbstractFunction<List<List<String>>> {

    private static final String FUNCTION_NAME = "show-idx";

    public Atom<List<List<String>>> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        final int size = arguments.size();
        if (size > 1)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final IndexableGraph graph = FunctionHelper.getIndexableGraph(arguments, 0, context);
        final List<List<String>> indices = new ArrayList<List<String>>();
        for (final Index index : graph.getIndices()) {
            String indexClass;
            String indexType;
            if (index instanceof AutomaticIndex)
                indexType = Tokens.AUTO;
            else
                indexType = Tokens.MANUAL;
            if (Vertex.class.isAssignableFrom(index.getIndexClass()))
                indexClass = Tokens.VERTEX;
            else
                indexClass = Tokens.EDGE;


            indices.add(Arrays.asList(index.getIndexName(), indexClass, indexType));
        }
        return new Atom<List<List<String>>>(indices);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}