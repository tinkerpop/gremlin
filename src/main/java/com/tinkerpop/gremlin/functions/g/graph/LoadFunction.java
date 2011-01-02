package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.util.graphml.GraphMLReader;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class LoadFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "load";


    public Atom<Boolean> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        final int size = arguments.size();
        if (size == 0 || size > 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final Graph graph;
        List<Object> objects = FunctionHelper.generateObjects(arguments);
        if (size > 0 && objects.get(0) instanceof Graph)
            graph = (Graph) objects.get(0);
        else
            graph = FunctionHelper.getGlobalGraph(context);
        final String uri;

        if (size == 2) {
            uri = (String) objects.get(1);
        } else {
            uri = (String) objects.get(0);
        }

        try {
            InputStream stream;
            try {
                stream = new URL(uri).openStream();
            } catch (MalformedURLException urlEx) {
                stream = new FileInputStream(uri);
            }

            GraphMLReader.inputGraph(graph, stream);
            return new Atom<Boolean>(true);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }


}
