package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.operations.UnaryOperation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.Func;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class StatementHelper {

    public static void unlockFunc(Operation operation) {
        if (operation instanceof UnaryOperation) {
            Atom atom = ((UnaryOperation) operation).getOperand();
            if (atom instanceof Func) {
                ((Func) atom).unlock();
            }
        }

    }
}
