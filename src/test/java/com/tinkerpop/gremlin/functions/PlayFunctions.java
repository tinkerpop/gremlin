package com.tinkerpop.gremlin.functions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PlayFunctions extends AbstractFunctions {

    public PlayFunctions() {
        functions.add(new PlayStringFunction());
        functions.add(new PlayNumberFunction());
    }

    public String getNamespace() {
        return "play";
    }
}

