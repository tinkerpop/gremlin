package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.pipes.filter.FilterPipe;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BooleanFilterPipeTest extends BaseTest {
    public void testBooleanFilter() {
        List<String> list = Arrays.asList("marko", "povel", "peter", "josh");
        FilterPipe<String> pipe = new BooleanFilterPipe<String>(false);
        pipe.setStarts(list);
        int counter = 0;
        for (String name : pipe) {
            counter++;
        }
        assertEquals(counter, list.size());

        pipe = new BooleanFilterPipe<String>(true);
        pipe.setStarts(list);
        counter = 0;
        for (String name : pipe) {
            counter++;
        }
        assertEquals(counter, 0);

    }
}
