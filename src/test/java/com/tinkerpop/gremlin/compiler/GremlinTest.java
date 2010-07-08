package com.tinkerpop.gremlin.compiler;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.Gremlin;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinTest extends BaseTest {

    public void testBasicMathStatements() throws Exception {
        this.stopWatch();
        String script = "1 + 2";
        List results = asList(Gremlin.evaluate(script));
        printPerformance(script, 1, "iterator listed", this.stopWatch());
        assertEquals(results.size(), 1);
        assertEquals(results.get(0), 3);

        this.stopWatch();
        script = "1 div (2 * 2)";
        results = asList(Gremlin.evaluate(script));
        printPerformance(script, 1, "iterator listed", this.stopWatch());
        assertEquals(results.size(), 1);
        assertEquals(results.get(0).getClass(), Double.class);
        assertEquals(results.get(0), 0.25d);

        this.stopWatch();
        script = "(1l - 2) * 2.0d";
        results = asList(Gremlin.evaluate(script));
        printPerformance(script, 1, "iterator listed", this.stopWatch());
        assertEquals(results.size(), 1);
        assertEquals(results.get(0), -2.0d);

        this.stopWatch();
        script = "2 + (4l * 2.0d) - 7";
        results = asList(Gremlin.evaluate(script));
        printPerformance(script, 1, "iterator listed", this.stopWatch());
        assertEquals(results.size(), 1);
        assertEquals(results.get(0), 3.0d);
    }

    public void testBasicGraphStatements() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinEvaluator.declareVariable(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        GremlinEvaluator.declareVariable(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        this.stopWatch();
        String script = "./outE/inV";
        Iterable itty = (Iterable) Gremlin.evaluate(script).iterator().next();
        printPerformance(script, 1, "pipe constructed", this.stopWatch());
        this.stopWatch();
        List<Vertex> results = asList(itty);
        printPerformance(script, 1, "pipe listed", this.stopWatch());
        assertEquals(results.size(), 3);
        String name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
        name = (String) results.get(1).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
        name = (String) results.get(2).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));

        this.stopWatch();
        script = "./outE[@label='created' or @label='knows']/inV";
        itty = (Iterable) Gremlin.evaluate(script).iterator().next();
        printPerformance(script, 1, "pipe constructed", this.stopWatch());
        this.stopWatch();
        results = asList(itty);
        printPerformance(script, 1, "pipe listed", this.stopWatch());
        assertEquals(results.size(), 3);
        name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
        name = (String) results.get(1).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));
        name = (String) results.get(2).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));

        this.stopWatch();
        script = "./outE[@label='created']/inV";
        itty = (Iterable) Gremlin.evaluate(script).iterator().next();
        printPerformance(script, 1, "pipe constructed", this.stopWatch());
        this.stopWatch();
        results = asList(itty);
        printPerformance(script, 1, "pipe listed", this.stopWatch());
        assertEquals(results.size(), 1);
        name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("lop"));

        this.stopWatch();
        script = "./outE[@label='knows']/inV";
        itty = (Iterable) Gremlin.evaluate(script).iterator().next();
        printPerformance(script, 1, "pipe constructed", this.stopWatch());
        this.stopWatch();
        results = asList(itty);
        printPerformance(script, 1, "pipe listed", this.stopWatch());
        assertEquals(results.size(), 2);
        name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("josh") || name.equals("vadas"));
        name = (String) results.get(1).getProperty("name");
        assertTrue(name.equals("josh") || name.equals("vadas"));

    }

    public void testHistoryOnGraph() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinEvaluator.declareVariable(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        GremlinEvaluator.declareVariable(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        this.stopWatch();
        String script = "./outE/inV/../..";
        Iterable itty = (Iterable) Gremlin.evaluate(script).iterator().next();
        printPerformance(script, 1, "pipe constructed", this.stopWatch());
        this.stopWatch();
        List<Vertex> results = asList(itty);
        printPerformance(script, 1, "pipe listed", this.stopWatch());
        assertEquals(results.size(), 1);
        String name = (String) results.get(0).getProperty("name");
        assertEquals(name, "marko");

        this.stopWatch();
        script = "./outE/inV/../../..";
        itty = (Iterable) Gremlin.evaluate(script).iterator().next();
        printPerformance(script, 1, "pipe constructed", this.stopWatch());
        assertNull(itty);

        this.stopWatch();
        script = "./outE/inV/outE/inV/../..";
        itty = (Iterable) Gremlin.evaluate(script).iterator().next();
        printPerformance(script, 1, "pipe constructed", this.stopWatch());
        this.stopWatch();
        results = asList(itty);
        printPerformance(script, 1, "pipe listed", this.stopWatch());
        assertEquals(results.size(), 1);
        name = (String) results.get(0).getProperty("name");
        assertEquals(name, "josh");

        this.stopWatch();
        script = "./outE/inV/outE/inV[@name='lop']/../..";
        itty = (Iterable) Gremlin.evaluate(script).iterator().next();
        printPerformance(script, 1, "pipe constructed", this.stopWatch());
        this.stopWatch();
        results = asList(itty);
        printPerformance(script, 1, "pipe listed", this.stopWatch());
        assertEquals(results.size(), 1);
        name = (String) results.get(0).getProperty("name");
        assertEquals(name, "josh");

        this.stopWatch();
        script = "./outE/inV/outE/inV[@name='ripple']/../..";
        itty = (Iterable) Gremlin.evaluate(script).iterator().next();
        printPerformance(script, 1, "pipe constructed", this.stopWatch());
        this.stopWatch();
        results = asList(itty);
        printPerformance(script, 1, "pipe listed", this.stopWatch());
        assertEquals(results.size(), 1);
        name = (String) results.get(0).getProperty("name");
        assertEquals(name, "josh");

        this.stopWatch();
        script = "./outE/inV/outE/inV[@name='ripple' or @name='lop' or @name='blah']/../../outE/inV";
        itty = (Iterable) Gremlin.evaluate(script).iterator().next();
        printPerformance(script, 1, "pipe constructed", this.stopWatch());
        this.stopWatch();
        results = asList(itty);
        printPerformance(script, 1, "pipe listed", this.stopWatch());
        assertEquals(results.size(), 2);
        name = (String) results.get(0).getProperty("name");
        assertTrue(name.equals("ripple") || name.equals("lop"));

    }

}
