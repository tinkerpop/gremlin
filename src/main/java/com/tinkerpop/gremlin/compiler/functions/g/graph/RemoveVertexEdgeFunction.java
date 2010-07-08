package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.functions.FunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RemoveVertexEdgeFunction extends AbstractFunction<Boolean> {

    private final static String FUNCTION_NAME = "remove-ve";

    public Atom<Boolean> compute(final List<Operation> parameters) throws RuntimeException {
        final int size = parameters.size();
        if (size == 0 || size > 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final Graph graph = FunctionHelper.getGraph(parameters, 0);
        final Element element;

        if (size == 1)
            element = (Element) parameters.get(0).compute().getValue();
        else
            element = (Element) parameters.get(1).compute().getValue();

        if (element instanceof Vertex) {
            graph.removeVertex((Vertex) element);
        } else if (element instanceof Edge) {
            graph.removeEdge((Edge) element);
        }

        return new Atom<Boolean>(true);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}