package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.compiler.GremlinEvaluator;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import jline.ConsoleReader;

import java.io.PrintStream;

/**
 * @author Pavel A. Yaskevich
 */
public class Console {

    private static final String PROMPT = "gremlin> ";
    private static final String QUIT = "quit";
    private static final String INDENT = "\t   ";
    private static final String THREE_SPACES = "   ";

    private static final String[] compoundStatements = {"if", "while", "repeat", "foreach", "func", "path"};

    public static void main(String[] args) throws Exception {

        // debug mode
        GremlinEvaluator.DEBUG = true;

        final PrintStream output = System.out;

        final ConsoleReader reader = new ConsoleReader();
        reader.setBellEnabled(false);

        output.println();
        output.println("         \\,,,/");
        output.println("         (o o)");
        output.println("-----oOOo-(_)-oOOo-----");

        String line = "";
        String prompt = "";

        int codeDepth = 0;

        String compoundStatementParts = "";
        boolean inCompoundStatement = false;

        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();
        
        while (line != null) {

            // set appropriate prompt
            if (inCompoundStatement) {
                prompt = INDENT;
                if (codeDepth > 1) {
                    for (int i = 0; i < codeDepth; i++) {
                        prompt += THREE_SPACES;
                    }
                }
            } else {
                prompt = PROMPT;
            }

            // read console line
            line = reader.readLine(prompt).trim();

            if (line.isEmpty()) continue;

            // analyze current statement
            for (final String statement : compoundStatements) {
                if (line.indexOf(statement + " ") == 0) {
                    inCompoundStatement = true;
                    codeDepth++;
                }
            }

            if (inCompoundStatement)
                compoundStatementParts += line + "\n";

            // break on quit
            if (null == line || line.equalsIgnoreCase(QUIT)) {
                break;
            }

            if (inCompoundStatement && line.equals("end"))
                codeDepth--;

            if (inCompoundStatement && codeDepth > 0)
                continue;

            if (codeDepth == 0 && inCompoundStatement) {
                line = compoundStatementParts;
                compoundStatementParts = "";
                inCompoundStatement = false;
            }

            try {
                engine.eval(line, context);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                //e.printStackTrace();
            }
        }
    }
}
