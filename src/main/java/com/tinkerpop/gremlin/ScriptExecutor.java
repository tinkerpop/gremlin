package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.types.Atom;

import javax.script.Bindings;
import javax.script.ScriptContext;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Pavel A. Yaskevich
 */
public class ScriptExecutor {

    public static void main(final String[] arguments) throws IOException {
        final PrintStream output = System.out;
        final int argumentsCount = arguments.length;

        // every Iterable/Iterator statement will be iterated
        GremlinEvaluator.SCRIPT_MODE = true;

        final GremlinScriptEngine engine = new GremlinScriptEngine();

        if (argumentsCount == 0) {
            output.println("Usage: <path_to_grm_script> <argument $1> <argument $2> ...");
        } else {
            if (argumentsCount > 1) {
                final Bindings bindings = engine.getContext().getBindings(ScriptContext.ENGINE_SCOPE);

                for (int i = 1; i < argumentsCount; i++) {
                    bindings.put("$" + i, new Atom<String>(arguments[i]));
                }
            }

            try {
                engine.eval(new FileReader(arguments[0]));
            } catch (Exception e) {
                engine.getContext().getErrorWriter().flush();
                System.err.println(GremlinScriptEngine.exceptionInPrintableFormat(e));
            }
        }
    }

}
