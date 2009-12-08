package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.db.BaseGraphTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerGraphTest extends BaseGraphTest {

    public void testAddVertex() {
        BaseGraphTest.testAddVertexStringId(new TinkerGraph());
    }

    public void testRemoveVertex() {
        BaseGraphTest.testRemoveVertexStringId(new TinkerGraph());
        BaseGraphTest.testRemoveVertexNullId(new TinkerGraph());
    }

    public void testRemoveVertexEdges() {
        BaseGraphTest.testRemoveVertexEdges(new TinkerGraph());
    }

    public void testVertexIterator() {
        super.testVertexIterator(TinkerGraphFactory.createTinkerGraph());
    }

    public void testEdgeIterator() {
        super.testEdgeIterator(TinkerGraphFactory.createTinkerGraph());
    }

    public void testEdgeIterator2() {
        BaseGraphTest.testEdgeIterator2SelfLoops(new TinkerGraph());
        BaseGraphTest.testEdgeIterator2NoSelfLoops(new TinkerGraph());
    }
}
