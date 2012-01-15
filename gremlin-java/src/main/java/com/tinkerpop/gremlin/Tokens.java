package com.tinkerpop.gremlin;

import com.tinkerpop.pipes.filter.FilterPipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Tokens {

    public static final String VERSION = "1.5-SNAPSHOT";
    public static final String LABEL = "label";
    public static final String ID = "id";

    public static enum T {
        eq, neq, lt, lte, gt, gte, v, e
    }

    public static final String OUT = "out";
    public static final String OUTV = "outV";
    public static final String IN = "in";
    public static final String INV = "inV";
    public static final String BOTH = "both";
    public static final String BOTHV = "bothV";
    public static final String OUTE = "outE";
    public static final String INE = "inE";
    public static final String BOTHE = "bothE";
    public static final String V = "V";
    public static final String E = "E";


    public static final String _ = "_";
    public static final String AGGREGATE = "aggregate";
    public static final String AND = "and";
    public static final String AS = "as";
    public static final String BACK = "back";
    public static final String CAP = "cap";
    public static final String COPYSPLIT = "copySplit";
    public static final String EXCEPT = "except";
    public static final String EXHAUSTMERGE = "exhaustMerge";
    public static final String FAIRMERGE = "fairMerge";
    public static final String SIDEEFFECT = "sideEffect";
    public static final String TRANSFORM = "transform";
    public static final String FILTER = "filter";
    public static final String GATHER = "gather";
    public static final String GROUPCOUNT = "groupCount";
    public static final String IFTHENELSE = "ifThenElse";
    public static final String INDEX = "index";
    public static final String LOOP = "loop";
    public static final String MAP = "map";
    public static final String MEMOIZE = "memoize";
    public static final String OBJECTFILTER = "objectFilter";
    public static final String OPTIONAL = "optional";
    public static final String OR = "or";
    public static final String PATHS = "paths";
    public static final String PATH = "path";
    public static final String PROPERTYFILTER = "propertyFilter";
    public static final String RANDOM = "random";
    public static final String RETAIN = "retain";
    public static final String SCATTER = "scatter";
    public static final String SELECT = "select";
    public static final String STEP = "step";
    public static final String STORE = "store";
    public static final String TABLE = "table";
    public static final String DEDUP = "dedup";
    public static final String SIMPLEPATH = "simplePath";

    public static FilterPipe.Filter mapFilter(final Tokens.T t) {
        if (t == T.eq) {
            return FilterPipe.Filter.EQUAL;
        } else if (t == T.neq) {
            return FilterPipe.Filter.NOT_EQUAL;
        } else if (t == T.lt) {
            return FilterPipe.Filter.LESS_THAN;
        } else if (t == T.lte) {
            return FilterPipe.Filter.LESS_THAN_EQUAL;
        } else if (t == T.gt) {
            return FilterPipe.Filter.GREATER_THAN;
        } else if (t == T.gte) {
            return FilterPipe.Filter.GREATER_THAN_EQUAL;
        } else {
            throw new IllegalArgumentException(t.toString() + " is an unknown filter type");
        }
    }


}
