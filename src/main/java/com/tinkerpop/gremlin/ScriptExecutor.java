package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.context.VariableLibrary;
import com.tinkerpop.gremlin.compiler.types.Atom;

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

        final GremlinScriptContext context = new GremlinScriptContext();
        final GremlinScriptEngine engine = new GremlinScriptEngine(context);

        if (argumentsCount == 0) {
            output.println("Parameters: <path_to_grm_script>");
        } else {
            if (argumentsCount > 1) {
                final VariableLibrary variables = context.getVariableLibrary();

                for (int i = 1; i < argumentsCount; i++) {
                    variables.putAtom("$" + i, new Atom<String>(arguments[i]));
                }
            }

            try {
                engine.eval(new FileReader(arguments[0]), context);
            } catch (Exception e) {
                context.getErrorWriter().flush();
                System.err.println(GremlinScriptEngine.exceptionInPrintableFormat(e));
            }
        }
    }

}
