package com.tinkerpop.gremlin.test.sideeffect;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.Table;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TableStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_asXaX_out_properyXnameX_asXbX_table_cap(final Pipe<Vertex, Table> pipe) {
        while (pipe.hasNext()) {
            System.out.println(pipe.next());
        }
    }

    public void test_g_v1_asXaX_out_asXbX_tableXnameX_cap(final Pipe<Vertex, Table> pipe) {
        while (pipe.hasNext()) {
            System.out.println(pipe.next());
        }
    }
}