package com.tinkerpop.gremlin;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinTokens {

    public static final String VERSION = "1.0-SNAPSHOT";
    public static final String LABEL = "label";
    public static final String ID = "id";

    public enum T {
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
    public static final String ANDFILTER = "andFilter";
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
    public static final String GROUPOBJECT = "groupObject";
    public static final String IFELSE = "ifelse";
    public static final String LOOP = "loop";
    public static final String ORFILTER = "orFilter";
    public static final String PATHS = "paths";
    public static final String PROPFILTER = "propFilter";
    public static final String RETAIN = "retain";
    public static final String SCATTER = "scatter";
    public static final String STEP = "step";
    public static final String UNIQUEOBJECT = "uniqueObject";
    public static final String UNIQUEPATH = "uniquePath";


}
