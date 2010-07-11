package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.operations.UnaryOperation;
import com.tinkerpop.pipes.AbstractPipe;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FunctionPipe<S> extends AbstractPipe<S, S> {

    private final Function function;
    private final List<Operation> parameters;
    private final List<Integer> pipeObjectIndices;

    public FunctionPipe(Function function, List<Operation> parameters, List<Integer> pipeObjectIndices) {
        this.function = function;
        this.parameters = parameters;
        this.pipeObjectIndices = pipeObjectIndices;
    }

    public S processNextStart() {
        while (this.starts.hasNext()) {
            S s = this.starts.next();
            if (null != pipeObjectIndices) {
                for (Integer index : this.pipeObjectIndices)
                    this.parameters.set(index, new UnaryOperation(new Atom<S>(s)));
            }
            Object object = this.function.compute(this.parameters).getValue();
            if (object instanceof Boolean && ((Boolean) object)) {
                return s;
            }
        }
        throw new NoSuchElementException();
    }
}
