package com.tinkerpop.gremlin;

import com.tinkerpop.blueprints.Compare;
import com.tinkerpop.blueprints.CompareRelation;
import com.tinkerpop.blueprints.Contains;
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
        incr,
        /**
         * In collection
         */
        in,
        /**
         * Not in collection
         */
        notin;

        public T opposite() {
            if (this.equals(eq))
                return neq;
            else if (this.equals(neq))
                return eq;
            else if (this.equals(gt))
                return lte;
            else if (this.equals(gte))
                return lt;
            else if (this.equals(lt))
                return gte;
            else if (this.equals(lte))
                return gt;
            else if (this.equals(decr))
                return incr;
            else if (this.equals(incr))
                return decr;
            else if (this.equals(in))
                return notin;
            else if (this.equals(notin))
                return in;
            else throw new IllegalArgumentException("The provided token has no opposite: " + this);
        }
    }

    public static TransformPipe.Order mapOrder(final T t) {
        if (t.equals(T.decr))
            return TransformPipe.Order.DECR;
        else if (t.equals(T.incr))
            return TransformPipe.Order.INCR;
        else
            throw new IllegalArgumentException(t.toString() + " is an unknown order type");
    }

    public static CompareRelation mapCompareRelation(final T t) {
        if (t.equals(T.eq))
            return Compare.EQUAL;
        else if (t.equals(T.neq))
            return Compare.NOT_EQUAL;
        else if (t.equals(T.lt))
            return Compare.LESS_THAN;
        else if (t.equals(T.lte))
            return Compare.LESS_THAN_EQUAL;
        else if (t.equals(T.gt))
            return Compare.GREATER_THAN;
        else if (t.equals(T.gte))
            return Compare.GREATER_THAN_EQUAL;
        else if (t.equals(T.in))
            return Contains.IN;
        else if(t.equals(T.notin))
            return Contains.NOT_IN;
        else
        throw new IllegalArgumentException(t.toString() + " is an unknown filter type");
    }

}
