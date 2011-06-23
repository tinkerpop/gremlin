package com.tinkerpop.gremlin;


import com.tinkerpop.gremlin.jsr223.GremlinScriptEngine
import com.tinkerpop.gremlin.pipes.ClosureFilterPipe
import com.tinkerpop.gremlin.pipes.GremlinPipeline
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.filter.ComparisonFilterPipe.Filter
import javax.script.SimpleBindings
import com.tinkerpop.gremlin.loaders.*

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class Gremlin {

    private static final Set<String> steps = new HashSet<String>();
    private static final GremlinScriptEngine engine = new GremlinScriptEngine();

    public static void load() {
        ObjectLoader.load();
        GraphLoader.load();
        IndexLoader.load();
        ElementLoader.load();
        PipeLoader.load();

        try {
            SailGraphLoader.load();
        } catch (Throwable e) {
            // this means that SailGraph was not in the dependency
            // that is ok
        }
    }

    public static Filter mapFilter(final t) {
        switch (t) {
            case t.eq:
                return Filter.NOT_EQUAL;
                break;
            case t.neq:
                return Filter.EQUAL;
                break;
            case t.lt:
                return Filter.GREATER_THAN_EQUAL;
                break;
            case t.lte:
                return Filter.GREATER_THAN;
                break;
            case t.gt:
                return Filter.LESS_THAN_EQUAL;
                break;
            case t.gte:
                return Filter.LESS_THAN;
                break;
        }
        throw new IllegalArgumentException(t.toString() + " is an uknown filter type");
    }

    public static GremlinPipeline compose(final Object start) {
        return compose(start, null, null);
    }

    public static GremlinPipeline compose(final Object start, final Pipe pipe) {
        return compose(start, pipe, null);
    }

    public static GremlinPipeline compose(final Object start, final Pipe pipe, final Closure closure) {
        GremlinPipeline pipeline;
        if (start instanceof GremlinPipeline) {
            pipeline = start;
            if (null != pipe)
                pipeline.addPipe(pipe);
        } else if (start instanceof Pipe) {
            pipeline = new GremlinPipeline();
            pipeline.addPipe(start);
            if (null != pipe)
                pipeline.addPipe(pipe);
        } else {
            pipeline = new GremlinPipeline();
            if (null != pipe)
                pipeline.addPipe(pipe);
            pipeline.setStarts((Iterator) start.iterator());
        }
        if (closure) {
            pipeline.addPipe(new ClosureFilterPipe(closure));
        }
        return pipeline;
    }

    public static Pipe compile(final String script) {
        return (Pipe) engine.eval(script, new SimpleBindings());
    }

    public static void addStep(final String stepName) {
        Gremlin.steps.add(stepName);
    }

    public static boolean isStep(final String stepName) {
        return Gremlin.steps.contains(stepName);
    }

    public static void defineStep(final String stepName, final List<Class> classes, final Closure stepClosure) {
        Gremlin.addStep(stepName);
        classes.each {
            it.metaClass."$stepName" = { Gremlin.compose(delegate, stepClosure()) };
        }
    }
}
