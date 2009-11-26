package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.db.tg.TinkerGraph;
import com.tinkerpop.gremlin.db.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.db.tg.TinkerVertex;
import org.apache.commons.jxpath.ClassFunctions;
import org.apache.commons.jxpath.FunctionLibrary;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathIntrospector;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class EvaluatorTest extends BaseTest {

    public EvaluatorTest() {
        JXPathIntrospector.registerDynamicClass(Vertex.class, VertexPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Edge.class, EdgePropertyHandler.class);
    }


    public void testHaltCont() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("6");
        //assertEquals(marko.getProperty("name"), "marko");
        JXPathContext context = JXPathContext.newContext(marko);
        context.setLenient(true);

        FunctionLibrary library = new FunctionLibrary();
        library.addFunctions(new ClassFunctions(GremlinClassFunctions.class, "g"));
        library.addFunctions(context.getFunctions());
        context.setFunctions(library);

        //assertEquals(context.selectNodes("(./outEdges/inVertex)[g:assign('$i')][g:cont(countIterator($i) = 3)]/name"), context.selectNodes("./outEdges/inVertex/name"));
        //context.selectNodes("(./outEdges/inVertex)[g:assign('$i')][g:cont(countIterator($i) < 2)]/name[g:assign('$i')]");
//        assertEquals(context.iterate("$i[g:printIterator()]"), context.iterate("./outEdges/inVertex[g:printIterator()]"));

        printList(context.selectNodes("((./outEdges[@label=\"created\"]/inVertex/inEdges[@label=\"created\"]/outVertex/@name)[g:assign('$y')]/../@age)[g:assign('$z')][g:cont(false())]"));
        printIterator(context.iterate("$y"));
        printIterator(context.iterate("$z"));


    }

    public void testSet() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        assertEquals(marko.getProperty("name"), "marko");
        JXPathContext context = JXPathContext.newContext(marko);
        context.setLenient(true);

        FunctionLibrary library = new FunctionLibrary();
        library.addFunctions(new ClassFunctions(GremlinClassFunctions.class, "g"));
        library.addFunctions(context.getFunctions());
        context.setFunctions(library);

        assertEquals(context.selectNodes("."), context.selectNodes("."));
        assertEquals(context.selectNodes("./name[g:assign('$i')]"), context.selectNodes("./name"));
        assertEquals(context.selectNodes("./name[g:assign('$i')]"), context.selectNodes("$i"));
        context.selectNodes("./inEdges[g:assign('$i')]");
        assertEquals(context.selectNodes("$i").size(), 1);
        context.selectNodes("(./inEdges)[g:assign('$i')]");
        assertEquals(context.selectNodes("$i").size(), 3);       
    }

    public void testNoop() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        assertEquals(marko.getProperty("name"), "marko");
        JXPathContext context = JXPathContext.newContext(marko);
        context.setLenient(true);

        FunctionLibrary library = new FunctionLibrary();
        library.addFunctions(new ClassFunctions(GremlinClassFunctions.class, "g"));
        library.addFunctions(context.getFunctions());
        context.setFunctions(library);

        assertEquals(context.selectNodes("."), context.selectNodes("."));
        assertEquals(context.selectNodes("./name"), context.selectNodes("./@name"));
        assertTrue(context.selectNodes("./name") != context.selectNodes("./@age"));
        assertEquals(context.selectNodes("./name"), context.selectNodes("./@name[g:noop()]"));
        assertEquals(context.selectNodes("./name"), context.selectNodes("./@name[g:noop()][g:noop()]"));
        assertEquals(context.selectNodes("./name"), context.selectNodes("./@name[g:noop()][g:noop()][g:noop()]"));
        assertEquals(context.selectNodes("./outEdges/inVertex"), context.selectNodes("./outEdges[g:noop()]/inVertex[g:noop()][g:noop()][g:noop()]"));
    }

    public void testOneStepTraverseFromMarko() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        assertEquals(marko.getProperty("name"), "marko");

        JXPathContext context = JXPathContext.newContext(marko);
        context.setLenient(true);
        assertEquals(context.getValue("./@name"), "marko");
        assertEquals(context.getValue("./@age"), 29);
        assertEquals(countIterator(context.iterate("./outEdges")), 3);

        assertEquals(countIterator(context.iterate("./outEdges[@label='knows']")), 2);
        assertEquals(countIterator(context.iterate("./outEdges[@label='knows']/inVertex/@name")), 2);
        assertEquals(countIterator(context.iterate("./outEdges[@label='knows' and @weight='1.0']/inVertex/@name")), 1);
        assertEquals(countIterator(context.iterate("./outEdges[@label='knows' and @weight > '1.0']/inVertex/@name")), 0);

        assertEquals(countIterator(context.iterate("./outEdges[@label='created']")), 1);
        assertEquals(context.getValue("./outEdges[@label='created']/inVertex"), graph.getVertex("3"));
        assertEquals(context.getValue("./outEdges[@label='created']/@weight"), 0.4);
        assertEquals(context.getValue("./outEdges[@label='created' and @weight ='0.4']/inVertex"), graph.getVertex("3"));
        assertEquals(context.getValue("./outEdges[@label='created' and @weight >'0.4']/inVertex"), null);
        assertEquals(context.getValue("./outEdges[@label='created' and @weight <'0.4']/inVertex"), null);
        assertEquals(context.getValue("./outEdges[@label='created' and @weight >='0.4']/inVertex"), graph.getVertex("3"));

    }

    public void testTwoStepTraverseFromMarko() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        assertEquals(marko.getProperty("name"), "marko");

        JXPathContext context = JXPathContext.newContext(marko);
        context.setLenient(true);
        assertEquals(countIterator(context.iterate("./outEdges")), 3);
        assertEquals(countIterator(context.iterate("./outEdges[@label='knows']")), 2);
        assertEquals(countIterator(context.iterate("./outEdges[@label='created']/inVertex/@name")), 1);
        assertEquals(context.getValue("./outEdges[@label='created']/inVertex/@name"), "lop");
        assertEquals(countIterator(context.iterate("./outEdges[@label='created']/inVertex/inEdges[@label='created']/outVertex")), 3);
        assertEquals(countIterator(context.iterate("./outEdges[@label='created']/inVertex/inEdges[@label='created' and @weight='0.2']/outVertex")), 1);
        assertEquals(context.getValue("./outEdges[@label='created']/inVertex/inEdges[@label='created' and @weight='0.2']/outVertex/@name"), "peter");
        assertEquals(context.getValue("./outEdges[@label='created']/inVertex/inEdges[@label='created' and @weight='0.2']/outVertex[matches(@name,'peter')]/@age"), 35);
        assertEquals(context.getValue("./outEdges[@label='created']/inVertex/inEdges[@label='created' and @weight='0.2']/outVertex[matches(@name,'peter')]/age"), 35);

    }

    public void testVariableSetting() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Vertex marko = graph.getVertex("1");
        JXPathContext context = JXPathContext.newContext(null);
        context.iterate("$x");
        context.iterate("$x = 1");
        context.getVariables().declareVariable("x", marko);
        assertEquals(context.getValue("$x/@name"), "marko");

    }



}
