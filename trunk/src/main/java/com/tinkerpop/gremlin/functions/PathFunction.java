package com.tinkerpop.gremlin.functions;

import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class PathFunction implements Function {

    public static final String FUNCTION_NAME = "p";

    public Boolean invoke(ExpressionContext context, Object[] parameters) {
        return Boolean.TRUE;
    }


}
