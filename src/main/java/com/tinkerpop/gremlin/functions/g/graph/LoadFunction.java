package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.parser.GraphMLReader;
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

        final Graph graph = FunctionHelper.getGraph(arguments, 0, context);
        final String filename;

        if (size == 2) {
            filename = (String) arguments.get(1).compute().getValue();
        } else {
            filename = (String) arguments.get(0).compute().getValue();
        }

        try {
            InputStream stream;
            try {
                stream = new URL(filename).openStream();
            } catch (MalformedURLException urlEx) {
                stream = new FileInputStream(filename);
            }

            GraphMLReader.inputGraph(graph, stream);
            return new Atom<Boolean>(true);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }


}
