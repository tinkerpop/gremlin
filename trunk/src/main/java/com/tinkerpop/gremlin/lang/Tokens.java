package com.tinkerpop.gremlin.lang;

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

    public static final String NEWLINE = "\n";
    public static final String WHITESPACE_REGEX = "[' '\t]+";
    public static final String ZEROPLUS_WHITESPACE_REGEX = "[' '\t]*";
    public static final String VARIABLE_REGEX = "[$][a-zA-Z'_'][a-zA-Z'_'0-9'.']*";
    public static final String NONWHITESPACE_REGEX = "[^' '\t]";
    public static final String VARIABLE_PATH_REGEX = VARIABLE_REGEX + NONWHITESPACE_REGEX + "+";

    public static final String SINGLESPACE = " ";
    public static final String FORWARD_SLASH = "/";

    public static final String OUT_EDGES = "outEdges";
    public static final String IN_EDGES = "inEdges";
    public static final String BOTH_EDGES = "bothEdges";

    public static final String OUT_VERTEX = "outVertex";
    public static final String IN_VERTEX = "inVertex";
    public static final String LABEL = "label";

    public static final String ID = "id";


}
