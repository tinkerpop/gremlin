package com.tinkerpop.gremlin.compiler.functions.sail;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import org.openrdf.sail.memory.MemoryStore;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class NamespaceFunctionTest extends BaseTest {

    public void testNamespace() {
        SailGraph graph = new SailGraph(new MemoryStore());
        GremlinScriptContext context = new GremlinScriptContext();
        context.getVariableLibrary().declare(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));

        Function<String> function = new NamespaceFunction();
        this.stopWatch();
        Atom<String> atom = function.compute(createUnaryArgs(graph, "rdf:test"), context);
        printPerformance(function.getFunctionName() + " function", 1, "namespace expanded", this.stopWatch());
        assertEquals(atom.getValue(), "http://www.w3.org/1999/02/22-rdf-syntax-ns#test");

        this.stopWatch();
        atom = function.compute(createUnaryArgs("blah:blah"), context);
        printPerformance(function.getFunctionName() + " function", 1, "namespace expanded", this.stopWatch());
        assertEquals(atom.getValue(), "blah:blah");

        graph.shutdown();
    }
}
