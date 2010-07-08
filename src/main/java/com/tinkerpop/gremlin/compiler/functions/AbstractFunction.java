package com.tinkerpop.gremlin.compiler.functions;

import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class AbstractFunction<T> implements Function<T> {

    protected static boolean assertTypes(final Object[] objects, final Class[] types) {
        for (int i = 0; i < objects.length; i++) {
            if (!types[i].isInstance(objects[i]))
                return false;
        }
        return true;
    }

    protected static List<Object> generateObjects(List<Operation> operations) {
        final List<Object> list = new ArrayList<Object>();
        for (Operation operation : operations) {
            list.add(operation.compute().getValue());
        }
        return list;
    }

    protected String createUnsupportedArgumentMessage() {
        return "Unsupported arguments for " + this.getFunctionName() + " function";
    }

}
