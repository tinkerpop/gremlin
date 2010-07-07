package com.tinkerpop.gremlin.compiler.operations.math;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class MultiplicationTest extends BaseTest {

    public void testMultiplySameTypes() {
        this.stopWatch();
        Multiplication operation = new Multiplication(createUnary(1.0d), createUnary(2.0d));
        printPerformance("mult operation", 2, "doubles", this.stopWatch());
        assertEquals(operation.compute().getValue().getClass(), Double.class);
        assertEquals(operation.compute().getValue(), 2.0d);

        this.stopWatch();
        operation = new Multiplication(createUnary(1.0f), createUnary(2.0f));
        printPerformance("mult operation", 2, "floats", this.stopWatch());
        assertEquals(operation.compute().getValue().getClass(), Float.class);
        assertEquals(operation.compute().getValue(), 2.0f);

        this.stopWatch();
        operation = new Multiplication(createUnary(1l), createUnary(2l));
        printPerformance("mult operation", 2, "longs", this.stopWatch());
        assertEquals(operation.compute().getValue().getClass(), Long.class);
        assertEquals(operation.compute().getValue(), 2l);

        this.stopWatch();
        operation = new Multiplication(createUnary(1), createUnary(2));
        printPerformance("mult operation", 2, "integers", this.stopWatch());
        assertEquals(operation.compute().getValue().getClass(), Integer.class);
        assertEquals(operation.compute().getValue(), 2);
    }

    public void testMultiplyDifferentTypes() {

        this.stopWatch();
        Multiplication op = new Multiplication(createUnary(1.0d), createUnary(2.0f));
        printPerformance("mult operation", 2, "double/float", this.stopWatch());
        assertEquals(op.compute().getValue().getClass(), Double.class);
        assertEquals(op.compute().getValue(), 2.0d);

        this.stopWatch();
        op = new Multiplication(createUnary(1.0f), createUnary(2l));
        printPerformance("mult operation", 2, "float/long", this.stopWatch());
        assertEquals(op.compute().getValue().getClass(), Float.class);
        assertEquals(op.compute().getValue(), 2.0f);

        this.stopWatch();
        op = new Multiplication(createUnary(1l), createUnary(2));
        printPerformance("mult operation", 2, "long/int", this.stopWatch());
        assertEquals(op.compute().getValue().getClass(), Long.class);
        assertEquals(op.compute().getValue(), 2l);

        this.stopWatch();
        op = new Multiplication(createUnary(1), createUnary(2.0d));
        printPerformance("mult operation", 2, "int/double", this.stopWatch());
        assertEquals(op.compute().getValue().getClass(), Double.class);
        assertEquals(op.compute().getValue(), 2.0d);
    }
}
