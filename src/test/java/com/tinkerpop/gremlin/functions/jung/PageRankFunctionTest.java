package com.tinkerpop.gremlin.functions.jung;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.compiler.util.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

import javax.script.ScriptContext;
import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PageRankFunctionTest extends JungTest {

    public void testOnlyAlphaParameter() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));

        Function<Map<Vertex, Double>> function = new PageRankFunction();
        this.stopWatch();
        Atom<Map<Vertex, Double>> atom = function.compute(this.createUnaryArgs(), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isMap());
        Map map = atom.getValue();
        assertEquals(this.getHighestRankVertex(map).getId(), "3");
        assertTrue(this.getLowestRankVertex(map).getId().equals("6") || this.getLowestRankVertex(map).getId().equals("1"));

        function = new PageRankFunction();
        this.stopWatch();
        Map parameters = new HashMap();
        parameters.put("alpha", 1.0);
        atom = function.compute(this.createUnaryArgs(graph, parameters), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isMap());
        map = atom.getValue();
        Set ranks = new HashSet();
        for (Vertex key : (Set<Vertex>) map.keySet()) {
            ranks.add(map.get(key));
        }
        assertEquals(ranks.size(), 1);
    }

    public void testOnlyLabelFilter() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        Map parameters = new HashMap();
        parameters.put("labels", Arrays.asList("knows"));
        Function<Map<Vertex, Double>> function = new PageRankFunction();
        this.stopWatch();
        Atom<Map<Vertex, Double>> atom = function.compute(this.createUnaryArgs(graph, parameters), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isMap());
        Map map = atom.getValue();
        assertTrue(this.getHighestRankVertex(map).getId().equals("2") || this.getHighestRankVertex(map).getId().equals("4"));
    }

    public void testOnlyLabelWeightFilter() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        Map parameters = new HashMap();
        parameters.put("weight-key", "weight");
        parameters.put("normalize", true);
        parameters.put("labels", Arrays.asList("knows"));
        Function<Map<Vertex, Double>> function = new PageRankFunction();
        this.stopWatch();
        Atom<Map<Vertex, Double>> atom = function.compute(this.createUnaryArgs(parameters), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isMap());
        Map map = atom.getValue();
        assertTrue(this.getHighestRankVertex(map).getId().equals("4"));
    }
}


