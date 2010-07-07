package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.pipes.IdentityPipe;
import com.tinkerpop.pipes.filter.CollectionFilterPipe;
import com.tinkerpop.pipes.filter.ComparisonFilterPipe;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FutureFilterPipeTest extends BaseTest {

    public void testBasicFutureFilter() {
        List<String> names = Arrays.asList("marko", "povel", "peter", "josh");
        FutureFilterPipe<String> pipe1 = new FutureFilterPipe<String>(new IdentityPipe<String>());
        pipe1.setStarts(names);
        int counter = 0;
        while (pipe1.hasNext()) {
            counter++;
            pipe1.next();
        }
        assertEquals(counter, 4);
    }

    public void testAdvancedFutureFilter() {
        List<String> names = Arrays.asList("marko", "povel", "peter", "josh");
        FutureFilterPipe<String> pipe1 = new FutureFilterPipe<String>(new CollectionFilterPipe<String>(Arrays.asList("marko", "povel"), ComparisonFilterPipe.Filter.EQUAL));
        pipe1.setStarts(names);
        int counter = 0;
        while (pipe1.hasNext()) {
            counter++;
            String name = pipe1.next();
            assertTrue(name.equals("peter") || name.equals("josh"));
        }
        assertEquals(counter, 2);
    }
}
