package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.Return;
import com.tinkerpop.gremlin.compiler.util.CodeBlock;

/**
 * @author Pavel A. Yaskevich
 */
public class While implements Operation {

    private final Operation condition;
    private final CodeBlock body;

    /*
      * $x := 0
      *
      * while $x >= 0 and $x < 30
      *   $x := $x + 1
      * end
      */

    public While(final Operation condition, final CodeBlock body) {
        this.condition = condition;
        this.body = body;
    }

    public Atom compute() {
        boolean repeatIteration = true;

        while (repeatIteration) {
            StatementHelper.unlockFunc(this.condition);
            Atom currCondResult = this.condition.compute();

            if (currCondResult.isNull())
                repeatIteration = false;

            if (currCondResult.isBoolean()) {
                repeatIteration = (Boolean) currCondResult.getValue();
            }

            if (repeatIteration) {
                Atom atom = this.body.invoke();
                if (atom instanceof Return) {
                    return atom;
                }
            }
        }

        return new Atom<Object>(null);
    }

    public Type getType() {
        return Type.CONTROL_STATEMENT;
    }

}
