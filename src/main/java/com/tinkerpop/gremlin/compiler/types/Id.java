package com.tinkerpop.gremlin.compiler.types;

import java.util.Random;

/**
 * @author Pavel A. Yaskevich
 */
public class Id<String> extends Atom<String> {

    private static final Random random = new Random();
    private final int hashCode = random.nextInt();
    
    public Id(String value) {
        super(value);
    }

    public boolean isIdentifier() {
        return true;
    }

    public int hashCode() {
        return hashCode;
    }
}
