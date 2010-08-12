package com.tinkerpop.gremlin.compiler.types;

import java.util.Random;

/**
 * @author Pavel A. Yaskevich
 */
public class Prop<String> extends Atom<String> {

    public Prop(String value) {
        super(value);
    }

    public boolean isProperty() {
        return true;
    }

}
