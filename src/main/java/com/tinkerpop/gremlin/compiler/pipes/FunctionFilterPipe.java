package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.filter.FilterPipe;

import java.util.List;

/**
 * [g:func()]
 * 
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FunctionFilterPipe<S> extends AbstractPipe<S, S> implements FilterPipe<S> {

    private final Function function;
    private final List<Operation> arguments;
    private final GremlinScriptContext context;

    public FunctionFilterPipe(Function function, List<Operation> arguments, final GremlinScriptContext context) {
        this.function = function;
        this.arguments = arguments;
        this.context = context;
    }

    public S processNextStart() {
        while (true) {
            S s = this.starts.next();
            this.context.setCurrentPoint(s);

            Object functionReturn = this.function.compute(GremlinPipesHelper.updateArguments(this.arguments, s), this.context).getValue();
            if (functionReturn instanceof Boolean && ((Boolean) functionReturn)) {
                return s;
            }
        }
    }
}
