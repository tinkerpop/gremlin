package com.tinkerpop.gremlin.groovy.jsr223;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.groovy.Gremlin;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ThreadTest extends BaseTest {

    public void testGroovyEngineThreadSafe() throws Exception {
        int runs = 100;
        final CountDownLatch latch = new CountDownLatch(runs);
        final Random random = new Random();

        for (int i = 0; i < runs; i++) {
            new Thread() {
                public void run() {
                    int id = random.nextInt(10);
                    long count = count(Gremlin.compile("" +
                            "v = TinkerGraphFactory.createTinkerGraph().v(" + id + "); " +
                            "if(v != null) { " +
                            "   v.outE.inV } else { " +
                            "   []._() " +
                            "}").iterator());
                    //System.out.println(count);
                    latch.countDown();
                }
            }.start();
        }
        latch.await();
    }

    public void testGroovyEngineThreadSafe2() throws Exception {
        int runs = 100;
        final CountDownLatch latch = new CountDownLatch(runs);
        final Random random = new Random();
        final List<String> names = Arrays.asList("marko", "peter", "josh", "vadas", "stephen", "pavel", "matthias");
        for (int i = 0; i < runs; i++) {
            new Thread() {
                public void run() {
                    final String name = names.get(random.nextInt(names.size() - 1));
                    long count = count(Gremlin.compile("" +
                            "pipe = TinkerGraphFactory.createTinkerGraph().V('name','" + name + "'); " +
                            "if(pipe.hasNext()) { " +
                            "   pipe.out } else { " +
                            "   []._() " +
                            "}").iterator());
                    //System.out.println(count);
                    latch.countDown();
                }
            }.start();
        }
        latch.await();
    }
}
