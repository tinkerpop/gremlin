package com.tinkerpop.gremlin.compiler.context;

import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.functions.Functions;
import com.tinkerpop.gremlin.compiler.functions.NativeFunctions;
import com.tinkerpop.gremlin.compiler.util.StringHelper;

import java.util.HashMap;
import java.util.ServiceLoader;

/**
 * @author Pavel A. Yaskevich
 */
public class FunctionLibrary extends HashMap<String, Functions> {

    public FunctionLibrary() {
        final ServiceLoader<Functions> functionsService = ServiceLoader.load(Functions.class);

        for (final Functions functions : functionsService) {
            this.registerFunctions(functions);
        }
    }

    public void loadFunctions(final String functionsClassName) throws RuntimeException {
        try {
            Class functionsClass = Class.forName(StringHelper.clearQuotes(functionsClassName));
            Functions functions = (Functions) functionsClass.getConstructor().newInstance();
            this.registerFunctions(functions);
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException("Unable to load " + functionsClassName);
        }
    }

    public void registerFunctions(final Functions functions) {
        super.put(functions.getNamespace(), functions);
    }

    public void registerFunction(final String namespace, final Function function) {
        Functions functions = super.get(namespace);

        if (functions == null) {
            functions = new NativeFunctions(namespace);
            functions.addFunction(function);
        } else {
            functions.addFunction(function);
        }

        super.put(namespace, functions);
    }

    public Function getFunction(final String namespace, final String functionName) throws RuntimeException {
        final Functions functions = super.get(namespace);

        if (functions == null) {
            throw new RuntimeException("No such namespace: " + namespace);
        } else {
            Function function = functions.getFunction(functionName);
            if (null != function)
                return function;
        }

        throw new RuntimeException("Unregistered function: " + namespace + ":" + functionName);
    }

}
