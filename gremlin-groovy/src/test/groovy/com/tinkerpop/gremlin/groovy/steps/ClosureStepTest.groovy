package com.tinkerpop.gremlin.groovy.steps

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.pipes.Pipe
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ClosureStepTest extends TestCase {

    public void testIsPipe() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertTrue(g.V.step {true} instanceof Pipe)
    }

    public void testStepCreation() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        //todo: make this work
        //Gremlin.defineStep('coDeveloper', [Pipe, Vertex], { _().sideEffect {def x = it}.outE[[label: 'created']].inV.inE[[label: 'created']].outV.filter{ x != it} });
        Gremlin.defineStep('coDeveloper', [Pipe, Vertex], {def x; _().sideEffect {x = it}.outE[[label: 'created']].inV.inE[[label: 'created']].outV.filter { x != it} });


        def list = []
        System.out.println(g.v(1).coDeveloper.toString());
        g.v(1).coDeveloper >> list
        assertTrue(list.contains(g.v(4)));
        assertTrue(list.contains(g.v(6)));
    }

    public void testSMethod() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        def results = [];
        g.v(1).outE.inV.step {it.next().name} >> results
        assertTrue(results.contains("josh"))
        assertTrue(results.contains("lop"))
        assertTrue(results.contains("vadas"))
        assertEquals(results.size(), 3)
    }
}
