package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.FunctionLibrary;
import org.apache.commons.jxpath.ClassFunctions;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;

import java.util.List;
import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinPathContext extends JXPathContextReferenceImpl {

    protected String contextPath;
    private static final String FUNCTION_NAMESPACE = "g";

    public GremlinPathContext(JXPathContext parentContext, Object element) {
        super(parentContext, element);
        FunctionLibrary library = new FunctionLibrary();
        library.addFunctions(new ClassFunctions(GremlinFunctions.class, FUNCTION_NAMESPACE));
        library.addFunctions(this.getFunctions());
        this.setFunctions(library);
    }

    public GremlinPathContext(Object element) {
        this(null, element);
    }

    public static GremlinPathContext newContext(JXPathContext parentContext, Object element) {
        JXPathIntrospector.registerDynamicClass(Vertex.class, VertexPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Edge.class, EdgePropertyHandler.class);
        return new GremlinPathContext(parentContext, element);
    }

    public static GremlinPathContext newContext(Object element) {
        return GremlinPathContext.newContext(null, element);
    }

    public List selectNodes(String path) {
        this.contextPath = path;
        return super.selectNodes(path);
    }

    public Iterator iterate(String path) {
        this.contextPath = path;
        return super.iterate(path);
    }

    public String getContextPath() {
        return this.contextPath;
    }
}
