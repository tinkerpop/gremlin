package com.tinkerpop.gremlin.functions;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.Tokens;
import org.antlr.runtime.RecognitionException;

import javax.script.ScriptContext;
import java.util.Map;

/**
 * @author Pavel A. Yaskevich
 */
public class NativeFunctionTest extends BaseTest {

    private final GremlinScriptContext context = new GremlinScriptContext();

    /**
     * func x:y($i)
     * 1 + $i
     * end
     *
     * @throws RecognitionException "when statement is invalid"
     */
    public void testFunctionStatements() throws RecognitionException {
        assertTrue((Boolean) this.evaluateGremlinScriptPrimitive("func x:y($i)\n1 + $i\nend", context, false));
        assertEquals(this.evaluateGremlinScriptPrimitive("x:y(1)", context, true), 2);
    }

    /**
     * func x:y($x, $y)
     * $x + $y
     * end
     *
     * @throws RecognitionException "when statement is invalid"
     */
    public void testFunctionWithOneArgument() throws RecognitionException {
        assertTrue((Boolean) this.evaluateGremlinScriptPrimitive("func x:y($x, $y)\n$x + $y\nend", context, false));
        assertEquals(this.evaluateGremlinScriptPrimitive("x:y(1,2)", context, true), 3);
    }

    /**
     * func x:y()
     * true
     * end
     *
     * @throws RecognitionException "when statement is invalid"
     */
    public void testFunctionWithoutArguments() throws RecognitionException {
        assertTrue((Boolean) this.evaluateGremlinScriptPrimitive("func x:y()\ntrue\nend", context, false));
        assertEquals(this.evaluateGremlinScriptPrimitive("x:y()", context, true), true);
    }

    /**
     * func x:y($x)
     * $x
     * end
     * func x:z()
     * $x := 1
     * end
     *
     * @throws RecognitionException "when statement is invalid"
     */
    public void testFunctionInclusion() throws RecognitionException {
        assertTrue((Boolean) this.evaluateGremlinScriptPrimitive("func x:y($x)\n$x\nend\nfunc x:z()\n$x := 1\nend", context, false));
        assertEquals(this.evaluateGremlinScriptPrimitive("x:y(x:z())", context, true), 1);
    }

    /**
     * - Test for functions with equal names
     * <p/>
     * func x:y($x)
     * $x
     * end
     * func z:y()
     * 1
     * end
     * <p/>
     * func x:y($x)
     * $x + 1
     * end
     * func z:y()
     * 2
     * end
     *
     * @throws RecognitionException "when statement is invalid"
     */
    public void testFunctionsWithEqualNames() throws RecognitionException {
        assertTrue((Boolean) this.evaluateGremlinScriptPrimitive("func x:y($x)\n$x\nend\nfunc z:y()\n1\nend", context, false));
        assertEquals(this.evaluateGremlinScriptPrimitive("x:y(2)", context, true), 2);
        assertEquals(this.evaluateGremlinScriptPrimitive("z:y()", context, true), 1);

        assertTrue((Boolean) this.evaluateGremlinScriptPrimitive("func x:y($x)\n$x + 1\nend\nfunc z:y()\n2\nend", context, false));
        assertEquals(this.evaluateGremlinScriptPrimitive("x:y(2)", context, true), 3);
        assertEquals(this.evaluateGremlinScriptPrimitive("z:y()", context, true), 2);
    }

    /**
     * func x:y($x)
     * foreach $i in g:list(1, 2)
     * $x := $x + $i
     * end
     * <p/>
     * $x
     * end
     *
     * @throws RecognitionException "when statement is invalid"
     */
    public void testFunctionWithSequance() throws RecognitionException {
        assertTrue((Boolean) this.evaluateGremlinScriptPrimitive("func x:y($x)\nforeach $i in g:list(1, 2)\n$x := $x+$i\nend\n$x\nend", context, false));
        assertEquals(this.evaluateGremlinScriptPrimitive("x:y(1)", context, true), 4);
    }

    /**
     * func x:y()
     * g:map(1, 2)
     * end
     *
     * @throws RecognitionException "when statement is invalid"
     */
    public void testFunctionReturnsMap() throws RecognitionException {
        assertTrue((Boolean) this.evaluateGremlinScriptPrimitive("func x:y()\ng:map(1, 2)\nend", context, false));
        Map result = (Map) this.evaluateGremlinScriptPrimitive("x:y()", context, true);
        assertNotNull(result);
        assertEquals(result.size(), 1);
        assertEquals(result.get(1), 2);
    }

    /**
     * func g:sum-iterval($n, $m)
     * $i := $n
     * $sum := 0
     * <p/>
     * while $i <= $m
     * $sum := $sum + $i
     * $i := $i + 1
     * end
     * <p/>
     * $sum
     * end
     *
     * @throws RecognitionException "when statement is invalid"
     */
    public void testExtendedFunctionSupport() throws RecognitionException {
        assertTrue((Boolean) this.evaluateGremlinScriptPrimitive("func g:sum-interval($n, $m)\n$i := $n\n$sum := 0\nwhile $i <= $m\n$sum := $sum + $i\n$i := $i + 1\nend\n$sum\nend", context, false));
        assertEquals(this.evaluateGremlinScriptPrimitive("g:sum-interval(1, 3)", context, true), 6);
        assertEquals(this.evaluateGremlinScriptPrimitive("g:sum-interval(1, 4)", context, true), 10);
        assertEquals(this.evaluateGremlinScriptPrimitive("g:sum-interval(1, 6)", context, true), 21);
    }

    /**
     * func g:vadas-edge($edges)
     * <p/>
     * foreach $edge in $edges
     * if $edge/inV/@name = 'vadas'
     * $result := $edge
     * end
     * end
     * <p/>
     * $result
     * end
     *
     * @throws RecognitionException "when statement is invalid"
     */
    public void testNativeFunctionWorkWithGPath() throws RecognitionException {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        assertTrue((Boolean) this.evaluateGremlinScriptPrimitive("func g:vadas-edge($edges)\nforeach $edge in $edges\nif $edge/inV/@name = 'vadas'\n$result := $edge\nend\nend\n$result\nend", context, false));
        assertEquals(this.evaluateGremlinScriptPrimitive("g:vadas-edge(./outE)", context, true), graph.getEdge("7"));
        assertEquals(this.evaluateGremlinScriptPrimitive("g:vadas-edge(./outE[0..2])", context, true), graph.getEdge("7"));
        assertNull(this.evaluateGremlinScriptPrimitive("g:vadas-edge(g:list())", context, true));
    }
}
