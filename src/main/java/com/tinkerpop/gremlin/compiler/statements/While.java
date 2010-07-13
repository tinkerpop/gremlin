package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class While implements Operation {

    private final Operation condition;
    private final List<Operation> statements;

    /*
      * $x := 0
      *
      * while $x >= 0 and $x < 30
      *   $x := $x + 1
      * end
      */

    public While(final Operation condition, final List<Operation> statements) {
        this.condition = condition;
        this.statements = statements;
    }

    public Atom compute() {
        boolean repeatIteration = true;

        while (repeatIteration) {
            Atom currCondResult = this.condition.compute();

            if (currCondResult.isNull())
                repeatIteration = false;

            if (currCondResult.isBoolean()) {
                Boolean condBool = (Boolean) currCondResult.getValue();
                repeatIteration = (condBool) ? true : false;
            }

            if (repeatIteration) {
                for (Operation operation : statements) {
                    operation.compute();
                }
            }
        }

        return new Atom(null);
    }

    public Type getType() {
        return Type.STATEMENT;
    }

}
