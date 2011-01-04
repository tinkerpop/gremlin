package com.tinkerpop.gremlin.jsr223;

import javax.script.Bindings;
import javax.script.ScriptContext;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Pavel A. Yaskevich
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ScriptExecutor {

    public static void main(final String[] arguments) throws IOException {
        final PrintStream output = System.out;
        final int argumentsCount = arguments.length;


        final GremlinScriptEngine engine = new GremlinScriptEngine();

        if (argumentsCount == 0) {
            output.println("Usage: <path_to_grm_script> <argument $1> <argument $2> ...");
        } else {
            if (argumentsCount > 1) {
                final Bindings bindings = engine.getContext().getBindings(ScriptContext.ENGINE_SCOPE);

                for (int i = 1; i < argumentsCount; i++) {
                    bindings.put("a" + i, arguments[i]);
                }
            }
            try {
                engine.eval(new FileReader(arguments[0]));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
