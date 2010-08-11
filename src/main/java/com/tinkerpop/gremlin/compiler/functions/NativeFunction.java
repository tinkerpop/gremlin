package com.tinkerpop.gremlin.compiler.functions;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.context.VariableLibrary;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.DynamicEntity;

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

    public Atom<Object> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (this.arguments.size() != arguments.size())
            throw new RuntimeException("Wrong number of arguments (" + arguments.size() + " of " + this.arguments.size() + ")");

        // cloning variable library
        // all changes in variables will stay inside function + full access to current state of global variables
        VariableLibrary varLib = context.getVariableLibrary().cloneLibrary();

        // mapping arguments
        for (int i = 0; i < this.arguments.size(); i++) {
            final Atom computedParam = arguments.get(i).compute();
            final Atom argumentValue = (computedParam instanceof DynamicEntity) ? new Atom<Object>(computedParam.getValue()) : computedParam;
            context.getVariableLibrary().declare(this.arguments.get(i), argumentValue);
        }

        long operationCount = 0;
        Atom<Object> result = null;

        for (Operation operation : this.body) {
            final Atom atom = operation.compute();

            if (atom instanceof DynamicEntity)
                atom.getValue();

            // setting 'result' only if this is the last statement of the function body
            if (operationCount == this.body.size() - 1) {
                if(atom instanceof DynamicEntity || atom.isIterable()) {
                    result = new Atom<Object>(atom.getValue());
                } else {
                    result = atom;
                }
            }

            operationCount++;
        }

        // setting variable library back to original
        context.setVariableLibrary(varLib);

        return result;
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }

}
