package com.tinkerpop.gremlin.core;

import com.tinkerpop.gremlin.*;
import com.tinkerpop.gremlin.db.tg.TinkerGraph;
import com.tinkerpop.gremlin.db.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.db.tg.TinkerVertex;
import junit.framework.TestCase;
import org.apache.commons.jxpath.ClassFunctions;
import org.apache.commons.jxpath.FunctionLibrary;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathIntrospector;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class EvaluatorTest extends TestCase {

    public EvaluatorTest() {
        JXPathIntrospector.registerDynamicClass(Vertex.class, VertexPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Edge.class, EdgePropertyHandler.class);
    }

    public void testBasicXpath() {
        JXPathContext context = JXPathContext.newContext(null);
        context.setLenient(true);
        assertFalse((Boolean) context.getValue("matches('marko','peter')"));
        assertTrue((Boolean) context.getValue("(((matches('marko','marko'))))"));
        assertTrue((Boolean) context.getValue("matches(\"marko\",\"marko\")"));
        assertEquals("marko", context.getValue("'marko'"));
        assertEquals("marko", context.getValue("\"marko\""));
    }

    public void testGFunctions() {
        TinkerGraph graph = TinkerGraphFactory.createTinkerGraph();
        TinkerVertex marko = graph.getVertex("1");
        assertEquals(marko.getProperty("name"), "marko");

        GremlinPathContext context = GremlinPathContext.newContext(marko);
        context.setLenient(true);

        

        //print(context.iterate("(./outEdges/inVertex)[g:printX()]"));
        //sweep(context.iterate("(./outEdges/inVertex)[g:set('$i')][g:print()]"));
        //System.out.println(context.getContextPath());
        //context.getVariables().declareVariable("$i",new LinkedList<Object>());
        //context.selectNodes("./outEdges/inVertex[g:set('$i')]/@name[g:set('$i')]");
        //System.out.println("--------------------------");
        //print(context.iterate("$i"));
        //System.out.println(context.getContextPath());
        //System.out.println("--------------------------");
        String path = "(((./outEdges/inVertex){2}/outEdges/inVertex){2}/inEdges[g:clip()]){5}";
        //Pattern pattern = Pattern.compile("\\{[0-9]+\\}");
        Pattern pattern = Pattern.compile(".*");
        Matcher matcher = pattern.matcher(path);
        System.out.println(matcher.matches() + "--");
        System.out.println(matcher.toMatchResult().groupCount());
        System.out.println(path.matches(".+\\{[0-9]+\\}.+"));
        /*for(String s : path.split("\\{[0-9]+\\}")) {
            System.out.println(s);
        }*/
        //print(context.iterate(path));

        //print(context.iterate("(1+2)[g:set('$i')]"));
        //print(context.iterate("./outEdges/inVertex/@name"));
        //System.out.println("----------");
        //context.selectNodes("./outEdges[g:halt(10 <= 5)]/inVertex/@name[g:setX(.,'$i')]");
        //context.selectNodes("./outEdges[g:halt(10 > 5)]/inVertex/@age[g:setX(.,'$i')]");
        //System.out.println("-----------------");
        //printList(context.selectNodes("$i"));

        //System.out.println("----------");

        //context.iterate("./outEdges[g:doPrint()]");

        //printList(context.selectNodes("./outEdges/inVertex[g:loop()]"));
    }

    public void testHaltCont() {
        TinkerGraph graph = TinkerGraphFactory.createTinkerGraph();
        TinkerVertex marko = graph.getVertex("1");
        assertEquals(marko.getProperty("name"), "marko");
        JXPathContext context = JXPathContext.newContext(marko);
        context.setLenient(true);

        FunctionLibrary library = new FunctionLibrary();
        library.addFunctions(new ClassFunctions(GremlinFunctions.class, "g"));
        library.addFunctions(context.getFunctions());
        context.setFunctions(library);

        assertEquals(context.selectNodes("(./outEdges/inVertex)[g:set('$i')][g:cont(count($i) = 3)]/name"), context.selectNodes("./outEdges/inVertex/name"));
        context.selectNodes("(./outEdges/inVertex)[g:set('$i')][g:cont(count($i) < 2)]/name[g:set('$i')]");
        assertEquals(context.iterate("$i[g:print()]"), context.iterate("./outEdges/inVertex[g:print()]"));


    }

    public void testSet() {
        TinkerGraph graph = TinkerGraphFactory.createTinkerGraph();
        TinkerVertex marko = graph.getVertex("1");
        assertEquals(marko.getProperty("name"), "marko");
        JXPathContext context = JXPathContext.newContext(marko);
        context.setLenient(true);

        FunctionLibrary library = new FunctionLibrary();
        library.addFunctions(new ClassFunctions(GremlinFunctions.class, "g"));
        library.addFunctions(context.getFunctions());
        context.setFunctions(library);

        assertEquals(context.selectNodes("."), context.selectNodes("."));
        assertEquals(context.selectNodes("./name[g:set('$i')]"), context.selectNodes("./name"));
        assertEquals(context.selectNodes("./name[g:set('$i')]"), context.selectNodes("$i"));
        context.selectNodes("./inEdges[g:set('$i')]");
        assertEquals(context.selectNodes("$i").size(), 1);
        context.selectNodes("(./inEdges)[g:set('$i')]");
        assertEquals(context.selectNodes("$i").size(), 3);       
    }

    public void testNoop() {
        TinkerGraph graph = TinkerGraphFactory.createTinkerGraph();
        TinkerVertex marko = graph.getVertex("1");
        assertEquals(marko.getProperty("name"), "marko");
        JXPathContext context = JXPathContext.newContext(marko);
        context.setLenient(true);

        FunctionLibrary library = new FunctionLibrary();
        library.addFunctions(new ClassFunctions(GremlinFunctions.class, "g"));
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
        TinkerGraph graph = TinkerGraphFactory.createTinkerGraph();
        TinkerVertex marko = graph.getVertex("1");
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
        TinkerGraph graph = TinkerGraphFactory.createTinkerGraph();
        TinkerVertex marko = graph.getVertex("1");
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

    public void testVariableSetting() {
        TinkerGraph graph = TinkerGraphFactory.createTinkerGraph();
        TinkerVertex marko = graph.getVertex("1");
        JXPathContext context = JXPathContext.newContext(null);
        context.iterate("$x");
        context.iterate("$x = 1");
        context.getVariables().declareVariable("x", marko);
        assertEquals(context.getValue("$x/@name"), "marko");

    }

    public static void printList(List list) {
        for(Object o : list) {
            System.out.println(o);
        }
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

    public static void sweep(Iterator itty) {
        while(itty.hasNext()) {
            itty.next();
        }
    }

}
