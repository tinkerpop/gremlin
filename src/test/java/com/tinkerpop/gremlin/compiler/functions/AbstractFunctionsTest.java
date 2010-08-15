package com.tinkerpop.gremlin.compiler.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.functions.g.ime.ListFunction;
import com.tinkerpop.gremlin.compiler.functions.g.ime.MapFunction;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AbstractFunctionsTest extends BaseTest {

    public void testFunctionRetrieval() {
        Functions testFunctions = new AbstractFunctions() {
            public String getNamespace() {
                return "test";
            }
        };
        assertEquals(testFunctions.getNamespace(), "test");
        testFunctions.addFunction(new MapFunction());
        testFunctions.addFunction(new ListFunction());
        assertEquals(testFunctions.getFunction("map").getClass(), MapFunction.class);
        assertEquals(testFunctions.getFunction("list").getClass(), ListFunction.class);
        try {
            testFunctions.getFunction("blah");
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testArraySizeTiming() {
        List list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        this.stopWatch();
        list.size();
        printPerformance("list.size()", 1, "evaluation", this.stopWatch());
        int counter = 5000;
        this.stopWatch();
        for (int i = 0; i < counter; i++) {
            list.size();
        }
        printPerformance("list.size()", counter, "evaluations", this.stopWatch());
    }

    public void testScanTiming() {
        Random random = new Random();
        int count = 10;
        for (int j = 1; j < 10; j++) {
            int total = count * j;
            List<String> uuids = generateUUIDs(total);
            this.stopWatch();
            for (int i = 0; i < 500; i++) {
                uuids.contains(uuids.get(random.nextInt(uuids.size())));
            }
            printPerformance("ArrayList scan", total, "size/500 look ups", this.stopWatch());

            Set<String> uuids2 = new HashSet<String>();
            uuids2.addAll(uuids);
            this.stopWatch();
            for (int i = 0; i < 500; i++) {
                uuids2.contains(uuids.get(random.nextInt(uuids.size())));
            }
            printPerformance("HashSet scan", total, "size/500 look ups", this.stopWatch());
        }
    }

}
