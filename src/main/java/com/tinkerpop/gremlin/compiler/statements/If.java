package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Func;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class If implements Operation {

    private final Operation condition;
    private final List<Operation> statements;
    private final List<Operation> alternatives;
    
    /*
      * $x := 0
      * $y := 5
      * $z := 7
      *
      * if $x > 0 or ($y + 2) <= 5 or ($z - 1) >= 6
      *    ...do something...
      * end
      */

    public If(final Operation condition, final List<Operation> statements, final List<Operation> alternatives) {
        this.condition = condition;
        this.statements = statements;
        this.alternatives = alternatives;
    }

    public Atom compute() {
        Atom condResult = this.condition.compute();

        if (!condResult.isNull()) {
            if ((Boolean) condResult.getValue()) {
                this.evaluateBody(this.statements);
            } else if (null != alternatives) {
                this.evaluateBody(this.alternatives);
            }
        }

        return new Atom<Object>(null);
    }

    public Type getType() {
        return Type.STATEMENT;
    }

    private void evaluateBody(List<Operation> body) {
        for (Operation operation : body) {
            final Atom atom = operation.compute();

            if (atom instanceof Func)
                atom.getValue();
        }    
    }
}
