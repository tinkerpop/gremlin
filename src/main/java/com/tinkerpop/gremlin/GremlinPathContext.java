package com.tinkerpop.gremlin;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.functions.CoreFunctionLibrary;
import com.tinkerpop.gremlin.functions.FunctionLibrary;
import com.tinkerpop.gremlin.paths.*;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinPathContext extends JXPathContextReferenceImpl {

    private boolean newRoot = false;
    private static PathLibrary pathLibrary = new PathLibrary();

    static {
        JXPathIntrospector.registerDynamicClass(Map.class, MapPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Graph.class, GraphPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Vertex.class, VertexPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Edge.class, EdgePropertyHandler.class);
        // todo: generalize this solution
        //JXPathIntrospector.registerDynamicClass(Number.class, ObjectPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(String.class, ObjectPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Boolean.class, ObjectPropertyHandler.class);
    }

    public GremlinPathContext(final GremlinPathContext parentContext, final Object root) {
        super(parentContext, root);
        super.setFunctions(CoreFunctionLibrary.getBaseLibrary());
        super.setVariables(new VariableLibrary(this));
    }

    public GremlinPathContext(final Object root) {
        this(null, root);
    }

    public static GremlinPathContext newContext(final GremlinPathContext parentContext, final Object root) {
        return new GremlinPathContext(parentContext, root);
    }

    public static GremlinPathContext newContext(final Object root) {
        return GremlinPathContext.newContext(null, root);
    }

    public void setRoot(Object root) {
        if (null != root && root instanceof List) {
            List rootList = (List) root;
            if (rootList.size() == 1)
                root = rootList.get(0);
        }
        this.contextBean = root;
        this.newRoot = true;
    }

    public Object getRoot() {
        return this.contextBean;
    }

    public boolean rootChanged() {
        return this.newRoot;
    }

    public VariableLibrary getVariables() {
        return (VariableLibrary) super.getVariables();
    }

    public static PathLibrary getPaths() {
        return pathLibrary;
    }

    public FunctionLibrary getFunctions() {
        return (FunctionLibrary) super.getFunctions();
    }
}
