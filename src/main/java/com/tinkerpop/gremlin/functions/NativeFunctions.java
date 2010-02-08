package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.statements.EvaluationException;

/**
 * @author Pavel A. Yaskevich
 */
public class NativeFunctions extends FunctionLibrary {

    public NativeFunctions(NativeFunction function) {
        super.addFunction(function.getNamespace(), function);
    }

    public void addFunctions(Functions functions) {
        throw new EvaluationException("Use constructor to add new native functions");
    }

}
 