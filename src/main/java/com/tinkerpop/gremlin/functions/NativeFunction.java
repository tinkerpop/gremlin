package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.context.VariableLibrary;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.DynamicEntity;
import com.tinkerpop.gremlin.compiler.util.CodeBlock;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class NativeFunction implements Function<Object> {

    private String FUNCTION_NAME;

    private final List<String> arguments;
    private final CodeBlock body;

    public NativeFunction(final String functionName, final List<String> arguments, final CodeBlock body) {
        this.FUNCTION_NAME = functionName;
        this.arguments = arguments;
        this.body = body;
    }

    public Atom compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (this.arguments.size() != arguments.size())
            throw new RuntimeException("Wrong number of arguments (" + arguments.size() + " of " + this.arguments.size() + ")");

        // cloning variable library
        // all changes in variables will stay inside function + full access to current state of global variables
        VariableLibrary varLib = context.getVariableLibrary().cloneLibrary();

        // mapping arguments
        for (int i = 0; i < this.arguments.size(); i++) {
            final Atom computedParam = arguments.get(i).compute();
            final Atom argumentValue = (computedParam instanceof DynamicEntity) ? new Atom<Object>(computedParam.getValue()) : computedParam;
            context.getVariableLibrary().putAtom(this.arguments.get(i), argumentValue);
        }
        
        // getting evaluation result
        final Object result = this.body.invoke().getValue();

        // setting variable library back to original
        context.setVariableLibrary(varLib);

        return new Atom<Object>(result);
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }

}
