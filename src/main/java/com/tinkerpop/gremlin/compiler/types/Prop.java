package com.tinkerpop.gremlin.compiler.types;

/**
 * @author Pavel A. Yaskevich
 */
public class Prop<String> extends Atom<String> {

    public Prop(final String value) {
        super(value);
    }

    public boolean isProperty() {
        return true;
    }

}
