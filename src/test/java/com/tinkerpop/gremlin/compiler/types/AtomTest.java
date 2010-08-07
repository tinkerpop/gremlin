package com.tinkerpop.gremlin.compiler.types;

import junit.framework.TestCase;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AtomTest extends TestCase {

    public void testAtomEquality() {
        assertEquals(new Atom<String>("marko"), new Atom<String>("marko"));
        assertEquals(new Atom<Integer>(1), new Atom<Integer>(1));
        assertNotSame(new Atom<String>("marko"), new Atom<String>("pavel"));
        assertNotSame(new Atom<Integer>(1), new Atom<Long>(1l));
    }

    public void testAtomHash() {
        Map<Atom, Integer> map = new HashMap<Atom, Integer>();
        map.put(new Atom<String>("marko"), 1);
        map.put(new Atom<String>("marko"), 2);
        map.put(new Atom<String>("pavel"), 3);
        assertEquals(map.size(), 2);
        assertEquals(map.get(new Atom<String>("marko")), new Integer(2));
        assertEquals(map.get(new Atom<String>("pavel")), new Integer(3));

    }

    public void testAtomInheritance() {
        LinkedHashMap map1 = new LinkedHashMap();
        assertTrue(new Atom<Map>(map1).isMap());
        HashMap map2 = new HashMap();
        assertTrue(new Atom<Map>(map2).isMap());
        LinkedList list1 = new LinkedList();
        assertTrue(new Atom<List>(list1).isIterable());
        ArrayList list2 = new ArrayList();
        assertTrue(new Atom<List>(list2).isIterable());
        HashSet set1 = new HashSet();
        assertTrue(new Atom<Set>(set1).isIterable());
    }
}
