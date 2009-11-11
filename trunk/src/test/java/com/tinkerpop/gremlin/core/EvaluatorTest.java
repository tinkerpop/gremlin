package com.tinkerpop.gremlin.core;

import com.tinkerpop.gremlin.Edge;
import com.tinkerpop.gremlin.EdgePropertyHandler;
import com.tinkerpop.gremlin.Vertex;
import com.tinkerpop.gremlin.VertexPropertyHandler;
import com.tinkerpop.gremlin.db.mini.MiniGraph;
import com.tinkerpop.gremlin.db.mini.MiniGraphFactory;
import com.tinkerpop.gremlin.db.mini.MiniVertex;
import junit.framework.TestCase;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathIntrospector;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class EvaluatorTest extends TestCase {

    public EvaluatorTest() {
        JXPathIntrospector.registerDynamicClass(Vertex.class, VertexPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Edge.class, EdgePropertyHandler.class);
    }

    public void testOneStepTraverseFromMarko() {
        MiniGraph graph = MiniGraphFactory.createTinkerGraph();
        MiniVertex marko = graph.getVertex("1");
        assertEquals(marko.getProperty("name"), "marko");

        JXPathContext context = JXPathContext.newContext(marko);
        context.setLenient(true);
        assertEquals(context.getValue("./@name"), "marko");
        assertEquals(context.getValue("./@age"), 29);
        assertEquals(count(context.iterate("./outEdges")), 3);
        
        assertEquals(count(context.iterate("./outEdges[@label='knows']")), 2);
        assertEquals(count(context.iterate("./outEdges[@label='knows']/inVertex/@name")), 2);
        assertEquals(count(context.iterate("./outEdges[@label='knows' and @weight='1.0']/inVertex/@name")), 1);
        assertEquals(count(context.iterate("./outEdges[@label='knows' and @weight > '1.0']/inVertex/@name")), 0);

        assertEquals(count(context.iterate("./outEdges[@label='created']")), 1);
        assertEquals(context.getValue("./outEdges[@label='created']/inVertex"), graph.getVertex("3"));
        assertEquals(context.getValue("./outEdges[@label='created']/@weight"), 0.4);
        assertEquals(context.getValue("./outEdges[@label='created' and @weight ='0.4']/inVertex"), graph.getVertex("3"));
        assertEquals(context.getValue("./outEdges[@label='created' and @weight >'0.4']/inVertex"), null);
        assertEquals(context.getValue("./outEdges[@label='created' and @weight <'0.4']/inVertex"), null);
        assertEquals(context.getValue("./outEdges[@label='created' and @weight >='0.4']/inVertex"), graph.getVertex("3"));
    }

    public void testTwoStepTraverseFromMarko() {
        MiniGraph graph = MiniGraphFactory.createTinkerGraph();
        MiniVertex marko = graph.getVertex("1");
        assertEquals(marko.getProperty("name"), "marko");

        JXPathContext context = JXPathContext.newContext(marko);
        context.setLenient(true);
        assertEquals(count(context.iterate("./outEdges")), 3);
        assertEquals(count(context.iterate("./outEdges[@label='knows']")), 2);
        assertEquals(count(context.iterate("./outEdges[@label='created']/inVertex/@name")), 1);
        assertEquals(context.getValue("./outEdges[@label='created']/inVertex/@name"), "lop");
        assertEquals(count(context.iterate("./outEdges[@label='created']/inVertex/inEdges[@label='created']/outVertex")), 3);
        assertEquals(count(context.iterate("./outEdges[@label='created']/inVertex/inEdges[@label='created' and @weight='0.2']/outVertex")), 1);
        assertEquals(context.getValue("./outEdges[@label='created']/inVertex/inEdges[@label='created' and @weight='0.2']/outVertex/@name"), "peter");
        assertEquals(context.getValue("./outEdges[@label='created']/inVertex/inEdges[@label='created' and @weight='0.2']/outVertex[matches(@name,'peter')]/@age"), 35);
        assertEquals(context.getValue("./outEdges[@label='created']/inVertex/inEdges[@label='created' and @weight='0.2']/outVertex[matches(@name,'peter')]/age"), 35);
    }

    public static void print(Iterator itty) {
        while (itty.hasNext()) {
            System.out.println(itty.next());
        }
    }

    public static int count(Iterator itty) {
        int counter = 0;
        while (itty.hasNext()) {
            itty.next();
            counter++;
        }
        return counter;
    }

}
