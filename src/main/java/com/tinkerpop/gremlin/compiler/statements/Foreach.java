package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.operations.util.DeclareVariable;

import java.util.Iterator;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class Foreach implements Operation {

    private String var;
    private Operation paramOp;
    private List<Operation> statements;

    /**
      *
      * $z := 0
      * $x := g:list(1, 2, 3)
      *
      * foreach $y in $x
      * 	 $z := $z + $y
      * end
      */

    public Foreach(String var, Operation paramOp, List<Operation> statements) {
        this.var = var;
        this.paramOp = paramOp;
        this.statements = statements;
    }

    @SuppressWarnings("unchecked")
    public Atom compute() {
        Atom paramsAtom = this.paramOp.compute();

        if (!paramsAtom.isIterable())
             return new Atom(null);

        Iterable params = (Iterable)paramsAtom.getValue();
        
        for (Object currentParam : params) {
            if (currentParam instanceof Atom) {
                DeclareVariable.decalareWithInit(this.var, (Atom) currentParam);
            } else {
                DeclareVariable.decalareWithInit(this.var, new Atom(currentParam));
            }

            for (int j = 0; j < this.statements.size(); j++) {
                this.statements.get(j).compute();
            }
        }

        GremlinEvaluator.freeVariable(this.var);

        return new Atom(null);
    }

    public Type getType() {
        return Type.STATEMENT;
    }

}
