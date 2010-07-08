package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.functions.Function;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddVertexFunctionTest extends BaseTest {

    public void testAddVertex() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinEvaluator.declareVariable(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));

        Function<Vertex> function = new AddVertexFunction();
        assertEquals(function.getFunctionName(), "add-v");
        this.stopWatch();
        Atom<Vertex> atom = function.compute(createUnaryArgs(graph, "20"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isVertex());
        assertEquals(atom.getValue().getId(), "20");

        this.stopWatch();
        atom = function.compute(createUnaryArgs("21"));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isVertex());
        assertEquals(atom.getValue().getId(), "21");

        Map<Atom, Atom> map = new HashMap<Atom, Atom>();
        map.put(new Atom<String>("name"), new Atom<String>("marko"));
        map.put(new Atom<String>(Tokens.ID), new Atom<String>("22"));
        this.stopWatch();
        atom = function.compute(createUnaryArgs(map));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isVertex());
        assertEquals(atom.getValue().getId(), "22");
        assertEquals(atom.getValue().getProperty("name"), "marko");
        Vertex vertexMarko = atom.getValue();

        map = new HashMap<Atom, Atom>();
        map.put(new Atom<String>("name"), new Atom<String>("pavel"));
        map.put(new Atom<String>(Tokens.ID), new Atom<String>("23"));
        this.stopWatch();
        atom = function.compute(createUnaryArgs(graph, map));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isVertex());
        assertEquals(atom.getValue().getId(), "23");
        assertEquals(atom.getValue().getProperty("name"), "pavel");
        Vertex vertexPavel = atom.getValue();

        GremlinEvaluator.declareVariable(Tokens.GRAPH_VARIABLE, new Atom<Graph>(new TinkerGraph()));
        this.stopWatch();
        atom = function.compute(createUnaryArgs(vertexMarko));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isVertex());
        assertEquals(atom.getValue().getId(), "22");
        assertEquals(atom.getValue().getProperty("name"), "marko");


        this.stopWatch();
        atom = function.compute(createUnaryArgs(graph, vertexPavel));
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isVertex());
        assertEquals(atom.getValue().getId(), "23");
        assertEquals(atom.getValue().getProperty("name"), "pavel");

    }
}
