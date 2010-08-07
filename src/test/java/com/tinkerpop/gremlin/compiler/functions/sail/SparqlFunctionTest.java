package com.tinkerpop.gremlin.compiler.functions.sail;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph;
import com.tinkerpop.blueprints.pgm.impls.sail.SailGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;
import org.openrdf.sail.memory.MemoryStore;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SparqlFunctionTest extends BaseTest {

    public void testSparql() {
        SailGraph graph = SailGraphFactory.createTinkerGraph(new MemoryStore());
        GremlinScriptContext context = new GremlinScriptContext();
        context.getVariableLibrary().declare(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        
        Function<List<Map<String, Vertex>>> function = new SparqlFunction();
        String query = "SELECT ?x ?y WHERE { ?x tg:knows ?y }";
        this.stopWatch();
        Atom<List<Map<String, Vertex>>> atom = function.compute(createUnaryArgs(graph, query), context);
        printPerformance(function.getFunctionName() + " function", 1, query, this.stopWatch());
        List<Map<String, Vertex>> results = atom.getValue();
        assertEquals(results.size(), 2);
        for (Map<String, Vertex> map : results) {
            assertEquals(map.get("x"), graph.getVertex("tg:1"));
            assertTrue(map.get("y").equals(graph.getVertex("tg:2")) || map.get("y").equals(graph.getVertex("tg:4")));
        }
        graph.shutdown();
    }
}
