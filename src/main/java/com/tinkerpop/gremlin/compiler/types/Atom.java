package com.tinkerpop.gremlin.compiler.types;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;

import java.util.Collection;
import java.util.Map;

/**
 * @author Pavel A. Yaskevich
 */
public class Atom<T> {

    private T value;

    /* identifier and property used in gpath */
    private boolean identifier = false;
    private boolean property = false;

    private static final String NULL = "null";
    private static final String EMPTY_STRING = "";
    private static final char DOUBLE_QUOTE = '"';
    private static final char SINGLE_QUOTE = '\'';

    public Atom() {
        this.value = null;
    }

    public Atom(T value) {
        this.value = value;

        // string preprocessing
        if (this.isString()) {
            String result = EMPTY_STRING;
            String stringValue = (String) this.value;

            for (int i = 0; i < stringValue.length(); i++) {
                final Character currentCharacter = stringValue.charAt(i);
                if ((i == 0 || i == stringValue.length() - 1) && (currentCharacter.equals(DOUBLE_QUOTE) || currentCharacter.equals(SINGLE_QUOTE)))
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

    public boolean isIdentifier() {
        return this.identifier;
    }

    public boolean isProperty() {
        return this.property;
    }

    public boolean isComparable() {
        return isClassOf(Comparable.class);
    }

    public void setIdentifier(final boolean flag) {
        this.identifier = flag;
    }

    public void setProperty(final boolean flag) {
        this.property = flag;
    }

    protected boolean isClassOf(final Class klass) {
        return (!this.isNull()) && (klass.isAssignableFrom(this.value.getClass()));
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

}
