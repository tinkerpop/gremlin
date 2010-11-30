package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.*;
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

        final IndexableGraph graph;
        List<Object> objects = FunctionHelper.generateObjects(arguments);
        if (size > 0 && objects.get(0) instanceof Graph)
            graph = (IndexableGraph) objects.get(0);
        else
            graph = (IndexableGraph) FunctionHelper.getGlobalGraph(context);


        String indexName;
        String indexClassName;
        String indexTypeName;
        if (size == 3) {
            indexName = (String) objects.get(0);
            indexClassName = (String) objects.get(1);
            indexTypeName = (String) objects.get(2);
        } else {
            indexName = (String) objects.get(1);
            indexClassName = (String) objects.get(2);
            indexTypeName = (String) objects.get(3);
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