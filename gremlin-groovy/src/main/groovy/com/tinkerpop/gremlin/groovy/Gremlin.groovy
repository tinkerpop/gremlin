package com.tinkerpop.gremlin.groovy;


import com.tinkerpop.gremlin.Tokens
import com.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngine
import com.tinkerpop.gremlin.groovy.loaders.ElementLoader
import com.tinkerpop.gremlin.groovy.loaders.GraphLoader
import com.tinkerpop.gremlin.groovy.loaders.IndexLoader
import com.tinkerpop.gremlin.groovy.loaders.ObjectLoader
import com.tinkerpop.gremlin.groovy.loaders.PipeLoader
import com.tinkerpop.gremlin.groovy.loaders.SailGraphLoader
import com.tinkerpop.pipes.Pipe
import javax.script.SimpleBindings

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class Gremlin {

    private static final Set<String> steps = new HashSet<String>();
    private static final GremlinGroovyScriptEngine engine = new GremlinGroovyScriptEngine();

    public static void load() {

        Gremlin.addStep(Tokens.STEP);
        // filter steps
        Gremlin.addStep(Tokens.FILTER);
        Gremlin.addStep(Tokens.SIMPLEPATH);
        Gremlin.addStep(Tokens.DEDUP);
        Gremlin.addStep(Tokens.AND);
        Gremlin.addStep(Tokens.OBJECTFILTER);
        Gremlin.addStep(Tokens.OR);
        Gremlin.addStep(Tokens.BACK);
        Gremlin.addStep(Tokens.EXCEPT);
        Gremlin.addStep(Tokens.RETAIN);
        Gremlin.addStep(Tokens.RANDOM);
        Gremlin.addStep(Tokens.PROPERTYFILTER);
        // sideeffect steps
        Gremlin.addStep(Tokens.SIDEEFFECT);
        Gremlin.addStep(Tokens.AGGREGATE);
        Gremlin.addStep(Tokens.GROUPCOUNT);
        Gremlin.addStep(Tokens.OPTIONAL)
        Gremlin.addStep(Tokens.TABLE);
        Gremlin.addStep(Tokens.STORE);
        Gremlin.addStep(Tokens.AS);
        // transform steps
        Gremlin.addStep(Tokens.TRANSFORM);
        Gremlin.addStep(Tokens._);
        Gremlin.addStep(Tokens.BOTH);
        Gremlin.addStep(Tokens.BOTHE);
        Gremlin.addStep(Tokens.BOTHV);
        Gremlin.addStep(Tokens.COPYSPLIT);
        Gremlin.addStep(Tokens.FAIRMERGE);
        Gremlin.addStep(Tokens.E);
        Gremlin.addStep(Tokens.EXHAUSTMERGE);
        Gremlin.addStep(Tokens.ID);
        Gremlin.addStep(Tokens.IN);
        Gremlin.addStep(Tokens.INE);
        Gremlin.addStep(Tokens.INV);
        Gremlin.addStep(Tokens.INDEX);
        Gremlin.addStep(Tokens.IFTHENELSE);
        Gremlin.addStep(Tokens.CAP);
        Gremlin.addStep(Tokens.LABEL);
        Gremlin.addStep(Tokens.LOOP);
        Gremlin.addStep(Tokens.MAP);
        Gremlin.addStep(Tokens.MEMOIZE);
        Gremlin.addStep(Tokens.GATHER);
        Gremlin.addStep(Tokens.SCATTER);
        Gremlin.addStep(Tokens.SELECT);
        Gremlin.addStep(Tokens.PATHS);
        Gremlin.addStep(Tokens.OUT);
        Gremlin.addStep(Tokens.OUTE);
        Gremlin.addStep(Tokens.OUTV);
        Gremlin.addStep(Tokens.V);

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
