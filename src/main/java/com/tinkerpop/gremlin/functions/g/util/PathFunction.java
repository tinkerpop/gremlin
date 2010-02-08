package com.tinkerpop.gremlin.functions.g.util;

import org.apache.commons.jxpath.ExpressionContext;
import com.tinkerpop.gremlin.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PathFunction implements Function {

    public static final String FUNCTION_NAME = "p";

    public Boolean invoke(final ExpressionContext context, final Object[] parameters) {
        return Boolean.TRUE;
    }

        public String getName() {
        return FUNCTION_NAME;
    }
}
