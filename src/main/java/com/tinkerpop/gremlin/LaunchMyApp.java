package com.tinkerpop.gremlin;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LaunchMyApp {

    public static void main(String[] args) throws IOException {
        String application = "com.tinkerpop.gremlin.Console";
        String lib = "/Users/marko/software/gremlin/target/gremlin-0.6-SNAPSHOT-standalone/lib";

        List<String> cmdArgs = new ArrayList<String>();
        if (lib != null) {
            String separator = File.pathSeparator;
            StringBuilder sb = new StringBuilder();
            File libFile = new File(lib);
            if (!libFile.isDirectory()) {
                throw new IllegalArgumentException("Provided lib is not a directory: " + lib);
            }
            sb.append(lib);
            sb.append(separator);
            final FilenameFilter filenameFilter = new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".jar");
                }
            };
            for (String file : libFile.list(filenameFilter)) {
                sb.append(file);
                sb.append(separator);
            }
            String javaHome = System.getProperty("java.home");
            cmdArgs.add(javaHome + "/bin/java");
            cmdArgs.add("-Xms32M -Xmx512M");
            cmdArgs.add("-cp");
            cmdArgs.add(sb.toString());
            cmdArgs.add(application);
        }
        System.out.println(cmdArgs);
        ProcessBuilder pb = new ProcessBuilder(cmdArgs);
        pb.start();
    }

    private static void printUsage() {
        System.out.println("LaunchMyApp [options] ClassName\n" + "Options:\n" + "  -help, -h              print this message\n" + "  -lib <path>            specifies a path to search for jars and classes");
    }
}

