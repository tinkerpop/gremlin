package com.tinkerpop.gremlin;

import jline.ConsoleReader;

import java.io.PrintWriter;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Console {

    public static void main(String[] args) throws Exception {

        ConsoleReader reader = new ConsoleReader();
        reader.setBellEnabled(false);
        reader.setUseHistory(true);

        String line;
        PrintWriter out = new PrintWriter(System.out);

        while ((line = reader.readLine("gremlin> ")) != null) {
            out.println("======>\"" + line + "\"");
            out.flush();

            if (line.equalsIgnoreCase("quit"))
                break;

        }

    }

}
