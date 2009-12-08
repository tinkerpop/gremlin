package com.tinkerpop.gremlin.db.neo;

import com.tinkerpop.gremlin.db.BaseGraphTest;

import java.io.File;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class NeoGraphTest extends BaseGraphTest {

    private static final String NEO_TEST_DIRECTORY = "/tmp/neo-tests";

    public void testAddVertexNumberId() {
        deleteGraphDirectory(new File(NEO_TEST_DIRECTORY));
        BaseGraphTest.testAddVertexNumberId(new NeoGraph(NEO_TEST_DIRECTORY));
    }

    public void testRemoveVertexNumberId() {
        deleteGraphDirectory(new File(NEO_TEST_DIRECTORY));
        BaseGraphTest.testRemoveVertexNullId(new NeoGraph(NEO_TEST_DIRECTORY));
    }

    public void testRemoveVertexEdges() {
        deleteGraphDirectory(new File(NEO_TEST_DIRECTORY));
        BaseGraphTest.testRemoveVertexEdges(new NeoGraph(NEO_TEST_DIRECTORY));
    }

    public void testEdgeIterator2() {
        deleteGraphDirectory(new File(NEO_TEST_DIRECTORY));
        BaseGraphTest.testEdgeIterator2NoSelfLoops(new NeoGraph(NEO_TEST_DIRECTORY));
    }

    public void testLongIdConversions() {
        String id1 = "100";  // good  100
        String id2 = "100.0"; // good 100
        String id3 = "100.1"; // good 100
        String id4 = "one"; // bad

        try {
            Double.valueOf(id1).longValue();
            assertTrue(true);
        } catch(NumberFormatException e) {
            assertFalse(true);
        }
        try {
            Double.valueOf(id2).longValue();
            assertTrue(true);
        } catch(NumberFormatException e) {
            assertFalse(true);
        }
        try {
            Double.valueOf(id3).longValue();
            assertTrue(true);
        } catch(NumberFormatException e) {
            assertFalse(true);
        }
        try {
            Double.valueOf(id4).longValue();
            assertTrue(false);
        } catch(NumberFormatException e) {
            assertFalse(false);
        }

    }

    private void deleteGraphDirectory(File directory) {
        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    deleteGraphDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
    }
}
