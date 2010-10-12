package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.pipes.Pipe;

import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ScatterPipeTest extends BaseTest {

    public void testScatterPipe() {
        Pipe scatter = new ScatterPipe();
        scatter.setStarts(Arrays.asList(Arrays.asList(1, 2, 3)));
        int counter = 0;
        while (scatter.hasNext()) {
            Object object = scatter.next();
            assertTrue(object.equals(1) || object.equals(2) || object.equals(3));
            counter++;
        }
        assertEquals(counter, 3);
    }
}
