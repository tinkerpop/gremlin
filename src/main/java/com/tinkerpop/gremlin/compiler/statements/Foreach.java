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

    /*
      * $x := 1|2|3|4
      * $z := 0
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
        Atom paramAtom = this.paramOp.compute();

        Iterator<Object> params = null;

        if (paramAtom.isList()) {
            params = ((List<Object>) paramAtom.getValue()).iterator();
        } else if (paramAtom.isIterable()) {
            params = (Iterator<Object>) paramAtom.getValue();
        } else {
            return new Atom(null);
        }

        while (params.hasNext()) {
            Object currentParam = params.next();

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
