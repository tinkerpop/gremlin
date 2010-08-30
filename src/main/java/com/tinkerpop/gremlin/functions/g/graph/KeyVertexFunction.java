package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class KeyVertexFunction extends AbstractFunction<Iterable<Element>> {

    private static final String FUNCTION_NAME = "key-v";

    public Atom<Iterable<Element>> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        final int size = arguments.size();
        if (size != 2 && size != 3)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final Graph graph = FunctionHelper.getGraph(arguments, 0, context);
        final String key;
        final Object value;

        if (size == 3) {
            key = (String) arguments.get(1).compute().getValue();
            value = arguments.get(2).compute().getValue();
        } else {
            key = (String) arguments.get(0).compute().getValue();
            value = arguments.get(1).compute().getValue();
        }

        return new Atom<Iterable<Element>>(graph.getIndex().get(key, value));
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }

}