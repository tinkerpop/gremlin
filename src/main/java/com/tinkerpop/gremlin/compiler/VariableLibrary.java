package com.tinkerpop.gremlin.compiler;

import com.tinkerpop.gremlin.compiler.operations.util.DeclareVariable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavel A. Yaskevich
 */
public class VariableLibrary {

    private static final String GRAPH_VARIABLE_ERROR = "Cannot set $_g to anything but a graph";

    private Map<String, Atom> variables;

    public VariableLibrary() {
        this.variables = new HashMap<String, Atom>();
    }

    public void declare(String variable, Atom value) {
        if (variable.equals(Tokens.GRAPH_VARIABLE) && !value.isGraph()) {
            throw new RuntimeException(GRAPH_VARIABLE_ERROR);
        }
        this.variables.put(variable, value);
    }

    public void free(String variable) {
        this.variables.remove(variable);
    }

    public Atom get(String variable) {
        Atom result = this.variables.get(variable);
        return (result == null) ? DeclareVariable.makeAtomValue(variable, new Atom(null)) : result;
    }

    public boolean isDeclared(String variable) {
        return this.variables.get(variable) != null;
    }

    public VariableLibrary clone() {
        VariableLibrary dupLibrary = new VariableLibrary();

        for (String k : this.variables.keySet()) {
            dupLibrary.declare(k, this.variables.get(k));
        }

        return dupLibrary;
    }

    public String toString() {
        return this.variables.toString();
    }
}
