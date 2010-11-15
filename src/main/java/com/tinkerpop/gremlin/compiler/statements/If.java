package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.CodeBlock;

/**
 * @author Pavel A. Yaskevich
 */
public class If implements Operation {

    private final Operation condition;
    private final CodeBlock trueBody;
    private final CodeBlock falseBody;

    /*
    * $x := 0
    * $y := 5
    * $z := 7
    *
    * if $x > 0 or ($y + 2) <= 5 or ($z - 1) >= 6
    *    ...do something...
    * end
    */

    public If(final Operation condition, final CodeBlock trueBody, final CodeBlock falseBody) {
        this.condition = condition;
        this.trueBody = trueBody;
        this.falseBody = falseBody;
    }

    public Atom compute() {
        Atom condResult = this.condition.compute();
        if (!condResult.isNull()) {
            if ((Boolean) condResult.getValue()) {
                return this.trueBody.invoke();
            } else if (null != this.falseBody) {
                return this.falseBody.invoke();
            }
        }

        return new Atom<Object>(null);
    }

    public Type getType() {
        return Type.STATEMENT;
    }
}
