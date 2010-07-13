package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class Repeat implements Operation {

    private final Operation counterOperation;
    private final List<Operation> statements;

    /*
      * $x := 6
      *
      * repeat $x
      * 	 ..do something...
      * end
      */

    public Repeat(final Operation counterOperation, final List<Operation> statements) {
        this.counterOperation = counterOperation;
        this.statements = statements;
    }

    public Atom compute() {
        Atom counter = this.counterOperation.compute();

        if (!counter.isNull()) {
            if (counter.isNumber()) {
                Number times = (Number) counter.getValue();

                for (int i = 0; i < times.intValue(); i++) {
                    for (Operation operation : statements) {
                        operation.compute();
                    }
                }
            }
        }

        return new Atom(null);
    }

    public Type getType() {
        return Type.STATEMENT;
    }

}
