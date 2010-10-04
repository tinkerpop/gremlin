package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.GremlinLexer;
import com.tinkerpop.gremlin.compiler.GremlinParser;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.context.VariableLibrary;
import com.tinkerpop.gremlin.compiler.exceptions.SyntaxErrorException;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.operations.UnaryOperation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.Function;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

import javax.script.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez
 */
public class GremlinScriptEngine extends AbstractScriptEngine implements Invocable {

    public static final String GREMLIN_RC_FILE = ".gremlinrc";

    public GremlinScriptEngine() {
        this.context = new GremlinScriptContext();
        try {
            this.eval(new FileReader(GREMLIN_RC_FILE), this.context);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public Bindings createBindings() {
        return new VariableLibrary();
    }

    private static GremlinScriptContext convertContext(final ScriptContext context) {
        if (context instanceof GremlinScriptContext)
            return (GremlinScriptContext) context;
        else {
            GremlinScriptContext context2 = new GremlinScriptContext();
            for (int scope : context.getScopes()) {
                context2.setBindings(context.getBindings(scope), scope);
            }
            return context2;
        }
    }


    private static void typeCastContextBindings(final ScriptContext context) {
        for (int scope : context.getScopes()) {
            Bindings bindings = context.getBindings(scope);
            if (!(bindings instanceof VariableLibrary) && null != bindings) {
                for (String key : bindings.keySet()) {
                    Object object = bindings.get(key);
                    if (object instanceof Atom) {
                        bindings.put(key, ((Atom) object).getValue());
                    }
                }
            }
        }
    }

    public Object eval(final Reader reader, final ScriptContext context) {

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
            typeCastContextBindings(context);

        } catch (SyntaxErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        return result;
    }

    public Object eval(final String script, final ScriptContext context) {
        return this.eval(new StringReader(script), context);
    }

    public ScriptEngineFactory getFactory() {
        return new GremlinScriptEngineFactory();
    }

    public void setContext(final ScriptContext context) {
        this.context = convertContext(context);
    }

    public <T> T getInterface(Class<T> clazz) {
        throw new UnsupportedOperationException();
    }

    public <T> T getInterface(Object thiz, Class<T> clazz) {
        throw new UnsupportedOperationException();
    }

    public Object invokeFunction(String name, Object... args) throws NoSuchMethodException, ScriptException {
        GremlinScriptContext ctx = (GremlinScriptContext) this.getContext();
        int colonIndex = name.indexOf(":");
        Function function;
        try {
            function = ctx.getFunctionLibrary().getFunction(name.substring(0, colonIndex), name.substring(colonIndex + 1));
        } catch (RuntimeException e) {
            throw new NoSuchMethodException();
        }

        List<Operation> arguments = new ArrayList<Operation>();
        for (Object arg : args) {
            arguments.add(new UnaryOperation(new Atom(arg)));
        }
        try {
            Atom ret = function.compute(arguments, ctx);
            if (ret.isNull())
                return null;
            else
                return ret.getValue();
        } catch (Exception e) {
            throw new ScriptException(e.getMessage());
        }

    }

    public Object invokeMethod(Object thiz, String name, Object... args) {
        throw new UnsupportedOperationException("Gremlin is not an object oriented language");
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
