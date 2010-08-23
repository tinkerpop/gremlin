package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.CodeBlock;

/**
 * @author Pavel A. Yaskevich
 */
public class Repeat implements Operation {

    private final Operation counterOperation;
    private final CodeBlock block;

    /*
      * $x := 6
      *
      * repeat $x
      * 	 ..do something...
      * end
      */

    public Repeat(final Operation counterOperation, final CodeBlock block) {
        this.counterOperation = counterOperation;
        this.block = block;
    }

    public Atom compute() {
        Atom counter = this.counterOperation.compute();

        if (!counter.isNull()) {
            if (counter.isNumber()) {
                Number times = (Number) counter.getValue();

                for (int i = 0; i < times.intValue(); i++) {
                    this.block.invoke();
                }
            }
        }

        return new Atom<Object>(null);
    }

    public Type getType() {
        return Type.CONTROL_STATEMENT;
    }

}
