package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.GremlinEvaluator;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.SyntaxException;
import org.apache.commons.jxpath.JXPathException;

import java.io.PrintStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.Exception;

/**
 * @author Pavel A. Yaskevich
 */
public class ScriptExecutor {

    private static final String SYNTAX_ERROR = "Syntax error: ";
    private static final String EVALUATION_ERROR = "Evaluation error: ";

    public static void main(final String[] args) throws IOException {
        PrintStream output = System.out;

        if(args.length != 1) {
            output.println("Parameters: <path_to_grm_script>");
        } else {
            GremlinEvaluator gremlinEvaluator = new GremlinEvaluator(); 
            
            try {
              FileInputStream script = new FileInputStream(args[0]); 
              gremlinEvaluator.evaluate(script);
            } catch (SyntaxException e) {
                output.println(SYNTAX_ERROR + e.getMessage());
            } catch (EvaluationException e) {
                output.println(EVALUATION_ERROR + e.getMessage());
            } catch (FileNotFoundException e) {
                output.println(e.getMessage());  
            } catch (Exception e) {
                output.println(e.getMessage());
            }
        }
    }
}
