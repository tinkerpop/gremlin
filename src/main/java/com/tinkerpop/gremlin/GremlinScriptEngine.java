package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.GremlinLexer;
import com.tinkerpop.gremlin.compiler.GremlinParser;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.context.VariableLibrary;
import com.tinkerpop.gremlin.compiler.exceptions.SyntaxErrorException;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

import javax.script.AbstractScriptEngine;
import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngineFactory;
import java.io.*;

/**
 * @author Marko A. Rodriguez
 */
public class GremlinScriptEngine extends AbstractScriptEngine {

    public static final String GREMLIN_RC_FILE = ".gremlinrc";

    /**
     * This constructor used only by GremlinScriptEngineFactory
     * is you don't want to evaluate .gremlinrc file you can use it too
     */
    public GremlinScriptEngine() {
        this.context = new GremlinScriptContext();
    }

    /**
     * This constructor used to initialize GremlinScriptEngine
     * and to evaluate .gremlinrc file on its' start up
     *
     * @param context GremlinScriptContext
     */
    public GremlinScriptEngine(final ScriptContext context) {
        this.context = context;
        try {
            this.eval(new FileReader(GREMLIN_RC_FILE), this.context);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Bindings createBindings() {
        return new VariableLibrary();
    }

    private static GremlinScriptContext convertContext(ScriptContext context) {
        if (context instanceof GremlinScriptContext)
            return (GremlinScriptContext) context;
        else {
            GremlinScriptContext context2 = new GremlinScriptContext();
            context2.setBindings(context.getBindings(ScriptContext.ENGINE_SCOPE), ScriptContext.ENGINE_SCOPE);
            return context2;
        }
    }

    public Object eval(final Reader reader, ScriptContext context) {

        String line;
        Iterable result;
        StringBuilder script = new StringBuilder();
        BufferedReader bReader = new BufferedReader(reader);

        try {
            // read whole script before evaluation
            while ((line = bReader.readLine()) != null) {
                script.append(line).append("\n");
            }

            // evaluate script
            result = this.evaluate(script.toString(), convertContext(context));

            // flushing output streams
            context.getWriter().flush();
        } catch (SyntaxErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return result;
    }

    public Object eval(final String script, final ScriptContext context) {
        return this.eval(new StringReader(script), context);
    }

    public Object get(final String key) {
        return this.context.getBindings(ScriptContext.ENGINE_SCOPE).get(key);
    }

    public Bindings getBindings(int scope) {
        return this.context.getBindings(scope);
    }

    public ScriptContext getContext() {
        return this.context;
    }

    public ScriptEngineFactory getFactory() {
        return new GremlinScriptEngineFactory();
    }

    public void put(final String key, final Object value) {
        this.context.getBindings(ScriptContext.ENGINE_SCOPE).put(key, value);
    }

    public void setBindings(final Bindings bindings, int scope) {
        this.context.setBindings(bindings, scope);
    }

    public void setContext(final ScriptContext context) {
        if (context instanceof GremlinScriptContext)
            this.context = context;
        else {
            this.context = new GremlinScriptContext();
            this.context.setBindings(context.getBindings(ScriptContext.ENGINE_SCOPE), ScriptContext.ENGINE_SCOPE);
        }
    }

    private Iterable evaluate(final String code, final GremlinScriptContext context) throws RecognitionException {
        ANTLRStringStream input = new ANTLRStringStream(code + "\n");
        return evaluate(input, context);
    }

    private Iterable evaluate(final CharStream input, final GremlinScriptContext context) throws RecognitionException {
        final GremlinLexer lexer = new GremlinLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final GremlinParser parser = new GremlinParser(tokens);
        final GremlinParser.program_return r = parser.program();
        final CommonTree t = (CommonTree) r.getTree();

        if (t.toStringTree().trim().isEmpty()) {
            return null;
        }

        final CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
        final GremlinEvaluator walker = new GremlinEvaluator(nodes, context);

        return walker.program().results;
    }

    private static String getExceptionCauseMessage(final Exception exception) {
        final Throwable cause = exception.getCause();
        return (cause == null) ? exception.getMessage() : getExceptionCauseMessage(exception.getCause());
    }

    private static String getExceptionCauseMessage(final Throwable cause) {
        final Throwable parentCause = cause.getCause();
        return (parentCause == null) ? cause.getMessage() : getExceptionCauseMessage(parentCause);
    }

    public static String exceptionInPrintableFormat(final Exception exception) {
        String message = getExceptionCauseMessage(exception);
        if (message == null) return "";

        // remove all package names and down case
        message = message.replaceAll("\\w+\\.(?! )", "").toLowerCase();
        return "Evaluation error: " + message.replaceAll("^\\w+:\\s", "");
    }
}
