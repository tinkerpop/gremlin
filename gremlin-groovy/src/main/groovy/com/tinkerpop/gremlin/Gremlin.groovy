package com.tinkerpop.gremlin;


import com.tinkerpop.gremlin.groovy.jsr223.GremlinScriptEngine
import com.tinkerpop.gremlin.loaders.ElementLoader
import com.tinkerpop.gremlin.loaders.GraphLoader
import com.tinkerpop.gremlin.loaders.IndexLoader
import com.tinkerpop.gremlin.loaders.ObjectLoader
import com.tinkerpop.gremlin.loaders.PipeLoader
import com.tinkerpop.gremlin.loaders.SailGraphLoader
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.filter.FilterPipe
import com.tinkerpop.pipes.filter.FilterPipe.Filter
import com.tinkerpop.pipes.util.FluentPipeline
import javax.script.SimpleBindings

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
                return FilterPipe.Filter.EQUAL;
                break;
            case t.neq:
                return FilterPipe.Filter.NOT_EQUAL;
                break;
            case t.lt:
                return FilterPipe.Filter.LESS_THAN;
                break;
            case t.lte:
                return FilterPipe.Filter.LESS_THAN_EQUAL;
                break;
            case t.gt:
                return FilterPipe.Filter.GREATER_THAN;
                break;
            case t.gte:
                return FilterPipe.Filter.GREATER_THAN_EQUAL;
                break;
        }
        throw new IllegalArgumentException(t.toString() + " is an uknown filter type");
    }

    private static FluentPipeline compose(final Object start, final Pipe pipe) {
        FluentPipeline pipeline;
        if (start instanceof FluentPipeline) {
            pipeline = start;
            if (null != pipe)
                pipeline.addPipe(pipe);
        } else if (start instanceof Pipe) {
            pipeline = new FluentPipeline();
            pipeline.addPipe(start);
            if (null != pipe)
                pipeline.addPipe(pipe);
        } else {
            pipeline = new FluentPipeline(start);
            if (null != pipe)
                pipeline.addPipe(pipe);
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

    public static Set<String> getStepNames() {
        return new HashSet(Gremlin.steps);
    }

    public static void defineStep(final String stepName, final List<Class> classes, Closure stepClosure) {
        Gremlin.steps.add(stepName);
        classes.each {
            stepClosure.setDelegate(delegate);
            it.metaClass."$stepName" = { final Object... parameters ->
                if (parameters.length == 1)
                    Gremlin.compose(delegate, stepClosure(parameters[0]));
                else
                    Gremlin.compose(delegate, stepClosure(parameters));
            };
        }
    }

    public static String version() {
        return Tokens.VERSION;
    }

}
