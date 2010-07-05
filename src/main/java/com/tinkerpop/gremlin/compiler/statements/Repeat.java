package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class Repeat implements Operation {

    private Operation counterOperation;
    private List<Operation> statements;

    /*
      * $x := 6
      *
      * repeat $x
      * 	 ..do something...
      * end
      */

    public Repeat(Operation counterOperation, List<Operation> statements) {
        this.counterOperation = counterOperation;
        this.statements = statements;
    }

    public Atom compute() {
        Atom counter = this.counterOperation.compute();

        if (!counter.isNull()) {
            if (counter.isNumber()) {
                Number times = (Number) counter.getValue();

                for (int i = 0; i < times.intValue(); i++) {
                    for (int j = 0; j < this.statements.size(); j++) {
                        this.statements.get(j).compute();
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
