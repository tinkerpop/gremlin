package com.tinkerpop.gremlin.compiler.functions.sail;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph;
import com.tinkerpop.blueprints.pgm.impls.sail.SailGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.functions.Function;
import org.openrdf.sail.memory.MemoryStore;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SparqlFunctionTest extends BaseTest {

    public void testSparql() {
        SailGraph graph = SailGraphFactory.createTinkerGraph(new MemoryStore());
        GremlinEvaluator.declareVariable(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        Function<List<Atom<Map<Atom<String>, Atom<Vertex>>>>> function = new SparqlFunction();
        this.stopWatch();
        Atom<List<Atom<Map<Atom<String>, Atom<Vertex>>>>> atom = function.compute(createUnaryArgs(graph, "SELECT ?x ?y WHERE { ?x tg:knows ?y }"));
        printPerformance(function.getFunctionName() + " function", 2, "binding values", this.stopWatch());
        System.out.println(atom);
        graph.shutdown();
    }
}
