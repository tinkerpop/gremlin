package com.tinkerpop.gremlin.compiler;

import junit.framework.TestCase;

import java.util.*;

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

    public void testAtomHash() {
        Map<Atom, Integer> map = new HashMap<Atom, Integer>();
        map.put(new Atom("marko"), 1);
        map.put(new Atom("marko"), 2);
        map.put(new Atom("pavel"), 3);
        assertEquals(map.size(), 2);
        assertEquals(map.get(new Atom("marko")), new Integer(2));
        assertEquals(map.get(new Atom("pavel")), new Integer(3));

    }

    public void testAtomInheritance() {
        LinkedHashMap map1 = new LinkedHashMap();
        assertTrue(new Atom(map1).isMap());
        HashMap map2 = new HashMap();
        assertTrue(new Atom(map2).isMap());
        LinkedList list1 = new LinkedList();
        assertTrue(new Atom(list1).isList());
        ArrayList list2 = new ArrayList();
        assertTrue(new Atom(list2).isList());
    }
}
