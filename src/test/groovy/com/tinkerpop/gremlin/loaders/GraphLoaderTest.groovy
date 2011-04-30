package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens.T
import com.tinkerpop.pipes.PipeHelper
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GraphLoaderTest extends TestCase {
    public void testVertexEdgeShortcuts() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        assertEquals(PipeHelper.counter(g.V), 6);
        assertTrue(["1", "2", "3", "4", "5", "6"].contains(g.V['id'][0] >> 1));
        assertTrue(["1", "2", "3", "4", "5", "6"].contains(g.V.id[1] >> 1));
        assertTrue(["1", "2", "3", "4", "5", "6"].contains(g.V['id'][2] >> 1));
        assertTrue(["1", "2", "3", "4", "5", "6"].contains(g.V.id[3] >> 1));
        assertTrue(["1", "2", "3", "4", "5", "6"].contains(g.V['id'][4] >> 1));
        assertTrue(["1", "2", "3", "4", "5", "6"].contains(g.V.id[5] >> 1));

        assertEquals(PipeHelper.counter(g.E), 6);
        assertTrue(["7", "8", "9", "10", "11", "12"].contains(g.E['id'][0] >> 1));
        assertTrue(["7", "8", "9", "10", "11", "12"].contains(g.E.id[1] >> 1));
        assertTrue(["7", "8", "9", "10", "11", "12"].contains(g.E['id'][2] >> 1));
        assertTrue(["7", "8", "9", "10", "11", "12"].contains(g.E.id[3] >> 1));
        assertTrue(["7", "8", "9", "10", "11", "12"].contains(g.E['id'][4] >> 1));
        assertTrue(["7", "8", "9", "10", "11", "12"].contains(g.E.id[5] >> 1));
    }

    public void testIdAndLabelProperties() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        assertEquals(g.v(1).id, "1");
        assertEquals(g.v(1)['id'], "1");

        assertEquals(PipeHelper.counter(g.v(1).outE.inV.id), 3);
        assertTrue(["2", "3", "4"].contains(g.v(1).outE.inV.id[0] >> 1));
        assertTrue(["2", "3", "4"].contains(g.v(1).outE.inV.id[1] >> 1));
        assertTrue(["2", "3", "4"].contains(g.v(1).outE.inV.id[2] >> 1));

        assertEquals(PipeHelper.counter(g.v(1).outE.label), 3);
        assertTrue(["created", "knows"].contains(g.v(1).outE.label[0] >> 1));
        assertTrue(["created", "knows"].contains(g.v(1).outE.label[1] >> 1));
        assertTrue(["created", "knows"].contains(g.v(1).outE.label[2] >> 1));
    }

    public void testBasicGraphStatements() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        assertEquals(PipeHelper.counter(g.v(1).outE.inV), 3);
        assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE.inV[0].name >> 1));
        assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE.inV[1].name >> 1));
        assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE.inV[2].name >> 1));

        assertEquals(PipeHelper.counter(g.v(1).outE {it.label == 'created' | it.label == 'knows'}.inV), 3);
        assertEquals(PipeHelper.counter(g.v(1).outE.orFilter(_()[[label: 'created']], _()[[label: 'knows']]).inV), 3);
        assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE {it.label == 'created' | it.label == 'knows'}.inV[0].name >> 1));
        assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE {it.label == 'created' | it.label == 'knows'}.inV[1].name >> 1));
        assertTrue(["vadas", "josh", "lop"].contains(g.v(1).outE {it.label == 'created' | it.label == 'knows'}.inV[2].name >> 1));

        assertEquals(g.v(1).outE[[label: 'created']].inV['name'][0].next(), "lop");
        assertEquals(PipeHelper.counter(g.v(1).outE[[label: 'knows']].inV), 2);
        assertTrue(["vadas", "josh"].contains(g.v(1).outE[[label: 'knows']].inV[0].name >> 1));
        assertTrue(["vadas", "josh"].contains(g.v(1).outE[[label: 'knows']].inV[1].name >> 1));

        assertEquals(PipeHelper.counter(g.v(1).outE[[weight: [T.gte, 0.5f]]].inV), 2);
        assertTrue(["vadas", "josh"].contains(g.v(1).outE[[weight: [T.gte, 0.5f]]].inV[0].name >> 1));
        assertTrue(["vadas", "josh"].contains(g.v(1).outE[[weight: [T.gte, 0.5f]]].inV[1].name >> 1));

        assertEquals(PipeHelper.counter(g.v(1).outE {it.weight >= g.v(1).outE['weight'][0] >> 1}.inV), 2);
        assertTrue(["vadas", "josh"].contains(g.v(1).outE {it.weight >= g.v(1).outE['weight'][0] >> 1}.inV[0].name >> 1));
        assertTrue(["vadas", "josh"].contains(g.v(1).outE[[weight: [T.gte, g.v(1).outE['weight'][0] >> 1]]].inV[1].name >> 1));

        assertEquals(PipeHelper.counter(g.v(1).inE), 0);
        assertEquals(PipeHelper.counter(g.v(1).outE.inV[[blah: [T.neq, null]]]), 0)
        assertEquals(PipeHelper.counter(g.v(1).outE.inV[[blah: null]]), 3)

        def results = [];
        g.v(1).outE('knows').inV.name >> results;
        assertEquals(results.size(), 2)
        assertTrue(results.contains('josh'))
        assertTrue(results.contains('vadas'))
        results = [];
        g.v(1).outE('created').inV.name >> results;
        assertEquals(results.size(), 1)
        assertTrue(results.contains('lop'))

        results = [];
        g.v(3).inE('created') {it.weight > 0.3}.outV.name >> results;
        assertEquals(results.size(), 2)
        assertTrue(results.contains('marko'))
        assertTrue(results.contains('josh'))
    }

    public void testAddVertexAndEdgeOverloading() throws Exception {
        Gremlin.load();
        Graph g = new TinkerGraph();
        Vertex v0 = g.addVertex(null, [name: 'marko', age: 31]);
        assertEquals(v0.getProperty('name'), 'marko');
        assertEquals(v0.getProperty('age'), 31);

        Vertex v1 = g.addVertex([name: 'pavel', location: 'belarus']);
        assertEquals(v1.getProperty('name'), 'pavel');
        assertEquals(v1.getProperty('location'), 'belarus');

        Vertex v2 = g.addVertex(null);
        assertEquals(v2.getPropertyKeys().size(), 0);

        Edge e0 = g.addEdge(null, v0, v1, 'knows', [weight: 0.5f]);
        assertEquals(e0.getOutVertex(), v0);
        assertEquals(e0.getInVertex(), v1);
        assertEquals(e0.getLabel(), 'knows');
        assertEquals(e0.getProperty('weight'), 0.5f);

        Edge e1 = g.addEdge(v0, v2, 'hates', [degree: 'alot']);
        assertEquals(e1.getOutVertex(), v0);
        assertEquals(e1.getInVertex(), v2);
        assertEquals(e1.getLabel(), 'hates');
        assertNull(e1.getProperty('weight'));
        assertEquals(e1.getProperty('degree'), 'alot');

        Edge e2 = g.addEdge(v1, v2, 'feels_nothing');
        assertEquals(e2.getOutVertex(), v1);
        assertEquals(e2.getInVertex(), v2);
        assertEquals(e2.getLabel(), 'feels_nothing');
        assertEquals(e2.getPropertyKeys().size(), 0);

        Edge e3 = g.addEdge(null, v2, v0, 'blah');
        assertEquals(e3.getOutVertex(), v2);
        assertEquals(e3.getInVertex(), v0);
        assertEquals(e3.getLabel(), 'blah');
        assertEquals(e3.getPropertyKeys().size(), 0);

        Vertex v3 = g.addVertex();


    }
}
