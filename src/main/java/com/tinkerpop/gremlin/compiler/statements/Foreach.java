package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.Func;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class Foreach implements Operation {

    private final String variable;
    private final Operation parameter;
    private final List<Operation> statements;
    private final GremlinScriptContext context;
    
    /**
     * $z := 0
     * $x := g:list(1, 2, 3)
     * 
     * foreach $y in $x
     *   $z := $z + $y
     * end
     */

    public Foreach(final String variable, final Operation parameter, final List<Operation> statements, final GremlinScriptContext context) {
        this.variable = variable;
        this.parameter = parameter;
        this.statements = statements;
        this.context = context;
    }

    @SuppressWarnings("unchecked")
    public Atom compute() {
        final Atom paramsAtom = this.parameter.compute();

        if (!paramsAtom.isIterable())
            return new Atom<Object>(null);

        for (Object currentParam : (Iterable) paramsAtom.getValue()) {
            final Atom value = (currentParam instanceof Atom) ? (Atom) currentParam : new Atom(currentParam); 
            context.getVariableLibrary().declare(this.variable, value);
            
            for (Operation operation : this.statements) {
                Atom atom = operation.compute();
                if (atom instanceof Func)
                    atom.getValue();
            }
        }

        context.getVariableLibrary().free(this.variable);

        return new Atom<Object>(null);
    }

    public Type getType() {
        return Type.CONTROL_STATEMENT;
    }

}
