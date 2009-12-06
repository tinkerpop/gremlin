package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class PrintFunction implements Function {

    public static final String FUNCTION_NAME = "print";

    public Boolean invoke(ExpressionContext context, Object[] parameters) {

        if (null == parameters) {
            System.out.println(context.getContextNodePointer().getValue());
            return Boolean.TRUE;
        } else {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            for (Object o : objects) {
                System.out.println(o);
            }
            return Boolean.TRUE;
        }
    }
}
