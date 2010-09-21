package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.CodeBlock;

/**
 * @author Pavel A. Yaskevich
 */
public class If implements Operation {

    private final Operation condition;
    private final CodeBlock body;
    private final CodeBlock alternative;

    /*
    * $x := 0
    * $y := 5
    * $z := 7
    *
    * if $x > 0 or ($y + 2) <= 5 or ($z - 1) >= 6
    *    ...do something...
    * end
    */

    public If(final Operation condition, final CodeBlock body, final CodeBlock alternative) {
        this.condition = condition;
        this.body = body;
        this.alternative = alternative;
    }

    public Atom compute() {
        Atom condResult = this.condition.compute();

        if (!condResult.isNull()) {
            if ((Boolean) condResult.getValue()) {
                return this.body.invoke();
            } else if (null != this.alternative) {
                return this.alternative.invoke();
            }
        }

        return new Atom<Object>(null);
    }

    public Type getType() {
        return Type.STATEMENT;
    }
}
