package com.tinkerpop.gremlin.groovy;


import com.tinkerpop.gremlin.Tokens
import com.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngine
import com.tinkerpop.gremlin.groovy.loaders.ElementLoader
import com.tinkerpop.gremlin.groovy.loaders.GraphLoader
import com.tinkerpop.gremlin.groovy.loaders.IndexLoader
import com.tinkerpop.gremlin.groovy.loaders.ObjectLoader
import com.tinkerpop.gremlin.groovy.loaders.PipeLoader
import com.tinkerpop.gremlin.groovy.loaders.SailGraphLoader
import com.tinkerpop.gremlin.java.GremlinPipeline
import com.tinkerpop.pipes.Pipe

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class Gremlin {

    private static final Set<String> steps = new HashSet<String>();
    private static final GremlinGroovyScriptEngine engine = new GremlinGroovyScriptEngine();

    public static void load() {

        GremlinPipeline.getMethods().each {
            if (it.getReturnType().equals(GremlinPipeline.class)) {
                Gremlin.addStep(it.getName());
            }
        }

        ElementLoader.load();
        GraphLoader.load();
        IndexLoader.load();
        ObjectLoader.load();
        PipeLoader.load();

        try {
            SailGraphLoader.load();
        } catch (Throwable e) {
            // this means that SailGraph was not in the dependency
            // that is ok
        }
    }


    private static GremlinGroovyPipeline compose(final Object start, final Pipe pipe) {
        GremlinGroovyPipeline pipeline;
        if (start instanceof GremlinGroovyPipeline) {
            pipeline = start;
            if (null != pipe)
                pipeline.addPipe(pipe);
        } else if (start instanceof Pipe) {
            pipeline = new GremlinGroovyPipeline();
            pipeline.addPipe(start);
            if (null != pipe)
                pipeline.addPipe(pipe);
        } else {
            pipeline = new GremlinGroovyPipeline(start);
            if (null != pipe)
                pipeline.addPipe(pipe);
        }

        return pipeline;
    }

    public static Pipe compile(final String script) {
        return (Pipe) engine.eval(script, engine.createBindings());
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

    public static void defineStep(final String stepName, final List<Class> classes, final Closure stepClosure) {
        Gremlin.steps.add(stepName);
        classes.each {
            stepClosure.setDelegate(delegate);
            it.metaClass."$stepName" = { final Object... parameters ->
                Gremlin.compose(delegate, stepClosure(* parameters));
            };
        }
    }

    public static String version() {
        return Tokens.VERSION;
    }

    public static String language() {
        return "gremlin-groovy";
    }

}
