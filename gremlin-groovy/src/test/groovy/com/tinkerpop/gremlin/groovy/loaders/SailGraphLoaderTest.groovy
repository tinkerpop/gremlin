package com.tinkerpop.gremlin.groovy.loaders

import com.tinkerpop.blueprints.impls.sail.impls.MemoryStoreSailGraph
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class SailGraphLoaderTest extends TestCase {

    public void testNamespacePrefix() {
        SailGraphLoader.load();

        def g = new MemoryStoreSailGraph();
        g.addNamespace('tg', 'http://tinkerpop.com#');
        assertEquals(g.uri('tg:1'), 'http://tinkerpop.com#1');
        assertEquals(g.qn('http://tinkerpop.com#1'), 'tg:1');
    }
}
