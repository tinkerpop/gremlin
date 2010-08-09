package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Pavel A. Yaskevich
 */
public class ScriptExecutor {

    public static void main(final String[] args) throws IOException {
        final PrintStream output = System.out;

        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();
        
        if (args.length != 1) {
            output.println("Parameters: <path_to_grm_script>");
        } else {
            try {
                engine.eval(new FileReader(args[0]), context);
            } catch (Exception e) {
                context.getErrorWriter().flush();
                System.out.println(e.getMessage());
            }
        }
    }

}
