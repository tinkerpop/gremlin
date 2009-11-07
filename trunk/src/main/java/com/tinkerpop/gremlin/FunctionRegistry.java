package com.tinkerpop.gremlin;

import java.util.HashMap;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class FunctionRegistry extends HashMap<String, Function> {

    public void main(String[] args) {
        this.get("marko").evaluate(this.get("the").evaluate(new Object()));
    }


}
