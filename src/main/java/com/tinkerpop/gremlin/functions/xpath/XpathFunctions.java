package com.tinkerpop.gremlin.functions.xpath;

import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.FunctionLibrary;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Functions;
import org.apache.commons.jxpath.JXPathContext;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class XPathFunctions extends FunctionLibrary {

    public static final String NAMESPACE_PREFIX = "";

    private static final String LAST = "last";
    private static final String POSITION = "position";
    private static final String COUNT = "count";
    //
    private static final String STRING = "string";
    private static final String CONCAT = "concat";
    private static final String STARTS_WITH = "starts-with";
    private static final String CONTAINS = "contains";
    private static final String SUBSTRING_BEFORE = "substring-before";
    private static final String SUBSTRING_AFTER = "substring-after";
    private static final String SUBSTRING = "substring";
    private static final String STRING_LENGTH = "string-length";
    private static final String NORMALIZE_SPACE = "normalize-space";
    private static final String TRANSLATE = "translate";
    //
    private static final String BOOLEAN = "boolean";
    private static final String NOT = "not";
    private static final String TRUE = "true";
    private static final String FALSE = "false";
    //
    private static final String NUMBER = "number";
    private static final String SUM = "sum";
    private static final String FLOOR = "floor";
    private static final String CEILING = "ceiling";
    private static final String ROUND = "round";
    //
    private static final String MATCHES = "matches";
    private static final String REPLACE = "replace";
    //
    private static final String NAME = "name";
    private static final String LOCAL_NAME = "local-name";
    private static final String NULL = "null";

    public XPathFunctions() {
        Functions coreFunctions = JXPathContext.newContext(null).getFunctions();
        // list functions
        /*this.addFunction(null, new FunctionWrapper(LAST, coreFunctions.getFunction(null, LAST, null)));
        this.addFunction(null, new FunctionWrapper(POSITION, coreFunctions.getFunction(null, POSITION, null)));
        this.addFunction(null, new FunctionWrapper(COUNT, coreFunctions.getFunction(null, COUNT, new Object[]{new ArrayList()})));
        // string functions
        this.addFunction(null, new FunctionWrapper(STRING, coreFunctions.getFunction(null, STRING, new Object[]{new Object()})));
        this.addFunction(null, new FunctionWrapper(CONCAT, coreFunctions.getFunction(null, CONCAT, new Object[]{new String(), new String()})));
        this.addFunction(null, new FunctionWrapper(STARTS_WITH, coreFunctions.getFunction(null, STARTS_WITH, new Object[]{new String(), new String()})));
        this.addFunction(null, new FunctionWrapper(CONTAINS, coreFunctions.getFunction(null, CONTAINS, new Object[]{new String(), new String()})));
        this.addFunction(null, new FunctionWrapper(SUBSTRING_AFTER, coreFunctions.getFunction(null, SUBSTRING_AFTER, new Object[]{new String(), new String()})));
        this.addFunction(null, new FunctionWrapper(SUBSTRING_BEFORE, coreFunctions.getFunction(null, SUBSTRING_BEFORE, new Object[]{new String(), new String()})));
        this.addFunction(null, new FunctionWrapper(SUBSTRING, coreFunctions.getFunction(null, SUBSTRING, new Object[]{new String(), 1})));
        this.addFunction(null, new FunctionWrapper(STRING_LENGTH, coreFunctions.getFunction(null, STRING_LENGTH, new Object[]{new String()})));
        this.addFunction(null, new FunctionWrapper(NORMALIZE_SPACE, coreFunctions.getFunction(null, NORMALIZE_SPACE, new Object[]{new String()})));
        this.addFunction(null, new FunctionWrapper(TRANSLATE, coreFunctions.getFunction(null, TRANSLATE, new Object[]{new String(), new String(), new String()})));
        // boolean functions
        this.addFunction(null, new FunctionWrapper(BOOLEAN, coreFunctions.getFunction(null, BOOLEAN, new Object[]{new Object()})));
        this.addFunction(null, new FunctionWrapper(NOT, coreFunctions.getFunction(null, NOT, new Object[]{true})));
        this.addFunction(null, new FunctionWrapper(TRUE, coreFunctions.getFunction(null, TRUE, null)));
        this.addFunction(null, new FunctionWrapper(FALSE, coreFunctions.getFunction(null, FALSE, null)));
        // number functions
        this.addFunction(null, new FunctionWrapper(NUMBER, coreFunctions.getFunction(null, NUMBER, new Object[]{new Object()})));
        this.addFunction(null, new SumFunction());
        this.addFunction(null, new FunctionWrapper(FLOOR, coreFunctions.getFunction(null, FLOOR, new Object[]{1})));
        this.addFunction(null, new FunctionWrapper(CEILING, coreFunctions.getFunction(null, CEILING, new Object[]{1})));
        this.addFunction(null, new FunctionWrapper(ROUND, coreFunctions.getFunction(null, ROUND, new Object[]{1})));
        // regular expression functions*/
        this.addFunction(null, new FunctionWrapper(MATCHES, coreFunctions.getFunction(null, MATCHES, new Object[]{new String(), new String()})));
        this.addFunction(null, new FunctionWrapper(REPLACE, coreFunctions.getFunction(null, REPLACE, new Object[]{new String(), new String(), new String()})));
        // other functions
        /*this.addFunction(null, new FunctionWrapper(NAME, coreFunctions.getFunction(null, NAME, new Object[]{new String()})));
        this.addFunction(null, new FunctionWrapper(LOCAL_NAME, coreFunctions.getFunction(null, LOCAL_NAME, new Object[]{new String()})));
        this.addFunction(null, new FunctionWrapper(NULL, coreFunctions.getFunction(null, NULL, null)));*/
    }

    public static class FunctionWrapper implements Function {

        private org.apache.commons.jxpath.Function function;
        private String name;

        public FunctionWrapper(final String name, final org.apache.commons.jxpath.Function function) {
            this.name = name;
            this.function = function;
        }

        public Object invoke(final ExpressionContext context, final Object[] parameters) {
            return this.function.invoke(context, parameters);
        }

        public String getName() {
            return this.name;
        }
    }
}
