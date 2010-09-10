package com.tinkerpop.gremlin.functions.sail;

import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;

import java.io.FileInputStream;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LoadFunction extends AbstractFunction<Boolean> {

    private final String FUNCTION_NAME = "load";
    private final String EMPTY_STRING = "";

    public Atom<Boolean> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        final int size = arguments.size();
        final SailGraph graph = (SailGraph) FunctionHelper.getGraph(arguments, 0, context);

        final String file;
        final String format;
        final String baseGraph;

        if (size == 2) {
            file = (String) arguments.get(0).compute().getValue();
            format = (String) arguments.get(1).compute().getValue();
            baseGraph = null;
        } else if (size == 3 && arguments.get(0).compute().getValue() instanceof SailGraph) {
            file = (String) arguments.get(1).compute().getValue();
            format = (String) arguments.get(2).compute().getValue();
            baseGraph = null;
        } else if (size == 3) {
            file = (String) arguments.get(0).compute().getValue();
            format = (String) arguments.get(1).compute().getValue();
            baseGraph = (String) arguments.get(2).compute().getValue();
        } else if (size == 4) {
            file = (String) arguments.get(1).compute().getValue();
            format = (String) arguments.get(2).compute().getValue();
            baseGraph = (String) arguments.get(3).compute().getValue();
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
