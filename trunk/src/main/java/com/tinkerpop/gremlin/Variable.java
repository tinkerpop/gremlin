package com.tinkerpop.gremlin;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Variable<T> {

    public static enum Type {REAL, NATURAL, VERTEX, EDGE, STRING, PATH}

    protected Variable.Type type;
    protected T value;

    public Variable(Variable.Type type, T value) {
        this.type = type;
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public Type getType() {
        return this.type;
    }

    public String toString() {
        return "[" + this.type + " " + this.value + "]";
    }

    /*public void setVariable(Variable.Type type, T value) {
        this.type = type;
        this.value = value;
    }*/

}
