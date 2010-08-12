package com.tinkerpop.gremlin.compiler.types;

import java.util.Random;

/**
 * @author Pavel A. Yaskevich
 */
public class Id<String> extends Atom<String> {

    public Id(String value) {
        super(value);
    }

    public boolean isIdentifier() {
        return true;
    }
    
}
