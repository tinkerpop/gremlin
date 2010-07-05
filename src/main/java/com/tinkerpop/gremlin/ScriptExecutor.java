package com.tinkerpop.gremlin;

import org.antlr.runtime.ANTLRFileStream;

import java.io.PrintStream;

/**
 * @author Pavel A. Yaskevich
 */
public class ScriptExecutor {

    public static void main(String[] args) {
        PrintStream output = System.out;

        if (args.length != 1) {
            output.println("Parameters: <path_to_grm_script>");
        } else {
            try {
                ANTLRFileStream file = new ANTLRFileStream(args[0]);
                Gremlin.evaluate(file);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
