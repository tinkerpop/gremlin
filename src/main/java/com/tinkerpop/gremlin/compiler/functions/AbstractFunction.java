package com.tinkerpop.gremlin.compiler.functions;

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

    protected String createUnsupportedArgumentMessage() {
        return "Unsupported arguments for " + this.getFunctionName() + " function";
    }

}
