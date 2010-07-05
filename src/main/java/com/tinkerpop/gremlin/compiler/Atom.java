package com.tinkerpop.gremlin.compiler;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Pavel A. Yaskevich
 */
public class Atom {

    private Object val;

    /* for not persistent variable calls */
    private String variableName;

    /* for not persistent function calls */
    private Function function;
    private List<Operation> functionParams;

    private boolean persistent = true;

    /* identifier and property used in gpath */
    private boolean identifier = false;
    private boolean property = false;
    private boolean iterator = false;

    private String dynamicObjectType = "";

    public Atom(Object value) {
        this.val = value;

        // string preprocessing
        if (this.isString()) {
            String result = "";
            String stringVal = (String) this.val;

            for (int i = 0; i < stringVal.length(); i++) {
                Character currChar = stringVal.charAt(i);

                if ((i == 0 || i == stringVal.length() - 1) && (currChar.equals('"') || currChar.equals('\'')))
                    continue;

                result += stringVal.charAt(i);
            }

            this.val = result;
        }
    }

    @SuppressWarnings("rawtypes")
    public Atom(Iterator itty) {
        this.iterator = true;
        this.val = itty;
    }

    public Object getValue() {
        return this.val;
    }

    public boolean isString() {
        return isClassOf(String.class);
    }

    public boolean isNumber() {
        return isClassOf(Double.class);
    }

    public boolean isBoolean() {
        return isClassOf(Boolean.class);
    }

    public boolean isNull() {
        return (this.val == null) ? true : false;
    }

    public boolean isList() {
        return isClassOf(List.class);
    }

    public boolean isMap() {
        return isClassOf(Map.class);
    }

    public boolean isIterable() {
        return isClassOf(Iterable.class);
    }

    public boolean isFunctionCall() {
        return (this.function == null) ? false : true;
    }

    public boolean isGraph() {
        return (this.val instanceof Graph) ? true : false;
    }

    public boolean isIterator() {
        return this.iterator;
    }

    public boolean isPersistent() {
        return this.persistent;
    }

    public boolean isIdentifier() {
        return this.identifier;
    }

    public boolean isProperty() {
        return this.property;
    }

    public void setPersistent(final boolean flag) {
        this.persistent = flag;
    }

    public void setVariableName(final String name) {
        this.variableName = name;
        this.dynamicObjectType = "VARIABLE";
    }

    public void setFunction(final Function fn, final List<Operation> params) {
        this.function = fn;
        this.functionParams = params;
        this.dynamicObjectType = "FUNCTION";
    }

    public void setIdentifier(final boolean flag) {
        this.identifier = flag;
    }

    public void setProperty(final boolean flag) {
        this.property = flag;
    }

    public Atom recalculated() {
        Atom result = null;

        try {
            if (this.dynamicObjectType.equals("VARIABLE")) {
                result = GremlinEvaluator.getVariable(this.variableName);
            } else if (this.dynamicObjectType.equals("FUNCTION")) {
                result = this.function.compute(this.functionParams);
            } else {
                result = this;
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return result;
    }

    @SuppressWarnings("rawtypes")
    private boolean isClassOf(final Class klass) {
        return (this.isNull()) ? false : ((klass.isAssignableFrom(this.val.getClass())) ? true : false);
    }

    public boolean equals(Object object) {
        if (object instanceof Atom) {
            if (((Atom) object).getValue().equals(this.val))
                return true;
        }
        return false;
    }

    public int hashCode() {
        return this.val.hashCode();
    }

    public String toString() {
        return (this.val == null) ? "null" : this.val.toString();
    }

}
