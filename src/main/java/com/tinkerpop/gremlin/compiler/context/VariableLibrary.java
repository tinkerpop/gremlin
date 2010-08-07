package com.tinkerpop.gremlin.compiler.context;

import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.types.Atom;

import javax.script.Bindings;
import java.util.HashMap;

/**
 * @author Pavel A. Yaskevich
 */
public class VariableLibrary extends HashMap<String, Object> implements Bindings {

    private static final String GRAPH_VARIABLE_ERROR = "Cannot set $_g to anything but a graph";

    public void declare(String variable, Atom value) {
        if (variable.equals(Tokens.GRAPH_VARIABLE) && !value.isGraph()) {
            throw new RuntimeException(GRAPH_VARIABLE_ERROR);
        }
        super.put(variable, value);
    }

    public void free(String variable) {
        super.remove(variable);
    }

    public void setHistoryVariable(Atom value) {
        super.put(Tokens.LAST_VARIABLE, value);    
    }

    public VariableLibrary cloneLibrary() {
        VariableLibrary dupLibrary = new VariableLibrary();

        for (String k : super.keySet()) {
            dupLibrary.declare(k, (Atom) super.get(k));
        }

        return dupLibrary;
    }
    
}
