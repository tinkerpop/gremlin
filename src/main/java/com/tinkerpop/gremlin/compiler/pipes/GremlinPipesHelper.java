package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.BinaryOperation;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.operations.UnaryOperation;
import com.tinkerpop.gremlin.compiler.operations.logic.*;
import com.tinkerpop.gremlin.compiler.types.Range;
import com.tinkerpop.pipes.IdentityPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.SingleIterator;
import com.tinkerpop.pipes.filter.AndFilterPipe;
import com.tinkerpop.pipes.filter.ComparisonFilterPipe.Filter;
import com.tinkerpop.pipes.filter.OrFilterPipe;
import com.tinkerpop.pipes.pgm.*;
import com.tinkerpop.pipes.util.HasNextPipe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class GremlinPipesHelper {

    @SuppressWarnings("rawtypes")
    public static List<Pipe> pipesForStep(final Atom token, final List<Operation> predicates) throws RuntimeException {
        List<Pipe> pipes = new ArrayList<Pipe>();
        String tokenString = (String) token.getValue();

        Pipe tokenPipe = pipeForToken(token);

        if (tokenPipe != null) {
            pipes.add(tokenPipe);
        } else {
            if (GremlinEvaluator.paths.isPath(tokenString)) {
                pipes.addAll(GremlinEvaluator.paths.getPath(tokenString));
            } else {
                throw new RuntimeException("No pipe exists for '" + tokenString + "'.");
            }
        }

        for (int i = 0; i < predicates.size(); i++) {
            pipes.add(pipeForPredicate(predicates.get(i)));
        }

        return pipes;
    }

    public static List<Pipe> pipesForStep(final List<Operation> predicates) {
        List<Pipe> pipes = new ArrayList<Pipe>();

        for (int i = 0; i < predicates.size(); i++) {
            pipes.add(pipeForPredicate(predicates.get(i)));
        }

        return pipes;
    }

    @SuppressWarnings("rawtypes")
    private static Pipe pipeForToken(final Atom tokenAtom) {
        Pipe pipe = null;

        if (tokenAtom.isIdentifier()) {
            String value = (String) tokenAtom.getValue();

            if (value.equals("."))
                pipe = new IdentityPipe();

            // outgoing edges
            if (value.equals("outE"))
                pipe = new VertexEdgePipe(VertexEdgePipe.Step.OUT_EDGES);

            // outgoing vertices
            if (value.equals("outV"))
                pipe = new EdgeVertexPipe(EdgeVertexPipe.Step.OUT_VERTEX);

            // ingoing edges
            if (value.equals("inE"))
                pipe = new VertexEdgePipe(VertexEdgePipe.Step.IN_EDGES);

            // ingoing vertices
            if (value.equals("inV"))
                pipe = new EdgeVertexPipe(EdgeVertexPipe.Step.IN_VERTEX);

            // both vertices
            if (value.equals("bothV"))
                pipe = new EdgeVertexPipe(EdgeVertexPipe.Step.BOTH_VERTICES);

            // both edges
            if (value.equals("bothE"))
                pipe = new VertexEdgePipe(VertexEdgePipe.Step.BOTH_EDGES);

            // vertex iterator
            if (value.equals("V"))
                pipe = new GraphElementPipe(GraphElementPipe.ElementType.VERTEX);

            // edge iterator
            if (value.equals("E"))
                pipe = new GraphElementPipe(GraphElementPipe.ElementType.EDGE);
        }

        if (tokenAtom.isProperty())
            pipe = new GremlinPropertyPipe(tokenAtom.getValue());

        return pipe;
    }

    @SuppressWarnings({"rawtypes"})
    private static Pipe pipeForPredicate(Operation predicate) throws RuntimeException {

        if (predicate instanceof BinaryOperation) {
            Operation[] operands = ((BinaryOperation) predicate).getOperands();

            // checking if there is a function call
            if (operands[0] instanceof UnaryOperation || operands[1] instanceof UnaryOperation) {
                UnaryOperation operandA = (UnaryOperation) operands[0];
                UnaryOperation operandB = (UnaryOperation) operands[1];

                Function function = null;
                List<Operation> parameters = null;
                List<Integer> pipeObjectIndices = null;
                Object objectProperty = null;
                
                if (operandA.isFunctionCall()) {
                    function = operandA.getFunctionObject();
                    parameters = operandA.getFunctionParameters();
                    pipeObjectIndices = operandA.pipeObjectIndicesInFunctionParams();
                    objectProperty = operandB.compute().getValue();
                }

                if (operandB.isFunctionCall()) {
                    function = operandB.getFunctionObject();
                    parameters = operandB.getFunctionParameters();
                    pipeObjectIndices = operandB.pipeObjectIndicesInFunctionParams();
                    objectProperty = operandA.compute().getValue();
                }

                // if we really deal with function call here
                if (function != null) {

                    Filter filter = null;

                    if (predicate instanceof Equality)
                        filter = Filter.NOT_EQUAL;

                    if (predicate instanceof UnEquality)
                        filter = Filter.EQUAL;

                    if (predicate instanceof GreaterThan)
                        filter = Filter.LESS_THAN;

                    if (predicate instanceof GreaterThanOrEqual)
                        filter = Filter.LESS_THAN_EQUAL;

                    if (predicate instanceof LessThan)
                        filter = Filter.GREATER_THAN;

                    if (predicate instanceof LessThanOrEqual)
                        filter = Filter.GREATER_THAN_EQUAL;

                    return new FunctionComparisonFilterPipe(function, parameters, pipeObjectIndices, filter, objectProperty);
                }
            }

            if (predicate instanceof And)
                return andFilterPipe(operands);

            if (predicate instanceof Or)
                return orFilterPipe(operands);

            Atom operandA = operands[0].compute();
            Atom operandB = operands[1].compute();

            String key = (String) operandA.getValue();

            Object storedObject = null;

            if (operandB.isNumber())
                storedObject = (Number) operandB.getValue();
            else
                storedObject = (String) operandB.getValue();

            if (predicate instanceof Equality)
                return propertyFilterPipe(key, storedObject, Filter.NOT_EQUAL);

            if (predicate instanceof UnEquality)
                return propertyFilterPipe(key, storedObject, Filter.EQUAL);

            if (predicate instanceof GreaterThan)
                return propertyFilterPipe(key, storedObject, Filter.LESS_THAN);

            if (predicate instanceof GreaterThanOrEqual)
                return propertyFilterPipe(key, storedObject, Filter.LESS_THAN_EQUAL);

            if (predicate instanceof LessThan)
                return propertyFilterPipe(key, storedObject, Filter.GREATER_THAN);

            if (predicate instanceof LessThanOrEqual)
                return propertyFilterPipe(key, storedObject, Filter.GREATER_THAN_EQUAL);

        } else {
            // unary operation like var def or premitive type
            UnaryOperation operation = (UnaryOperation) predicate;

            if (operation.isFunctionCall()) {
                return new FunctionFilterPipe(operation.getFunctionObject(), operation.getFunctionParameters(), operation.pipeObjectIndicesInFunctionParams());    
            }

            Atom unaryAtom = operation.compute();
            
            if (unaryAtom.isNumber()) {
                int idx = ((Number) unaryAtom.getValue()).intValue();
                return new GremlinRangeFilterPipe(idx, idx + 1);
            }

            if (unaryAtom.isBoolean()) {
                return new BooleanFilterPipe(!((Boolean) unaryAtom.getValue()));
            }

            if (unaryAtom.getValue() instanceof Range) {
                Range range = (Range) unaryAtom.getValue();
                return new GremlinRangeFilterPipe(range.getMinimum(), range.getMaximum());
            }
        }

        throw new RuntimeException("Can't map - " + predicate.getClass() + " to any of existing pipes.");
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static List<Pipe> pipesForAndOrOperations(final Operation... operands) {
        List<Pipe> pipes = new ArrayList<Pipe>();

        for (int i = 0; i < operands.length; i++) {
            pipes.add(new HasNextPipe(pipeForPredicate(operands[i])));
        }

        return pipes;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static Pipe andFilterPipe(final Operation... operands) {
        return new AndFilterPipe(pipesForAndOrOperations(operands));
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static Pipe orFilterPipe(final Operation... operands) {
        return new OrFilterPipe(pipesForAndOrOperations(operands));
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static Pipe propertyFilterPipe(final String key, final Object storedObject, final Filter filter) {
        if (key.equals("label")) {
            return new LabelFilterPipe((String) storedObject, filter);
        } else {
            return new PropertyFilterPipe(key, storedObject, filter);
        }
    }

    public static Iterator pipelineStartPoint(Object point) {
        //if (point instanceof Iterable && !(point instanceof Pipe)) {
        //    return new AtomStream((Iterable) point);
        //} else 
        if (point instanceof Iterable) {
            return ((Iterable) point).iterator();
        } else if (point instanceof Iterator) {
            return (Iterator) point;
        } else {
            return new SingleIterator(point);
        }
    }

    public static class AtomStream implements Iterable, Iterator {

        private final Iterator itty;

        public AtomStream(Iterable iterable) {
            itty = iterable.iterator();
        }

        public Object next() {
            final Object object = itty.next();
            if (object instanceof Atom)
                return ((Atom) object).getValue();
            else
                return object;
        }

        public boolean hasNext() {
            return this.itty.hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Iterator iterator() {
            return this;
        }
    }
}
