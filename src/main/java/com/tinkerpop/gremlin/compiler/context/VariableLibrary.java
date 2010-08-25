package com.tinkerpop.gremlin.compiler.context;

import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.Tokens;

import javax.script.Bindings;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavel A. Yaskevich
 */
public class VariableLibrary extends HashMap<String, Object> implements Bindings {

    private static final String GRAPH_VARIABLE_ERROR = "Cannot set $_g to anything but a graph";

    public VariableLibrary() {
        super();
    }

    public VariableLibrary(final Bindings bindings) {
        super();
        this.putAll(bindings);
    }


    public void putAtom(final String key, final Atom value) {
        if (key.equals(Tokens.GRAPH_VARIABLE) && !value.isGraph()) {
            throw new RuntimeException(GRAPH_VARIABLE_ERROR);
        }
        super.put(key, value);
    }

    public void setLastVariable(final Atom value) {
        super.put(Tokens.LAST_VARIABLE, value);
    }

    public VariableLibrary cloneLibrary() {
        VariableLibrary dupLibrary = new VariableLibrary();

        for (String k : super.keySet()) {
            dupLibrary.putAtom(k, (Atom) super.get(k));
        }

        return dupLibrary;
    }


    public Object get(final Object key) {
        Atom atom = (Atom) super.get(key);
        if (null != atom)
            return atom.getValue();
        else
            return null;
    }

    public Object put(final String key, Object value) {
        Object ret = this.get(key);
        if (value instanceof Atom)
            value = ((Atom) value).getValue();

        this.putAtom(key, new Atom(value));
        return ret;
    }

    public void putAll(final Map<? extends String, ? extends Object> toMerge) {
        for (Map.Entry<? extends String, ? extends Object> entry : toMerge.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }
}
