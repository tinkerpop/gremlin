package com.tinkerpop.gremlin.lang;

import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Tokens {

    public static final String ASSIGNMENT = ":=";
    public static final String FOREACH = "foreach";
    public static final String IN = "in";
    public static final String WHILE = "while";
    public static final String REPEAT = "repeat";
    public static final String IF = "if";
    public static final String ELSE = "else";
    public static final String END = "end";
    public static final String COMMENT = "#";

    public static final String DOLLAR_SIGN = "$";
    public static final String EMPTY_STRING = "";
    public static final String AT_VARIABLE = "$_";
    public static final String LAST_VARIABLE = "$_last";

    protected static final String NEWLINE = "\n";
    protected static final String WHITESPACE_REGEX = "[' '\t]+";
    protected static final String ZEROPLUS_WHITESPACE_REGEX = "[' '\t]*";
    protected static final String VARIABLE_REGEX = "[$][a-zA-Z'_'][a-zA-Z'_'0-9'.']*";
    protected static final String NONWHITESPACE_REGEX = "[^' '\t]";

    protected static final String SINGLESPACE = " ";
    protected static final String FORWARD_SLASH = "/";

    public static final String OUT_EDGES = "outEdges";
    public static final String IN_EDGES = "inEdges";
    public static final String BOTH_EDGES = "bothEdges";

    public static final String OUT_VERTEX = "outVertex";
    public static final String IN_VERTEX = "inVertex";
    public static final String LABEL = "label";


}
