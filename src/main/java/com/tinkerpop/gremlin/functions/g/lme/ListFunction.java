package com.tinkerpop.gremlin.functions.g.lme;

import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import org.apache.commons.jxpath.ExpressionContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ListFunction implements Function {

    public static final String FUNCTION_NAME = "list";

    public List invoke(final ExpressionContext context, final Object[] parameters) {
        // TODO: handle null() like an object or just exclude it?
        Object[] objects = FunctionHelper.nodeSetConversion(parameters);

        if (null != objects) {
            List list = new ArrayList();
            for (Object object : objects) {
                if (object instanceof Collection)
                    list.addAll((Collection) object);
                else {
                    list.add(object);
                }

            }
            return list;
        } else {
            return new ArrayList();
        }
    }

    public String getName() {
        return FUNCTION_NAME;
    }
}