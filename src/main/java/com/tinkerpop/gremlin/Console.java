package com.tinkerpop.gremlin;

import java.io.PrintStream;
import org.antlr.runtime.*;

import com.tinkerpop.gremlin.compiler.GremlinEvaluator;

import jline.ConsoleReader;

/**
 * @author Pavel A. Yaskevich
 */
public class Console {
	
	private static final String PROMPT 	= "gremlin> ";
	private static final String QUIT 	= "quit";
	private static final String INDENT  = "\t   ";
	
	private static final String[] compoundStatements = { "if", "while", "repeat", "foreach", "func", "path" };
	
    public static void main(String[] args) throws Exception {
    	
    	// debug mode
        GremlinEvaluator.DEBUG = true;
        
    	PrintStream output = System.out;

        ConsoleReader reader = new ConsoleReader();
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
        
        while(line != null) {
        	
        	// set appropriate prompt
        	if (inCompoundStatement) {
        		prompt = INDENT;
        		if (codeDepth > 1) {
        			for(int i = 0; i < codeDepth; i++) {
        				prompt += "  ";
        			}
        		}
        	} else {
        		prompt = PROMPT;
        	}
        	
        	// read console line
        	line = reader.readLine(prompt).trim();
        	
        	if(line.isEmpty()) continue;
        	
        	// analize current statement
        	for(String statement : compoundStatements) {
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
             
            ANTLRStringStream input = new ANTLRStringStream(line + "\n");
            
            try {
            	Gremlin.evaluate(input); 
            } catch(Exception e) {
            	System.err.println(e.getMessage());
            }
        }        
    }
}
