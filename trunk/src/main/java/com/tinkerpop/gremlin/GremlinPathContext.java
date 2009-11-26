package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.db.sesame.SesameFunctions;
import com.tinkerpop.gremlin.db.tg.TinkerFunctions;
import com.tinkerpop.gremlin.lang.Tokens;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import org.apache.commons.jxpath.ClassFunctions;
import org.apache.commons.jxpath.FunctionLibrary;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinPathContext extends JXPathContextReferenceImpl {

    private boolean newRoot = false;

    static {
        JXPathIntrospector.registerDynamicClass(Vertex.class, VertexPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Edge.class, EdgePropertyHandler.class);
    }

    public GremlinPathContext(GremlinPathContext parentContext, Object element) {
        super(parentContext, element);
        if (null == parentContext) {
            FunctionLibrary library = new FunctionLibrary();
            library.addFunctions(new GremlinFunctions(GremlinFunctions.NAMESPACE_PREFIX));
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
        if (variable.equals(Tokens.AT_VARIABLE)) {
            if (value instanceof List) {
                if (((List) value).size() == 1) {
                    value = ((List) value).get(0);
                }
            }
            this.setRoot(value);
        }
        this.getVariables().declareVariable(GremlinPathContext.cleanVariable(variable), value);
    }

    public Object getVariable(String variable) {
        try {
            return this.getVariables().getVariable(GremlinPathContext.cleanVariable(variable));
        } catch (Exception e) {
            return null;
        }
    }

    public void removeVariable(String variable) {
        this.getVariables().undeclareVariable(GremlinPathContext.cleanVariable(variable));
    }

    private static String cleanVariable(String variable) {
        return variable.replace(Tokens.DOLLAR_SIGN, Tokens.EMPTY_STRING);
    }
}
