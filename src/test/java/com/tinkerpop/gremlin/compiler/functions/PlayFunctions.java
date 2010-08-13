package com.tinkerpop.gremlin.compiler.functions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PlayFunctions extends AbstractFunctions {

    public PlayFunctions() {
        functions.add(new PlayFunction());
    }

    public String getNamespace() {
        return "play";
    }
}

