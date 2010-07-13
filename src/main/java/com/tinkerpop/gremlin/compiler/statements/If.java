package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class If implements Operation {

    private final Operation condition;
    private final List<Operation> statements;

    /*
      * $x := 0
      * $y := 5
      * $z := 7
      *
      * if $x > 0 or ($y + 2) <= 5 or ($z - 1) >= 6
      *    ...do something...
      * end
      */

    public If(final Operation condition, final List<Operation> statements) {
        this.condition = condition;
        this.statements = statements;
    }

    public Atom compute() {
        Atom condResult = this.condition.compute();

        if (condResult.isNull() == false) {
            if ((Boolean) condResult.getValue() == true) {
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
