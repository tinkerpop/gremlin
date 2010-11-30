package com.tinkerpop.gremlin.compiler.util;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Tokens {

    public static final String VERSION = "0.6-SNAPSHOT";

    public static final String ROOT_VARIABLE = "$_";
    public static final String GRAPH_VARIABLE = "$_g";
    public static final String LAST_VARIABLE = "$_last";

    public static final String _ID = "_id";

    public static final String RESULT_PROMPT = "==>";

    public static final String IDENTITY = ".";
    public static final String OUT_E = "outE";
    public static final String IN_E = "inE";
    public static final String BOTH_E = "bothE";
    public static final String OUT_V = "outV";
    public static final String IN_V = "inV";
    public static final String BOTH_V = "bothV";
    public static final String V = "V";
    public static final String E = "E";
    public static final String LABEL = "label";
    public static final String ID = "id";
    public static final String GATHER = "gather";
    public static final String SCATTER = "scatter";

    public static final String IN_BLOCK = "in-block?";
    public static final String AUTO = "auto";
    public static final String MANUAL = "manual";
    public static final String VERTEX = "vertex";
    public static final String EDGE = "edge";

    public static final String NULL = "null";
}
