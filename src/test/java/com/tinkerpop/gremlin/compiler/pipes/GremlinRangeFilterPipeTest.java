package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.Pipeline;
import com.tinkerpop.pipes.SingleIterator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinRangeFilterPipeTest extends BaseTest {

    public void testEmbeddedIterator() {
        List list = Arrays.asList(1, 2, Arrays.asList(3, 4), 5);
        Pipe pipe = new GremlinRangeFilterPipe(Arrays.asList(2));
        pipe.setStarts(list);
        while (pipe.hasNext()) {
            Object object = pipe.next();
            assertTrue(object.equals(3) || object.equals(4));
        }

    }

    public void testMapIterator() {
        Map map = new HashMap();
        map.put("marko", Arrays.asList(3, 4));
        Pipe pipe1 = new GremlinPropertyPipe("marko");
        Pipe pipe2 = new GremlinRangeFilterPipe(Arrays.asList(1));
        Pipe pipeline = new Pipeline(pipe1, pipe2);
        pipeline.setStarts(Arrays.asList(map));
        assertTrue(pipeline.hasNext());
        while (pipeline.hasNext()) {
            Object object = pipeline.next();
            assertEquals(object, 4);
        }
    }
}
