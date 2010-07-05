package com.tinkerpop.gremlin.compiler;

import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AtomTest extends TestCase {

    public void testAtomEquality() {
        assertEquals(new Atom("marko"), new Atom("marko"));
        assertEquals(new Atom(1), new Atom(1));
        assertNotSame(new Atom("marko"), new Atom("pavel"));
        assertNotSame(new Atom(1), new Atom(1l));

    }
}
