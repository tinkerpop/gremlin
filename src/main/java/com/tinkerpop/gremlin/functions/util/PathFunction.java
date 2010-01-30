package com.tinkerpop.gremlin.functions.util;

import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PathFunction implements Function {

    public static final String FUNCTION_NAME = "p";

    public Boolean invoke(final ExpressionContext context, final Object[] parameters) {
        return Boolean.TRUE;
    }
}
