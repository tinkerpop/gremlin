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

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddAutoIndexKeyFunction extends AbstractFunction<Object> {

    private static final String FUNCTION_NAME = "add-aidx-key";

    public Atom<Object> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        final int size = arguments.size();
        if (size != 2 && size != 3)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final IndexableGraph graph;
        List<Object> objects = FunctionHelper.generateObjects(arguments);
        if (size > 0 && objects.get(0) instanceof Graph)
            graph = (IndexableGraph) objects.get(0);
        else
            graph = (IndexableGraph) FunctionHelper.getGlobalGraph(context);


        String indexName;
        String indexKey;
        if (size == 2) {
            indexName = (String) objects.get(0);
            indexKey = (String) objects.get(1);
        } else {
            indexName = (String) objects.get(1);
            indexKey = (String) objects.get(2);
        }

        AutomaticIndex autoIndex = null;
        for (Index index : graph.getIndices()) {
            if (index.getIndexName().equals(indexName) && index instanceof AutomaticIndex)
                autoIndex = (AutomaticIndex) index;
        }
        if (null == autoIndex)
            throw new RuntimeException("No automatic index named " + indexName + " found");

        autoIndex.addAutoIndexKey(indexKey);
        return new Atom<Object>(null);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}