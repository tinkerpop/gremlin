package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.GPath;
import com.tinkerpop.gremlin.compiler.types.Var;
import com.tinkerpop.pipes.filter.AbstractComparisonFilterPipe;
import com.tinkerpop.pipes.filter.ComparisonFilterPipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DynamicObjectFilterPipe<S> extends AbstractComparisonFilterPipe<S, Object> {

    private Atom<Object> leftHandSide;
    private Atom<Object> rightHandSide;
    private GremlinScriptContext context;


    public DynamicObjectFilterPipe(final Atom<Object> left, final Atom<Object> right, final ComparisonFilterPipe.Filter filter, final GremlinScriptContext context) {
        super(filter);
        this.context = context;
        this.leftHandSide = left;
        this.rightHandSide = right;
    }

    public S processNextStart() {
        while (true) {
            S s = this.starts.next();
            this.context.setCurrentPoint(s);

            final Object leftValue = getSideValue(this.leftHandSide);
            final Object rightValue = getSideValue(this.rightHandSide);
            
            if (!this.compareObjects(leftValue, rightValue)) {
                return s;
            }
        }
    }

    private Object getSideValue(final Atom side) {
        if (side instanceof Var) {
            Var variable = (Var) side;

            if (variable.getVariableName().equals(Tokens.IDENTITY)) {
                return this.context.getCurrentPoint();
            }
        } else if (side instanceof GPath) {
            GPath path = (GPath) side;
            path.setRoot(this.context.getCurrentPoint());
            return path.getValue();
        }

        return side.getValue();
    }
}
