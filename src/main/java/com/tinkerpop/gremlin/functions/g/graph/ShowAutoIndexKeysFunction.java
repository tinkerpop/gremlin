package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.AutomaticIndex;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Index;
import com.tinkerpop.blueprints.pgm.IndexableGraph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;

import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ShowAutoIndexKeysFunction extends AbstractFunction<Set> {

    private static final String FUNCTION_NAME = "show-aidx-keys";

    public Atom<Set> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        final int size = arguments.size();
        if (size != 1 && size != 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final IndexableGraph graph;
        List<Object> objects = FunctionHelper.generateObjects(arguments);
        if (size > 0 && objects.get(0) instanceof Graph)
            graph = (IndexableGraph) objects.get(0);
        else
            graph = (IndexableGraph) FunctionHelper.getGlobalGraph(context);

        String indexName;
        if (size == 1) {
            indexName = (String) objects.get(0);
        } else {
            indexName = (String) objects.get(1);
        }

        AutomaticIndex autoIndex = null;
        for (Index index : graph.getIndices()) {
            if (index.getIndexName().equals(indexName) && index instanceof AutomaticIndex)
                autoIndex = (AutomaticIndex) index;
        }
        if (null == autoIndex)
            throw new RuntimeException("No automatic index named " + indexName + " found");

        return new Atom<Set>(autoIndex.getAutoIndexKeys());
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}