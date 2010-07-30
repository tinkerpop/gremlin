package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;

import java.io.FileReader;
import java.io.PrintStream;

/**
 * @author Pavel A. Yaskevich
 */
public class ScriptExecutor {

    public static void main(final String[] args) {
        final PrintStream output = System.out;

        final GremlinScriptEngine engine = new GremlinScriptEngine();
        
        if (args.length != 1) {
            output.println("Parameters: <path_to_grm_script>");
        } else {
            try {
                engine.eval(new FileReader(args[0]), new GremlinScriptContext());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
