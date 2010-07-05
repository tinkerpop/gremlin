package com.tinkerpop.gremlin.compiler;

import java.util.Map;
import java.util.HashMap;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.util.DeclareVariable;

/**
 * @author Pavel A. Yaskevich
 */
public class VariableLibrary {
    private Map<String, Atom> variables;
    
    public VariableLibrary() {
        this.variables = new HashMap<String, Atom>();
    }

    public void declare(String var, Atom value) {
        this.variables.put(var, value);
    }

    public void free(String var) {
        this.variables.remove(var);
    }

    public Atom get(String var) {
        Atom result = this.variables.get(var);
        return (result == null) ? DeclareVariable.makeAtomValue(var, new Atom(null)) : result;
    }

    public boolean isDeclared(String var) {
        return (this.variables.get(var) == null) ? false : true;
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
