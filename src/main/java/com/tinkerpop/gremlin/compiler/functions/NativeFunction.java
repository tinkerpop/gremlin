package com.tinkerpop.gremlin.compiler.functions;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.lib.VariableLibrary;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.operations.util.DeclareVariable;
import com.tinkerpop.gremlin.compiler.types.DynamicEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class NativeFunction implements Function<Object> {

    private String FUNCTION_NAME;

    private List<String> arguments;
    private List<Operation> body;

    public NativeFunction(final String functionName, final List<String> arguments, final List<Operation> body) {
        this.FUNCTION_NAME = functionName;
        this.arguments = arguments;
        this.body = body;
    }

    public Atom<Object> compute(final List<Operation> parameters) throws RuntimeException {
        if (this.arguments.size() != parameters.size())
            throw new RuntimeException("Wrong number of arguments (" + parameters.size() + " of " + this.arguments.size() + ")");

        // cloning variable library
        // all changes in variables will stay inside function + full access to current state of global variables
        VariableLibrary varLib = GremlinEvaluator.getVariableLibrary().cloneLibrary();

        // mapping arguments to parameters
        for (int i = 0; i < this.arguments.size(); i++) {
            Atom computedParam = parameters.get(i).compute();

            if (computedParam instanceof DynamicEntity) {
                DeclareVariable.decalareWithInit(this.arguments.get(i), new Atom<Object>(computedParam.getValue())); 
            } else {
                DeclareVariable.decalareWithInit(this.arguments.get(i), computedParam);
            }
        }

        long operationCount = 0;
        Atom<Object> result = null;

        for (Operation operation : this.body) {
            final Atom atom = operation.compute();

            // setting 'result' only if this is the last statement of the function body
            if (operationCount == this.body.size() - 1) {
                if (atom instanceof DynamicEntity) {
                    result = new Atom<Object>(atom.getValue());
                } else if(atom.isIterable()) {
                    List<Object> results = new ArrayList<Object>();

                    for(Object o : (Iterable) atom.getValue()) {
                        results.add(o);
                    }

                    result = new Atom<Object>(results);
                } else {
                    result = atom;
                }
            }

            operationCount++;
        }

        // setting variable library back to original
        GremlinEvaluator.setVariableLibrary(varLib);

        return result;
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }

}
