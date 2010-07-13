package com.tinkerpop.gremlin.compiler;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Pavel A. Yaskevich
 */
public class Atom<T> {

    private T value;

    /* for not persistent variable calls */
    private String variableName;

    /* for not persistent function calls */
    private Function function;
    private List<Operation> functionParameters;

    private boolean persistent = true;

    /* identifier and property used in gpath */
    private boolean identifier = false;
    private boolean property = false;

    private Type type = Type.REGULAR;

    private static final String NULL = "null";
    private static final String EMPTY_STRING = "";

    public enum Type {
        FUNCTION, VARIABLE, REGULAR
    }

    public Atom(T value) {
        this.value = value;

        // string preprocessing
        if (this.isString()) {
            String result = EMPTY_STRING;
            String stringValue = (String) this.value;

            for (int i = 0; i < stringValue.length(); i++) {
                final Character currentCharacter = stringValue.charAt(i);
                if ((i == 0 || i == stringValue.length() - 1) && (currentCharacter.equals('"') || currentCharacter.equals('\'')))
                    continue;
                result += stringValue.charAt(i);
            }

            this.value = (T) result;
        }
    }

    public T getValue() {
        return this.value;
    }

    public boolean isString() {
        return isClassOf(String.class);
    }

    public boolean isNumber() {
        return isClassOf(Number.class);
    }

    public boolean isInteger() {
        return isClassOf(Integer.class);
    }

    public boolean isLong() {
        return isClassOf(Long.class);
    }

    public boolean isFloat() {
        return isClassOf(Float.class);
    }

    public boolean isDouble() {
        return isClassOf(Double.class);
    }

    public boolean isBoolean() {
        return isClassOf(Boolean.class);
    }

    public boolean isNull() {
        return null == this.value;
    }

    public boolean isMap() {
        return isClassOf(Map.class);
    }

    public boolean isIterable() {
        return isClassOf(Iterable.class);
    }

    public boolean isCollection() {
        return isClassOf(Collection.class);
    }

    public boolean isFunctionCall() {
        return this.type == Type.FUNCTION;
    }

    public boolean isGraph() {
        return isClassOf(Graph.class);
    }

    public boolean isElement() {
        return isClassOf(Element.class);
    }

    public boolean isVertex() {
        return isClassOf(Vertex.class);
    }

    public boolean isEdge() {
        return isClassOf(Edge.class);
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

    public boolean isComparable() {
        return isClassOf(Comparable.class);
    }

    public boolean isVariableCall() {
        return this.type == Type.VARIABLE;
    }

    public void setPersistent(final boolean flag) {
        this.persistent = flag;
    }

    public void setVariableName(final String name) {
        this.variableName = name;
        this.type = Type.VARIABLE;
    }

    public void setFunction(final Function function, final List<Operation> parameters) {
        this.function = function;
        this.functionParameters = parameters;
        this.type = Type.FUNCTION;
    }

    public void setIdentifier(final boolean flag) {
        this.identifier = flag;
    }

    public void setProperty(final boolean flag) {
        this.property = flag;
    }

    public Atom recalculated() {
        final Atom result;

        try {
            if (this.type == Type.VARIABLE) {
                result = GremlinEvaluator.getVariable(this.variableName);
            } else if (this.type == Type.FUNCTION) {
                result = this.function.compute(this.functionParameters);
            } else {
                result = this;
            }
            return result;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    private boolean isClassOf(final Class klass) {
        return (this.isNull()) ? false : ((klass.isAssignableFrom(this.value.getClass())) ? true : false);
    }

    public boolean equals(Object object) {
        return object instanceof Atom && (((Atom) object).getValue().equals(this.value));
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return (this.value == null) ? NULL : this.value.toString();
    }

    public Function getFunctionObject() {
        return this.function;
    }

    public List<Operation> getFunctionParameters() {
        return this.functionParameters;
    }

}
