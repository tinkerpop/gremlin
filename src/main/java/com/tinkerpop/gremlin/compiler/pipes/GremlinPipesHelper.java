package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.operations.BinaryOperation;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.operations.logic.*;
import com.tinkerpop.pipes.IdentityPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.SingleIterator;
import com.tinkerpop.pipes.filter.AndFilterPipe;
import com.tinkerpop.pipes.filter.ComparisonFilterPipe.Filter;
import com.tinkerpop.pipes.filter.OrFilterPipe;
import com.tinkerpop.pipes.filter.RangeFilterPipe;
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
    public static List<Pipe> pipesForStep(Atom token, List<Operation> predicates) throws RuntimeException {
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

            if (value.equals(".."))
                System.out.println("history!!");

            // vertex iterator
            if (value.equals("V"))
                pipe = new GraphElementPipe(GraphElementPipe.ElementType.VERTEX);

            // edge iterator
            if (value.equals("E"))
                pipe = new GraphElementPipe(GraphElementPipe.ElementType.EDGE);
        }

        if (tokenAtom.isProperty())
            pipe = new PropertyPipe((String) tokenAtom.getValue());


        return pipe;
    }

    @SuppressWarnings({"rawtypes"})
    private static Pipe pipeForPredicate(Operation predicate) throws RuntimeException {

        if (predicate instanceof BinaryOperation) {
            Operation[] operands = ((BinaryOperation) predicate).getOperands();

            if (predicate instanceof And)
                return andFilterPipe(operands);

            if (predicate instanceof Or)
                return orFilterPipe(operands);

            Atom operandA = operands[0].compute();
            Atom operandB = operands[1].compute();

            String key = (String) operandA.getValue();

            Object storedObject = null;

            if (operandB.isNumber())
                storedObject = ((Double) operandB.getValue()).floatValue();
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
            Atom unaryAtom = predicate.compute();

            if (unaryAtom.isNumber()) {
                int idx = ((Double) unaryAtom.getValue()).intValue();
                return new RangeFilterPipe(idx - 1, idx);
            }
        }

        throw new RuntimeException("Can not map - " + predicate.getClass() + " to any of existing pipes.");
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
        return (point instanceof Iterator) ? (Iterator) point : new SingleIterator(point);
    }
}
