package com.tinkerpop.gremlin.compiler.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.functions.g.lme.ListFunction;
import com.tinkerpop.gremlin.compiler.functions.g.lme.MapFunction;

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
        int count = 50;
        for (int j = 0; j < 10; j++) {
            List<String> uuids = generateUUIDs(count);
            this.stopWatch();
            for (int i = 0; i < 250; i++) {
                uuids.contains(uuids.get(random.nextInt(uuids.size())));
            }
            printPerformance("ArrayList scan", count, "look ups", this.stopWatch());

            Set<String> uuids2 = new HashSet<String>();
            uuids2.addAll(uuids);
            this.stopWatch();
            for (int i = 0; i < 250; i++) {
                uuids2.contains(uuids.get(random.nextInt(uuids.size())));
            }
            printPerformance("HashSet scan", count, "lookups", this.stopWatch());
        }
    }

}
