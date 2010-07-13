package com.tinkerpop.gremlin.compiler.functions;

import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class AbstractFunction<T> implements Function<T> {

    protected static List<Object> generateObjects(List<Operation> operations) {
        final List<Object> list = new ArrayList<Object>();
        for (Operation operation : operations) {
            list.add(operation.compute().getValue());
        }
        return list;
    }

    protected static void fillCollection(Collection collection, Iterator itty) {
        while (itty.hasNext()) {
            collection.add(itty.next());
        }
    }

    protected String createUnsupportedArgumentMessage() {
        return "Unsupported arguments for " + this.getFunctionName() + " function";
    }

}
