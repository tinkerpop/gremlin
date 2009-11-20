package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.*;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.db.tg.TinkerGraph;
import com.tinkerpop.gremlin.db.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.db.tg.TinkerVertex;
import org.apache.commons.jxpath.ClassFunctions;
import org.apache.commons.jxpath.FunctionLibrary;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathIntrospector;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class EvaluatorTest extends BaseTest {

    public EvaluatorTest() {
        JXPathIntrospector.registerDynamicClass(Vertex.class, VertexPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Edge.class, EdgePropertyHandler.class);
    }

    

    public void testGFunctions() {
        TinkerGraph graph = TinkerGraphFactory.createTinkerGraph();
        TinkerVertex marko = graph.getVertex("1");
        assertEquals(marko.getProperty("name"), "marko");

        GremlinPathContext context = (GremlinPathContext)GremlinPathContext.newContext(marko);
        context.setLenient(true);

        

        //printIterator(context.iterate("(./outEdges/inVertex)[g:printX()]"));
        //sweep(context.iterate("(./outEdges/inVertex)[g:set('$i')][g:printIterator()]"));
        //System.out.println(context.getContextPath());
        //context.getVariables().declareVariable("$i",new LinkedList<Object>());
        //context.selectNodes("./outEdges/inVertex[g:set('$i')]/@name[g:set('$i')]");
        //System.out.println("--------------------------");
        //printIterator(context.iterate("$i"));
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
        //printIterator(context.iterate(path));

        //printIterator(context.iterate("(1+2)[g:set('$i')]"));
        //printIterator(context.iterate("./outEdges/inVertex/@name"));
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
        TinkerVertex marko = graph.getVertex("6");
        //assertEquals(marko.getProperty("name"), "marko");
        JXPathContext context = JXPathContext.newContext(marko);
        context.setLenient(true);

        FunctionLibrary library = new FunctionLibrary();
        library.addFunctions(new ClassFunctions(GremlinFunctions.class, "g"));
        library.addFunctions(context.getFunctions());
        context.setFunctions(library);

        //assertEquals(context.selectNodes("(./outEdges/inVertex)[g:set('$i')][g:cont(countIterator($i) = 3)]/name"), context.selectNodes("./outEdges/inVertex/name"));
        //context.selectNodes("(./outEdges/inVertex)[g:set('$i')][g:cont(countIterator($i) < 2)]/name[g:set('$i')]");
//        assertEquals(context.iterate("$i[g:printIterator()]"), context.iterate("./outEdges/inVertex[g:printIterator()]"));

        printList(context.selectNodes("((./outEdges[@label=\"created\"]/inVertex/inEdges[@label=\"created\"]/outVertex/@name)[g:set('$y')]/../@age)[g:set('$z')][g:cont(false())]"));
        printIterator(context.iterate("$y"));
        printIterator(context.iterate("$z"));


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
        TinkerGraph graph = TinkerGraphFactory.createTinkerGraph();
        TinkerVertex marko = graph.getVertex("1");
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
        TinkerGraph graph = TinkerGraphFactory.createTinkerGraph();
        TinkerVertex marko = graph.getVertex("1");
        JXPathContext context = JXPathContext.newContext(null);
        context.iterate("$x");
        context.iterate("$x = 1");
        context.getVariables().declareVariable("x", marko);
        assertEquals(context.getValue("$x/@name"), "marko");

    }



}
