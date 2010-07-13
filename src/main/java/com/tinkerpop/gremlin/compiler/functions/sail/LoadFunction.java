package com.tinkerpop.gremlin.compiler.functions.sail;

import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.functions.FunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.io.FileInputStream;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LoadFunction extends AbstractFunction<Boolean> {

    private final String FUNCTION_NAME = "load";
    private final String EMPTY_STRING = "";

    public Atom<Boolean> compute(final List<Operation> parameters) throws RuntimeException {

        final int size = parameters.size();
        final SailGraph graph = (SailGraph) FunctionHelper.getGraph(parameters, 0);

        final String file;
        final String format;
        final String baseGraph;

        if (size == 2) {
            file = (String) parameters.get(0).compute().getValue();
            format = (String) parameters.get(1).compute().getValue();
            baseGraph = null;
        } else if (size == 3 && parameters.get(0).compute().getValue() instanceof SailGraph) {
            file = (String) parameters.get(1).compute().getValue();
            format = (String) parameters.get(2).compute().getValue();
            baseGraph = null;
        } else if (size == 3) {
            file = (String) parameters.get(0).compute().getValue();
            format = (String) parameters.get(1).compute().getValue();
            baseGraph = (String) parameters.get(2).compute().getValue();
        } else if (size == 4) {
            file = (String) parameters.get(1).compute().getValue();
            format = (String) parameters.get(2).compute().getValue();
            baseGraph = (String) parameters.get(3).compute().getValue();
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
        try {
            graph.loadRDF(new FileInputStream(file), EMPTY_STRING, format, baseGraph);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return new Atom<Boolean>(true);
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }


}
