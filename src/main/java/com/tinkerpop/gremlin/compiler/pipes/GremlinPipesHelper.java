package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.context.PathLibrary;
import com.tinkerpop.gremlin.compiler.operations.BinaryOperation;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.operations.UnaryOperation;
import com.tinkerpop.gremlin.compiler.operations.logic.*;
import com.tinkerpop.gremlin.compiler.types.*;
import com.tinkerpop.pipes.IdentityPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.filter.AndFilterPipe;
import com.tinkerpop.pipes.filter.ComparisonFilterPipe.Filter;
import com.tinkerpop.pipes.filter.OrFilterPipe;
import com.tinkerpop.pipes.pgm.*;
import com.tinkerpop.pipes.util.HasNextPipe;

import java.lang.reflect.Constructor;
import java.util.*;

/**
 * @author Pavel A. Yaskevich
 */
public class GremlinPipesHelper {

    public static List<Pipe> pipesForStep(final Atom token, final List<Operation> predicates, final GremlinScriptContext context) throws RuntimeException {
        final List<Pipe> pipes = new ArrayList<Pipe>();
        final String tokenString = (String) token.getValue();

        final Pipe tokenPipe = pipeForToken(token);

        if (tokenPipe != null) {
            pipes.add(tokenPipe);
        } else {
            PathLibrary paths = context.getPathLibrary();

            if (paths.isPath(tokenString)) {
                pipes.addAll(paths.getPath(tokenString));
            } else {
                throw new RuntimeException("No pipe exists for '" + tokenString + "'");
            }
        }

        for (final Operation operation : predicates) {
            pipes.add(pipeForPredicate(operation, context));
        }

        return pipes;
    }

    public static List<Pipe> pipesForStep(final List<Operation> predicates, final GremlinScriptContext context) {
        final List<Pipe> pipes = new ArrayList<Pipe>();

        for (final Operation operation : predicates) {
            pipes.add(pipeForPredicate(operation, context));
        }

        return pipes;
    }

    private static Pipe pipeForToken(final Atom tokenAtom) {

        if (tokenAtom.isIdentifier()) {
            String value = (String) tokenAtom.getValue();
            if (value.equals(Tokens.IDENTITY))
                return new IdentityPipe();
            // outgoing edges
            if (value.equals(Tokens.OUT_E))
                return new VertexEdgePipe(VertexEdgePipe.Step.OUT_EDGES);
            // outgoing vertices
            if (value.equals(Tokens.OUT_V))
                return new EdgeVertexPipe(EdgeVertexPipe.Step.OUT_VERTEX);
            // ingoing edges
            if (value.equals(Tokens.IN_E))
                return new VertexEdgePipe(VertexEdgePipe.Step.IN_EDGES);
            // ingoing vertices
            if (value.equals(Tokens.IN_V))
                return new EdgeVertexPipe(EdgeVertexPipe.Step.IN_VERTEX);
            // both vertices
            if (value.equals(Tokens.BOTH_V))
                return new EdgeVertexPipe(EdgeVertexPipe.Step.BOTH_VERTICES);
            // both edges
            if (value.equals(Tokens.BOTH_E))
                return new VertexEdgePipe(VertexEdgePipe.Step.BOTH_EDGES);
            // vertex iterator
            if (value.equals(Tokens.V))
                return new GraphElementPipe(GraphElementPipe.ElementType.VERTEX);
            // edge iterator
            if (value.equals(Tokens.E))
                return new GraphElementPipe(GraphElementPipe.ElementType.EDGE);
        } else if (tokenAtom.isProperty()) {
            String value = (String) tokenAtom.getValue();
            if (value.equals(Tokens.LABEL))
                return new LabelPipe();
            else if (value.equals(Tokens.ID))
                return new IdPipe();
            else
                return new GremlinPropertyPipe(tokenAtom.getValue());
        }
        return null;
    }

    private static Pipe pipeForPredicate(final Operation predicate, final GremlinScriptContext context) throws RuntimeException {

        if (predicate instanceof BinaryOperation) {
            final Operation[] operands = ((BinaryOperation) predicate).getOperands();

            if (predicate instanceof And)
                return andFilterPipe(context, operands);
            else if (predicate instanceof Or)
                return orFilterPipe(context, operands);

            Filter filter;

            if (predicate instanceof Equality) {
                filter = Filter.NOT_EQUAL;
            } else if (predicate instanceof UnEquality) {
                filter = Filter.EQUAL;
            } else if (predicate instanceof GreaterThan) {
                filter = Filter.LESS_THAN_EQUAL;
            } else if (predicate instanceof GreaterThanOrEqual) {
                filter = Filter.LESS_THAN;
            } else if (predicate instanceof LessThan) {
                filter = Filter.GREATER_THAN_EQUAL;
            } else if (predicate instanceof LessThanOrEqual) {
                filter = Filter.GREATER_THAN;
            } else {
                throw new RuntimeException("Unknown relation");
            }

            final Atom operandA = operands[0].compute();
            final Atom operandB = operands[1].compute();

            if (operandA instanceof DynamicEntity || operandB instanceof DynamicEntity) {
                return new DynamicPredicateFilterPipe(operandA, operandB, filter, context);
            }

            final String key = (String) operandA.getValue();

            final Object storedObject;

            if (operandB.isNumber())
                storedObject = operandB.getValue();
            else
                storedObject = (operandB.isNull()) ? null : operandB.getValue();

            return propertyFilterPipe(key, storedObject, filter);
        } else {
            // unary operation like var def or premitive type
            final UnaryOperation operation = (UnaryOperation) predicate;

            final Atom unaryAtom = operation.compute();

            if (unaryAtom instanceof Func) {
                Func functionCall = (Func) unaryAtom;
                return new FunctionFilterPipe(functionCall.getFunction(), functionCall.getArguments(), context);
            }

            if (unaryAtom.isNumber()) {
                int idx = ((Number) unaryAtom.getValue()).intValue();
                return new GremlinRangeFilterPipe(idx, idx + 1);
            }

            if (unaryAtom.isBoolean()) {
                return new BooleanFilterPipe(!((Boolean) unaryAtom.getValue()));
            }

            final Object value = unaryAtom.getValue();
            
            if (value instanceof Iterable) {
                final Iterator collection = ((Iterable) value).iterator();

                final Integer min = (Integer) collection.next();

                int max = min + 1;
                while(collection.hasNext()) {
                    max = (Integer) collection.next();
                }
                
                return new GremlinRangeFilterPipe(min, max + 1);
            }
        }

        throw new RuntimeException("No pipe for " + predicate.getClass());
    }

    private static List<Pipe> pipesForAndOrOperations(final GremlinScriptContext context, final Operation... operands) {
        final List<Pipe> pipes = new ArrayList<Pipe>();

        for (Operation operation : operands) {
            pipes.add(new HasNextPipe(pipeForPredicate(operation, context)));
        }
        return pipes;
    }

    private static Pipe andFilterPipe(final GremlinScriptContext context, final Operation... operands) {
        return new AndFilterPipe(pipesForAndOrOperations(context, operands));
    }

    private static Pipe orFilterPipe(final GremlinScriptContext context, final Operation... operands) {
        return new OrFilterPipe(pipesForAndOrOperations(context, operands));
    }

    private static Pipe propertyFilterPipe(final String key, final Object storedObject, final Filter filter) {
        if (key.equals(Tokens.LABEL)) {
            return new LabelFilterPipe((String) storedObject, filter);
        } else if (key.equals(Tokens.ID)) {
            return new IdFilterPipe(storedObject.toString(), filter);
        } else {
            return new PropertyFilterPipe(key, storedObject, filter);
        }
    }

    public static List<Operation> updateArguments(final List<Operation> currentArguments, final Object currentIterationPoint) {
        List<Operation> arguments = new ArrayList<Operation>();
        
        for (Operation argumentOperation : currentArguments) {

            if (argumentOperation instanceof BinaryOperation) {
                final BinaryOperation op = (BinaryOperation) argumentOperation;
                final List<Operation> currOperands = Arrays.asList(op.getOperands());
                final List<Operation> operands = updateArguments(currOperands, currentIterationPoint);

                try {
                    final Constructor repl = op.getClass().getConstructor((new Operation[0]).getClass());
                    arguments.add((Operation) repl.newInstance(new Object[] { operands.toArray(new Operation[2]) }));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                continue;
            }
            

            final Atom argument = argumentOperation.compute();

            if (argument instanceof DynamicEntity) {
                Operation operation = null;
                
                if (argument instanceof Var) {
                    final String name = ((Var) argument).getVariableName();

                    if (name.equals(Tokens.IDENTITY)) {
                        final Atom<Object> currentPoint = new Atom<Object>(currentIterationPoint);
                        operation = new UnaryOperation(currentPoint);
                    } else {
                        operation = argumentOperation;
                    }
                } else if (argument instanceof GPath) {
                    final GPath path = (GPath) argument;
                    path.setRoot(currentIterationPoint);
                    
                    operation = new UnaryOperation(path);
                } else if (argument instanceof Func) {
                    final Func function = (Func) argument;
                    final List<Operation> functionArguments = function.getArguments();
                    final List<Operation> newArguments = updateArguments(functionArguments, currentIterationPoint);
                    final Func replacement = new Func(function.getFunction(), newArguments, function.getContext());
                    
                    operation = new UnaryOperation(replacement);
                }

                arguments.add(operation);
            } else {
                arguments.add(argumentOperation);
            }
        }

        return arguments;
    }
}
