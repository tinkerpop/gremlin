package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.models.ggm.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.Tokens;
import org.apache.commons.jxpath.Variables;

import javax.script.Bindings;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class VariableLibrary extends HashMap<String, Object> implements Variables, Bindings {

    private static final Pattern variablePattern = Pattern.compile(Tokens.VARIABLE_REGEX);
    private final GremlinPathContext gremlinPathContext;

    public VariableLibrary(GremlinPathContext gremlinPathContext) {
        this.gremlinPathContext = gremlinPathContext;
    }

    public Object put(final String name, final Object value) {
        Object o = this.get(removeVariableDollarSign(name));
        this.declareVariable(name, value);
        return o;
    }

    public Object get(final String name) {
        return super.get(removeVariableDollarSign(name));
    }

    public void declareVariable(final String name, final Object value) {
        if (variablePattern.matcher(name).matches()) {
            // $i := ././././
            if (name.equals(Tokens.AT_VARIABLE)) {
                // $_ := ./././
                this.gremlinPathContext.setRoot(value);
            } else if (name.equals(Tokens.GRAPH_VARIABLE)) {
                // $_g := ./././
                if (!(value instanceof Graph)) {
                    throw new EvaluationException(Tokens.GRAPH_VARIABLE + " can only reference a graph");
                }
            }
            super.put(removeVariableDollarSign(name), value);
        } else {
            // $i[1] := ././././
            // $i/@key := ././././
            if (!(value instanceof List)) {
                this.gremlinPathContext.setValue(name, value);
            } else {
                if (((List) value).size() == 0) {
                    this.gremlinPathContext.setValue(name, null);
                } else {
                    throw EvaluationException.createException(EvaluationException.EvaluationErrorType.EMBEDDED_COLLECTIONS);
                }
            }
        }
    }

    public Object getVariable(final String name) {
        return super.get(removeVariableDollarSign(name));
    }

    public boolean isDeclaredVariable(final String name) {
        return super.containsKey(removeVariableDollarSign(name));
    }

    public void undeclareVariable(final String name) {
        super.remove(removeVariableDollarSign(name));
    }

    private static String removeVariableDollarSign(final String variable) {
        return variable.replace(Tokens.DOLLAR_SIGN, Tokens.EMPTY_STRING);
    }
}
