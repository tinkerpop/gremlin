package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.operations.util.DeclareVariable;
import com.tinkerpop.gremlin.compiler.types.Func;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class Foreach implements Operation {

    private final String variable;
    private final Operation parameter;
    private final List<Operation> statements;

    /**
     * $z := 0
     * $x := g:list(1, 2, 3)
     * <p/>
     * foreach $y in $x
     * $z := $z + $y
     * end
     */

    public Foreach(final String variable, final Operation parameter, final List<Operation> statements) {
        this.variable = variable;
        this.parameter = parameter;
        this.statements = statements;
    }

    @SuppressWarnings("unchecked")
    public Atom compute() {
        final Atom paramsAtom = this.parameter.compute();

        if (!paramsAtom.isIterable())
            return new Atom(null);

        final Iterable params = (Iterable) paramsAtom.getValue();

        for (Object currentParam : params) {
            if (currentParam instanceof Atom) {
                DeclareVariable.decalareWithInit(this.variable, (Atom) currentParam);
            } else {
                DeclareVariable.decalareWithInit(this.variable, new Atom(currentParam));
            }

            for (Operation operation : this.statements) {
                Atom atom = operation.compute();
                if (atom instanceof Func)
                    atom.getValue();
            }
        }

        GremlinEvaluator.freeVariable(this.variable);

        return new Atom(null);
    }

    public Type getType() {
        return Type.STATEMENT;
    }

}
