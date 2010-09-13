package com.tinkerpop.gremlin.functions.g.ime;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.Function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GetFunctionTest extends BaseTest {

    public void testGet() {
        GremlinScriptContext context = new GremlinScriptContext();

        Function<Object> function = new GetFunction();
        List list = Arrays.asList("pavel", 23);
        Map map = new HashMap();
        map.put("name", "pavel");
        map.put("id", "23");
        Vertex vertex = TinkerGraphFactory.createTinkerGraph().getVertex(1);

        this.stopWatch();
        Atom<Object> atom = function.compute(createUnaryArgs(list, 1), context);
        printPerformance(function.getFunctionName() + " function", 1, "list get", this.stopWatch());
        assertEquals(atom.getValue(), 23);

        this.stopWatch();
        atom = function.compute(createUnaryArgs(map, "name"), context);
        printPerformance(function.getFunctionName() + " function", 1, "map get", this.stopWatch());
        assertEquals(atom.getValue(), "pavel");

        this.stopWatch();
        atom = function.compute(createUnaryArgs(vertex, "name"), context);
        printPerformance(function.getFunctionName() + " function", 1, "vertex get", this.stopWatch());
        assertEquals(atom.getValue(), "marko");

        try {
            function.compute(createUnaryArgs(list, "bad"), context);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }

    }

    public void testGetInline() throws Exception {
        Object result = evaluateGremlinScriptPrimitive("g:get(g:list(1,2,3),1)", true);
        assertEquals(result, 2);
        result = evaluateGremlinScriptPrimitive("g:get(g:list(1,2,3),g:get(g:list(1,2,3),0))", true);
        assertEquals(result, 2);
        result = evaluateGremlinScriptPrimitive("g:get(g:map('marko',1,'pavel',2),'marko')", true);
        assertEquals(result, 1);
    }
}
