package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.*;
import com.tinkerpop.gremlin.compiler.util.Tokens;
import com.tinkerpop.pipes.filter.AbstractComparisonFilterPipe;
import com.tinkerpop.pipes.filter.ComparisonFilterPipe;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DynamicPredicateFilterPipe<S> extends AbstractComparisonFilterPipe<S, Object> {

    private Atom<Object> leftHandSide;
    private Atom<Object> rightHandSide;
    private GremlinScriptContext context;


    public DynamicPredicateFilterPipe(final Atom<Object> left, final Atom<Object> right, final ComparisonFilterPipe.Filter filter, final GremlinScriptContext context) {
        super(filter);
        this.context = context;
        this.leftHandSide = left;
        this.rightHandSide = right;
    }

    public S processNextStart() {
        while (true) {
            S s = this.starts.next();
            this.context.setCurrentPoint(s);

            final Object leftValue = getSideValue(s, this.leftHandSide);
            final Object rightValue = getSideValue(s, this.rightHandSide);

            if (!this.compareObjects(leftValue, rightValue)) {
                return s;
            }
        }
    }

    private Object getSideValue(final S point, final Atom side) {
        if (side instanceof DynamicEntity) {
            final Object currentPoint = this.context.getCurrentPoint();

            if (side instanceof Var) {
                Var variable = (Var) side;

                if (variable.getVariableName().equals(Tokens.IDENTITY)) {
                    return currentPoint;
                }
            } else if (side instanceof GPath) {
                GPath path = (GPath) side;
                path.setRoot(currentPoint);
                return path.getValue();
            } else if (side instanceof Func) {
                final Func function = (Func) side;
                final List<Operation> arguments = function.getArguments();
                final List<Operation> newArguments = GremlinPipesHelper.updateArguments(arguments, currentPoint);
                final Func replacement = new Func(function.getFunction(), newArguments, function.getContext());
                return replacement.getValue();
            }
        } else if (side instanceof Prop) {
            if (point instanceof Map)
                return ((Map) point).get(side.getValue());
            else if (point instanceof Element) {
                String property = side.getValue().toString();
                if (property.equals(Tokens.LABEL))
                    return ((Edge) point).getLabel();
                else if (property.equals(Tokens.ID))
                    return ((Element) point).getId();
                else
                    return ((Element) point).getProperty(side.getValue().toString());
            } else
                throw new RuntimeException("Illegal start to this pipe (must be element or map)");
        }

        return side.getValue();

    }
}
