package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Index;
import com.tinkerpop.blueprints.pgm.IndexableGraph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.Tokens;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddIndexFunction extends AbstractFunction<Object> {

    private static final String FUNCTION_NAME = "add-idx";

    public Atom<Object> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        final int size = arguments.size();
        if (size != 3 && size != 4)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final IndexableGraph graph = FunctionHelper.getIndexableGraph(arguments, 0, context);
        String indexName;
        String indexClassName;
        String indexTypeName;
        if (size == 3) {
            indexName = (String) arguments.get(0).compute().getValue();
            indexClassName = (String) arguments.get(1).compute().getValue();
            indexTypeName = (String) arguments.get(2).compute().getValue();
        } else {
            indexName = (String) arguments.get(1).compute().getValue();
            indexClassName = (String) arguments.get(2).compute().getValue();
            indexTypeName = (String) arguments.get(3).compute().getValue();
        }

        Class indexClass;
        if (indexClassName.equals(Tokens.VERTEX))
            indexClass = Vertex.class;
        else if (indexClassName.equals(Tokens.EDGE))
            indexClass = Edge.class;
        else
            throw new RuntimeException("Index class must be either vertex or edge, not " + indexClassName);

        Index.Type indexType;
        if (indexTypeName.equals(Tokens.AUTO)) {
            indexType = Index.Type.AUTOMATIC;
        } else if (indexTypeName.equals(Tokens.MANUAL)) {
            indexType = Index.Type.MANUAL;
        } else {
            throw new RuntimeException("Index type must be either auto or manual, not " + indexTypeName);
        }

        graph.createIndex(indexName, indexClass, indexType);
        return new Atom<Object>(null);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}