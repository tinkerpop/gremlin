package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.compiler.util.Tokens;

import java.io.IOException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Version {

    public static void main(final String[] arguments) throws IOException {
        System.out.println("gremlin " + Tokens.VERSION);
    }
}
