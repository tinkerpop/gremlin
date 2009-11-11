package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.ClassFunctions;
import org.apache.commons.jxpath.FunctionLibrary;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathIntrospector;

import java.util.Iterator;


/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Evaluator {

    protected JXPathContext baseContext;

    public Evaluator() {
        FunctionLibrary library = new FunctionLibrary();
        library.addFunctions(new ClassFunctions(TestFunctions.class, "g"));
        JXPathIntrospector.registerDynamicClass(Vertex.class, VertexPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Edge.class, EdgePropertyHandler.class);
        this.baseContext = JXPathContext.newContext(null);
        this.baseContext.setFunctions(library);
    }

    public Iterator evaluate(Element startElement, String path) {
        JXPathContext context = JXPathContext.newContext(baseContext, startElement);

        return context.iterate(path);
    }


}
