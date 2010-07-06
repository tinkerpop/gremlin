package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.operations.UnaryOperation;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TestHelper extends TestCase {

    public static UnaryOperation createUnary(Object object) {
        return new UnaryOperation(new Atom(object));
    }

    public static List<Operation> createUnaryArgs(Object... objects) {
        List<Operation> args = new ArrayList<Operation>();
        for (Object object : objects) {
            args.add(createUnary(object));
        }
        return args;
    }

    public static int countIterable(Iterable itty) {
        int counter = 0;
        for (Object object : itty) {
            counter++;
        }
        return counter;
    }

    public void testTrue() {
        assertTrue(true);
    }
}
