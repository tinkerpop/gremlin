package com.tinkerpop.gremlin.compiler.operations.math;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ModuloTest extends BaseTest {

    public void testModuloSameTypes() {
        this.stopWatch();
        Modulo operation = new Modulo(createUnary(2.0d), createUnary(1.0d));
        printPerformance("mod operation", 2, "doubles", this.stopWatch());
        assertEquals(operation.compute().getValue().getClass(), Double.class);
        assertEquals(operation.compute().getValue(), 0.0d);

        this.stopWatch();
        operation = new Modulo(createUnary(2.0f), createUnary(1.0f));
        printPerformance("mod operation", 2, "floats", this.stopWatch());
        assertEquals(operation.compute().getValue().getClass(), Float.class);
        assertEquals(operation.compute().getValue(), 0.0f);

        this.stopWatch();
        operation = new Modulo(createUnary(4l), createUnary(3l));
        printPerformance("mod operation", 2, "longs", this.stopWatch());
        assertEquals(operation.compute().getValue().getClass(), Long.class);
        assertEquals(operation.compute().getValue(), 1l);

        this.stopWatch();
        operation = new Modulo(createUnary(4), createUnary(3));
        printPerformance("mod operation", 2, "ints", this.stopWatch());
        assertEquals(operation.compute().getValue().getClass(), Integer.class);
        assertEquals(operation.compute().getValue(), 1);
    }

    public void testModuloDifferentTypes() {

        this.stopWatch();
        Modulo op = new Modulo(createUnary(2.0d), createUnary(1.0f));
        printPerformance("mult operation", 2, "double/float", this.stopWatch());
        assertEquals(op.compute().getValue().getClass(), Double.class);
        assertEquals(op.compute().getValue(), 0.0d);

        this.stopWatch();
        op = new Modulo(createUnary(2.0f), createUnary(1l));
        printPerformance("mult operation", 2, "float/long", this.stopWatch());
        assertEquals(op.compute().getValue().getClass(), Float.class);
        assertEquals(op.compute().getValue(), 0.0f);

        this.stopWatch();
        op = new Modulo(createUnary(4l), createUnary(3));
        printPerformance("mult operation", 2, "long/int", this.stopWatch());
        assertEquals(op.compute().getValue().getClass(), Long.class);
        assertEquals(op.compute().getValue(), 1l);

        this.stopWatch();
        op = new Modulo(createUnary(4), createUnary(3.0d));
        printPerformance("mult operation", 2, "int/double", this.stopWatch());
        assertEquals(op.compute().getValue().getClass(), Double.class);
        assertEquals(op.compute().getValue(), 1.0d);
    }
}
