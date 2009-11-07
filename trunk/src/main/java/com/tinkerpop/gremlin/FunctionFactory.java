package com.tinkerpop.gremlin;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class FunctionFactory {

    public static Function composeFunction(final String name, final Function... functions) {
        return new Function() {
            public Object evaluate(final Object input) {
                Object temp = input;
                for(Function f : functions) {
                    temp = f.evaluate(temp);
                }
                return temp;
            }

            public String getName() {
                return name;
            }
        };
    }
}
