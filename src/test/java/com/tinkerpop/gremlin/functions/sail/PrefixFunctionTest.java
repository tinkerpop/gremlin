package com.tinkerpop.gremlin.functions.sail;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph;
import com.tinkerpop.blueprints.pgm.impls.sail.impls.MemoryStoreSailGraph;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.Tokens;
import com.tinkerpop.gremlin.functions.Function;

import javax.script.ScriptContext;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PrefixFunctionTest extends BaseTest {

    public void testPrefix() {
        SailGraph graph = new MemoryStoreSailGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));

        Function<String> function = new PrefixFunction();
        this.stopWatch();
        Atom<String> atom = function.compute(createUnaryArgs(graph, "http://www.w3.org/1999/02/22-rdf-syntax-ns#test"), context);
        printPerformance(function.getFunctionName() + " function", 1, "namespace prefixed", this.stopWatch());
        assertEquals(atom.getValue(), "rdf:test");

        this.stopWatch();
        atom = function.compute(createUnaryArgs("blah:blah"), context);
        printPerformance(function.getFunctionName() + " function", 1, "namespace prefixed", this.stopWatch());
        assertEquals(atom.getValue(), "blah:blah");

        graph.shutdown();
    }
}