package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.db.sesame.SesameFunctions;
import com.tinkerpop.gremlin.db.tg.TinkerFunctions;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.Tokens;
import org.apache.commons.jxpath.ClassFunctions;
import org.apache.commons.jxpath.FunctionLibrary;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinPathContext extends JXPathContextReferenceImpl {

    private boolean newRoot = false;
    private static final Pattern variablePattern = Pattern.compile(Tokens.VARIABLE_REGEX);


    static {
        JXPathIntrospector.registerDynamicClass(Vertex.class, VertexPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Edge.class, EdgePropertyHandler.class);
    }

    public GremlinPathContext(GremlinPathContext parentContext, Object element) {
        super(parentContext, element);
        if (null == parentContext) {
            FunctionLibrary library = new FunctionLibrary();
            library.addFunctions(new GremlinFunctions());
            library.addFunctions(new ClassFunctions(TinkerFunctions.class, TinkerFunctions.NAMESPACE_PREFIX));
            library.addFunctions(new ClassFunctions(SesameFunctions.class, SesameFunctions.NAMESPACE_PREFIX));
            library.addFunctions(this.getFunctions());
            this.setFunctions(library);
            this.getVariables().declareVariable(Tokens.LAST_VARIABLE, element);
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
                this.setRoot(value);
            }
            this.getVariables().declareVariable(GremlinPathContext.removeVariableDollarSign(variable), value);
        } else {
            // $i[1] := ././././
            // $i/@key := ././././
            if (!(value instanceof Collection && value instanceof Map)) {
                this.setValue(variable, value);
            } else {
                throw new RuntimeException("A collection or map can not be the element of a collection or map.");
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
