package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.parser.GraphMLReader;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.functions.GraphFunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;

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


    public Atom<Boolean> compute(final List<Operation> parameters) throws RuntimeException {
        if (parameters.size() == 0 || parameters.size() > 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        Graph graph = GraphFunctionHelper.getGraph(parameters, 0);
        String filename = null;

        if (parameters.size() == 2) {
            filename = (String) parameters.get(1).compute().getValue();
        } else {
            filename = (String) parameters.get(0).compute().getValue();
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
            throw new RuntimeException(e.getMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }


}
