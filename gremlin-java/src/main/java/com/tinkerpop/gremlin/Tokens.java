package com.tinkerpop.gremlin;

import com.tinkerpop.blueprints.Query;
import com.tinkerpop.pipes.transform.TransformPipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Tokens {

    public static final String VERSION = "2.4.0-SNAPSHOT";
    public static final String LABEL = "label";
    public static final String ID = "id";

    public static enum T {
        /**
         * Greater than
         */
        gt,
        /**
         * Less than
         */
        lt,
        /**
         * Equal to
         */
        eq,
        /**
         * Greater than or equal to
         */
        gte,
        /**
         * Less than or equal to
         */
        lte,
        /**
         * Not equal to
         */
        neq,
        /**
         * Decrement
         */
        decr,
        /**
         * Increment
         */
        incr
    }

    public static TransformPipe.Order mapOrder(final T t) {
        if (t.equals(T.decr))
            return TransformPipe.Order.DECR;
        else if (t.equals(T.incr))
            return TransformPipe.Order.INCR;
        else
            throw new IllegalArgumentException(t.toString() + " is an unknown order type");
    }


    public static Query.Compare mapCompare(final T t) {
        if (t.equals(T.eq))
            return Query.Compare.EQUAL;
        else if (t.equals(T.neq))
            return Query.Compare.NOT_EQUAL;
        else if (t.equals(T.lt))
            return Query.Compare.LESS_THAN;
        else if (t.equals(T.lte))
            return Query.Compare.LESS_THAN_EQUAL;
        else if (t.equals(T.gt))
            return Query.Compare.GREATER_THAN;
        else if (t.equals(T.gte))
            return Query.Compare.GREATER_THAN_EQUAL;
        else
            throw new IllegalArgumentException(t.toString() + " is an unknown filter type");
    }

}
