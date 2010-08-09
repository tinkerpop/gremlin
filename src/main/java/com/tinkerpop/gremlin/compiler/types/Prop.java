package com.tinkerpop.gremlin.compiler.types;

import com.tinkerpop.gremlin.compiler.pipes.GremlinPropertyPipe;
import com.tinkerpop.pipes.Pipe;

import java.util.Random;

/**
 * @author Pavel A. Yaskevich
 */
public class Prop<String> extends Atom<String> {

    private final int hashCode = new Random().nextInt();

    public Prop(String value) {
        super(value);
    }

    public boolean isProperty() {
        return true;
    }

    public int hashCode() {
        return hashCode;
    }

}
