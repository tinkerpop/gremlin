package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.ClassFunctions;
import org.apache.commons.jxpath.FunctionLibrary;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinPathContext extends JXPathContextReferenceImpl {

    //protected String contextPath;
    private static final String FUNCTION_NAMESPACE = "g";
    protected Graph graph;
    private boolean newRoot = false;

    static {
        JXPathIntrospector.registerDynamicClass(Vertex.class, VertexPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Edge.class, EdgePropertyHandler.class);
    }

    public GremlinPathContext(JXPathContext parentContext, Object element) {
        super(parentContext, element);
        if (null == parentContext) {
            FunctionLibrary library = new FunctionLibrary();
            library.addFunctions(new ClassFunctions(GremlinFunctions.class, FUNCTION_NAMESPACE));
            library.addFunctions(this.getFunctions());
            this.setFunctions(library);
            this.getVariables().declareVariable("_", null);
        } else if (parentContext instanceof GremlinPathContext) {
            this.setGraph(((GremlinPathContext) parentContext).getGraph());
        }
    }

    public GremlinPathContext(Object element) {
        this(null, element);
    }

    public static JXPathContext newContext(JXPathContext parentContext, Object element) {
        return new GremlinPathContext(parentContext, element);
    }

    public static JXPathContext newContext(Object element) {
        return GremlinPathContext.newContext(null, element);
    }

    /* public List selectNodes(String path) {
        //System.out.println(this.contextBean + " root nodes");
        //this.contextPath = path;
        return super.selectNodes(path);
    }*/

    /*public Iterator iterate(String path) {
        //this.contextPath = path;
        return super.iterate(path);
    }*/

    /*public String getContextPath() {
        return this.contextPath;
    }*/

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Graph getGraph() {
        return this.graph;
    }


    public void setContextBean(Object root) {
        this.contextBean = root;
        this.newRoot = true;
    }

    public boolean rootChanged() {
        return this.newRoot;
    }
}
