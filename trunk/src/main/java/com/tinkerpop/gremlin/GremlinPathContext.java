package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.db.neo.NeoFunctions;
import com.tinkerpop.gremlin.db.sesame.SesameFunctions;
import com.tinkerpop.gremlin.db.tg.TinkerFunctions;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.Tokens;
import org.apache.commons.jxpath.ClassFunctions;
import org.apache.commons.jxpath.FunctionLibrary;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinPathContext extends JXPathContextReferenceImpl {

    private boolean newRoot = false;
    private static final Pattern variablePattern = Pattern.compile(Tokens.VARIABLE_REGEX);
    private static final FunctionLibrary library = new FunctionLibrary();

    static {
        JXPathIntrospector.registerDynamicClass(Vertex.class, VertexPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Edge.class, EdgePropertyHandler.class);

        library.addFunctions(new GremlinFunctions());
        library.addFunctions(new TinkerFunctions());
        library.addFunctions(new NeoFunctions());
        library.addFunctions(new SesameFunctions());
        library.addFunctions(JXPathContext.newContext(null).getFunctions());
    }

    public GremlinPathContext(GremlinPathContext parentContext, Object object) {
        super(parentContext, object);
        if (null == parentContext) {
            this.setFunctions(library);
            // TODO why does this not work?
            if (object instanceof List && ((List) object).size() == 1)
                this.setVariable(Tokens.LAST_VARIABLE, ((List) object).get(0));
            else
                this.setVariable(Tokens.LAST_VARIABLE, object);
        }
    }


    public GremlinPathContext(Object element) {
        this(null, element);
    }

    public static GremlinPathContext newContext(GremlinPathContext parentContext, Object element) {
        return new GremlinPathContext(parentContext, element);
    }

    public static GremlinPathContext newContext(Object element) {
        return GremlinPathContext.newContext(null, element);
    }

    public void setRoot(Object root) {
        this.contextBean = root;
        this.newRoot = true;
    }

    public Object getRoot() {
        return this.contextBean;
    }

    public boolean rootChanged() {
        return this.newRoot;
    }

    public void setVariable(String variable, Object value) {

        if (variablePattern.matcher(variable).matches()) {
            // $i := ././././
            if (variable.equals(Tokens.AT_VARIABLE)) {
                // this is to semi-solve the null pointer exception from backtracking using element collections
                if (value instanceof Collection) {
                    if (value instanceof Set) {
                        if (((Set) value).size() == 1) {
                            this.setRoot(((Set) value).iterator().next());
                        } else {
                            this.setRoot(value);
                        }
                    } else if (value instanceof List) {
                        if (((List) value).size() == 1) {
                            this.setRoot(((List) value).get(0));
                        } else {
                            this.setRoot(value);
                        }
                    }
                } else {
                    this.setRoot(value);
                }
            }
            this.getVariables().declareVariable(GremlinPathContext.removeVariableDollarSign(variable), value);
        } else {
            // $i[1] := ././././
            // $i/@key := ././././
            if (!(value instanceof Collection || value instanceof Map)) {
                this.setValue(variable, value);
            } else {
                throw EvaluationException.createException(EvaluationException.EvaluationErrorType.EMBEDDED_COLLECTIONS);
            }
        }
    }

    public Object getVariable(String variable) {
        try {
            return this.getVariables().getVariable(GremlinPathContext.removeVariableDollarSign(variable));
        } catch (Exception e) {
            return null;
        }
    }

    public void removeVariable(String variable) {
        // TODO fix this hack
        this.getVariables().declareVariable(GremlinPathContext.removeVariableDollarSign(variable), null);
        this.getVariables().undeclareVariable(GremlinPathContext.removeVariableDollarSign(variable));

    }

    private static String removeVariableDollarSign(String variable) {
        return variable.replace(Tokens.DOLLAR_SIGN, Tokens.EMPTY_STRING);
    }
}
