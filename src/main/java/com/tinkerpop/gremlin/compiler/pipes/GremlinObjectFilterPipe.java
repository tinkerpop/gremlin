package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.*;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.filter.FilterPipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinObjectFilterPipe<S> extends AbstractPipe<S, S> implements FilterPipe<S> {

    private Atom<Object> leftHandSide;
    private Atom<Object> rightHandSide;
    private GremlinScriptContext context;


    public GremlinObjectFilterPipe(final Atom<Object> left, final Atom<Object> right, final GremlinScriptContext context) {
        this.context = context;

        this.leftHandSide = left;
        this.rightHandSide = right;
    }
    
    public S processNextStart() {
        while (true) {
            S s = this.starts.next();
            this.context.setCurrentPoint(s);

            final Object leftValue  = getSideValue(this.leftHandSide);
            final Object rightValue = getSideValue(this.rightHandSide);
            
            if (leftValue.equals(rightValue))
                return s;
        }
    }

    private Object getSideValue(final Atom side) {
        if (side instanceof Id) {
            Id identifier = (Id) side;

            if (identifier.getValue().equals(Tokens.IDENTITY)) {
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
